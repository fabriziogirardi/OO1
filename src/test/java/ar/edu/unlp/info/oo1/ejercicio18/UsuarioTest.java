package ar.edu.unlp.info.oo1.ejercicio18;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;
import junit.framework.TestCase;

import java.time.LocalDate;

public class UsuarioTest extends TestCase
{
    Usuario usuario;

    public void setUp() throws Exception
    {
        usuario = new Usuario("Juan", "Calle Falsa 123", "12345678");
        String direccion = usuario.getDireccion();
    }

    public void testVerificarDisponibilidadFechaDisponible()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0, new PoliticaFlexible());
        propiedad.addReserva(usuario, new DateLapse(LocalDate.now(), LocalDate.now().plusDays(10)));
        assertTrue(propiedad.verificarDisponibilidad(
                new DateLapse(LocalDate.now().plusDays(11), LocalDate.now().plusDays(20))));
    }

    public void testVerificarDisponibilidadFechaNoDisponible()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0, new PoliticaFlexible());
        propiedad.addReserva(usuario, new DateLapse(LocalDate.now(), LocalDate.now().plusDays(10)));
        assertFalse(propiedad.verificarDisponibilidad(
                new DateLapse(LocalDate.now().plusDays(5), LocalDate.now().plusDays(15))));
    }

    public void testReservarPropiedadDisponible()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0, new PoliticaFlexible());
        Reserva reserva = propiedad.addReserva(usuario, new DateLapse(LocalDate.now().plusDays(1),
                                                                      LocalDate.now().plusDays(10)));
        assertNotNull(reserva);
    }

    public void testCancelarReserva()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0, new PoliticaFlexible());
        Reserva reserva = propiedad.addReserva(usuario, new DateLapse(LocalDate.now().plusDays(1),
                                                                      LocalDate.now().plusDays(10)));
        propiedad.cancelarReserva(reserva);
        assertFalse(propiedad.getReservas().contains(reserva));
    }

    public void testPoliticaFlexible()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0, new PoliticaFlexible());
        Reserva reserva = propiedad.addReserva(usuario, new DateLapse(LocalDate.now().plusDays(1),
                                                                      LocalDate.now().plusDays(10)));
        assertEquals(9000.0, reserva.calcularPrecio());
        double devolucion = propiedad.cancelarReserva(reserva);
        assertEquals(9000.0, devolucion);
    }

    public void testPoliticaEstricta()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0, new PoliticaEstricta());
        Reserva reserva = propiedad.addReserva(usuario, new DateLapse(LocalDate.now().plusDays(1),
                                                                      LocalDate.now().plusDays(10)));
        assertEquals(9000.0, reserva.calcularPrecio());
        double devolucion = propiedad.cancelarReserva(reserva);
        assertEquals(0.0, devolucion);
    }

    public void testPoliticaModeradaDiezDiasAntes()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0, new PoliticaModerada());
        Reserva reserva = propiedad.addReserva(usuario, new DateLapse(LocalDate.now().plusDays(11),
                                                                      LocalDate.now().plusDays(20)));
        assertEquals(9000.0, reserva.calcularPrecio());
        double devolucion = propiedad.cancelarReserva(reserva);
        assertEquals(9000.0, devolucion);
    }

    public void testPoliticaModeradaTresDiasAntes()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0, new PoliticaModerada());
        Reserva reserva = propiedad.addReserva(usuario, new DateLapse(LocalDate.now().plusDays(4),
                                                                      LocalDate.now().plusDays(13)));
        assertEquals(9000.0, reserva.calcularPrecio());
        double devolucion = propiedad.cancelarReserva(reserva);
        assertEquals(4500.0, devolucion);
    }

    public void testCambiarPoliticaCancelacion()
    {
        Propiedad propiedad = usuario.addPropiedad("Casa", "Calle Falsa 123", 1000.0, new PoliticaFlexible());
        propiedad.setPoliticaCancelacion(new PoliticaEstricta());
        Reserva reserva = propiedad.addReserva(usuario, new DateLapse(LocalDate.now().plusDays(1),
                                                                      LocalDate.now().plusDays(10)));
        assertEquals(9000.0, reserva.calcularPrecio());
        double devolucion = propiedad.cancelarReserva(reserva);
        assertEquals(0.0, devolucion);
    }
}