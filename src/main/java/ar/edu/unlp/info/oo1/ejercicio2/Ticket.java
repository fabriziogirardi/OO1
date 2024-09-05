package ar.edu.unlp.info.oo1.ejercicio2;

import ar.edu.unlp.info.oo1.ejercicio2.Interfaces.ITicket;

import java.time.LocalDate;

public class Ticket implements ITicket
{
    private LocalDate fecha;

    private int cantidadDeProductos;

    private float precioTotal;

    private float pesoTotal;

    public Ticket(int cantidadDeProductos, float precioTotal, float pesoTotal, LocalDate fecha)
    {
        this.cantidadDeProductos = cantidadDeProductos;
        this.precioTotal = precioTotal;
        this.pesoTotal = pesoTotal;
        this.fecha = fecha;
    }

    public float impuesto()
    {
        return this.precioTotal * 0.21f;
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

    public float getPrecioTotal()
    {
        return this.precioTotal;
    }

    public float getPesoTotal()
    {
        return this.pesoTotal;
    }
}
