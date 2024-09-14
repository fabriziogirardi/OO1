package ar.edu.unlp.info.oo1.practica1.ejercicio4;

import ar.edu.unlp.info.oo1.practica1.ejercicio4.Interfaces.IProducto;
import ar.edu.unlp.info.oo1.practica1.ejercicio4.Interfaces.ITicket;

import java.time.LocalDate;
import java.util.List;

public class Ticket implements ITicket
{
    private LocalDate       fecha;
    private List<IProducto> productos;

    public Ticket(List<IProducto> productos, LocalDate fecha)
    {
        this.productos = productos;
        this.fecha     = fecha;
    }

    public double impuesto()
    {
        return this.getPrecioTotal() * 0.21;
    }

    public double getPrecioTotal()
    {
        return this.productos.stream().mapToDouble(IProducto::getPrecio).sum();
    }

    public double getPesoTotal()
    {
        return this.productos.stream().mapToDouble(IProducto::getPeso).sum();
    }

    public int getCantidadDeProductos()
    {
        return this.productos.size();
    }

    @Override
    public LocalDate getFecha()
    {
        return fecha;
    }
}
