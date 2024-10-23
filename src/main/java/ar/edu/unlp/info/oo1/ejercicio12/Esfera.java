package ar.edu.unlp.info.oo1.ejercicio12;

public class Esfera extends Pieza
{
    private final double radio;

    public Esfera(String material, String color, double radio)
    {
        super(material, color);
        this.radio = radio;
    }

    public double getRadio()
    {
        return this.radio;
    }

    public double getVolumen()
    {
        return (4.0 / 3.0) * Math.PI * Math.pow(this.getRadio(), 3);
    }

    public double getSuperficie()
    {
        return 4 * Math.PI * Math.pow(this.getRadio(), 2);
    }
}
