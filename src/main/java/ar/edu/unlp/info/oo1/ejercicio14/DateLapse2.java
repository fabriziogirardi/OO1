package ar.edu.unlp.info.oo1.ejercicio14;

import java.time.LocalDate;

public class DateLapse2 implements Intervalable
{
    private final LocalDate from;
    private final int sizeInDays;

    public DateLapse2(LocalDate from, int sizeInDays)
    {
        this.from = from;
        this.sizeInDays = sizeInDays;
    }

    public LocalDate getFrom()
    {
        return this.from;
    }

    public LocalDate getTo()
    {
        return this.from.plusDays(this.sizeInDays);
    }

    public int sizeInDays()
    {
        return this.sizeInDays;
    }

    public boolean includesDate(LocalDate other)
    {
        return other != null && (!other.isBefore(this.getFrom()) && !other.isAfter(this.getTo()));
    }
}
