package uiConsola;

import java.util.ArrayList;

import servicios.Fachada;
import servicios.ServiciosUsuarios;
import utils.Consola;
import utils.I18n;
import dominio.Presupuesto;

public class UiConsultas
{

  public static void presupuestos()
  {
    // FIXME Hay que fijarse si esto va ordenado por Fecha de Modificacion o por Fecha de Ejecución...
    ArrayList losPresupuestos = Fachada.obtenerPresupuestoPorUsuarioOrdenadoFechaModificacionDesc(ServiciosUsuarios.getUsuarioActual());
    if (losPresupuestos.size() > 0) {
      int opcion = Consola.menu(losPresupuestos);
      Presupuesto unPresupuesto = (Presupuesto) losPresupuestos.get(opcion);
      ArrayList losItems = unPresupuesto.getItems();
      Consola.listado(losItems);
      Consola.leer(I18n.PRESIONE_ENTER);
    }
    else {
      Consola.println(I18n.LISTA_VACIA);
      Consola.leer(I18n.PRESIONE_ENTER);
    }
  }
}
