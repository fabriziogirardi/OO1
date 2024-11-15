package ar.edu.unlp.info.oo1.ejercicio22;

import java.util.ArrayList;
import java.util.List;

public class Email
{
    private final String        titulo;
    private final String        cuerpo;
    private final List<Archivo> adjuntos;

    public Email(String titulo, String cuerpo)
    {
        this(titulo, cuerpo, new ArrayList<>());
    }

    public Email(String titulo, String cuerpo, List<Archivo> adjuntos)
    {
        this.titulo   = titulo;
        this.cuerpo   = cuerpo;
        this.adjuntos = adjuntos;
    }

    public String getTitulo()
    {
        return this.titulo;
    }

    public String getCuerpo()
    {
        return this.cuerpo;
    }

    public List<Archivo> getAdjuntos()
    {
        return new ArrayList<>(this.adjuntos);
    }

    public int espacioOcupado()
    {
        return this.getTitulo().length() + this.getCuerpo().length() + this.getAdjuntos().stream().mapToInt(
                Archivo::tamanio).sum();
    }

    public String getCategoria() {
        int size = this.espacioOcupado();

        if (size > 500) {
            return "Grande";
        } else if (size > 300) {
            return "Mediano";
        } else {
            return "Pequeño";
        }
    }

    public boolean contiene(String texto)
    {
        return this.titulo.contains(texto) || this.cuerpo.contains(texto);
    }
}
