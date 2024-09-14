package ar.edu.unlp.info.oo1.practica1.ejercicio5;

public class Cuerpo3D
{
    private double altura;
    private FiguraGeometrica caraBasal;

    public void setAltura(double altura)
    {
        this.altura = altura;
    }

    public double getAltura()
    {
        return this.altura;
    }

    public void setCaraBasal(FiguraGeometrica caraBasal)
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
