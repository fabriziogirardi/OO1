package ar.edu.unlp.info.oo1.ejercicio23;

public class SeisCuotas implements IFormaDePago
{
    private double getRecargo()
    {
        return 0.2;
    }

    public double calcularCosto(double precio)
    {
        return precio * (1 + this.getRecargo());
    }
}
