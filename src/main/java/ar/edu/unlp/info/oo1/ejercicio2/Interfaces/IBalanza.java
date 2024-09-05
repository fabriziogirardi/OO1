package ar.edu.unlp.info.oo1.ejercicio2.Interfaces;

public interface IBalanza
{
    void ponerEnCero();

    void agregarProducto(IProducto IProducto);

    ITicket emitirTicket();

    double getPesoTotal();

    double getPrecioTotal();

    int getCantidadDeProductos();
}
