package testeo;

import java.util.ArrayList;

import servicios.ServiciosGrupos;

import dominio.Grupo;
import junit.framework.TestCase;

public class TestGrupo extends TestCase
{
  Grupo unGrupo = null;
  ArrayList permisos = new ArrayList();
  

  public void setUp() {
    permisos.add(Grupo.USUARIOS);
    unGrupo = new Grupo("Administradores", permisos);
    ServiciosGrupos.agregar(unGrupo);
  }
  
  public void testAgregarGrupo()  {
    int cantidad = ServiciosGrupos.cantidad();    
    Grupo otroGrupo = new Grupo("Reportes", permisos);
    ServiciosGrupos.agregar(otroGrupo);    
    assertEquals(cantidad + 1, ServiciosGrupos.cantidad());  
  }
  public void testGrupoDuplicado()  {
    Grupo unGrupo = new Grupo("Administradores");
    assertFalse(ServiciosGrupos.agregar(unGrupo));
  }  
  public void testGrupoDuplicadoConDatos()  {
    ArrayList otroPermisos = new ArrayList();
    otroPermisos.add(Grupo.ARTICULOS);
    Grupo unGrupo = new Grupo("Administradores", otroPermisos);
    assertFalse(ServiciosGrupos.agregar(unGrupo));
  }  

    public void testObtenerGrupo() {
    Grupo otroGrupo = new Grupo("Administradores");
    otroGrupo = (Grupo)ServiciosGrupos.obtener(otroGrupo);
    assertTrue(otroGrupo.tienePermiso(Grupo.CAMBIO_DUENIO_PRESUPUESTO));
  }
  public void testBorrarGrupo()  {
    Grupo otroGrupo = new Grupo("Administradores");
    otroGrupo = (Grupo)ServiciosGrupos.obtener(otroGrupo);    
    ServiciosGrupos.borrar(otroGrupo);
    assertEquals(null, ServiciosGrupos.obtener(otroGrupo));
  }
  public void testModificarGrupo() {
    Grupo otroGrupo = new Grupo("DBA");
    ServiciosGrupos.modificar(unGrupo, otroGrupo);
    Grupo ultimoGrupo = (Grupo)ServiciosGrupos.obtener
                                      (new Grupo("DBA"));  
    assertFalse(ultimoGrupo.tienePermiso(Grupo.ADMIN));
  }
  public void testModificarGrupoSet() {
    Grupo otroGrupo = new Grupo("UE");
    otroGrupo.agregarPermiso(Grupo.PRESUPUESTOS);
    assertTrue(ServiciosGrupos.modificar(unGrupo, otroGrupo));
    Grupo ultimoGrupo = (Grupo)ServiciosGrupos.obtener
                                      (new Grupo("UE"));  
    assertTrue(ultimoGrupo.tienePermiso(Grupo.PRESUPUESTOS));    
  }
  public void testModificarGrupoPorDuplicado() {
    Grupo otroGrupo = new Grupo("grupo4");
    otroGrupo.agregarPermiso(Grupo.CONSULTAS);
    assertTrue(ServiciosGrupos.agregar(otroGrupo));    
    Grupo dupGrupo = new Grupo("grupo4");
    assertFalse(ServiciosGrupos.modificar(unGrupo, dupGrupo));
    Grupo ultimoGrupo = (Grupo)ServiciosGrupos.obtener
                                      (new Grupo("grupo4"));  
    assertTrue(ultimoGrupo.tienePermiso(Grupo.CONSULTAS));
  }   
  

}
