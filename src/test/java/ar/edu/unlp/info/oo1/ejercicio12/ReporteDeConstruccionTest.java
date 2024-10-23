package ar.edu.unlp.info.oo1.ejercicio12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReporteDeConstruccionTest
{
    ReporteDeConstruccion reporteDeConstruccion;
    Pieza cilindro;
    Pieza esfera;
    Pieza prisma;

    @BeforeEach
    void setUp()
    {
        reporteDeConstruccion = new ReporteDeConstruccion();
        setUpPiezas();
    }

    @Test
    void testConstructor()
    {
        assertEquals(0, reporteDeConstruccion.getPiezas().size());
    }

    @Test
    void agregarPieza()
    {
        reporteDeConstruccion.agregarPieza(cilindro);
        assertEquals(1, reporteDeConstruccion.getPiezas().size());
    }

    @Test
    void getVolumenDeMaterial()
    {
        reporteDeConstruccion.agregarPieza(cilindro);
        reporteDeConstruccion.agregarPieza(esfera);
        reporteDeConstruccion.agregarPieza(prisma);
        assertEquals(4188.790204786391, reporteDeConstruccion.getVolumenDeMaterial("Madera"));
        assertEquals(1770.7963267948967, reporteDeConstruccion.getVolumenDeMaterial("Metal"));
    }

    @Test
    void getSuperficieDeColor()
    {
        reporteDeConstruccion.agregarPieza(cilindro);
        reporteDeConstruccion.agregarPieza(esfera);
        reporteDeConstruccion.agregarPieza(prisma);
        assertEquals(942.4777960769379, reporteDeConstruccion.getSuperficieDeColor("Rojo"));
        assertEquals(1476.6370614359173, reporteDeConstruccion.getSuperficieDeColor("Azul"));
    }

    void setUpPiezas()
    {
        cilindro = new Cilindro("Metal", "Rojo", 10, 5);
        esfera = new Esfera("Madera", "Azul", 10);
        prisma = new Prisma("Metal", "Azul", 10, 5, 4);
    }
}