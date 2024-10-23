package ar.edu.unlp.info.oo1.ejercicio11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InversorTest
{
    private PlazoFijo plazoFijo;
    private InversionEnAcciones inversionEnAcciones;
    private Inversor inversor;

    @BeforeEach
    void setUp()
    {
        inversor = new Inversor("Juan");
    }

    @Test
    void testConstructor()
    {
        assertEquals("Juan", inversor.getNombre());
        assertEquals(0, inversor.getInversiones().size());
    }

    @Test
    void testAgregarInversion()
    {
        iniciarPlazoFijo();
        inversor.agregarInversion(plazoFijo);
        assertEquals(1, inversor.getInversiones().size());
        assertEquals(plazoFijo, inversor.getInversiones().getFirst());
    }

    @Test
    void testQuitarInversion()
    {
        iniciarPlazoFijo();
        inversor.agregarInversion(plazoFijo);
        inversor.quitarInversion(plazoFijo);
        assertEquals(0, inversor.getInversiones().size());
    }

    @Test
    void testValorActualPlazoFijo()
    {
        iniciarPlazoFijo();
        inversor.agregarInversion(plazoFijo);
        assertEquals((1000 * (Math.pow(1.15, 5))), inversor.valorActual());
    }

    @Test
    void testValorActualInversionEnAcciones()
    {
        iniciarInversionEnAcciones();
        inversor.agregarInversion(inversionEnAcciones);
        assertEquals(15000, inversor.valorActual());

        // Para que no joda que no testeo el getter
        assertEquals("Apple", inversionEnAcciones.getNombre());
    }

    @Test
    void testValorActualInversiones()
    {
        iniciarPlazoFijo();
        iniciarInversionEnAcciones();
        inversor.agregarInversion(plazoFijo);
        inversor.agregarInversion(inversionEnAcciones);
        assertEquals((1000 * (Math.pow(1.15, 5))) + 15000, inversor.valorActual());
    }

    void iniciarPlazoFijo()
    {
        plazoFijo = new PlazoFijo(LocalDate.now().minusDays(5),1000, 0.15);
    }

    void iniciarInversionEnAcciones()
    {
        inversionEnAcciones = new InversionEnAcciones("Apple",1000, 15);

    }
}