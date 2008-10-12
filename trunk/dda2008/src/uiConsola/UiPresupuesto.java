package uiConsola;

import java.util.Calendar;
import java.util.Date;

import dominio.Articulo;
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
    // TODO Auto-generated method stub
   Fachada.modificarPresupuesto(); 
  }

  public static void listadoPresupuestos()
  {
    // TODO Auto-generated method stub
Fachada.listadoPresupuestos();    
  }

}
