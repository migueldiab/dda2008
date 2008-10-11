package uiConsola;

import java.util.Calendar;
import java.util.Date;

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
	  Fachada.agregarPresupuesto();
	  agregarItems(unPresupuesto);
	  
  }
public static void agregarItems(Presupuesto unPresupuesto){
	Object item=null;
	do{
		  item=Consola.listadoArrayList(ServiciosArticulos.listado(), "Seleccione item para agregar");
		if(!(item==null)){
		  Fachada.agregarItemPresupuesto(unPresupuesto,	item);
		}
		} while (!(item==null));
	Fachada.calcularCosto(unPresupuesto);
	
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
