package ar.edu.unlp.info.oo1.ejercicio5;

import ar.edu.unlp.info.oo1.ejercicio5.Interfaces.IFiguraGeometrica;

public class Cuadrado implements IFiguraGeometrica
{
    private double lado;

    public void setLado(double lado)
    {
        this.lado = lado;
    }

    public double getLado()
    {
        return this.lado;
    }

    public double getPerimetro()
    {
        return 4 * this.getLado();
    }

    public double getArea()
    {
        return Math.pow(this.getLado(), 2);
    }
}