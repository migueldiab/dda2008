package testeo;

import servicios.ServiciosUsuarios;
import dominio.Grupo;
import dominio.Usuario;
import junit.framework.TestCase;

public class TestUsuario extends TestCase {
  Grupo unGrupo = null;
  Usuario unUsuario = null;
  

  public void setUp() {
    unGrupo = new Grupo();
    unUsuario = new Usuario("usuario1", "clave", unGrupo, "El Usuario", "Ramirez");
    ServiciosUsuarios.agregar(unUsuario);
  }
  
  public void testAgregarUsuario()  {
    int cantidad = ServiciosUsuarios.cantidad();    
    Usuario otroUsuario = new Usuario("usuario2", "clave", unGrupo, "Otro Usuario", "Ramirez");
    ServiciosUsuarios.agregar(otroUsuario);    
    assertEquals(cantidad + 1, ServiciosUsuarios.cantidad());  
  }
  public void testUsuarioDuplicado()  {
    Usuario unUsuario = new Usuario("usuario1");
    assertFalse(ServiciosUsuarios.agregar(unUsuario));
  }  
  public void testUsuarioDuplicadoConDatos()  {
    Usuario unUsuario = new Usuario("usuario1", "clave", new Grupo(), "Otro Usuario", "Mismo ID");
    assertFalse(ServiciosUsuarios.agregar(unUsuario));
  }  
  public void testObtenerUsuario() {
    Usuario otroUsuario = new Usuario("usuario1");
    otroUsuario = (Usuario)ServiciosUsuarios.obtener(otroUsuario);
    assertEquals("Ramirez", otroUsuario.getApellido());    
    assertEquals("El Usuario", otroUsuario.getNombre());
  }
  public void testBorrarUsuario()  {
    Usuario otroUsuario = new Usuario("usuario2", "clave", unGrupo, "El Usuario", "Ramirez");
    otroUsuario = (Usuario)ServiciosUsuarios.obtener(otroUsuario);    
    ServiciosUsuarios.borrar(otroUsuario);
    assertEquals(null, ServiciosUsuarios.obtener(otroUsuario));
  }
  public void testModificarUsuario() {
    Usuario otroUsuario = new Usuario("usuario2", "clave", unGrupo, "Prueba1", "Prueba2");
    ServiciosUsuarios.modificar(unUsuario, otroUsuario);
    Usuario ultimoUsuario = (Usuario)ServiciosUsuarios.obtener
                                      (new Usuario("usuario2"));  
    assertEquals("Prueba1", ultimoUsuario.getNombre());
    assertEquals("Prueba2", ultimoUsuario.getApellido());    
  }
  public void testModificarUsuarioSet() {
    Usuario otroUsuario = new Usuario("usuario3");
    otroUsuario.setClave("OtraClave");
    otroUsuario.setApellido("UnApellido");
    assertTrue(ServiciosUsuarios.modificar(unUsuario, otroUsuario));
    Usuario ultimoUsuario = (Usuario)ServiciosUsuarios.obtener
                                      (new Usuario("usuario3"));  
    assertEquals("OtraClave", ultimoUsuario.getClave());
    assertEquals("UnApellido", ultimoUsuario.getApellido());    
  }
  public void testModificarUsuarioPorDuplicado() {
    Usuario otroUsuario = new Usuario("usuario4", "OtraClave", unGrupo, "El Usuario", "UnApellido");
    assertTrue(ServiciosUsuarios.agregar(otroUsuario));    
    Usuario dupUsuario = new Usuario("usuario4");
    assertFalse(ServiciosUsuarios.modificar(unUsuario, dupUsuario));
    Usuario ultimoUsuario = (Usuario)ServiciosUsuarios.obtener
                                      (new Usuario("usuario4"));  
    assertEquals("OtraClave", ultimoUsuario.getClave());
    assertEquals("UnApellido", ultimoUsuario.getApellido());    
  }   
  
}
