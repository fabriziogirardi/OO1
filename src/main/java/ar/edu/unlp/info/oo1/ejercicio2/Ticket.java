package ar.edu.unlp.info.oo1.ejercicio2;

import ar.edu.unlp.info.oo1.ejercicio2.Interfaces.ITicket;

import java.time.LocalDate;

public class Ticket implements ITicket
{
    private final LocalDate fecha;
    private final int       cantidadDeProductos;
    private final double    precioTotal;
    private final double    pesoTotal;

    public Ticket(int cantidadDeProductos, double precioTotal, double pesoTotal, LocalDate fecha)
    {
        this.cantidadDeProductos = cantidadDeProductos;
        this.precioTotal         = precioTotal;
        this.pesoTotal           = pesoTotal;
        this.fecha               = fecha;
    }

    public double impuesto()
    {
        return this.precioTotal * 0.21;
    }

    public int getCantidadDeProductos()
    {
        return this.cantidadDeProductos;
    }

    @Override
    public LocalDate getFecha()
    {
        return fecha;
    }

    public double getPrecioTotal()
    {
        return this.precioTotal;
    }

    public double getPesoTotal()
    {
        return this.pesoTotal;
    }
}
