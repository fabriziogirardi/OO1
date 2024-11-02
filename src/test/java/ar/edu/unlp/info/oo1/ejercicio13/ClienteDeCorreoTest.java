package ar.edu.unlp.info.oo1.ejercicio13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteDeCorreoTest
{
    ClienteDeCorreo clienteDeCorreo;

    @BeforeEach
    void setUp()
    {
        clienteDeCorreo = new ClienteDeCorreo();
    }

    @Test
    void testRecibir()
    {
        clienteDeCorreo.recibir(new Email("Prueba", "Esto es una prueba"));
        assertEquals(1, clienteDeCorreo.getInbox().getEmails().size());
    }

    @Test
    void testBuscarEstandoEnInbox()
    {
        Email email = new Email("Prueba", "Esto es una prueba");
        Email email2 = new Email("Prueba2", "Esto es una prueba 2 que es distinta");

        clienteDeCorreo.recibir(email);
        clienteDeCorreo.recibir(email2);

        assertEquals(email, clienteDeCorreo.buscar("Prueba"));
        assertEquals(email2, clienteDeCorreo.buscar("distinta"));
    }

    @Test
    void testBuscarEstandoEnCarpeta()
    {
        Email email = new Email("Prueba", "Esto es una prueba principal");
        Email email2 = new Email("Prueba2", "Esto es una prueba 2 que es distinta");

        clienteDeCorreo.recibir(email);
        clienteDeCorreo.recibir(email2);

        Carpeta carpeta = new Carpeta("Carpeta1");
        clienteDeCorreo.agregarCarpeta(carpeta);
        clienteDeCorreo.getInbox().mover(email, carpeta);

        assertEquals(email2, clienteDeCorreo.buscar("Prueba"));
        assertEquals(email, clienteDeCorreo.buscar("principal"));
        assertNull(clienteDeCorreo.buscar("No existe"));
    }

    @Test
    void testEspacioOcupado()
    {
        assertEquals(0, clienteDeCorreo.espacioOcupado());
        List<Archivo> archivos = new ArrayList<>();
        archivos.add(new Archivo("Archivo"));
        clienteDeCorreo.recibir(new Email("Prueba", "Esto es una prueba", archivos));
        assertEquals(31, clienteDeCorreo.espacioOcupado());
    }

    @Test
    void testAgregarCarpeta()
    {
        assertEquals(0, clienteDeCorreo.getCarpetas().size());
        clienteDeCorreo.agregarCarpeta(new Carpeta("Carpeta1"));
        assertEquals(1, clienteDeCorreo.getCarpetas().size());
    }

    @Test
    void testGetInbox()
    {
        Carpeta inbox = clienteDeCorreo.getInbox();
        assertNotNull(inbox);
        assertEquals("Inbox", inbox.getNombre());
    }

    @Test
    void testGetCarpetas()
    {
        clienteDeCorreo.agregarCarpeta(new Carpeta("Carpeta1"));
        assertNotNull(clienteDeCorreo.getCarpetas());
    }

    @Test
    void testMoverEmail()
    {
        Email email = new Email("Prueba", "Esto es una prueba");
        clienteDeCorreo.recibir(email);

        Carpeta carpeta = new Carpeta("Carpeta1");
        clienteDeCorreo.agregarCarpeta(carpeta);

        clienteDeCorreo.getInbox().mover(email, carpeta);

        assertEquals(0, clienteDeCorreo.getInbox().getEmails().size());
        assertEquals(1, clienteDeCorreo.getCarpetas().getFirst().getEmails().size());
    }
}