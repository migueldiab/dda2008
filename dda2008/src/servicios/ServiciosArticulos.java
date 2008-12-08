package servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import utils.I18n;

import dominio.Articulo;
import dominio.ArticuloCompuesto;
import dominio.ArticuloSimple;
import dominio.Componente;
import dominio.Item;
import dominio.Medida;
import dominio.Presupuesto;
import dominio.Usuario;

public class ServiciosArticulos 
{
  private static ArrayList articulos = new ArrayList();

  public static boolean agregar(Object o)
  {
    Articulo unArticulo = (Articulo) o;
    if ((unArticulo.getNombre().length()<4) ||
      (unArticulo.getMedida()==null))
      return false;
    
    if (articulos.indexOf(unArticulo)==-1) {
      articulos.add(unArticulo);
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
        for (ArticuloCompuesto articuloComponente : listadoCompuestos()) {
          for (Componente unComponente : articuloComponente.listarComponentes()) {
            if (unArticulo.equals(unComponente.getArticulo())) {
              return false;
            }
          }
        }
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

  public static boolean modificar(Articulo original,Articulo nuevo)
  {
    if (( original == null))  return false;
    int posOriginal = articulos.indexOf( original);
    if (posOriginal == -1) return false;
   
    
    // Medida : No se puede modificar si el articulo esta involucrado en algun presupuesto
    ArrayList presupuestos = null;
    presupuestos = ServiciosPresupuestos.obtenerPresupuestoPorArticulo(original);
    if (presupuestos.size() > 0 && !original.getMedida().equals(nuevo.getMedida())) {
          return false;
    }
    original.setCantidad(nuevo.getCantidad());
    original.setCosto(nuevo.getCosto());
    original.setMedida(nuevo.getMedida());
    original.setNombre(nuevo.getNombre());
    original.remplazarComponentes(nuevo.listarComponentes());
    return true;
  }

  public static int cantidad()
  {
    return articulos.size();
  }

  public static Object obtener(Object o)
  {
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

  public static ArrayList<Object[]> getArticulosStockInsuficiente(Calendar cal) {
	
	  return null;
  }

  public static ArrayList<ArticuloCompuesto> listadoCompuestos() {
    if (cantidad() == 0)
      return null;
    else {
      ArrayList<ArticuloCompuesto> articulosCompuestos = new ArrayList<ArticuloCompuesto>();
      for (int i=0;i<articulos.size();i++) {
        String tipo = ((Articulo) articulos.get(i)).tipoArticulo();
        if (tipo.equals("Compuesto")) {
          articulosCompuestos.add((ArticuloCompuesto) articulos.get(i));
        }
      }
      return articulosCompuestos;
    }
  }

  public static ArrayList listadoSimples() {
    if (cantidad() == 0)
      return null;
    else {
      ArrayList<ArticuloSimple> articulosCompuestos = new ArrayList<ArticuloSimple>();
      for (int i=0;i<articulos.size();i++) {
        String tipo = ((Articulo) articulos.get(i)).tipoArticulo();
        if (tipo.equals("Simple")) {
          articulosCompuestos.add((ArticuloSimple) articulos.get(i));
        }
      }
      return articulosCompuestos;
    }
  }

  public static boolean agregarCompuesto(ArticuloCompuesto unArticuloCompuesto) {
    if (unArticuloCompuesto.listarComponentes().size()<2)
      return false;
    Articulo unArticulo = (Articulo) obtener(unArticuloCompuesto);
    if (unArticulo!=null)
      return modificar(unArticulo, unArticuloCompuesto);
    else
      return agregar((Articulo) unArticuloCompuesto) ;   
  }

  public static boolean verificarRedundancia(ArticuloCompuesto elArticuloCompuesto, Componente elComponente) {
    ArticuloCompuesto unArticuloCompuesto = (ArticuloCompuesto) obtener(elComponente.getArticulo());
    if (unArticuloCompuesto!=null) {
      for (Componente unComponente : unArticuloCompuesto.listarComponentes()) {
        if (unComponente.getArticulo().esCompuesto()) {
          if (unComponente.getArticulo().equals(elArticuloCompuesto)) {
            return false;
          }
          else {
            if (articuloTieneComponente((ArticuloCompuesto) unComponente.getArticulo(), new Componente(elArticuloCompuesto)))
              return false;
          }
        }
      }
    }
    return true;
  }

  private static boolean articuloTieneComponente(ArticuloCompuesto compuesto, Componente componente) {
    for (Componente unComponente : compuesto.listarComponentes()) {
      if (unComponente.equals(componente)) {
        return true;
      }
    }
    return false;
  }


  
  	public static ArrayList StockSimplesPresupuestos(Item itemRoot, ArrayList articulosSimplesUnPresupuesto){
		Articulo articuloRoot=itemRoot.getElArticulo();
		for(int i=0;i<articulos.size();i++){
			Articulo unArticulo=(Articulo)articulos.get(i);
			if(articuloRoot.equals(unArticulo)&&unArticulo.esHoja()){
				articulosSimplesUnPresupuesto=addArticuloToArraylistCompuestosRetorno(unArticulo, itemRoot.getCantidadItem(),articulosSimplesUnPresupuesto);
			}
			else if(articuloRoot.equals(unArticulo)&&unArticulo.esCompuesto()){
				ArrayList losComponentes=unArticulo.listarComponentes();
				articulosSimplesUnPresupuesto=traerComponentesDeArticulosSimplesConCantidad(losComponentes,1,articulosSimplesUnPresupuesto);
			}
		}
		return articulosSimplesUnPresupuesto;
	}

  	private static ArrayList traerComponentesDeArticulosSimplesConCantidad(ArrayList losComponentes,int x,ArrayList arrayLoop){
  		boolean anteriorHoja=false;
  		for(int i=0;i<losComponentes.size();i++){
  			Componente componente=(Componente)losComponentes.get(i);
  			if(componente.getArticulo().esHoja()){
  				arrayLoop=addArticuloToArraylistCompuestosRetorno(componente.getArticulo(), x*componente.getCantidad(),arrayLoop);
  				if(anteriorHoja){
  				x=1;
  				}
  				anteriorHoja=true;
  			}
  			else if(componente.getArticulo().esCompuesto()){
  				x=x*componente.getCantidad();
  				arrayLoop=traerComponentesDeArticulosSimplesConCantidad(componente.getArticulo().listarComponentes(),x,arrayLoop);
  				x=1;
  				anteriorHoja=false;
  			}
  		}
  		return arrayLoop;
  	}
  
  	private static ArrayList addArticuloToArraylistCompuestosRetorno(Articulo unArticulo,int cantidad,ArrayList componentes){
  		boolean tiene=false;
		for(int i=0;i<componentes.size()&&tiene==false;i++){
			Componente componente=((Componente) componentes.get(i));
			Articulo tmpArt=componente.getArticulo();
			if(tmpArt.equals(unArticulo)){
				componente.setCantidad(componente.getCantidad()+cantidad);
				tiene=true;
			}
		}
		if (tiene==false){
			Componente tmpComponente=new Componente(unArticulo,cantidad);
			componentes.add(tmpComponente);
		}
		return componentes;
  		
  		
  		
  	}
    public static boolean actualizarDatosComponentes() {
      for (ArticuloCompuesto unArticulo : listadoCompuestos()) {
        unArticulo.recalcularStock();
        unArticulo.recalcularCosto();
      }
      return true;
    }

    public static boolean actualizarStock(Articulo articulo, int cantidadItem) {
      ArticuloCompuesto artCompuesto = (ArticuloCompuesto) articulo;
      for (Componente componente : artCompuesto.listarComponentes()) {
        if (componente.getArticulo().esCompuesto()) {
          if (!actualizarStock(componente.getArticulo(), cantidadItem*componente.getCantidad())) {
            return false;
          }
        }
        else {
          Articulo elArticulo = (Articulo) obtener(componente.getArticulo());
          int cant = elArticulo.getCantidad();
          if (cant<0) {
            return false;
          }
          else {
            cant = cant - (cantidadItem*componente.getCantidad());
            elArticulo.setCantidad(cant);
          }          
        }        
      }
      return true;
    }
  
  
  
}
