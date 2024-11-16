package ar.edu.unlp.info.oo1.ejercicio23;

public class ExpressDomicilio implements IFormaDeEnvio
{
    private double precioPorKm()
    {
        return 0.5;
    }

    public double calcularCosto(String direccion1, String direccion2)
    {
        return this.precioPorKm() * CalculadoraDeDistancia.distanciaEntre(direccion1, direccion2);
    }
}
