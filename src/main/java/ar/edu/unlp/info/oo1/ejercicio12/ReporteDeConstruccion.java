package ar.edu.unlp.info.oo1.ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion
{
    private final List<Pieza> piezas;

    public ReporteDeConstruccion()
    {
        this.piezas = new ArrayList<>();
    }

    public void agregarPieza(Pieza pieza)
    {
        this.piezas.add(pieza);
    }

    public List<Pieza> getPiezas()
    {
        return new ArrayList<>(this.piezas);
    }

    public double getVolumenDeMaterial(String material)
    {
        return this.piezas.stream()
            .filter(pieza -> pieza.getMaterial().equals(material))
            .mapToDouble(Pieza::getVolumen)
            .sum();
    }

    public double getSuperficieDeColor(String color)
    {
        return this.piezas.stream()
            .filter(pieza -> pieza.getColor().equals(color))
            .mapToDouble(Pieza::getSuperficie)
            .sum();
    }
}
