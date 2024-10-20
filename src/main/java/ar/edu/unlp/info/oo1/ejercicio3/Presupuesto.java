package ar.edu.unlp.info.oo1.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto
{
    private final LocalDate  fecha;
    private final String     cliente;
    private final List<Item> items = new ArrayList<>();

    public Presupuesto(String cliente) {
        this.fecha = LocalDate.now();
        this.cliente = cliente;
    }

    public double calcularTotal()
    {
        return this.items.stream().mapToDouble(Item::costo).sum();
    }

    public void agregarItem(Item item)
    {
        this.items.add(item);
    }

    public LocalDate getFecha()
    {
        return this.fecha;
    }

    public String getCliente()
    {
        return this.cliente;
    }
}
