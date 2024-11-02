package ar.edu.unlp.info.oo1.ejercicio15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest
{
    private Usuario usuario;

    @BeforeEach
    void setUp()
    {
        this.usuario = new Usuario("Juan", "Calle 123");
    }

    @Test
    void getNombre()
    {
        assertEquals("Juan", this.usuario.getNombre());
    }

    @Test
    void getDireccion()
    {
        assertEquals("Calle 123", this.usuario.getDireccion());
    }

    @Test
    void ultimoConsumo()
    {
        Consumo consumo = new Consumo(100, 50);
        Consumo consumo2 = new Consumo(200, 100);
        this.usuario.agregarConsumo(consumo);
        this.usuario.agregarConsumo(consumo2);
        assertEquals(consumo2, this.usuario.ultimoConsumo());
    }

    @Test
    void agregarConsumo()
    {
        Consumo consumo = new Consumo(100, 50);
        this.usuario.agregarConsumo(consumo);
        assertEquals(consumo, this.usuario.ultimoConsumo());
    }

    @Test
    void emitirFactura()
    {
        Consumo consumo = new Consumo(100, 50);
        this.usuario.agregarConsumo(consumo);
        CuadroTarifario cuadroTarifario = new CuadroTarifario(20.50);
        Factura factura = this.usuario.emitirFactura(cuadroTarifario);
        assertEquals("Juan", factura.getNombre());
        assertEquals("Calle 123", factura.getDireccion());
        assertEquals(2050 - 205, factura.getTotal());
        assertEquals(2050 * 0.1, factura.getBonificacion());
    }
}