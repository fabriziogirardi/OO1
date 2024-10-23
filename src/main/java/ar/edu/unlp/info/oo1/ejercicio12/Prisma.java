package ar.edu.unlp.info.oo1.ejercicio12;

public class Prisma extends Pieza
{
    private final double ladoMayor;
    private final double ladoMenor;
    private final double altura;

    public Prisma(String material, String color, double ladoMayor, double ladoMenor, double altura)
    {
        super(material, color);
        this.ladoMayor = ladoMayor;
        this.ladoMenor = ladoMenor;
        this.altura = altura;
    }

    public double getAltura()
    {
        return this.altura;
    }

    public double getLadoMayor()
    {
        return this.ladoMayor;
    }

    public double getLadoMenor()
    {
        return this.ladoMenor;
    }

    public double getVolumen()
    {
        return this.getLadoMayor() * this.getLadoMenor() * this.getAltura();
    }

    public double getSuperficie()
    {
        return 2 * (this.getLadoMayor() * this.getLadoMenor() + this.getLadoMayor() * this.getAltura() + this.getLadoMenor() * this.getAltura());
    }
}
