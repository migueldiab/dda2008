package servicios;

import java.util.ArrayList;

import dominio.Usuario;

public class Usuarios
{
  private static ArrayList usuarios = new ArrayList();
  private static Usuario usuarioActual = new Usuario();
  
  public static boolean login(String usuario, String clave) {
    // if index of usuarios != -1
    // if clave es correcta
    // usuarioactual = usuario
    return false;
  }
  
  public static boolean logout() {
    usuarioActual = null;
    return true;
  }

}
