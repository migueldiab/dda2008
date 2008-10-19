package dominio;

import java.util.Comparator;

public class CriterioComparacionPorFechaModificacionAsc implements Comparator{

  public int compare(Object unPresupuesto1, Object unPresupuesto2) {
    Presupuesto p1=(Presupuesto)unPresupuesto1;
    Presupuesto p2=(Presupuesto)unPresupuesto2;
    return p1.getFechaModificacion().compareTo(p2.getFechaModificacion())*-1;
    // FIXME Si comparamos alrevés no tenemos que hacer el *-1... Igual, creo que hay que mostrarlo en orden Descendiente, no?
    
  }
}
