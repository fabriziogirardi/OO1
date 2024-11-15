package ar.edu.unlp.info.oo1.ejercicio20;

import java.time.LocalDate;

public class ReciboDeSueldo
{
    private final String    nombre;
    private final String    apellido;
    private final String    cuil;
    private final int       antiguedad;
    private final LocalDate fecha;
    private final double    monto;

    public ReciboDeSueldo(String nombre, String apellido, String cuil, int antiguedad, double monto)
    {
        this.nombre     = nombre;
        this.apellido   = apellido;
        this.cuil       = cuil;
        this.antiguedad = antiguedad;
        this.fecha      = LocalDate.now();
        this.monto      = monto;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getApellido()
    {
        return this.apellido;
    }

    public String getCuil()
    {
        return this.cuil;
    }

    public int getAntiguedad()
    {
        return this.antiguedad;
    }

    public LocalDate getFecha()
    {
        return this.fecha;
    }

    public double getMonto()
    {
        return this.monto;
    }
}
