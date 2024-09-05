package ar.edu.unlp.info.oo1.ejercicio2;

import ar.edu.unlp.info.oo1.ejercicio2.Interfaces.IBalanza;
import ar.edu.unlp.info.oo1.ejercicio2.Interfaces.IProducto;

import java.time.LocalDate;

public class Balanza implements IBalanza
{
    private int cantidadDeProductos;
    private float precioTotal;
    private float pesoTotal;

    public void ponerEnCero()
    {
        this.cantidadDeProductos = 0;
        this.precioTotal = 0;
        this.pesoTotal = 0;
    }

    public void agregarProducto(IProducto IProducto)
    {
        if (IProducto != null)
        {
            this.cantidadDeProductos++;
            this.precioTotal += IProducto.getPrecio();
            this.pesoTotal += IProducto.getPeso();
        }
    }

    public Ticket emitirTicket()
    {
        return new Ticket(this.cantidadDeProductos, this.precioTotal, this.pesoTotal, LocalDate.now());
    }

    public double getPesoTotal()
    {
        return this.pesoTotal;
    }

    public double getPrecioTotal()
    {
        return this.precioTotal;
    }

    public int getCantidadDeProductos()
    {
        return this.cantidadDeProductos;
    }
}
