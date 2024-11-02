package ar.edu.unlp.info.oo1.ejercicio15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CuadroTarifarioTest
{
    private CuadroTarifario cuadroTarifario;

    @BeforeEach
    void setUp()
    {
        this.cuadroTarifario = new CuadroTarifario(20.50);
    }

    @Test
    void testGetPrecioKwh()
    {
        assertEquals(20.50, this.cuadroTarifario.getPrecioKwh());
    }

    @Test
    void testSetPrecioKwh()
    {
        this.cuadroTarifario.setPrecioKwh(30.50);
        assertEquals(30.50, this.cuadroTarifario.getPrecioKwh());
    }
}