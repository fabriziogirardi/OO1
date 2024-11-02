package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;

public class Factura
{
    private final String    nombre;
    private final String    direccion;
    private final LocalDate fecha;
    private final double    bonificacion;
    private final double    total;

    public Factura(String nombre, String direccion, LocalDate fecha, double bonificacion, double costoConsumo)
    {
        this.nombre       = nombre;
        this.direccion    = direccion;
        this.fecha        = fecha;
        this.bonificacion = bonificacion;
        this.total        = costoConsumo - bonificacion;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDireccion()
    {
        return this.direccion;
    }

    public LocalDate getFecha()
    {
        return this.fecha;
    }

    public double getBonificacion()
    {
        return this.bonificacion;
    }

    public double getTotal()
    {
        return this.total;
    }
}