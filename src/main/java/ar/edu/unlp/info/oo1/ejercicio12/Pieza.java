package ar.edu.unlp.info.oo1.ejercicio12;

abstract public class Pieza
{
    private final String material;
    private final String color;

    public Pieza(String material, String color)
    {
        this.material = material;
        this.color = color;
    }

    public String getMaterial()
    {
        return this.material;
    }

    public String getColor()
    {
        return this.color;
    }

    abstract public double getSuperficie();
    abstract public double getVolumen();
}