package ar.edu.unlp.info.oo1.ejercicio13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArchivoTest
{
    Archivo archivo;

    @BeforeEach
    void setUp()
    {
        archivo = new Archivo("Archivo");
    }

    @Test
    void testGetNombre()
    {
        assertEquals("Archivo", archivo.getNombre());
    }

    @Test
    void testTamanio()
    {
        assertEquals(7, archivo.tamanio());
    }
}