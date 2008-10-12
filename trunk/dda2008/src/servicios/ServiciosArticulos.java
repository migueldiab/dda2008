package servicios;

import java.util.ArrayList;

import dominio.Articulo;

public class ServiciosArticulos 
{
  public static ArrayList articulos = new ArrayList();

  public static boolean agregar(Object o)
  {
    // TODO Auto-generated method stub
    if (articulos.indexOf((Articulo) o)==-1) {
      articulos.add((Articulo) o);
      return true;
    }
    else {
      return false;
    }    
  }

  public static boolean borrar(Object o)
  {
    if (articulos.indexOf((Articulo) o)!=-1) {
      articulos.remove((Articulo) o);
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
      return articulos;
  }

  public static boolean modificar(Object original, Object nuevo)
  {
    if (((Articulo) original == null) || ((Articulo) nuevo == null)) return false;
    int posOriginal = articulos.indexOf((Articulo) original);
    if (posOriginal == -1) return false;
    int posNuevo = articulos.indexOf((Articulo) nuevo);
    if (posNuevo > -1 && posNuevo != posOriginal) return false;
    articulos.set(posOriginal, (Articulo) nuevo);
    return true;
  }

  public static int cantidad()
  {
    return articulos.size();
  }

  public static Object obtener(Object o)
  {
    // TODO Auto-generated method stub
    int pos = articulos.indexOf((Articulo) o);
    if (pos!=-1) { 
      return articulos.get(pos);
    }
    else {
      return null;
    }  
  }

}
