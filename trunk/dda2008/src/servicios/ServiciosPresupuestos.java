package servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import dominio.Articulo;
import dominio.CriterioComparacionPorFechaModificacionAsc;
import dominio.Grupo;
import dominio.Presupuesto;
import dominio.Usuario;

public class ServiciosPresupuestos
{
  private static ArrayList presupuestos = new ArrayList();
  
  public static boolean agregar(Presupuesto unPresupuesto){
    Date now=new Date();
  	if (presupuestos.indexOf(unPresupuesto)==-1){
    	unPresupuesto.setFechaModificacion(now);
      // FIXME
      if (ServiciosUsuarios.getUsuarioActual()!=null)
        unPresupuesto.setDuenio(ServiciosUsuarios.getUsuarioActual());
    	presupuestos.add(unPresupuesto);
    	return true;
  	}
  	else
  	{
  	  return false;
  	}
  }
  public static boolean borrar(Object o){
  	 if(presupuestos.indexOf((Presupuesto)o)==-1){
  		 presupuestos.remove((Presupuesto)o);
  		 return true;
  	 }
  	 else{
  		 return false;
  	 }
  }
  
  public static void calcularCosto(Presupuesto unPresupuesto){
  int x = 0;
  double costo=0;
  	 for(x=0;x<unPresupuesto.getItems().size();x++){
  		 Articulo item=(Articulo) unPresupuesto.getItems().get(x);
  		 costo+=item.getCosto()*item.getCantidad();
  		}
  		unPresupuesto.setCosto(costo);
  	 }
  
  public static ArrayList listado(){
  	 if(presupuestos.size()==0){
  		 return null;
  	 }
  	 else{
  	   return presupuestos;
  	 }
  }
  
  public static boolean agregarItem(Presupuesto unPresupuesto,Object unItem){
  		 if(unPresupuesto.getItems().contains(unItem)){
  			 return false;
  			 }
  		 else{
  			unPresupuesto.agregarItem(unItem);
  			return true;
  		 }
  	 
  }
  
  public static boolean borrarItem(Presupuesto unPresupuesto,Object unItem){
  	 int indice=presupuestos.indexOf(unPresupuesto);
  	 if (indice==-1){
  		 return false;
  	 }
  	 else{
  		 if(!unPresupuesto.getItems().contains(unItem)){
  			 return false;
  			 }
  		 else{
  			unPresupuesto.borrarItem((Articulo)unItem); 
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
			 if (!(unPresupuesto.getFechaEjecucion().equals(fechaEjecucion))){
				 unPresupuesto.setFechaEjecucion(fechaEjecucion);
			 }
			 return true;
		 }
  }
  
  public static boolean modificarItemPresupuesto(Presupuesto unPresupuesto,Articulo item,int cantItem){
	  int indice=presupuestos.indexOf(unPresupuesto);
	  	 if (indice==-1){
	  		 return false;
	  	 }
	  	 else{
	  		 if(!unPresupuesto.getItems().contains(item)){
	  			 return false;
	  		 }
	  		 else{
	  			 item.setCantidad(cantItem);
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
    for (int j = 0; j < presupuestos.size(); j++) { //item?
      Articulo unItem = (Articulo) items.get(j);
      if (unItem.equals(unArticulo)) {
       losPresupuestos.add(unItem);//devuelve item no presupuesto
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
        for (int j = 0; j < presupuestos.size(); j++) {
          Articulo unItem = (Articulo) items.get(j);
          if (unItem.equals(unArticulo)) {
            losPresupuestos.add(unItem); //devuelve los articulos
          }    
        }
      }
    }
    return losPresupuestos;
  }
  public static ArrayList obtenerPresupuestoPorUsuarioOrdenadoFechaModificacionDesc(Usuario unUsuario)
  {
    ArrayList losPresupuestos = new ArrayList();
    Collections.sort(presupuestos);
    
    for (int i = 0; i < presupuestos.size(); i++) {
      Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
      if (unPresupuesto.getDuenio().equals(unUsuario) || !unUsuario.getGrupo().equals(new Grupo("Gestor"))) {
        losPresupuestos.add(unPresupuesto);
      }
    }    
        
    return losPresupuestos;
  }

  public static ArrayList obtenerPresupuestoEnConstruccionPorUsuarioOrdenadoFechaModificacion(Usuario unUsuario)
  {
    ArrayList losPresupuestos = new ArrayList();
    Collections.sort(presupuestos);
    
    for (int i = 0; i < presupuestos.size(); i++) {
      Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
      if (unPresupuesto.getDuenio().equals(unUsuario) || !unUsuario.getGrupo().equals(new Grupo("Gestor"))) {
       if(unPresupuesto.getEstado().equals("En Construccion")){
    	  losPresupuestos.add(unPresupuesto);
       }
      }
    }    
        
    return losPresupuestos;
  }
public static boolean finalizarPresupuestos(Presupuesto unPresupuesto) {
	ArrayList items=unPresupuesto.getItems();
	for(int i=0;i<items.size();i++){
		Articulo item=(Articulo)items.get(i);
		Articulo articulo=null;
		ArrayList articulos=ServiciosArticulos.listado();
		for (int j=0;j<articulos.size();j++){
			articulo=(Articulo)articulos.get(j);
			if (articulo.equals(item)){
				articulo.setCantidad(articulo.getCantidad()-item.getCantidad());
				item.setCosto(articulo.getCosto());
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
		Articulo item=(Articulo)items.get(i);
		Articulo articulo=null;
		ArrayList articulos=ServiciosArticulos.listado();
		while(j<articulos.size()){
			articulo=(Articulo)articulos.get(j);
			if (articulo.equals(item)){
				if(articulo.getCantidad()<item.getCantidad()){
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
public static ArrayList obtenerPresupuestoPorUsuarioOrdenadoFechaModificacionAsc(Usuario unUsuario) {
	ArrayList losPresupuestos = new ArrayList();
    Collections.sort(presupuestos,new CriterioComparacionPorFechaModificacionAsc());
    
    for (int i = 0; i < presupuestos.size(); i++) {
      Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
      if (unPresupuesto.getDuenio().equals(unUsuario) || !unUsuario.getGrupo().equals(new Grupo("Gestor"))) {
        losPresupuestos.add(unPresupuesto);
      }
    }    
        
    return losPresupuestos;
  }
public static Presupuesto copiarPresupuesto(Presupuesto unPresupuesto,String descripcion) {
	Presupuesto nuevoPresupuesto=new Presupuesto(descripcion,unPresupuesto.getFechaEjecucion());
	nuevoPresupuesto.setItems(unPresupuesto.getItems());
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

  
  
 
}
