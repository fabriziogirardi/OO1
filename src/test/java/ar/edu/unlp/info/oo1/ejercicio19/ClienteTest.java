package ar.edu.unlp.info.oo1.ejercicio19;

import ar.edu.unlp.info.oo1.ejercicio14.DateLapse;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.util.List;

public class ClienteTest extends TestCase
{
    Individuo individuo;
    Empresa   empresa;

    public void setUp() throws Exception
    {
        individuo = new Individuo("Juan", "Calle Falsa 123", "12345678");
        String dni = individuo.getDni();
        empresa = new Empresa("ACME", "Calle Falsa 456", "87654321");
        String      cuit   = empresa.getCuit();
        List<Envio> envios = individuo.getEnvios();
    }

    public void testEnvioLocalLentoIndividuo()
    {
        Envio  envio   = new EnvioLocal(LocalDate.now(), "La Plata", "Berisso", 10, false);
        String origen  = envio.getOrigen();
        String destino = envio.getDestino();
        individuo.agregarEnvio(envio);
        assertEquals(900.0, individuo.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioLocalRapidoIndividuo()
    {
        Envio envio = new EnvioLocal(LocalDate.now(), "La Plata", "Berisso", 10, true);
        individuo.agregarEnvio(envio);
        assertEquals(1350.0, individuo.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioLocalLentoEmpresa()
    {
        Envio envio = new EnvioLocal(LocalDate.now(), "La Plata", "Berisso", 10, false);
        empresa.agregarEnvio(envio);
        assertEquals(1000.0, empresa.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioLocalRapidoEmpresa()
    {
        Envio envio = new EnvioLocal(LocalDate.now(), "La Plata", "Berisso", 10, true);
        empresa.agregarEnvio(envio);
        assertEquals(1500.0, empresa.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioInterurbanoCortoIndividuo()
    {
        Envio envio = new EnvioInterurbano(LocalDate.now(), "La Plata", "Berisso", 10, 10);
        individuo.agregarEnvio(envio);
        assertEquals(180.0, individuo.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioInterurbanoMedioIndividuo()
    {
        Envio envio = new EnvioInterurbano(LocalDate.now(), "La Plata", "Berisso", 10, 100);
        individuo.agregarEnvio(envio);
        assertEquals(225.0, individuo.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioInterurbanoLargoIndividuo()
    {
        Envio envio = new EnvioInterurbano(LocalDate.now(), "La Plata", "Berisso", 10, 1000);
        individuo.agregarEnvio(envio);
        assertEquals(270.0, individuo.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioInterurbanoCortoEmpresa()
    {
        Envio envio = new EnvioInterurbano(LocalDate.now(), "La Plata", "Berisso", 10, 10);
        empresa.agregarEnvio(envio);
        assertEquals(200.0, empresa.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioInterurbanoMedioEmpresa()
    {
        Envio envio = new EnvioInterurbano(LocalDate.now(), "La Plata", "Berisso", 10, 100);
        empresa.agregarEnvio(envio);
        assertEquals(250.0, empresa.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioInterurbanoLargoEmpresa()
    {
        Envio envio = new EnvioInterurbano(LocalDate.now(), "La Plata", "Berisso", 10, 1000);
        empresa.agregarEnvio(envio);
        assertEquals(300.0, empresa.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioInternacionalLivianoIndividuo()
    {
        Envio envio = new EnvioInternacional(LocalDate.now(), "La Plata", "Berisso", 1000);
        individuo.agregarEnvio(envio);
        assertEquals(15000 * 0.9, individuo.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioInternacionalPesadoIndividuo()
    {
        Envio envio = new EnvioInternacional(LocalDate.now(), "La Plata", "Berisso", 1001);
        individuo.agregarEnvio(envio);
        assertEquals(17012 * 0.9, individuo.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioInternacionalLivianoEmpresa()
    {
        Envio envio = new EnvioInternacional(LocalDate.now(), "La Plata", "Berisso", 1000);
        empresa.agregarEnvio(envio);
        assertEquals(15000.0, empresa.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioInternacionalPesadoEmpresa()
    {
        Envio envio = new EnvioInternacional(LocalDate.now(), "La Plata", "Berisso", 1001);
        empresa.agregarEnvio(envio);
        assertEquals(17012.0, empresa.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now().plusDays(1))));
    }

    public void testEnvioAntesDelRango()
    {
        Envio envio = new EnvioLocal(LocalDate.now(), "La Plata", "Berisso", 10, false);
        individuo.agregarEnvio(envio);
        assertEquals(0.0,
                     individuo.calcularMonto(new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2))));
    }

    public void testEnvioDespuesDelRango()
    {
        Envio envio = new EnvioLocal(LocalDate.now(), "La Plata", "Berisso", 10, false);
        individuo.agregarEnvio(envio);
        assertEquals(0.0, individuo.calcularMonto(
                new DateLapse(LocalDate.now().minusDays(2), LocalDate.now().minusDays(1))));
    }

    public void testEnvioEnRangoAcotadoAlMismoDia()
    {
        Envio envio = new EnvioLocal(LocalDate.now(), "La Plata", "Berisso", 10, false);
        individuo.agregarEnvio(envio);
        assertEquals(900.0, individuo.calcularMonto(new DateLapse(LocalDate.now(), LocalDate.now())));
    }
}