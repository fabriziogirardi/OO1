package ar.edu.unlp.info.oo1.ejercicio19;

import java.time.LocalDate;

public class EnvioInterurbano extends Envio
{
    private final double distancia;

    public EnvioInterurbano(LocalDate fecha, String origen, String destino, int peso, double distancia)
    {
        super(fecha, origen, destino, peso);
        this.distancia = distancia;
    }

    public double getDistancia()
    {
        return this.distancia;
    }

    public double calcularcosto()
    {
        return this.getDistancia() > 500
               ? 30 * this.getPeso()
               : this.getDistancia() >= 100
                 ? 25 * this.getPeso()
                 : 20 * this.getPeso();
    }
}
