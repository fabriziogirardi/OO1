package ar.edu.unlp.info.oo1.ejercicio20;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPorHoras extends Contrato
{
    private final double    valorHora;
    private final int       horasATrabajar;
    private final LocalDate fechaFin;

    public ContratoPorHoras(Empleado empleado, LocalDate fechaInicio, double valorHora, int horasATrabajar,
                            LocalDate fechaFin)
    {
        super(empleado, fechaInicio);
        this.valorHora      = valorHora;
        this.horasATrabajar = horasATrabajar;
        this.fechaFin       = fechaFin;
    }

    public double getValorHora()
    {
        return this.valorHora;
    }

    public int getHorasATrabajar()
    {
        return this.horasATrabajar;
    }

    public LocalDate getFechaFin()
    {
        return this.fechaFin;
    }

    public boolean isActivo()
    {
        return LocalDate.now().isBefore(this.getFechaFin());
    }

    public double calcularSueldoBasico()
    {
        return this.getValorHora() * this.getHorasATrabajar();
    }

    public long calcularAntiguedad()
    {
        return ChronoUnit.DAYS.between(this.getFechaInicio(), LocalDate.now());
    }
}
