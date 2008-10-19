package uiConsola;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import dominio.Articulo;
import dominio.Presupuesto;
import dominio.Usuario;

import servicios.Fachada;
import servicios.ServiciosArticulos;
import utils.Consola;
import utils.I18n;

public class UiPresupuesto
{

  public static void agregarPresupuesto()
  {
      String descripcion ="";
	  Calendar cal=null;
	  
	  descripcion=Consola.leer(I18n.DESCRIPCION +" : ");
	  I18n.setFormato("dd/MM/yyyy");
	  cal=Consola.leerFecha(I18n.FECHAEJECUCION);
	  Date fechaEjecucion=null;
	
	  if (!(cal==null)){			//validar esto si anda
	  fechaEjecucion=cal.getTime();
	  }
	  		  
	  Presupuesto unPresupuesto=new Presupuesto(descripcion,fechaEjecucion);
	  Fachada.agregarPresupuesto(unPresupuesto);
	  agregarItems(unPresupuesto);
	  
  }
  public static void agregarItems(Presupuesto unPresupuesto){
		int cant=0;
	  Object item=null;
	do{
		  item=Consola.agregoItems(ServiciosArticulos.listado(), "Seleccione item para agregar");
		if(item!=null){
			Consola.println(((Articulo)item).toString());
			cant=Consola.leerInt("|  "+I18n.SELECCIONE_CANTIDAD+" : ");
			if (cant<=((Articulo)item).getCantidad()&& cant>0){
				Articulo itemClone =(Articulo) ((Articulo)item).clone();
				itemClone.setCantidad(cant);
				Fachada.agregarItemPresupuesto(unPresupuesto, itemClone);
			}else{
				Consola.println("|  "+I18n.CANTIDAD_MAL+" ");
				break;
			}
			Fachada.calcularCosto(unPresupuesto);
			Consola.println("ToString unPresupuesto" + unPresupuesto.toString()); //quitar despues
		} 
	}while (item!=null);
}
  
  public static void borrarPresupuesto()
  {
    // TODO Auto-generated method stub
   Fachada.borrarPresupuesto(); 
  }

  public static void modificarPresupuesto()
  {
   ArrayList presupuestos =Fachada.listadoPresupuestos();
     if (presupuestos == null) {
     Consola.println(I18n.LISTA_VACIA);
     Consola.leer(I18n.PRESIONE_ENTER);
     }
     else {
    	 int posPresupuesto = Consola.menu(presupuestos);
    	 Presupuesto original = (Presupuesto) presupuestos.get(posPresupuesto);
    	 String descripcion = "";
    	 Date fechaEjecucion = null;
    	 Consola.println(original.toString());
    	 descripcion = Consola.modificar(I18n.DESCRIPCION, original.getDescripcion());
    	 fechaEjecucion = Consola.modificarFecha(I18n.FECHAEJECUCION, original.getFechaEjecucion());
    	 String confirma = Consola.leer(I18n.CONFIRMA_MODIFICAR);
    	 	if (confirma.toUpperCase().equals(I18n.SI.toUpperCase()))
    	 	{
    	 		if (Fachada.modificarPresupuesto(original,descripcion,fechaEjecucion)){
    	 			Consola.println(I18n.MODIFICADO_OK); 
    	 		}
    	 	}
    	 	String confirma2 = Consola.leer(I18n.MODIFICA_ITEMS);
    	 	if (confirma2.toUpperCase().equals(I18n.SI.toUpperCase())){
    	 		modificarItems(original);
    	 	}
    	 	else{
    	 		Consola.println(I18n.CANCELADA);
    	 		Consola.leer(I18n.PRESIONE_ENTER);
       	 	}  
  }
  }
  
  public static void modificarItems(Presupuesto unPresupuesto){
	
	Articulo item=null;
	int posItem=0;
    int cantItem=0;
	ArrayList items = unPresupuesto.getItems();
    posItem = Consola.menu(items);
    item = (Articulo) items.get(posItem);
    cantItem=Consola.modificarInt(I18n.CANTIDAD, item.getCantidad());
  if (cantItem>item.getCantidad()){
	  Consola.println(I18n.CANTIDAD_MAYOR);
  }
  else{
	  String confirma = Consola.leer(I18n.MODIFICA_ITEMS);
	    if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
	    	Fachada.modificarItemPresupuesto(unPresupuesto,item,cantItem);
	    }  
  }
  
  }
	
  public static void listadoPresupuestos()
  {
    // TODO Auto-generated method stub
    ArrayList presupuestos = Fachada.listadoPresupuestos();;
    if (presupuestos == null) {
      Consola.println(I18n.LISTA_VACIA);
      Consola.leer(I18n.PRESIONE_ENTER);
    }
    else {
      Consola.listado(presupuestos);
      Consola.leer(I18n.PRESIONE_ENTER);
    }   
  }
