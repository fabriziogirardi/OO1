package ar.edu.unlp.info.oo1.ejercicio23;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona
{
    private final List<Producto> productos;

    public Vendedor(String nombre, String direccion)
    {
        super(nombre, direccion);
        this.productos = new ArrayList<>();
    }

    public void crearPedido(Cliente c, IFormaDePago fdp, IFormaDeEnvio fde, Producto p, int n)
    {
        if (p.stockSuficiente(n)) {
            Pedido pedido = new Pedido(this, c, fdp, fde, p, n);
            c.addPedido(pedido);
        }
    }

    public void agregarProducto(Producto p)
    {
        this.productos.add(p);
    }

    public List<Producto> getProductos()
    {
        return new ArrayList<>(this.productos);
    }
}
