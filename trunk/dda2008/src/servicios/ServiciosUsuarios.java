package servicios;

import java.util.ArrayList;

import dominio.Usuario;

public class ServiciosUsuarios
{
  public  static final int MAX_LOGIN = 3;
  private static ArrayList usuarios = new ArrayList();
  public  static Usuario usuarioActual = null;
  
  public static Usuario login(String usuario, String clave) {
    Usuario unUsuario = new Usuario(usuario);
    unUsuario = (Usuario) ServiciosUsuarios.obtener(unUsuario);
    if (unUsuario != null) { 
      if (unUsuario.getClave().equals(clave)) {
        return unUsuario;
      }
      else {
        return null;
      }
    }
    else {
      return null;
    }      
  }
  
  public static boolean logout() {
    usuarioActual = null;
    return true;
  }

  public static boolean agregar(Usuario unUsuario)
  {
    // TODO Auto-generated method stub
    if (usuarios.indexOf(unUsuario)==-1) {
      usuarios.add(unUsuario);
      return true;
    }
    else {
      return false;
    }        
  }
  public static boolean borrar(Usuario unUsuario) {
    if (usuarios.indexOf(unUsuario)!=-1) {
      usuarios.remove(unUsuario);
      return true;
    }
    else {
      return false;
    }      
  }

  public static boolean modificar(Usuario original, Usuario nuevo) {
    if ((original == null) || (nuevo == null)) return false;
    int posOriginal = usuarios.indexOf(original);
    if (posOriginal == -1) return false;
    int posNuevo = usuarios.indexOf(nuevo);
    if (posNuevo > -1 && posNuevo != posOriginal) return false;
    usuarios.set(posOriginal, nuevo);
    return true;
  }
  public static int cantidad()
  {
    // TODO Auto-generated method stub
    return usuarios.size();
  }

  public static Object obtener(Usuario unUsuario)
  {
    // TODO Auto-generated method stub
    int pos = usuarios.indexOf(unUsuario);
    if (pos!=-1) { 
      return usuarios.get(pos);
    }
    else {
      return null;
    }  
  }

  public static ArrayList listado()
  {
    // TODO Auto-generated method stub
    if (cantidad() == 0)
      return null;
    else
      return usuarios;
  }  
}