public static void cambiarDuenio() {
	
	ArrayList gestores=Fachada.listadoGestoresPorApellido();
    if (gestores==null) {
        Consola.println(I18n.LISTA_VACIA);
        Consola.leer(I18n.PRESIONE_ENTER);
      }
      else {
    	  int posGestor=Consola.menu(gestores,I18n.SELECCIONE_GESTOR);
  		Usuario unGestor=(Usuario) gestores.get(posGestor);
  		ArrayList presupuestosGestor=Fachada.obtenerPresupuestoPorUsuarioOrdenadoFechaModificacionAsc(unGestor);
  		if(presupuestosGestor == null){
  			Consola.println(I18n.LISTA_VACIA);
  	        Consola.leer(I18n.PRESIONE_ENTER);
  		}
  		int posPresupuesto=Consola.menuPresupuestos(presupuestosGestor);
  		Presupuesto unPresupuesto=(Presupuesto) presupuestosGestor.get(posPresupuesto);
        ArrayList gestoresXNombre=Fachada.listadoGestoresPorNombreUsuario();
        int posNuevoDuenio = Consola.menu(gestoresXNombre, I18n.SELECCIONE_NUEVO_DUENIO);
        Usuario nuevoDuenio=(Usuario) gestoresXNombre.get(posNuevoDuenio);
        if(Fachada.cambiarDuenio(unPresupuesto,nuevoDuenio)){
        	Consola.println(I18n.MODIFICADO_OK);
        	Consola.println(I18n.PRESIONE_ENTER);
        }
        
      }   
    }
	
public static void finalizarPresupuesto() {
ArrayList losPresupuestos=Fachada.obtenerPresupuestoEnConstruccionPorUsuarioOrdenadoFechaModificacion(Fachada.getUsuarioActual());
	if (losPresupuestos == null) {
	     Consola.println(I18n.LISTA_VACIA);
	     }
	     else {
	    		int posPresupuesto= Consola.menuPresupuestos(losPresupuestos);
	    		Presupuesto unPresupuesto = (Presupuesto) losPresupuestos.get(posPresupuesto);
	    		Consola.println(unPresupuesto.toString());
	    		String confirma=Consola.leer(I18n.CONFIRMA_FINALIZACION);
	    		if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
	    			if(Fachada.validoCantidadesFinalizacion(unPresupuesto)){
	    				Fachada.finalizarPresupuesto(unPresupuesto);
	    				Consola.println(I18n.FINALIZADO_OK);
	    				Consola.leer(I18n.PRESIONE_ENTER);
	    			}
	    			else{
	    				Consola.println(I18n.ARTICULOS_SIN_STOCK);
	    				Consola.leer(I18n.PRESIONE_ENTER);
	    			}
	    		}
	    		else{
	    			Consola.println(I18n.CANCELADA);
	    			Consola.leer(I18n.PRESIONE_ENTER);
	    		}
	     }
	
}
public static void copiarPresupuesto() {
	ArrayList losPresupuestos=Fachada.obtenerPresupuestoPorUsuarioOrdenadoFechaModificacionAsc(Fachada.getUsuarioActual());
	if (losPresupuestos == null) {
	     Consola.println(I18n.LISTA_VACIA);
	     }
	     else {
	    	 int posPresupuesto=Consola.menuPresupuestos(losPresupuestos);
	    	 Presupuesto unPresupuesto=(Presupuesto) losPresupuestos.get(posPresupuesto);
	    	 Consola.println(unPresupuesto.toString());
	    	 String confirma=Consola.leer(I18n.CONFIRMA_COPIA);
	    	 if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
	    		 String descripcion=Consola.leer(I18n.INGRESE_DESCRIPCION);
	    		 Consola.println(Fachada.copiarPresupuesto(unPresupuesto,descripcion).toString());
	    		 Consola.println(I18n.PRESIONE_ENTER);
	    	 }
	    	 else{
	    		 Consola.println(I18n.CANCELADA);
	    		 Consola.println(I18n.PRESIONE_ENTER);
	    	 }
	     }




}


}












