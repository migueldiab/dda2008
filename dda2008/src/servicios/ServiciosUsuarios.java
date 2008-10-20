package servicios;

import java.util.ArrayList;
import java.util.Collections;

import dominio.CriterioComparacionPorNombreUsuarioAsc;
import dominio.Usuario;

public class ServiciosUsuarios
{
  public  static final int MAX_LOGIN = 3;
  private static ArrayList usuarios = new ArrayList();
  private  static Usuario usuarioActual = null;
  
  public static boolean login(String usuario, String clave) {
    Usuario unUsuario = new Usuario(usuario);
    unUsuario = (Usuario) ServiciosUsuarios.obtener(unUsuario);
    if (unUsuario != null) { 
      if (unUsuario.getClave().equals(clave)) {
        usuarioActual = unUsuario;
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }      
  }
  
  public static Usuario getUsuarioActual() {
    return usuarioActual;
  }
  public static boolean logout() {
    usuarioActual = null;
    return true;
  }

  public static boolean agregar(Usuario unUsuario)
  {
    
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
    
    // No se puede modificar el rol de un usuario gestor que sea dueño de algun presupuesto
    if (!original.getGrupo().equals(nuevo.getGrupo())) {
      ArrayList presupuestos = null;
      presupuestos = ServiciosPresupuestos.obtenerPresupuestoPorUsuario(original);
      if (presupuestos.size() > 0) {
        return false;
      }
    }
    usuarios.set(posOriginal, nuevo);
    return true;
  }
  public static int cantidad()
  {
    
    return usuarios.size();
  }

  public static Object obtener(Usuario unUsuario)
  {
    
    int pos = usuarios.indexOf(unUsuario);
    if (pos!=-1) { 
      return usuarios.get(pos);
    }
    else {
      return null;
    }  
  }

  public static ArrayList listadoGestores(){
	if (cantidad() == 0)
	return null;
	else{
		ArrayList gestores=new ArrayList();
		for (int i = 0; i < usuarios.size(); i++) {
		      Usuario unUsuario = (Usuario) usuarios.get(i);
		      if (unUsuario.getGrupo().getNombre().equals("Gestor")) {
		    	  gestores.add(unUsuario);
		      }
		}		
		return gestores;
	}
	
  }

  public static ArrayList listado()
  {
    if (cantidad() == 0)
      return null;
    else
    	
      return usuarios;
  }

public static ArrayList listadoGestoresPorNombreUsuario() {
	if (cantidad() == 0)
		return null;
		else{
			ArrayList gestores=listadoGestores();
		Collections.sort(gestores,(new CriterioComparacionPorNombreUsuarioAsc()));
		return gestores;
		}
}

public static ArrayList listadoGestoresPorApellido() {
	if (cantidad() == 0)
		return null;
		else{
			ArrayList gestores=listadoGestores();
			Collections.sort(gestores);
			return gestores;
	        }
}
}
