package servicios;

import java.util.ArrayList;

import dominio.Usuario;

public class ServicioUsuarios
{
  private static ArrayList usuarios = new ArrayList();
  private static Usuario usuarioActual = null;
  
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

  public static boolean agregarUsuario(Usuario unUsuario)
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
  public static boolean borrarUsuario(Usuario unUsuario) {
    if (usuarios.indexOf(unUsuario)!=-1) {
      usuarios.remove(unUsuario);
      return true;
    }
    else {
      return false;
    }      
  }

  public static boolean modificarUsuario(Usuario original, Usuario nuevo) {
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

  public static Object obtenerUsuario(Usuario unUsuario)
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

  public static ArrayList listadoUsuarios()
  {
    // TODO Auto-generated method stub
    if (cantidad() == 0)
      return null;
    else
      return usuarios;
  }  
}
