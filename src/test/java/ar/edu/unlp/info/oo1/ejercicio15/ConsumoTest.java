package ar.edu.unlp.info.oo1.ejercicio15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsumoTest
{
    private Consumo consumo;

    @BeforeEach
    void setUp()
    {
        this.consumo = new Consumo(100, 50);
    }

    @Test
    void getConsumoEnergiaActiva()
    {
        assertEquals(100, this.consumo.getConsumoEnergiaActiva());
    }

    @Test
    void getConsumoEnergiaReactiva()
    {
        assertEquals(50, this.consumo.getConsumoEnergiaReactiva());
    }

    @Test
    void calcularCostoConsumo()
    {
        assertEquals(2050, this.consumo.calcularCostoConsumo(20.50));
    }

    @Test
    void calcularFactorPotencia()
    {
        double fp = 100 / Math.sqrt(Math.pow(100, 2) + Math.pow(50, 2));
        assertEquals(fp, this.consumo.calcularFactorPotencia());
    }

    @Test
    void verificarBonificacion()
    {
        assertTrue(this.consumo.verificarBonificacion());
        Consumo consumo2 = new Consumo(100, 100);
        assertFalse(consumo2.verificarBonificacion());
    }
}