package ar.edu.unlp.info.oo1.ejercicio15;

public class Consumo
{
    private final double consumoEnergiaActiva;
    private final double consumoEnergiaReactiva;

    public Consumo(double consumoEnergiaActiva, double consumoEnergiaReactiva)
    {
        this.consumoEnergiaActiva = consumoEnergiaActiva;
        this.consumoEnergiaReactiva = consumoEnergiaReactiva;
    }

    public double getConsumoEnergiaActiva()
    {
        return this.consumoEnergiaActiva;
    }

    public double getConsumoEnergiaReactiva()
    {
        return this.consumoEnergiaReactiva;
    }

    public double calcularCostoConsumo(double precioKwh)
    {
        return this.consumoEnergiaActiva * precioKwh;
    }

    public double calcularFactorPotencia()
    {
        return this.consumoEnergiaActiva / Math.sqrt(Math.pow(this.consumoEnergiaActiva, 2) + Math.pow(this.consumoEnergiaReactiva, 2));
    }

    public boolean verificarBonificacion()
    {
        return this.calcularFactorPotencia() > 0.8;
    }
}
