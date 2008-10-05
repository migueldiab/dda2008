package servicios;

import java.util.ArrayList;

import dominio.Articulo;

public class ServiciosArticulos implements Servicios
{
  static ArrayList articulos = new ArrayList();
  
  public boolean nuevo(Object o) {
    return true;
  }

  public static boolean agregarArticulo(Articulo unArticulo)
  {
    // TODO Auto-generated method stub
    if (articulos.indexOf(unArticulo)==-1) {
      articulos.add(unArticulo);
      return true;
    }
    else {
      return false;
    }        
  }
  public static boolean borrarArticulo(Articulo unArticulo) {
    if (articulos.indexOf(unArticulo)!=-1) {
      articulos.remove(unArticulo);
      return true;
    }
    else {
      return false;
    }      
  }

  public static boolean modificarArticulo(Articulo original, Articulo nuevo) {
    if ((original == null) || (nuevo == null)) return false;
    int posOriginal = articulos.indexOf(original);
    if (posOriginal == -1) return false;
    int posNuevo = articulos.indexOf(nuevo);
    if (posNuevo > -1 && posNuevo != posOriginal) return false;
    articulos.set(posOriginal, nuevo);
    return true;
  }
  public static int cantidad()
  {
    // TODO Auto-generated method stub
    return articulos.size();
  }

  public static Object obtenerArticulo(Articulo unArticulo)
  {
    // TODO Auto-generated method stub
    int pos = articulos.indexOf(unArticulo);
    if (pos!=-1) { 
      return articulos.get(pos);
    }
    else {
      return null;
    }  
  }

  public static ArrayList listadoArticulos()
  {
    // TODO Auto-generated method stub
    if (cantidad() == 0)
      return null;
    else
      return articulos;
  }
  
}
