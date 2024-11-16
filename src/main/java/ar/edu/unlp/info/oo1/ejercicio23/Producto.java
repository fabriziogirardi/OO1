package ar.edu.unlp.info.oo1.ejercicio23;

public class Producto
{
    private final String nombre;
    private final String categoria;
    private final double precio;
    private       int    stock;

    public Producto(String nombre, String categoria, double precio, int stock)
    {
        this.nombre    = nombre;
        this.categoria = categoria;
        this.precio    = precio;
        this.stock     = stock;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getCategoria()
    {
        return this.categoria;
    }

    public double getPrecio()
    {
        return this.precio;
    }

    public int getStock()
    {
        return this.stock;
    }

    public boolean stockSuficiente(int cantidad)
    {
        return this.stock >= cantidad;
    }

    public void sumarStock(int cantidad)
    {
        this.stock += cantidad;
    }

    public void restarStock(int cantidad)
    {
        this.stock -= cantidad;
    }

    public double calcularCosto(int cantidad)
    {
        return this.precio * cantidad;
    }
}
