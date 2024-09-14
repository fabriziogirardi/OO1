package ar.edu.unlp.info.oo1.practica1.ejercicio3;

public class Item
{
    private final String detalle;
    private final int cantidad;
    private final double costoUnitario;

    public Item(String detalle, int cantidad, double costoUnitario) {
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public double costo() {
        return this.costoUnitario * this.cantidad;
    }

    public double getCostoUnitario()
    {
        return this.costoUnitario;
    }

    @Override
    public String toString() {
        return this.cantidad + " " + this.detalle + " a $" + this.costoUnitario + " c/u";
    }
}
