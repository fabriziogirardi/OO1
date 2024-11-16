package ar.edu.unlp.info.oo1.ejercicio23;

import ar.edu.unlp.info.oo1.ejercicio21.BagImpl;

public abstract class Persona
{
    private final String nombre;
    private final String direccion;

    public Persona(String nombre, String direccion)
    {
        this.nombre    = nombre;
        this.direccion = direccion;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDireccion()
    {
        return this.direccion;
    }
}
