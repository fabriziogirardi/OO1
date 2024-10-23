package ar.edu.unlp.info.oo1.ejercicio11;

import ar.edu.unlp.info.oo1.ejercicio11.interfaces.Inversion;

import java.util.ArrayList;
import java.util.List;

public class Inversor
{

    private final String          nombre;
    private final List<Inversion> inversiones;

    public Inversor(String n)
    {
        this.nombre = n;
        inversiones = new ArrayList<>();
    }

    public String getNombre()
    {
        return nombre;
    }

    public void agregarInversion(Inversion i)
    {
        inversiones.add(i);
    }

    public void quitarInversion(Inversion i)
    {
        inversiones.remove(i);
    }

    public List<Inversion> getInversiones()
    {
        return new ArrayList<>(inversiones);
    }

    public double valorActual()
    {
        return inversiones.stream().mapToDouble(Inversion::valorActual).sum();
    }
}
