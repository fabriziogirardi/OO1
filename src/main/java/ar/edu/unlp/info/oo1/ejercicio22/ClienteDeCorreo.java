package ar.edu.unlp.info.oo1.ejercicio22;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo
{
    private final Carpeta       inbox;
    private final List<Carpeta> carpetas;

    public ClienteDeCorreo()
    {
        this.inbox    = new Carpeta("Inbox");
        this.carpetas = new ArrayList<>();
    }

    public void recibir(Email email)
    {
        this.inbox.agregarEmail(email);
    }

    public Email buscar(String texto)
    {
        Email email = this.inbox.buscar(texto);

        if (email == null) {
            email = this.carpetas.stream()
                                 .map(carpeta -> carpeta.buscar(texto))
                                 .filter(e -> e != null)
                                 .findFirst()
                                 .orElse(null);
        }

        return email;
    }

    public int espacioOcupado()
    {
        return this.inbox.espacioOcupado() + this.carpetas.stream().mapToInt(
                Carpeta::espacioOcupado).sum();
    }

    public void agregarCarpeta(Carpeta c)
    {
        this.carpetas.add(c);
    }

    public Carpeta getInbox()
    {
        return this.inbox;
    }

    public List<Carpeta> getCarpetas()
    {
        return new ArrayList<>(this.carpetas);
    }

    public int getCantidadDeEmails()
    {
        return this.inbox.getEmails().size()
               + this.carpetas.stream().mapToInt(Carpeta::getCantidadDeEmails).sum();
    }
}
