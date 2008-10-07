package testeo;

import dominio.Grupo;
import dominio.Usuario;
import junit.framework.TestCase;

public class TestUsuario extends TestCase {
  public void testCrearUsuarioPorId()  {
    Usuario unUsuario = new Usuario("madrax", "test", new Grupo());
    
  }
  
}
