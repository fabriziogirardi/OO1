package ar.edu.unlp.info.oo1.ejercicio15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacturaTest
{
    private Factura factura;

    @BeforeEach
    void setUp()
    {
        Usuario usuario = new Usuario("Juan", "Calle 123");
        Consumo consumo = new Consumo(100, 50);
        usuario.agregarConsumo(consumo);
        CuadroTarifario cuadroTarifario = new CuadroTarifario(20.50);
        this.factura = usuario.emitirFactura(cuadroTarifario);
    }

    @Test
    void getNombre()
    {
        assertEquals("Juan", this.factura.getNombre());
    }

    @Test
    void getDireccion()
    {
        assertEquals("Calle 123", this.factura.getDireccion());
    }

    @Test
    void getFecha()
    {
        assertEquals(java.time.LocalDate.now(), this.factura.getFecha());
    }

    @Test
    void getBonificacion()
    {
        assertEquals(2050 * 0.1, this.factura.getBonificacion());
    }

    @Test
    void getTotal()
    {
        assertEquals(2050 - 205, this.factura.getTotal());
    }
}