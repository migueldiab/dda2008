package testeo;

import servicios.ServiciosArticulos;
import dominio.*;
import junit.framework.TestCase;

public class TestArticulo extends TestCase
{
  private Medida unaMedida;
  private Articulo unArticulo;
  
  public void setUp() {
    unaMedida = new Medida("kg", "Kilogramo");
    unArticulo = new Articulo("art1", unaMedida, 10, 105.30);
    ServiciosArticulos.agregar(unArticulo);
  }
  public void testAgregarArticulo()  {
    int cantidad = ServiciosArticulos.cantidad();    
    Articulo otroArticulo = new Articulo("otro articulo", unaMedida, 23, 123.30);
    ServiciosArticulos.agregar(otroArticulo);    
    assertEquals(cantidad + 1, ServiciosArticulos.cantidad());  
  }
  public void testArticuloDuplicado()  {
    Articulo unArticulo = new Articulo("art1", unaMedida);
    assertFalse(ServiciosArticulos.agregar(unArticulo));
  }  
  public void testArticuloDuplicadoConDatos()  {
    Articulo unArticulo = new Articulo("art1", unaMedida, 98, 125.30);
    assertFalse(ServiciosArticulos.agregar(unArticulo));
  }  
  public void testObtenerArticulo() {
    Articulo otroArticulo = new Articulo("art1", unaMedida);
    otroArticulo = (Articulo)ServiciosArticulos.obtener(otroArticulo);
    assertEquals(10, otroArticulo.getCantidad());    
    assertEquals(105.30, otroArticulo.getCosto(), 0);
  }
  public void testBorrarArticulo()  {
    Articulo otroArticulo = new Articulo("art1", unaMedida);
    otroArticulo = (Articulo)ServiciosArticulos.obtener(otroArticulo);    
    ServiciosArticulos.borrar(otroArticulo);
    assertEquals(null, ServiciosArticulos.obtener(otroArticulo));
  }
  public void testModificarArticulo() {
    Articulo otroArticulo = new Articulo("art1", unaMedida, 78, 654.65);
    ServiciosArticulos.modificar(unArticulo, otroArticulo);
    Articulo ultimoArticulo = (Articulo)ServiciosArticulos.obtener
                                      (new Articulo("art1", unaMedida));  
    assertEquals(78, ultimoArticulo.getCantidad());
    assertEquals(654.65, ultimoArticulo.getCosto(), 0);
  }
  public void testModificarArticuloSet() {
    Articulo otroArticulo = new Articulo("art1", unaMedida);
    otroArticulo.setCantidad(25);
    otroArticulo.setCosto(374.23);
    assertTrue(ServiciosArticulos.modificar(unArticulo, otroArticulo));
    Articulo ultimoArticulo = (Articulo)ServiciosArticulos.obtener
                                      (new Articulo("art1", unaMedida));  
    assertEquals(25, ultimoArticulo.getCantidad());
    assertEquals(374.23, ultimoArticulo.getCosto(), 0);
  }
  public void testModificarArticuloPorDuplicado() {
    Articulo otroArticulo = new Articulo("art2", unaMedida, 12, 123.32);
    assertTrue(ServiciosArticulos.agregar(otroArticulo));    
    Articulo dupArticulo = new Articulo("art2", unaMedida, 23, 123.30);
    assertFalse(ServiciosArticulos.modificar(unArticulo, dupArticulo));
    Articulo ultimoArticulo = (Articulo)ServiciosArticulos.obtener
                                      (new Articulo("art2", unaMedida));  
    assertEquals(12, ultimoArticulo.getCantidad());
    assertEquals(123.32, ultimoArticulo.getCosto(), 0);
  }    
}
