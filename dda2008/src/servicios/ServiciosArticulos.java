package servicios;

import java.util.ArrayList;
import java.util.Collections;

import dominio.Articulo;
import dominio.Item;
import dominio.Medida;
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
    	Collections.sort(articulos);
      return articulos;
  }

  public static boolean modificar(Articulo original,String nombre,Medida medida,int cantidad,double costo )
  {
    if (( original == null))  return false;
    int posOriginal = articulos.indexOf( original);
    if (posOriginal == -1) return false;
   
    
    // Medida : No se puede modificar si el articulo esta involucrado en algun presupuesto
    ArrayList presupuestos = null;
    presupuestos = ServiciosPresupuestos.obtenerPresupuestoPorArticulo(original);
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
	try {
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
			    		Item itemPresupuesto=(Item)items.get(j);
			    		if ((itemPresupuesto.getElArticulo().equals(a))){
			    			existe=true;
			    		}
			    	}
			    	if (existe==false){
				    	losArticulos.add(a);	
				    }
			    }
			    
			     
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Collections.sort(losArticulos);
		return losArticulos;
  }
}