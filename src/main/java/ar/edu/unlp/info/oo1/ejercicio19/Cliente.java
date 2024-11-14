package ar.edu.unlp.info.oo1.ejercicio19;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente
{
    private final String      nombre;
    private final String      direccion;
    private final List<Envio> envios;

    public Cliente(String nombre, String direccion)
    {
        this.nombre    = nombre;
        this.direccion = direccion;
        this.envios    = new ArrayList<>();
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDireccion()
    {
        return this.direccion;
    }

    public void agregarEnvio(Envio envio)
    {
        this.envios.add(envio);
    }

    public List<Envio> getEnvios()
    {
        return new ArrayList<>(this.envios);
    }

    public double calcularMonto(DateLapse periodo)
    {
        double monto = this.envios.stream()
                                  .filter(envio -> envio.estaEnPeriodo(periodo))
                                  .mapToDouble(Envio::calcularcosto)
                                  .sum();
        return this.aplicarDescuento(monto);
    }

    protected abstract double aplicarDescuento(double monto);
}
