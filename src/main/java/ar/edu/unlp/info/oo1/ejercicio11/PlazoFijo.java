package ar.edu.unlp.info.oo1.ejercicio11;

import ar.edu.unlp.info.oo1.ejercicio11.interfaces.Inversion;

import java.time.LocalDate;

public class PlazoFijo implements Inversion
{
    private final LocalDate fechaDeConstitucion;
    private final double    montoDepositado;
    private final double    porcentajeDeInteresDiario;

    public PlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado, double porcentajeDeInteresDiario)
    {
        this.fechaDeConstitucion = fechaDeConstitucion;
        this.montoDepositado = montoDepositado;
        this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
    }

    @Override
    public double valorActual()
    {
        return this.montoDepositado * Math.pow(1 + this.porcentajeDeInteresDiario, LocalDate.now().toEpochDay() - this.fechaDeConstitucion.toEpochDay());
    }
}
