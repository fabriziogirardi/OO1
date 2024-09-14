package ar.edu.unlp.info.oo1.practica1.ejercicio5;

public class Circulo extends FiguraGeometrica
{
    private double radio;

    public double getDiametro()
    {
        return 2 * this.getRadio();
    }

    public void setDiametro(double diametro)
    {
        this.setRadio(diametro / 2);
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
