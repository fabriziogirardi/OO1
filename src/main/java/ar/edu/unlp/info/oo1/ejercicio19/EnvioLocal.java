package ar.edu.unlp.info.oo1.ejercicio19;

import java.time.LocalDate;

public class EnvioLocal extends Envio
{
    private final boolean entregaRapida;

    public EnvioLocal(LocalDate fecha, String origen, String destino, int peso, boolean entregaRapida)
    {
        super(fecha, origen, destino, peso);
        this.entregaRapida = entregaRapida;
    }

    public boolean getEntregaRapida()
    {
        return this.entregaRapida;
    }

    public double calcularcosto()
    {
        return 1000 + (this.getEntregaRapida() ? 500 : 0);
    }
}
