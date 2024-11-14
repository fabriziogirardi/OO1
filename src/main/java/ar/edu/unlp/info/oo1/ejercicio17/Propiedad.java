package ar.edu.unlp.info.oo1.ejercicio17;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;

import java.util.ArrayList;
import java.util.List;

public class Propiedad
{
    private final String        nombre;
    private final String        direccion;
    private final double        precio;
    private final Usuario       propietario;
    private final List<Reserva> reservas;

    public Propiedad(String nombre, String direccion, double precio, Usuario propietario)
    {
        this.nombre    = nombre;
        this.direccion = direccion;
        this.precio    = precio;
        this.propietario = propietario;
        this.reservas  = new ArrayList<>();
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDireccion()
    {
        return this.direccion;
    }

    public double getPrecio()
    {
        return this.precio;
    }

    public Usuario getPropietario()
    {
        return this.propietario;
    }

    public Reserva addReserva(Usuario u, DateLapse periodo)
    {
        if (this.verificarDisponibilidad(periodo)) {
            Reserva r = new Reserva(u, this, periodo);
            this.reservas.add(r);
            return r;
        }

        return null;
    }

    public void cancelarReserva(Reserva r)
    {
        if (this.reservas.contains(r) && !r.enCurso()) {
            this.reservas.remove(r);
        }
    }

    public List<Reserva> getReservas()
    {
        return new ArrayList<>(this.reservas);
    }

    public double calcularIngresosEnPeriodo(DateLapse fecha)
    {
        return this.reservas.stream()
                            .filter(r -> !r.disponible(fecha))
                            .mapToDouble(Reserva::calcularPrecio)
                            .sum();
    }

    public boolean verificarDisponibilidad(DateLapse periodo)
    {
        return this.reservas.stream().allMatch(r -> r.disponible(periodo));
    }
}
