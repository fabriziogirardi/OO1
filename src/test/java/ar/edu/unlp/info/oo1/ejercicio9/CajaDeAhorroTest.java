package ar.edu.unlp.info.oo1.ejercicio9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CajaDeAhorroTest {

    private CajaDeAhorro cajaAhorro1;

    @BeforeEach
    void setUp()
    {
        cajaAhorro1 = new CajaDeAhorro();
    }

    @Test
    void testConstructor()
    {
        assertEquals(0, cajaAhorro1.getSaldo());
    }

    @Test
    void testDepositar()
    {
        cajaAhorro1.depositar(1000);
        assertEquals(1000 * 0.98, cajaAhorro1.getSaldo());
    }

    @Test
    void testExtraerConSaldo()
    {
        cajaAhorro1.depositar(1000);
        assertTrue(cajaAhorro1.extraer(100));

        // Se debería restar el 2% en el depósito y sumar el 2% en la extracción
        double resultadoEsperado = 1000 * 0.98 - 100 * 1.02;
        assertEquals(resultadoEsperado, cajaAhorro1.getSaldo());
    }

    @Test
    void testExtraerSinSaldo()
    {
        assertFalse(cajaAhorro1.extraer(100));
        assertEquals(0, cajaAhorro1.getSaldo());
    }

    @Test
    void testTransferirConSaldo()
    {
        CajaDeAhorro cajaAhorro2 = new CajaDeAhorro();
        cajaAhorro1.depositar(1000);
        assertTrue(cajaAhorro1.transferirACuenta(100, cajaAhorro2));

        // Se debería restar el 2% en el depósito y sumar el 2% en la transferencia
        // en la cuenta 1 y restar el 2% en la cuenta 2
        double resultadoEsperado1 = 1000 * 0.98 - 100 * 1.02;
        double resultadoEsperado2 = 100 * 0.98;
        assertEquals(resultadoEsperado1, cajaAhorro1.getSaldo());
        assertEquals(resultadoEsperado2, cajaAhorro2.getSaldo());
    }

    @Test
    void testTransferirSinSaldo()
    {
        CajaDeAhorro cajaAhorro2 = new CajaDeAhorro();
        assertFalse(cajaAhorro1.transferirACuenta(100, cajaAhorro2));
        assertEquals(0, cajaAhorro1.getSaldo());
        assertEquals(0, cajaAhorro2.getSaldo());
    }

    @Test
    void testTransferirCuentaCorrienteConSaldo()
    {
        CuentaCorriente cuentaCorriente = new CuentaCorriente();
        cajaAhorro1.depositar(1000);
        assertTrue(cajaAhorro1.transferirACuenta(100, cuentaCorriente));

        // Se debería restar el 2% en el depósito y sumar el 2% en la transferencia
        double resultadoEsperado1 = 1000 * 0.98 - 100 * 1.02;
        assertEquals(resultadoEsperado1, cajaAhorro1.getSaldo());

        // A la cuenta corriente no se le descuenta nada.
        assertEquals(100, cuentaCorriente.getSaldo());
    }

    @Test
    void testTransferirCuentaCorrienteSinSaldo()
    {
        CuentaCorriente cuentaCorriente = new CuentaCorriente();
        assertFalse(cajaAhorro1.transferirACuenta(100, cuentaCorriente));
        assertEquals(0, cajaAhorro1.getSaldo());
        assertEquals(0, cuentaCorriente.getSaldo());
    }
}