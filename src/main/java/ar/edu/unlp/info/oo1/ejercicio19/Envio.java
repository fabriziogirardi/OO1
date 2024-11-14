package ar.edu.unlp.info.oo1.ejercicio19;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;

import java.time.LocalDate;

public abstract class Envio
{
    private final LocalDate fecha;
    private final String    origen;
    private final String    destino;
    private final int       peso;

    public Envio(LocalDate fecha, String origen, String destino, int peso)
    {
        this.fecha   = fecha;
        this.origen  = origen;
        this.destino = destino;
        this.peso    = peso;
    }

    public LocalDate getFecha()
    {
        return this.fecha;
    }

    public String getOrigen()
    {
        return this.origen;
    }

    public String getDestino()
    {
        return this.destino;
    }

    public int getPeso()
    {
        return this.peso;
    }

    public boolean estaEnPeriodo(DateLapse periodo)
    {
        return periodo.includesDate(this.fecha);
    }

    public abstract double calcularcosto();
}
