package ar.edu.unlp.info.oo1.ejercicio22;

import ar.edu.unlp.info.oo1.ejercicio21.BagImpl;

import java.util.ArrayList;
import java.util.List;

public class Carpeta
{
    private final String      nombre;
    private final List<Email> emails;

    public Carpeta(String nombre)
    {
        this.nombre = nombre;
        this.emails = new ArrayList<>();
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void mover(Email email, Carpeta destino)
    {
        destino.agregarEmail(email);
        this.eliminarEmail(email);
    }

    public void agregarEmail(Email email)
    {
        this.emails.add(email);
    }

    public void eliminarEmail(Email email)
    {
        this.emails.remove(email);
    }

    public Email buscar(String texto)
    {
        return this.emails.stream().filter(email -> email.contiene(texto)).findFirst().orElse(null);
    }

    public int espacioOcupado()
    {
        return this.emails.stream().mapToInt(Email::espacioOcupado).sum();
    }

    public List<Email> getEmails()
    {
        return new ArrayList<>(this.emails);
    }

    public BagImpl<String> categorias() {
        BagImpl<String> categorias = new BagImpl<>();
        this.getEmails().forEach(email -> categorias.add(email.getCategoria()));
        return categorias;
    }

    public int getCantidadDeEmails() {
        return this.getEmails().size();
    }
}