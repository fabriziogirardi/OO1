package ar.edu.unlp.info.oo1.ejercicio14;

import java.time.LocalDate;

public class DateLapse implements Intervalable
{
    private final LocalDate from;
    private final LocalDate to;

    public DateLapse(LocalDate from, LocalDate to)
    {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom()
    {
        return this.from;
    }

    public LocalDate getTo()
    {
        return this.to;
    }

    public int sizeInDays()
    {
        return (int) this.from.datesUntil(this.to).count();
    }

    public boolean includesDate(LocalDate other)
    {
        return other != null && (!other.isBefore(this.getFrom()) && !other.isAfter(this.getTo()));
    }

    public boolean overlaps (DateLapse other) {
        return other != null && (this.includesDate(other.getFrom()) || this.includesDate(other.getTo()));
    }
}
