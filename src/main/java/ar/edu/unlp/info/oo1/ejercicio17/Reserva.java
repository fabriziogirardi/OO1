package ar.edu.unlp.info.oo1.ejercicio17;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;

import java.time.LocalDate;

public class Reserva
{
    private final Usuario inquilino;
    private final Propiedad propiedad;
    private final DateLapse periodo;

    public Reserva(Usuario inquilino, Propiedad propiedad, DateLapse periodo)
    {
        this.inquilino = inquilino;
        this.propiedad = propiedad;
        this.periodo   = periodo;
    }

    public Usuario getInquilino()
    {
        return this.inquilino;
    }

    public Propiedad getPropiedad()
    {
        return this.propiedad;
    }

    public DateLapse getPeriodo()
    {
        return this.periodo;
    }

    public boolean enCurso()
    {
        return this.periodo.includesDate(LocalDate.now());
    }

    public double calcularPrecio()
    {
        return this.periodo.sizeInDays() * this.propiedad.getPrecio();
    }

    public boolean disponible(DateLapse fecha)
    {
        return !this.periodo.overlaps(fecha);
    }
}
