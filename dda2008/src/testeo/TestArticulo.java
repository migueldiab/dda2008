package testeo;

import dominio.*;
import junit.framework.TestCase;

public class TestArticulo extends TestCase
{
  private Medida unaMedida;
  private Articulo unArticulo;
  
  public void setUp() {
    unaMedida = new Medida("kg", "Kilogramo");
    unArticulo = new Articulo("art1", unaMedida, 10, 105.30);
    servicios.ServiciosArticulos.agregarArticulo(unArticulo);
  }
  public void testAgregarArticulo()  {
    int cantidad = servicios.ServiciosArticulos.cantidad();    
    Articulo otroArticulo = new Articulo("otro articulo", unaMedida, 23, 123.30);
    servicios.ServiciosArticulos.agregarArticulo(otroArticulo);    
    assertEquals(cantidad + 1, servicios.ServiciosArticulos.cantidad());  
  }
  public void testArticuloDuplicado()  {
    Articulo unArticulo = new Articulo("art1", unaMedida);
    assertFalse(servicios.ServiciosArticulos.agregarArticulo(unArticulo));
  }  
  public void testArticuloDuplicadoConDatos()  {
    Articulo unArticulo = new Articulo("art1", unaMedida, 98, 125.30);
    assertFalse(servicios.ServiciosArticulos.agregarArticulo(unArticulo));
  }  
  public void testObtenerArticulo() {
    Articulo otroArticulo = new Articulo("art1", unaMedida);
    otroArticulo = (Articulo)servicios.ServiciosArticulos.obtenerArticulo(otroArticulo);
    assertEquals(10, otroArticulo.getCantidad());    
    assertEquals(105.30, otroArticulo.getCosto(), 0);
  }
  public void testBorrarArticulo()  {
    Articulo otroArticulo = new Articulo("art1", unaMedida);
    otroArticulo = (Articulo)servicios.ServiciosArticulos.obtenerArticulo(otroArticulo);    
    servicios.ServiciosArticulos.borrarArticulo(otroArticulo);
    assertEquals(null, servicios.ServiciosArticulos.obtenerArticulo(otroArticulo));
  }
  public void testModificarArticulo() {
    Articulo otroArticulo = new Articulo("art1", unaMedida, 78, 654.65);
    servicios.ServiciosArticulos.modificarArticulo(unArticulo, otroArticulo);
    Articulo ultimoArticulo = (Articulo)servicios.ServiciosArticulos.obtenerArticulo
                                      (new Articulo("art1", unaMedida));  
    assertEquals(78, ultimoArticulo.getCantidad());
    assertEquals(654.65, ultimoArticulo.getCosto(), 0);
  }
  public void testModificarArticuloSet() {
    Articulo otroArticulo = new Articulo("art1", unaMedida);
    otroArticulo.setCantidad(25);
    otroArticulo.setCosto(374.23);
    assertTrue(servicios.ServiciosArticulos.modificarArticulo(unArticulo, otroArticulo));
    Articulo ultimoArticulo = (Articulo)servicios.ServiciosArticulos.obtenerArticulo
                                      (new Articulo("art1", unaMedida));  
    assertEquals(25, ultimoArticulo.getCantidad());
    assertEquals(374.23, ultimoArticulo.getCosto(), 0);
  }
  public void testModificarArticuloPorDuplicado() {
    Articulo otroArticulo = new Articulo("art2", unaMedida, 12, 123.32);
    assertTrue(servicios.ServiciosArticulos.agregarArticulo(otroArticulo));    
    Articulo dupArticulo = new Articulo("art2", unaMedida, 23, 123.30);
    assertFalse(servicios.ServiciosArticulos.modificarArticulo(unArticulo, dupArticulo));
    Articulo ultimoArticulo = (Articulo)servicios.ServiciosArticulos.obtenerArticulo
                                      (new Articulo("art2", unaMedida));  
    assertEquals(12, ultimoArticulo.getCantidad());
    assertEquals(123.32, ultimoArticulo.getCosto(), 0);
  }    
}
