package dominio;

import java.util.Comparator;

public class CriterioComparacionPorFechaEjecucionYModificacionDesc implements Comparator{
	
	public int compare(Object unPresupuesto1, Object unPresupuesto2) {
		int retorno=0;
		Presupuesto p1=(Presupuesto)unPresupuesto1;
		Presupuesto p2=(Presupuesto)unPresupuesto2;
		int fechaEjecucion=p1.getFechaEjecucion().compareTo(p2.getFechaEjecucion())*-1;
		if (fechaEjecucion==0){
		   	retorno=p1.getFechaModificacion().compareTo(p2.getFechaModificacion())*-1;
			}
		else{
		   	retorno=fechaEjecucion;
			}
		    return retorno;
		  }
}
