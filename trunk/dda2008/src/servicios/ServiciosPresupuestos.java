package servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import utils.I18n;

import dominio.*;


public class ServiciosPresupuestos
{
	private static ArrayList presupuestos = new ArrayList();
  
  public static boolean agregar(Presupuesto unPresupuesto){
    
  	if (presupuestos.indexOf(unPresupuesto)==-1){
    	presupuestos.add(unPresupuesto);
    	unPresupuesto.setCosto(calcularCosto(unPresupuesto));
    	return true;
  	}
  	else
  	{
  	  return false;
  	}
  }
  public static boolean borrar(Presupuesto o){
  	 if(presupuestos.indexOf(o)!=-1){
  		 presupuestos.remove(o);
  		 return true;
  	 }
  	 else{
  		 return false;
  	 }
  }
  
  public static Double calcularCosto(Presupuesto unPresupuesto){
  int x = 0;
  double costo=0;
  	 for(x=0;x<unPresupuesto.getItems().size();x++){
  		 Item item=(Item) unPresupuesto.getItems().get(x);
  		 if(unPresupuesto.getEstado().equals(Presupuesto.FINALIZADO)){
  			 costo+=item.getCostoFinalizado();
  		 }
  		 else{
  		 costo+=item.getElArticulo().getCosto()*item.getCantidadItem();
  		 }
  	 }
  	 return costo;
  }
  public static ArrayList listado(){
  	 if(presupuestos.size()==0){
  		 return null;
  	 }
  	 else{
  	   return presupuestos;
  	 }
  }
  
  public static boolean agregarItem(Presupuesto unPresupuesto,Object unArticulo, int cant){
  		Item unItem=new Item((Articulo)unArticulo,cant);
  		if(unPresupuesto.getItems().contains(unItem)){
  			 return false;
  			 }
  		 else{
  			unPresupuesto.agregarItem(unItem);
  			return true;
  		 }
  	 
  }
  
  public static boolean borrarItem(Presupuesto unPresupuesto,Item unItem){
  	 int indice=presupuestos.indexOf(unPresupuesto);
  	 if (indice==-1){
  		 return false;
  	 }
  	 else{
  		 if(!unPresupuesto.getItems().contains(unItem)){
  			 return false;
  			 }
  		 else{
  			unPresupuesto.borrarItem((Item)unItem); 
  			return true;
  		 }
  	 }
  }
  
  public static boolean modificarPresupuesto(Presupuesto unPresupuesto,
			String descripcion, Date fechaEjecucion) {
	  int indice=presupuestos.indexOf(unPresupuesto);
		 if (indice==-1){
	  		 return false;
	  	 }
		 else{
			 if (!(unPresupuesto.getDescripcion().equals(descripcion))){
				 unPresupuesto.setDescripcion(descripcion);
			 }
			 	 unPresupuesto.setFechaEjecucion(fechaEjecucion);
			 return true;
		 }
  }
  
  public static boolean modificarItemPresupuesto(Presupuesto unPresupuesto,Item item,int cantItem){
	  int indice=presupuestos.indexOf(unPresupuesto);
	  	 if (indice==-1){
	  		 return false;
	  	 }
	  	 else{
	  		 if(!unPresupuesto.getItems().contains(item)){
	  			 return false;
	  		 }
	  		 else{
	  			 item.setCantidadItem(cantItem);
	  			 calcularCosto(unPresupuesto);
	  			 Date now=new Date();
	  			 unPresupuesto.setFechaModificacion(now);
	  			 return true;
	  		 }
	  	 }
  }
  
  public static ArrayList obtenerPresupuestoPorArticulo(Articulo unArticulo)
  {
   ArrayList losPresupuestos = new ArrayList();
   	for (int i = 0; i < presupuestos.size(); i++) {
	   Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
	   ArrayList items = new ArrayList();
	   items = unPresupuesto.getItems();
	   	for (int j = 0; j < items.size(); j++) { 
	   		Item unItem = (Item) items.get(j);
	   		if (unItem.getElArticulo().equals(unArticulo)) {
	   			losPresupuestos.add(unPresupuesto);
	   		}    
	   	}
   	}
   return losPresupuestos;
  }
  public static ArrayList obtenerPresupuestoPorUsuario(Usuario unUsuario)
  {
      ArrayList losPresupuestos = new ArrayList();
     
    for (int i = 0; i < presupuestos.size(); i++) {
      Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
      if (unPresupuesto.getDuenio().equals(unUsuario)) {
        losPresupuestos.add(unPresupuesto);
      }
    }
    return losPresupuestos;
  }
  
