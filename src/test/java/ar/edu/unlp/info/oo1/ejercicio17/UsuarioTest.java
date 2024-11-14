package ar.edu.unlp.info.oo1.ejercicio17;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.util.List;

public class UsuarioTest extends TestCase
{
    Usuario usuario;

    public void setUp() throws Exception
    {
        usuario = new Usuario("Juan", "Calle Falsa 123", "12345678");
        String direccion = usuario.getDireccion();
        String dni       = usuario.getDni();
    }

    public void testVerificarDisponibilidadFechaDisponible()
    {
        Propiedad       propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0);
        Usuario         u         = propiedad.getPropietario();
        List<Propiedad> p         = u.getPropiedades();
        propiedad.addReserva(usuario, new DateLapse(LocalDate.now(), LocalDate.now().plusDays(10)));
        assertTrue(propiedad.verificarDisponibilidad(
                new DateLapse(LocalDate.now().plusDays(11), LocalDate.now().plusDays(20))));
    }

    public void testVerificarDisponibilidadFechaNoDisponible()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0);
        propiedad.addReserva(usuario, new DateLapse(LocalDate.now(), LocalDate.now().plusDays(10)));
        assertFalse(propiedad.verificarDisponibilidad(
                new DateLapse(LocalDate.now().plusDays(5), LocalDate.now().plusDays(15))));
    }

    public void testReservarPropiedadDisponible()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0);
        Reserva   reserva   = propiedad.addReserva(usuario, new DateLapse(LocalDate.now().plusDays(1),
                                                                          LocalDate.now().plusDays(10)));
        assertNotNull(reserva);
    }

    public void testCancelarReserva()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0);
        Reserva   reserva   = propiedad.addReserva(usuario, new DateLapse(LocalDate.now().plusDays(1),
                                                                          LocalDate.now().plusDays(10)));
        propiedad.cancelarReserva(reserva);
        assertFalse(propiedad.getReservas().contains(reserva));
    }

    public void testCalcularIngresos()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0);
        propiedad.addReserva(usuario, new DateLapse(LocalDate.now(), LocalDate.now().plusDays(10)));
        propiedad.addReserva(usuario, new DateLapse(LocalDate.now().plusDays(11), LocalDate.now().plusDays(20)));
        assertEquals(19000.0,
                     usuario.calcularIngresosEnPeriodo(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(20))));
    }
}