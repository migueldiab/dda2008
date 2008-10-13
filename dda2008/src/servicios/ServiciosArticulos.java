package servicios;

import java.util.ArrayList;

import utils.Consola;
import utils.I18n;

import dominio.Articulo;
import dominio.Presupuesto;

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

  public static boolean borrar(Articulo unArticulo)
  {
    if (articulos.indexOf(unArticulo)!=-1) {
      ArrayList presupuestos = null;
      presupuestos = ServiciosPresupuestos.obtenerPresupuestoPorArticulo(unArticulo);
      if (presupuestos.size() > 0) {
        return false;
      }
      else {
        articulos.remove(unArticulo);
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
      return null;
    else
      return articulos;
  }

  public static boolean modificar(Articulo original, Articulo nuevo)
  {
    if (( original == null) || ( nuevo == null)) return false;
    int posOriginal = articulos.indexOf( original);
    if (posOriginal == -1) return false;
    int posNuevo = articulos.indexOf( nuevo);
    if (posNuevo > -1 && posNuevo != posOriginal) return false;
    
    // Medida : No se puede modificar si el articulo esta involucrado en algun presupuesto
    ArrayList presupuestos = null;
    presupuestos = ServiciosPresupuestos.obtenerPresupuestoPorArticulo(original);
    if (presupuestos.size() > 0) {
      if (!original.getMedida().equals(nuevo.getMedida())) {
          return false;
      }
      else if (original.getCosto() != nuevo.getCosto()) {
        ArrayList losPresupuestos = new ArrayList();
        for (int i=0; i < presupuestos.size(); i++) {
          Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
          if (unPresupuesto.getEstado().equals(Presupuesto.EN_CONSTRUCCION)) {
            if (unPresupuesto.getFechaEjecucion() != null) {
              losPresupuestos.add(unPresupuesto);
            }
          }
        }
        if (losPresupuestos.size() > 0) {
          Consola.println("El articulo se encuentra en los siguientes presupuestos : ");
          Consola.listado(losPresupuestos);
          String confirma = Consola.leer(I18n.CONFIRMA_MODIFICAR);
          if (confirma.equals(I18n.NO)) {
            return false;
          }          
        }
      }
    }
    articulos.set(posOriginal, nuevo);
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
