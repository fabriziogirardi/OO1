package ar.edu.unlp.info.oo1.ejercicio4;

import ar.edu.unlp.info.oo1.ejercicio4.Interfaces.IBalanza;
import ar.edu.unlp.info.oo1.ejercicio4.Interfaces.IProducto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Balanza implements IBalanza
{
    private final List<IProducto> productos = new ArrayList<>();

    public void ponerEnCero()
    {
        this.productos.clear();
    }

    public void agregarProducto(IProducto IProducto)
    {
        if (IProducto != null) {
            this.productos.add(IProducto);
        }
    }

    public Ticket emitirTicket()
    {
        return new Ticket(this.productos, LocalDate.now());
    }

    public double getPesoTotal()
    {
        return this.productos.stream().mapToDouble(IProducto::getPeso).sum();
    }

    public double getPrecioTotal()
    {
        return this.productos.stream().mapToDouble(IProducto::getPrecio).sum();
    }

    public int getCantidadDeProductos()
    {
        return this.productos.size();
    }

    public List<IProducto> getProductos()
    {
        return new ArrayList<>(this.productos);
    }
}
