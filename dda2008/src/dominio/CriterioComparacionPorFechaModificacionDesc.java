package dominio;
import java.util.Comparator;


public class CriterioComparacionPorFechaModificacionDesc implements Comparator{
	  public int compare(Object unPresupuesto1, Object unPresupuesto2) {
	    Presupuesto p1=(Presupuesto)unPresupuesto1;
	    Presupuesto p2=(Presupuesto)unPresupuesto2;
	    return p1.getFechaModificacion().compareTo(p2.getFechaModificacion())*-1;
	        
	  }
	}


