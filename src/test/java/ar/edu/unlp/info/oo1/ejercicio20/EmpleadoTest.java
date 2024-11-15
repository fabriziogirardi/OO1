package ar.edu.unlp.info.oo1.ejercicio20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class EmpleadoTest
{
    Empleado empleado;

    Empleado crearEmpleado(boolean hijos, boolean conyuge)
    {
        return new Empleado("Juan", "Perez", "1234567890", LocalDate.of(2000, 6, 18), hijos, conyuge);
    }

    @BeforeEach
    void setUp()
    {
        empleado = crearEmpleado(false, false);
    }

    @Test
    void getNombre()
    {
        assertEquals("Juan", empleado.getNombre());
    }

    @Test
    void getApellido()
    {
        assertEquals("Perez", empleado.getApellido());
    }

    @Test
    void getCuil()
    {
        assertEquals("1234567890", empleado.getCuil());
    }

    @Test
    void getFechaNacimiento()
    {
        assertEquals(LocalDate.of(2000, 6, 18), empleado.getFechaNacimiento());
    }

    @Test
    void hasHijo()
    {
        assertFalse(empleado.hasHijo());
    }

    @Test
    void hasConyuge()
    {
        assertFalse(empleado.hasConyuge());
    }

    @Test
    void getContratos()
    {
        assertEquals(0, empleado.getContratos().size());
    }

    @Test
    void addContrato()
    {
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 5), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(1, empleado.getContratos().size());
        assertEquals(contrato, empleado.getContratos().getFirst());
    }

    @Test
    void calcularAntiguedad()
    {
        assertEquals(0, empleado.calcularAntiguedad());
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 5), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(5, empleado.calcularAntiguedad());
    }

    @Test
    void calcularSueldoSinAños()
    {
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(100), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoCincoAños()
    {
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 5), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoSeisAños()
    {
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 6), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000 * 1.3, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoDiezAños()
    {
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 10), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000 * 1.3, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoOnceAños()
    {
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 11), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000 * 1.5, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoQuinceAños()
    {
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 15), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000 * 1.5, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoDieciseisAños()
    {
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 16), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000 * 1.7, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoVeinteAños()
    {
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 20), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000 * 1.7, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoVeintiunAños()
    {
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 21), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000 * 2, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoConHijo()
    {
        empleado = crearEmpleado(true, false);
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 5), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000 + 2000, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoConConyuge()
    {
        empleado = crearEmpleado(false, true);
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 5), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000 + 5000, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoConHijoConConyuge()
    {
        empleado = crearEmpleado(true, true);
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 5), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        assertEquals(18000 + 7000, empleado.calcularSueldo());
    }

    @Test
    void calcularSueldoPorHoras()
    {
        empleado = crearEmpleado(false, false);
        Contrato contrato = new ContratoPorHoras(empleado, LocalDate.now().minusDays(365 * 5), 100, 160,
                                                 LocalDate.now().plusDays(10));
        empleado.addContrato(contrato);
        assertEquals(16000, empleado.calcularSueldo());
    }

    @Test
    void generarReciboDeSueldo()
    {
        empleado = crearEmpleado(false, false);
        Contrato contrato = new ContratoDePlanta(empleado, LocalDate.now().minusDays(365 * 5), 18000, 5000, 2000);
        empleado.addContrato(contrato);
        ReciboDeSueldo recibo = empleado.generarReciboDeSueldo();
        assertEquals("Juan", recibo.getNombre());
        assertEquals("Perez", recibo.getApellido());
        assertEquals("1234567890", recibo.getCuil());
        assertEquals(LocalDate.now(), recibo.getFecha());
        assertEquals(18000, recibo.getMonto());
    }
}