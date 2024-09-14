package ar.edu.unlp.info.oo1.practica1.ejercicio4;

import ar.edu.unlp.info.oo1.practica1.ejercicio4.Interfaces.IProducto;

public class Producto implements IProducto
{
    private double peso;
    private double precioPorKilo;
    private String descripcion;

    public double getPrecio()
    {
        return peso * precioPorKilo;
    }

    public double getPrecioPorKilo()
    {
        return precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo)
    {
        this.precioPorKilo = precioPorKilo;
    }

    public double getPeso()
    {
        return peso;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
}
