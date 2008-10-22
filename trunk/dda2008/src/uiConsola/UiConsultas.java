package uiConsola;

import java.util.ArrayList;

import servicios.Fachada;
import utils.Consola;
import utils.I18n;
import dominio.Presupuesto;

public class UiConsultas
{

	public static void presupuestos()
	{
		ArrayList losPresupuestos=new ArrayList();
		if(Fachada.getUsuarioActual().getGrupo().toString().equals("Gestor"))    {
			losPresupuestos=Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(), 1, 1, 1);
		}else{
			losPresupuestos = Fachada.obtenerPresupuestos(null, 1, 1, 1);
		}
		if (losPresupuestos.size() > 0) {
			Presupuesto unPresupuesto = (Presupuesto) Consola.menu(losPresupuestos,I18n.LISTADOS,4);
			if(unPresupuesto!=null){
				ArrayList losItems = unPresupuesto.getItems();
				Consola.listado(losItems);
				Consola.leer(I18n.PRESIONE_ENTER);
			}else {
				Consola.println(I18n.CANCELADA);
				Consola.leer(I18n.PRESIONE_ENTER);
			}
		}else{
			Consola.println(I18n.LISTA_VACIA);
			Consola.leer(I18n.PRESIONE_ENTER);
		}
	}
}
