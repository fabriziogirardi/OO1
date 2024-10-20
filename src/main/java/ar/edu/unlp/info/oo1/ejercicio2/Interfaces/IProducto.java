package ar.edu.unlp.info.oo1.ejercicio2.Interfaces;

public interface IProducto
{
    double getPrecio();

    double getPrecioPorKilo();

    void setPrecioPorKilo(double precio);

    double getPeso();

    void setPeso(double peso);

    String getDescripcion();

    void setDescripcion(String descripcion);
}
