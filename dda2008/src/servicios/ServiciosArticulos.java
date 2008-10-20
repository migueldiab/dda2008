package servicios;

import java.util.ArrayList;
import java.util.Collections;

import dominio.Articulo;
import dominio.Presupuesto;

public class ServiciosArticulos 
{
  private static ArrayList articulos = new ArrayList();

  public static boolean agregar(Object o)
  {
    
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
    if (presupuestos.size() > 0 && !original.getMedida().equals(nuevo.getMedida())) {
          return false;
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

  public static ArrayList obtenerArticulosNotIn(Presupuesto unPresupuesto) {
	ArrayList losArticulos=new ArrayList();
	boolean existe;
	for (int i = 0; i < articulos.size(); i++) {
			existe=false;
			Articulo a= (Articulo) articulos.get(i);
		    ArrayList items=new ArrayList();
		    items=unPresupuesto.getItems();
		    if (items.isEmpty()){
		    	losArticulos.add(a);
		    }
		    else{
		    	for(int j = 0; j < items.size(); j++) {
		    		Articulo itemPresupuesto=(Articulo)items.get(j);
		    		if ((itemPresupuesto.equals(a))){
		    			existe=true;
		    		}
		    	}
		    	if (existe==false){
			    	losArticulos.add(a);	
			    }
		    }
		    
		     
	}
	Collections.sort(losArticulos);
		return losArticulos;
  }
}