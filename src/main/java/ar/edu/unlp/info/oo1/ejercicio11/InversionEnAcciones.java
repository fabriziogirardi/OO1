package ar.edu.unlp.info.oo1.ejercicio11;

import ar.edu.unlp.info.oo1.ejercicio11.interfaces.Inversion;

public class InversionEnAcciones implements Inversion
{
    private final String nombre;
    private final double cantidad;
    private final double valorUnitario;

    public InversionEnAcciones(String nombre, double cantidad, double valorUnitario)
    {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public String getNombre()
    {
        return nombre;
    }

    @Override
    public double valorActual()
    {
        return this.cantidad * this.valorUnitario;
    }
}
