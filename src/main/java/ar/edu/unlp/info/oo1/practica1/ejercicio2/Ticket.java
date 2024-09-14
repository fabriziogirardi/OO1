package ar.edu.unlp.info.oo1.practica1.ejercicio2;

import ar.edu.unlp.info.oo1.practica1.ejercicio2.Interfaces.ITicket;

import java.time.LocalDate;

public class Ticket implements ITicket
{
    private LocalDate fecha;

    private int cantidadDeProductos;

    private double precioTotal;

    private double pesoTotal;

    public Ticket(int cantidadDeProductos, double precioTotal, double pesoTotal, LocalDate fecha)
    {
        this.cantidadDeProductos = cantidadDeProductos;
        this.precioTotal = precioTotal;
        this.pesoTotal = pesoTotal;
        this.fecha = fecha;
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
