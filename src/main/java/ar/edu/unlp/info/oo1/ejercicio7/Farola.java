package ar.edu.unlp.info.oo1.ejercicio7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Farola
{
    private       boolean      encendida = false;
    private final List<Farola> vecinos   = new ArrayList<>();

    public void pairWithNeighbor(Farola farola)
    {
        if (!this.vecinos.contains(farola)) {
            this.vecinos.add(farola);
            farola.pairWithNeighbor(this);
        }
    }

    public Collection<Farola> getNeighbors()
    {
        return new ArrayList<>(this.vecinos);
    }

    public void turnOn()
    {
        if (!this.encendida) {
            this.encendida = true;
            this.vecinos.forEach(Farola::turnOn);
        }
    }

    public void turnOff()
    {
        if (this.encendida) {
            this.encendida = false;
            this.vecinos.forEach(Farola::turnOff);
        }
    }

    public boolean isOn()
    {
        return this.encendida;
    }

    public boolean isOff()
    {
        return !this.isOn();
    }
}