package ar.edu.unlp.info.oo1.ejercicio20;

import java.time.LocalDate;

public abstract class Contrato
{
    private LocalDate fechaInicio;
    private Empleado  empleado;

    public Contrato(Empleado empleado, LocalDate fechaInicio)
    {
        this.empleado    = empleado;
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaInicio()
    {
        return this.fechaInicio;
    }

    protected Empleado getEmpleado()
    {
        return this.empleado;
    }

    abstract public boolean isActivo();

    abstract public double calcularSueldoBasico();

    abstract public long calcularAntiguedad();
}
