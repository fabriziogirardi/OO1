package ar.edu.unlp.info.oo1.ejercicio20;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoDePlanta extends Contrato
{
    private final double sueldoMensual;
    private final double montoConyuge;
    private final double montoHijo;

    public ContratoDePlanta(Empleado empleado, LocalDate fechaInicio, double sueldoMensual, double montoConyuge, double montoHijo)
    {
        super(empleado, fechaInicio);
        this.sueldoMensual = sueldoMensual;
        this.montoConyuge  = montoConyuge;
        this.montoHijo     = montoHijo;
    }

    public double getSueldoMensual()
    {
        return this.sueldoMensual;
    }

    public double getMontoConyuge()
    {
        return this.montoConyuge;
    }

    public double getMontoHijo()
    {
        return this.montoHijo;
    }

    public boolean isActivo()
    {
        return true;
    }

    public double calcularSueldoBasico()
    {
        return this.getSueldoMensual()
                + (this.getEmpleado().hasConyuge() ? this.getMontoConyuge() : 0)
                + (this.getEmpleado().hasHijo()    ? this.getMontoHijo()    : 0);
    }

    public long calcularAntiguedad()
    {
        return ChronoUnit.DAYS.between(this.getFechaInicio(), LocalDate.now());
    }
}
