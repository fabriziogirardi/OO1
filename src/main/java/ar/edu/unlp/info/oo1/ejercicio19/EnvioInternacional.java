package ar.edu.unlp.info.oo1.ejercicio19;

import java.time.LocalDate;

public class EnvioInternacional extends Envio
{
    public EnvioInternacional(LocalDate fecha, String origen, String destino, int peso)
    {
        super(fecha, origen, destino, peso);
    }

    public double calcularcosto()
    {
        return 5000 + (this.getPeso() > 1000 ? this.getPeso() * 12 : this.getPeso() * 10);

    }
}