  public static ArrayList obtenerPresupuestoPorArticuloEstadoConFecha(Articulo unArticulo, String unEstado)
  {
    ArrayList losPresupuestos = new ArrayList();
   
    for (int i = 0; i < presupuestos.size(); i++) {
      Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
      if (unPresupuesto.getEstado().equals(unEstado) && unPresupuesto.getFechaEjecucion() != null) {
        ArrayList items = new ArrayList();
        items = unPresupuesto.getItems();
        for (int j = 0; j < items.size(); j++) {
          Item unItem = (Item) items.get(j);
          if (unItem.getElArticulo().equals(unArticulo)) {
            losPresupuestos.add(unPresupuesto);
          }    
        }
      }
    }
    return losPresupuestos;
  }
 
  public static ArrayList obtenerPresupuestos(Usuario unUsuario,int Criterio0Asc1Desc,int Criterio0XFechaMod1XFechaEje,int Criterio0EnConstr1Todos){
	ArrayList losPresupuestos=new ArrayList();
	 
	if (unUsuario==null){
		losPresupuestos=listado();
	}
	else{
		for (int i = 0; i < presupuestos.size(); i++) {
		      Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
		      	if (unPresupuesto.getDuenio().equals(unUsuario)) {
		      		if (Criterio0EnConstr1Todos==0){
		      			if(unPresupuesto.getEstado().equals("En Construccion")){
		    			  losPresupuestos.add(unPresupuesto);
		      			}
		      		}
		      		else if (Criterio0EnConstr1Todos==1){
		      			losPresupuestos.add(unPresupuesto);
		      		}
		      		else{
		      			return null;
		      		}
		      	}
		}
	}
	if (Criterio0Asc1Desc==0 && Criterio0XFechaMod1XFechaEje==0){
		Collections.sort(losPresupuestos,new CriterioComparacionPorFechaModificacionAsc());
	}
	else if (Criterio0Asc1Desc==1 && Criterio0XFechaMod1XFechaEje==0){
		Collections.sort(losPresupuestos,new CriterioComparacionPorFechaModificacionDesc());
	}
	else if (Criterio0XFechaMod1XFechaEje==1){
		Collections.sort(losPresupuestos,new CriterioComparacionPorFechaEjecucionYModificacionDesc());
	}
	  return losPresupuestos;
  }

  public static ArrayList obtenerItems(Presupuesto unPresupuesto){
	  return unPresupuesto.getItems();
  }
  
  public static boolean finalizarPresupuestos(Presupuesto unPresupuesto) {
	unPresupuesto.setEstado(I18n.FINALIZADO);
	  ArrayList items=unPresupuesto.getItems();
	for(int i=0;i<items.size();i++){
		Item item=(Item)items.get(i);
		Articulo articulo=null;
		ArrayList articulos=ServiciosArticulos.listado();
		for (int j=0;j<articulos.size();j++){
			articulo=(Articulo)articulos.get(j);
			if (articulo.equals(item.getElArticulo())){
				articulo.setCantidad(articulo.getCantidad()-item.getCantidadItem());
				item.setCostoFinalizado(articulo.getCosto());
			}
		}
	}
	return true;
}

  public static boolean validoCantidadesFinalizacion(Presupuesto unPresupuesto) {
	ArrayList items=unPresupuesto.getItems();
	int count=0;
	int j=0;
	for(int i=0;i<items.size();i++){
		j=0;
		Item item=(Item)items.get(i);
		Articulo articulo=null;
		ArrayList articulos=ServiciosArticulos.listado();
		while(j<articulos.size()){
			articulo=(Articulo)articulos.get(j);
			if (articulo.equals(item.getElArticulo())){
				if(articulo.getCantidad()<item.getCantidadItem()){
					return false;
				}
				else{
					count++;
				}
			}
			j++;
		}
		}
	if (count<unPresupuesto.getItems().size()){
		return false;
	}
	return true;
}

