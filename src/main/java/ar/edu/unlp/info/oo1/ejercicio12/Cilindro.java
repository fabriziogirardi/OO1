package ar.edu.unlp.info.oo1.ejercicio12;

public class Cilindro extends Pieza
{
    private final double radio;
    private final double altura;

    public Cilindro(String material, String color, double radio, double altura)
    {
        super(material, color);
        this.radio = radio;
        this.altura = altura;
    }

    public double getRadio()
    {
        return this.radio;
    }

    public double getAltura()
    {
        return this.altura;
    }

    @Override
    public double getVolumen()
    {
        return Math.PI * Math.pow(this.getRadio(), 2) * this.getAltura();
    }

    @Override
    public double getSuperficie()
    {
        return (2 * Math.PI * this.getRadio() * this.getAltura()) + (2 * Math.PI * Math.pow(this.getRadio(), 2));
    }
}
