package ar.edu.unlp.info.oo1.ejercicio18;

public class PoliticaFlexible implements IPoliticaCancelacion
{
    public double calcularReintegro(Reserva r)
    {
        return r.calcularPrecio();
    }
}