  public static Presupuesto copiarPresupuesto(Presupuesto unPresupuesto,String descripcion) {
	Presupuesto nuevoPresupuesto=new Presupuesto(descripcion,unPresupuesto.getFechaEjecucion());
	
	;// pppp//mal
	ArrayList nuevosItems=new ArrayList();
	for(int i=0;i<unPresupuesto.getItems().size();i++){
		Item item=(Item)unPresupuesto.getItems().get(i);
		try {
			Item nuevoItem=(Item) item.clone();
			nuevosItems.add(nuevoItem);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		nuevoPresupuesto.setItems(nuevosItems);
	}
	nuevoPresupuesto.setDuenio(ServiciosUsuarios.getUsuarioActual());
	Date now=new Date();
	nuevoPresupuesto.setFechaModificacion(now);
	nuevoPresupuesto.setCosto(unPresupuesto.getCosto());
	presupuestos.add(nuevoPresupuesto);
	return nuevoPresupuesto;
		
}

  public static boolean cambiarDuenio(Presupuesto unPresupuesto,Usuario nuevoDuenio) {
	  int indice=presupuestos.indexOf(unPresupuesto);
	  if (indice==-1){
		  return false;
	  }
	  else{
		  unPresupuesto.setDuenio(nuevoDuenio);
		  return true;
	  }

  }

  public static boolean validoPresupuesto(String descripcion,Usuario usuarioActual) {
	  for(int i=0;i<presupuestos.size();i++){
		  Presupuesto unPresupuesto=(Presupuesto) presupuestos.get(i);
		  if (unPresupuesto.getDescripcion().equals(descripcion)){
			  if (unPresupuesto.getDuenio().equals(usuarioActual)){
				  return false;
			  }

		  }
	  }
	  return true;

  }
  public static boolean validoFechaEjecucion(Presupuesto unPresupuesto) {
	  Date now=new Date();
	  if(unPresupuesto.getFechaEjecucion()==null){
		  return false;
	  }else if(unPresupuesto.getFechaEjecucion().after(now)){
		  return false;
	  }
	  return true;
  }
  public static ArrayList obtenerPresupuestoPorArticuloCompuesto(ArticuloCompuesto original) {
	  // TODO Hacer el metodo
	  return null;
  }

  public static ArrayList obtenerPresupuestosEnConstruccionFechaMenorQue(Calendar cal){
	  ArrayList losPresupuestos=new ArrayList();
	  for(int i=0;i<presupuestos.size();i++){
		  Presupuesto unPresupuesto=(Presupuesto) presupuestos.get(i);
		  if(unPresupuesto.getEstado()=="En Construccion"){
			  if(unPresupuesto.getFechaEjecucion().before(cal.getTime())){
				 losPresupuestos.add(unPresupuesto); 
			  }
		  }
	  }
	  return losPresupuestos;
  }
public static ArrayList obtenerPresupuestosAntesDe(Date fecha) {
	ArrayList retorno=new ArrayList();
	for(int i=0;i<presupuestos.size();i++){
		Presupuesto unPresupuesto=(Presupuesto) presupuestos.get(i);
		if(unPresupuesto.getEstado()=="En Construccion"){
			if(unPresupuesto.getFechaEjecucion().before(fecha)){
				retorno.add(unPresupuesto);
			}
			
		}
	}
	return retorno;
}
public static ArrayList getArticulosSimplesDePresupuestosAntesDe(Date fecha) {
	ArrayList retorno=new ArrayList();
	ArrayList losPresupuestos=obtenerPresupuestosAntesDe(fecha);
	for(int i=0;i<losPresupuestos.size();i++){
		Presupuesto unPresupuesto=(Presupuesto)losPresupuestos.get(i);
		for(int j=0;j<unPresupuesto.getItems().size();j++){
			Item unItem=(Item) unPresupuesto.getItems().get(j);
			if(retorno.contains(unItem.getElArticulo())){
				int intArtRetorno = retorno.indexOf(unItem.getElArticulo());
				Articulo itemRetorno=(Articulo)retorno.get(intArtRetorno);
				//itemRetorno.setCantidad(itemRetorno.getCantidad()+unItem.getCantidad
			}
			
		}
		
		
	}
	return retorno;
}


}
