package ar.edu.unlp.info.oo1.ejercicio13;

public class Archivo
{
    private final String nombre;

    public Archivo(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public int tamanio()
    {
        return this.getNombre().length();
    }
}
