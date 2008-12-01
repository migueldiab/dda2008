package servicios;

import java.util.ArrayList;
import java.util.Collections;

import dominio.ArticuloCompuesto;
import dominio.Item;
import dominio.Medida;
import dominio.Presupuesto;
import dominio.Usuario;

public class ServiciosArticulosCompuestos 
{
  private static ArrayList<ArticuloCompuesto> articulosCompuestos = new ArrayList<ArticuloCompuesto>();

  public static boolean agregar(Object o)
  {
    
    if (articulosCompuestos.indexOf((ArticuloCompuesto) o)==-1) {
      articulosCompuestos.add((ArticuloCompuesto) o);
      return true;
    }
    else {
      return false;
    }    
  }

  public static boolean borrar(ArticuloCompuesto unArticuloCompuesto)
  {
    if (articulosCompuestos.indexOf(unArticuloCompuesto)!=-1) {
      ArrayList presupuestos = null;
      presupuestos = ServiciosPresupuestos.obtenerPresupuestoPorArticuloCompuesto(unArticuloCompuesto);
      if (presupuestos.size() > 0) {
        return false;
      }
      else {
        articulosCompuestos.remove(unArticuloCompuesto);
        return true;        
      }     
    }
    else {
      return false;
    }      
  }

  public static ArrayList listado()
  {
    if (cantidad() == 0)
      return new ArrayList();
    else
      Collections.sort(articulosCompuestos);
      return articulosCompuestos;
  }

  public static boolean modificar(ArticuloCompuesto original,String nombre,Medida medida,int cantidad,double costo )
  {
    if (( original == null))  return false;
    int posOriginal = articulosCompuestos.indexOf( original);
    if (posOriginal == -1) return false;
   
    
    // Medida : No se puede modificar si el articulo esta involucrado en algun presupuesto
    ArrayList presupuestos = null;
    presupuestos = ServiciosPresupuestos.obtenerPresupuestoPorArticuloCompuesto(original);
    if (presupuestos.size() > 0 && !original.getMedida().equals(medida)) {
          return false;
    }
    original.setCantidad(cantidad);
    original.setCosto(costo);
    original.setMedida(medida);
    original.setNombre(nombre);
    return true;
  }

  public static int cantidad()
  {
    return articulosCompuestos.size();
  }

  public static Object obtener(Object o)
  {
    int pos = articulosCompuestos.indexOf((ArticuloCompuesto) o);
    if (pos!=-1) { 
      return articulosCompuestos.get(pos);
    }
    else {
      return null;
    }  
  }

  

}
