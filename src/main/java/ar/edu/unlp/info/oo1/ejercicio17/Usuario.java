package ar.edu.unlp.info.oo1.ejercicio17;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;

import java.util.ArrayList;
import java.util.List;

public class Usuario
{
    private final String          nombre;
    private final String          direccion;
    private final String          dni;
    private final List<Propiedad> propiedades;

    public Usuario(String nombre, String direccion, String dni)
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.propiedades = new ArrayList<>();
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDireccion()
    {
        return this.direccion;
    }

    public String getDni()
    {
        return this.dni;
    }

    public Propiedad addPropiedad(String nombre, String direccion, double precio)
    {
        Propiedad propiedad = new Propiedad(nombre, direccion, precio, this);
        this.propiedades.add(propiedad);
        return propiedad;
    }

    public List<Propiedad> getPropiedades()
    {
        return new ArrayList<>(this.propiedades);
    }

    public double calcularIngresosEnPeriodo(DateLapse fecha)
    {
        return this.propiedades.stream()
                               .mapToDouble(p -> p.calcularIngresosEnPeriodo(fecha))
                               .sum();
    }
}
