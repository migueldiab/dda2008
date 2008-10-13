package uiConsola;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dominio.Articulo;
import dominio.Medida;
import dominio.Presupuesto;

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
	  Consola.setFormato("dd/MM/yyyy");
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
         String confirma2 = Consola.leer(I18n.MODIFICA_ITEMS);
         if (confirma2.toUpperCase().equals(I18n.SI.toUpperCase())){
         modificarItems(original);
         }
       }
       else
         Consola.println(I18n.ERROR);
     }      
   }  
  
  public static void modificarItems(Presupuesto unPresupuesto){
	
	Articulo item=null;
	int posItem=0;
    int cantItem=0;
	ArrayList items = unPresupuesto.getItems();
    posItem = Consola.menu(items);
    item = (Articulo) items.get(posItem);
    cantItem=Consola.leerInt(I18n.CANTIDAD);
    String confirma = Consola.leer(I18n.MODIFICA_ITEMS);
    if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
    	Fachada.modificarItemPresupuesto(unPresupuesto,cantItem);
    }
	
	
	
}
	
	
	
	
  public static void listadoPresupuestos()
  {
    // TODO Auto-generated method stub
Fachada.listadoPresupuestos();    
  }

}
