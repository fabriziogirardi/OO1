package ar.edu.unlp.info.oo1.ejercicio9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest
{
    private CuentaCorriente cuentaCorriente1;
    private CuentaCorriente cuentaCorriente2;

    @BeforeEach
    void setUp()
    {
        cuentaCorriente1 = new CuentaCorriente();
    }

    @Test
    void testCconstructor()
    {
        assertEquals(0, cuentaCorriente1.getSaldo());
    }

    @Test
    void testDepositar()
    {
        cuentaCorriente1.depositar(100);
        assertEquals(100, cuentaCorriente1.getSaldo());
    }

    @Test
    void testExtraerConSaldoSuficiente()
    {
        cuentaCorriente1.depositar(100);
        assertTrue(cuentaCorriente1.extraer(100));
        assertEquals(0, cuentaCorriente1.getSaldo());
    }

    @Test
    void testExtraerConSaldoInsuficienteSinDescubierto()
    {
        cuentaCorriente1.depositar(100);
        assertFalse(cuentaCorriente1.extraer(101));
        assertEquals(100, cuentaCorriente1.getSaldo());
    }

    @Test
    void testExtraerConSaldoInsuficienteConDescubierto()
    {
        cuentaCorriente1.depositar(100);
        cuentaCorriente1.setDescubierto(50);
        assertTrue(cuentaCorriente1.extraer(150));
        assertEquals(-50, cuentaCorriente1.getSaldo());
    }

    @Test
    void testExtraerConSaldoInsuficienteConDescubiertoExcedido()
    {
        cuentaCorriente1.depositar(100);
        cuentaCorriente1.setDescubierto(50);
        assertFalse(cuentaCorriente1.extraer(151));
        assertEquals(100, cuentaCorriente1.getSaldo());
    }

    @Test
    void testTransferirConSaldoSuficiente()
    {
        cuentaCorriente1.depositar(100);
        cuentaCorriente2 = new CuentaCorriente();
        assertTrue(cuentaCorriente1.transferirACuenta(50, cuentaCorriente2));
        assertEquals(50, cuentaCorriente1.getSaldo());
        assertEquals(50, cuentaCorriente2.getSaldo());
    }

    @Test
    void testTransferirConSaldoInsuficienteSinDescubierto()
    {
        cuentaCorriente1.depositar(100);
        cuentaCorriente2 = new CuentaCorriente();
        assertFalse(cuentaCorriente1.transferirACuenta(101, cuentaCorriente2));
        assertEquals(100, cuentaCorriente1.getSaldo());
        assertEquals(0, cuentaCorriente2.getSaldo());
    }

    @Test
    void testTransferirConSaldoInsuficienteConDescubierto()
    {
        cuentaCorriente1.depositar(100);
        cuentaCorriente1.setDescubierto(50);
        cuentaCorriente2 = new CuentaCorriente();
        assertTrue(cuentaCorriente1.transferirACuenta(150, cuentaCorriente2));
        assertEquals(-50, cuentaCorriente1.getSaldo());
        assertEquals(150, cuentaCorriente2.getSaldo());
    }

    @Test
    void testTransferirConSaldoInsuficienteConDescubiertoExcedido()
    {
        cuentaCorriente1.depositar(100);
        cuentaCorriente1.setDescubierto(50);
        cuentaCorriente2 = new CuentaCorriente();
        assertFalse(cuentaCorriente1.transferirACuenta(151, cuentaCorriente2));
        assertEquals(100, cuentaCorriente1.getSaldo());
        assertEquals(0, cuentaCorriente2.getSaldo());
    }

    @Test
    void testTransferirACajaDeAhorro()
    {
        cuentaCorriente1.depositar(100);
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro();
        assertTrue(cuentaCorriente1.transferirACuenta(50, cajaDeAhorro));
        assertEquals(50, cuentaCorriente1.getSaldo());

        double saldoEsperado = (50 * 0.98);
        assertEquals(saldoEsperado, cajaDeAhorro.getSaldo());
    }
}