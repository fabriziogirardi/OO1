package ar.edu.unlp.info.oo1.ejercicio18;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;

import java.time.LocalDate;

public class PoliticaModerada implements IPoliticaCancelacion
{
    public double calcularReintegro(Reserva r)
    {
        DateLapse diasAntes = new DateLapse(LocalDate.now(), r.getFrom());
        return diasAntes.sizeInDays() >= 7
               ? r.calcularPrecio()
               : diasAntes.sizeInDays() >= 2
                 ? r.calcularPrecio() / 2
                 : 0;

    }
}
