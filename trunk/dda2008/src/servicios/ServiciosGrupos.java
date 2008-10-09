package servicios;

import java.util.ArrayList;

import dominio.Grupo;

public class ServiciosGrupos
{  
  static ArrayList grupos = new ArrayList();

  public static boolean agregar(Object o)
  {
    // TODO Auto-generated method stub
    if (grupos.indexOf((Grupo) o)==-1) {
      grupos.add((Grupo) o);
      return true;
    }
    else {
      return false;
    }    
  }

  public static boolean borrar(Object o)
  {
    if (grupos.indexOf((Grupo) o)!=-1) {
      grupos.remove((Grupo) o);
      return true;
    }
    else {
      return false;
    }      
  }

  public static ArrayList listado()
  {
    if (cantidad() == 0)
      return null;
    else
      return grupos;
  }

  public static boolean modificar(Object original, Object nuevo)
  {
    if (((Grupo) original == null) || ((Grupo) nuevo == null)) return false;
    int posOriginal = grupos.indexOf((Grupo) original);
    if (posOriginal == -1) return false;
    int posNuevo = grupos.indexOf((Grupo) nuevo);
    if (posNuevo > -1 && posNuevo != posOriginal) return false;
    grupos.set(posOriginal, (Grupo) nuevo);
    return true;
  }

  public static int cantidad()
  {
    return grupos.size();
  }

  public static Object obtener(Object o)
  {
    // TODO Auto-generated method stub
    int pos = grupos.indexOf((Grupo) o);
    if (pos!=-1) { 
      return grupos.get(pos);
    }
    else {
      return null;
    }  
  }
  
}
