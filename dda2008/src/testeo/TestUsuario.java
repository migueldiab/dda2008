package testeo;

import dominio.Usuario;
import junit.framework.TestCase;

public class TestUsuario extends TestCase {
  public void testCrearUsuarioPorId()  {
    Usuario unUsuario = new Usuario("madrax");
    assertEquals(unUsuario.getId(),"madrax");
  }
  
  public void testCrearUsuario()  {
    Usuario unUsuario = new Usuario();
    assertEquals(unUsuario.getId(),null);
    
   }
  
}
