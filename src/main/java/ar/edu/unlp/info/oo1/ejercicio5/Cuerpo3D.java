package ar.edu.unlp.info.oo1.ejercicio5;

import ar.edu.unlp.info.oo1.ejercicio5.Interfaces.IFiguraGeometrica;

public class Cuerpo3D
{
    private double altura;
    private IFiguraGeometrica caraBasal;

    public void setAltura(double altura)
    {
        this.altura = altura;
    }

    public double getAltura()
    {
        return this.altura;
    }

    public void setCaraBasal(IFiguraGeometrica caraBasal)
    {
        this.caraBasal = caraBasal;
    }

    public double getVolumen()
    {
        return this.getAltura() * this.caraBasal.getArea();
    }

    public double getSuperficieExterior()
    {
        return 2 * this.caraBasal.getArea() + this.caraBasal.getPerimetro() * this.getAltura();
    }
}
