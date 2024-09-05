package ar.edu.unlp.info.oo1.balanzaElectronica;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import ar.edu.unlp.info.oo1.ejercicio2.*;
import ar.edu.unlp.info.oo1.ejercicio2.Interfaces.IBalanza;
import ar.edu.unlp.info.oo1.ejercicio2.Interfaces.IProducto;
import ar.edu.unlp.info.oo1.ejercicio2.Interfaces.ITicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BalanzaTest {
 
  private IBalanza balanza;
  
  private IProducto queso;
  
  private IProducto jamon;

  private static final double DELTA = 0.00001;
  
  @BeforeEach
  void setUp() throws Exception {
    balanza = new Balanza();
    queso = new Producto();
    queso.setPeso(0.1);
    queso.setPrecioPorKilo(140);
    queso.setDescripcion("Queso");

    jamon = new Producto();
    jamon.setDescripcion("Jamón");
    jamon.setPeso(0.1);
    jamon.setPrecioPorKilo(90);
  }

  @Test
  void testAgregarProducto() {

    balanza.agregarProducto(queso);
    assertEquals(0.1, balanza.getPesoTotal(), DELTA);
    assertEquals(14, balanza.getPrecioTotal(), DELTA);
    assertEquals(1, balanza.getCantidadDeProductos());

    balanza.agregarProducto(jamon);
    assertEquals(0.2, balanza.getPesoTotal(), DELTA);
    assertEquals(23, balanza.getPrecioTotal(), DELTA);
    assertEquals(2, balanza.getCantidadDeProductos());
  }

  @Test
  void testCantidadDeProductos() {
    assertEquals(0, balanza.getCantidadDeProductos());
    balanza.agregarProducto(queso);
    assertEquals(1, balanza.getCantidadDeProductos());
    balanza.agregarProducto(jamon);
    assertEquals(2, balanza.getCantidadDeProductos());
  }  
  
  @Test
  void testEmitirTicket() {
    balanza.agregarProducto(queso);
    balanza.agregarProducto(jamon);
    ITicket ticket = balanza.emitirTicket();
    assertEquals(0.2, ticket.getPesoTotal(), DELTA);
    assertEquals(23, ticket.getPrecioTotal(), DELTA);
    assertEquals(2, ticket.getCantidadDeProductos());
    assertEquals(23 * 0.21, ticket.impuesto(), DELTA);
    assertEquals(LocalDate.now(), ticket.getFecha());

    queso.setPrecioPorKilo(200);
    jamon.setPrecioPorKilo(160);
    assertEquals(23, ticket.getPrecioTotal(), DELTA);
  }

  @Test
  void testConstructor() {
    assertEquals(0, balanza.getPesoTotal(), DELTA);
    assertEquals(0, balanza.getPrecioTotal(), DELTA);
    assertEquals(0, balanza.getCantidadDeProductos());
  }

  @Test
  void testPesoTotal() {
    assertEquals(0, balanza.getPesoTotal(), DELTA);
    balanza.agregarProducto(queso);
    assertEquals(0.1, balanza.getPesoTotal(), DELTA);
    balanza.agregarProducto(jamon);
    assertEquals(0.2, balanza.getPesoTotal(), DELTA);
  }  

  @Test
  void testPonerEnCero() {
    balanza.agregarProducto(queso);
    balanza.ponerEnCero();
    assertEquals(0, balanza.getPesoTotal(), DELTA);
    assertEquals(0, balanza.getPrecioTotal(), DELTA);
    assertEquals(0, balanza.getCantidadDeProductos());
  }  

  @Test
  void testPrecioTotal() {
    assertEquals(0, balanza.getPrecioTotal(), DELTA);
    balanza.agregarProducto(queso);
    assertEquals(14, balanza.getPrecioTotal(), DELTA);
    balanza.agregarProducto(jamon);
    assertEquals(23, balanza.getPrecioTotal(), DELTA);
  }  
}
