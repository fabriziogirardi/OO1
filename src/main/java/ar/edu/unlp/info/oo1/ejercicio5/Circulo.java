package ar.edu.unlp.info.oo1.ejercicio5;

import ar.edu.unlp.info.oo1.ejercicio5.Interfaces.IFiguraGeometrica;

public class Circulo implements IFiguraGeometrica
{
    private double radio;

    public double getDiametro()
    {
        return 2 * this.getRadio();
    }

    public double getRadio()
    {
        return this.radio;
    }

    public void setRadio(double radio)
    {
        this.radio = radio;
    }

    public double getPerimetro()
    {
        return 2 * Math.PI * this.getRadio();
    }

    public double getArea()
    {
        return Math.PI * Math.pow(this.getRadio(), 2);
    }
}
