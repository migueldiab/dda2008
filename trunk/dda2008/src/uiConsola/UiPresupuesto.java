package uiConsola;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dominio.Articulo;
import dominio.Presupuesto;
import dominio.Usuario;

import servicios.Fachada;
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
	  String confirma=Consola.leer(I18n.DESEA_FECHA_EJECUCION);
	  Date fechaEjecucion=null;
	  if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
		  cal=Consola.leerFecha(I18n.FECHAEJECUCION);
		  if (!(cal==null)){
		  fechaEjecucion=cal.getTime();
		  }
	  }
	  if(Fachada.validoPresupuesto(descripcion,Fachada.getUsuarioActual())){
		  Presupuesto unPresupuesto=new Presupuesto(descripcion,fechaEjecucion);
		  Fachada.agregarPresupuesto(unPresupuesto);
		  agregarItems(unPresupuesto);  
	  }
	  else{
		  Consola.println(I18n.PRESUPUESTO_YA_EXSTE);
		  Consola.leer(I18n.PRESIONE_ENTER);
	  }
	  
	  
  }
  public static void agregarItems(Presupuesto unPresupuesto){
		int cant=0;
	  Object item=null;
	do{
		  item=Consola.agregoItems(Fachada.obtenerArticulosNotIn(unPresupuesto),I18n.SELECCIONE_ARTICULO);
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
			for(int x=0;x<unPresupuesto.getItems().size();x++){
				  Consola.println(((Articulo) unPresupuesto.getItems().get(x)).toStringConCosto());
		   }
			Consola.println("Costo Total: "+unPresupuesto.getCosto());
			
		} 
	}while (item!=null);
}
  
  private static void borrarItems(Presupuesto unPresupuesto) {
		ArrayList items=Fachada.obtenerItems(unPresupuesto);
		  if (items.isEmpty()) {
			     Consola.println(I18n.LISTA_VACIA);
			     Consola.leer(I18n.PRESIONE_ENTER);
			     }
			     else {
		int posItem = Consola.menu(items, I18n.SELECCIONE_ITEM_BORRAR);
			Articulo unItem=(Articulo) items.get(posItem);
			Fachada.borrarItemPresupuesto(unPresupuesto, unItem);
			     }
		
	}
  public static void borrarPresupuesto()
  {
	  ArrayList presupuestos =Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(), 0, 0, 1);
      if (presupuestos.isEmpty()) {
    	  Consola.println(I18n.LISTA_VACIA);
    	  Consola.leer(I18n.PRESIONE_ENTER);
	  }
	  else {
		  int posPresupuesto = Consola.menuPresupuestos(presupuestos);
		  Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(posPresupuesto);
		  Consola.println(unPresupuesto.toString());
		  String confirma=Consola.leer(I18n.CONFIRMA_ELIMINAR);
		  if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
			  if(Fachada.borrarPresupuesto(unPresupuesto)){
				  Consola.println(I18n.BORRADO_OK);
				  Consola.leer(I18n.PRESIONE_ENTER);
			  }
			  else{
				  Consola.println(I18n.ERROR); 
				  Consola.leer(I18n.PRESIONE_ENTER);
			  }
		  }
		  else{
			Consola.println(I18n.CANCELADA);
  			Consola.leer(I18n.PRESIONE_ENTER); 
		  }
	  }
  }

  public static void modificarPresupuesto()
  {
   ArrayList presupuestos =Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(), 1, 0, 0);
     if (presupuestos.isEmpty()) {
     Consola.println(I18n.LISTA_VACIA);
     Consola.leer(I18n.PRESIONE_ENTER);
     }
     else {
    	 int posPresupuesto = Consola.menuPresupuestos(presupuestos);
    	 Presupuesto original = (Presupuesto) presupuestos.get(posPresupuesto);
    	 Consola.println(original.toString());
    	 UiPresupuesto.MenuModificacionPresupuestos(original);
     }
  } 
    	 
  public static void modificarInformacionPresupuesto(Presupuesto original){
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
  }
    	 
  
  public static void MenuModificacionPresupuestos(Presupuesto unPresupuesto){
	  boolean menu_anterior = false;   
     
      do {
        ArrayList items = new ArrayList();
        items.add(I18n.ITEM_ALTA);
        items.add(I18n.ITEM_BAJA);
        items.add(I18n.ITEM_MODIFICA);
        items.add(I18n.PRESUPUESTO_MODIFICA);
        items.add(I18n.MENU_ANTERIOR);
        String opcion = (String) items.get(Consola.menu(items, I18n.USUARIOS));
        if (opcion.equals(I18n.ITEM_ALTA)) agregarItems(unPresupuesto);
        if (opcion.equals(I18n.ITEM_BAJA)) borrarItems(unPresupuesto);
        if (opcion.equals(I18n.ITEM_MODIFICA)) modificarItems(unPresupuesto);
        if (opcion.equals(I18n.PRESUPUESTO_MODIFICA)) modificarInformacionPresupuesto(unPresupuesto);
        if (opcion.equals(I18n.MENU_ANTERIOR)) menu_anterior = true;
      } while (!menu_anterior);
  }
  
  
 
public static void modificarItems(Presupuesto unPresupuesto){
	
	Articulo item=null;
	int posItem=0;
    int cantItem=0;
	ArrayList items = unPresupuesto.getItems();
	if(items.isEmpty()){
		Consola.println(I18n.LISTA_VACIA);
		Consola.leer(I18n.PRESIONE_ENTER);
	}
	else{
    posItem = Consola.menu(items);
    item = (Articulo) items.get(posItem);
    cantItem=Consola.modificarInt(I18n.CANTIDAD, item.getCantidad());
    if (cantItem<=((Articulo)item).getCantidad()&& cantItem>0){
    	String confirma = Consola.leer(I18n.MODIFICA_ITEMS);
	    if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
	    	Fachada.modificarItemPresupuesto(unPresupuesto,item,cantItem);
	    }  
	    else{
	    	Consola.println(I18n.CANCELADA);
  			Consola.leer(I18n.PRESIONE_ENTER); 
	    }
    }else{
	    	Consola.println("|  "+I18n.CANTIDAD_MAL+" ");
	        Consola.leer(I18n.PRESIONE_ENTER);
	    }
	}
  }
	
  public static void listadoPresupuestos()
  {
    // TODO Auto-generated method stub
    ArrayList presupuestos = Fachada.listadoPresupuestos();;
    if (presupuestos.isEmpty()) {
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
    if (gestores.isEmpty()) {
        Consola.println(I18n.LISTA_VACIA);
        Consola.leer(I18n.PRESIONE_ENTER);
      }
      else {
    	  int posGestor=Consola.menu(gestores,I18n.SELECCIONE_GESTOR);
    	  Usuario unGestor=(Usuario) gestores.get(posGestor);
    	  ArrayList presupuestosGestor=Fachada.obtenerPresupuestos(unGestor, 0, 0, 0);
    	  if(presupuestosGestor.isEmpty()){
    	    Consola.println(I18n.LISTA_VACIA);
  	      Consola.leer(I18n.PRESIONE_ENTER);
    	  }
    	  else {
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
    }
	
public static void finalizarPresupuesto() {
ArrayList losPresupuestos=Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(), 1, 0, 0);
	if (losPresupuestos.isEmpty()) {
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
	ArrayList losPresupuestos=Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(), 0, 0, 1);
	if (losPresupuestos.isEmpty()) {
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












