package ar.edu.unlp.info.oo1.ejercicio13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarpetaTest
{
    Carpeta carpeta1;
    Carpeta carpeta2;

    @BeforeEach
    void setUp()
    {
        carpeta1 = new Carpeta("Carpeta 1");
        carpeta2 = new Carpeta("Carpeta 2");
    }

    @Test
    void testGetNombre()
    {
        assertEquals("Carpeta 1", carpeta1.getNombre());
        assertEquals("Carpeta 2", carpeta2.getNombre());
    }

    @Test
    void testMover()
    {
        Email email1 = new Email("Email 1", "Texto 1");
        carpeta1.agregarEmail(email1);
        carpeta1.mover(email1, carpeta2);
        assertEquals(0, carpeta1.getEmails().size());
        assertEquals(1, carpeta2.getEmails().size());
    }

    @Test
    void testAgregarEmail()
    {
        Email email1 = new Email("Email 1", "Texto 1");
        carpeta1.agregarEmail(email1);
        assertEquals(1, carpeta1.getEmails().size());
    }

    @Test
    void testEliminarEmail()
    {
        Email email1 = new Email("Email 1", "Texto 1");
        carpeta1.agregarEmail(email1);
        carpeta1.eliminarEmail(email1);
        assertEquals(0, carpeta1.getEmails().size());
    }

    @Test
    void testBuscar()
    {
        Email email1 = new Email("Email 1", "Texto 1");
        carpeta1.agregarEmail(email1);
        assertEquals(email1, carpeta1.buscar("Texto 1"));
    }

    @Test
    void testEspacioOcupado()
    {
        Email email1 = new Email("Email 1", "Texto 1");
        Email email2 = new Email("Email 2", "Texto 2");
        carpeta1.agregarEmail(email1);
        carpeta1.agregarEmail(email2);
        assertEquals(28, carpeta1.espacioOcupado());
    }

    @Test
    void testGetEmails()
    {
        Email email1 = new Email("Email 1", "Texto 1");
        Email email2 = new Email("Email 2", "Texto 2");
        carpeta1.agregarEmail(email1);
        carpeta1.agregarEmail(email2);
        List<Email> emails = carpeta1.getEmails();
        assertEquals(2, emails.size());
    }
}