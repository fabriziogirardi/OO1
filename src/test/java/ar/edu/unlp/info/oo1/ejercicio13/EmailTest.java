package ar.edu.unlp.info.oo1.ejercicio13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest
{
    Email email;

    @BeforeEach
    void setUp()
    {
        Archivo archivo = new Archivo("Archivo");
        List<Archivo> adjuntos = new ArrayList<>();
        adjuntos.add(archivo);
        email = new Email("Titulo", "Cuerpo", adjuntos);
    }

    @Test
    void testGetTitulo()
    {
        assertEquals("Titulo", email.getTitulo());
    }

    @Test
    void testGetCuerpo()
    {
        assertEquals("Cuerpo", email.getCuerpo());
    }

    @Test
    void testGetAdjuntos()
    {
        assertEquals(1, email.getAdjuntos().size());
    }

    @Test
    void testEspacioOcupado()
    {
        assertEquals(19, email.espacioOcupado());
    }

    @Test
    void testContiene()
    {
        assertTrue(email.contiene("Titulo"));
        assertTrue(email.contiene("Cuerpo"));
        assertFalse(email.contiene("Texto"));
    }
}