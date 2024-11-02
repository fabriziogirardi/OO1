package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario
{
    private final String        nombre;
    private final String        direccion;
    private final List<Consumo> consumos;

    public Usuario(String nombre, String direccion)
    {
        this.nombre    = nombre;
        this.direccion = direccion;
        this.consumos  = new ArrayList<>();
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDireccion()
    {
        return this.direccion;
    }

    public Consumo ultimoConsumo()
    {
        return this.consumos.getLast();
    }

    public void agregarConsumo(Consumo consumo)
    {
        this.consumos.add(consumo);
    }

    public Factura emitirFactura(CuadroTarifario cuadroTarifario)
    {
        double total = this.ultimoConsumo().calcularCostoConsumo(cuadroTarifario.getPrecioKwh());
        double bonificacion = this.ultimoConsumo().verificarBonificacion() ? total * 0.1 : 0.0;

        return new Factura(this.getNombre(),
                           this.getDireccion(),
                           LocalDate.now(),
                           bonificacion,
                           total);
    }
}
