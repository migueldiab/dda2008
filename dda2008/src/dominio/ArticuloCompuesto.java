package dominio;

import java.awt.Color;
import java.util.ArrayList;

import servicios.Fachada;



public class ArticuloCompuesto  extends Articulo implements Cloneable, Comparable {

  public ArrayList<Componente> componentes = new ArrayList<Componente>();
  
  public ArticuloCompuesto(String nombre, Medida unaMedida) {
    super(nombre, unaMedida);
  }

  public ArticuloCompuesto(String nombre, Medida unaMedida, int cantidad, double costo) {
    super(nombre, unaMedida, cantidad, costo);
  }

  

  @Override
  public boolean agregarComponente(Componente unComponente) {
    try {
      // No puedo agregar un componente a si mismo
      if (unComponente.getArticulo().equals(this)) {
        return false;
      }
      if (unComponente.getArticulo().esCompuesto()) {
        if (!Fachada.verificarRedundanciaArticulosCompuestos(this, unComponente))
            return false;
      }
      int pos = getPosComponente(unComponente);
      if (pos!=-1) {
         unComponente = componentes.get(pos);
         int cantidad = unComponente.getCantidad();
         unComponente.setCantidad(++cantidad);
         recalcularStock();
         recalcularCosto();
      }
      else {
        this.componentes.add(unComponente);  
      }
      return true;
      
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public String tipoArticulo() {
    return "Compuesto";
  }

  @Override
  public boolean eliminarComponente(Componente unComponente) {
    try {
      int pos = getPosComponente(unComponente);
      if (pos!=-1) {
         unComponente = componentes.get(pos);
         int cantidad = unComponente.getCantidad();
         if (cantidad==1) {
           if (componentes.size()>1)
             componentes.remove(pos);
           else
             return false;
         }
         else {
           unComponente.setCantidad(--cantidad);
         }
         recalcularStock();
         recalcularCosto();
         return true;
      }
      else {
        // No existe el componente
        return false;  
      }
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public ArrayList<Componente> listarComponentes() {
    return this.componentes;
  }

  @Override
  public boolean esHoja() {
    return false;
  }

  public int contarComponentes() {
    return componentes.size();
  }

  public Object getHijo(int posicion) {
    return componentes.get(posicion);
  }

  public int getPosComponente(Componente unComponente) {
    return componentes.indexOf(unComponente);
  }

  @Override
  public boolean esCompuesto() {
    return true;
  }


  public boolean recalcularStock() {
    int cantidadMax = 99999;
    for (Componente unComponente : this.listarComponentes()) {
      if (unComponente.getArticulo().esCompuesto()) {
        ((ArticuloCompuesto) unComponente.getArticulo()).recalcularStock();
      }
      int temp = unComponente.getArticulo().getCantidad() / unComponente.getCantidad();
      if (cantidadMax > temp) {
        cantidadMax = temp;
      }
    }
    this.setCantidad(cantidadMax);
    return true;
  }
  
  public boolean recalcularCosto() {
    double costo = 0;
    for (Componente unComponente : this.listarComponentes()) {
      if (unComponente.getArticulo().esCompuesto()) {
        ((ArticuloCompuesto) unComponente.getArticulo()).recalcularCosto();
      }
      double temp = unComponente.getArticulo().getCosto() * unComponente.getCantidad();
      costo += temp;
    }
    this.setCosto(costo);
    return true;
  }

@Override
public Articulo getPadre(Componente hijo) {
		if(componentes.contains(hijo)){
		return this;
		}
		Articulo padre=null;
		for(int x=0;x<componentes.size()&& padre==null;x++){
			Componente unHijo=(Componente)componentes.get(x);
			padre=unHijo.getArticulo().getPadre(hijo);
		}
		return padre;
	}

  @Override
  public boolean remplazarComponentes(ArrayList<Componente> listaComponetes) {
    if (listaComponetes.size()>0) {
      componentes.clear();
      for (Componente unComponente : listaComponetes) {
        agregarComponente(unComponente);
      }
      return true;      
    }
    else {
      return false;
    }
  }

  public boolean agregarComponenteCantidad(Componente unComponente) {
    try {
      // No puedo agregar un componente a si mismo
      if (unComponente.getArticulo().equals(this)) {
        return false;
      }
      if (unComponente.getArticulo().esCompuesto()) {
        if (!Fachada.verificarRedundanciaArticulosCompuestos(this, unComponente))
            return false;
      }
      int pos = getPosComponente(unComponente);
      if (pos!=-1) {
        if (unComponente.getCantidad()>0) {
          setCantidad(unComponente.getCantidad());
          recalcularStock();
          recalcularCosto();
        }
        else {
          return false;
        }
      }
      else {
        this.componentes.add(unComponente);  
      }
      return true;
      
    } catch (Exception e) {
      return false;
    }    
    
  }

}
