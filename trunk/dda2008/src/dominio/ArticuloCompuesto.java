package dominio;

import java.util.ArrayList;



public class ArticuloCompuesto  extends Articulo implements Cloneable, Comparable {

  public ArrayList<Componente> componentes = new ArrayList<Componente>();
  
  public ArticuloCompuesto(String nombre, Medida unaMedida) {
    super(nombre, unaMedida);
    // TODO Auto-generated constructor stub
  }

  public ArticuloCompuesto(String nombre, Medida unaMedida, int cantidad, double costo) {
    super(nombre, unaMedida, cantidad, costo);
  }

  

  @Override
  public boolean agregarComponente(Componente unComponente) {
    try {
      int pos = getPosComponente(unComponente);
      if (pos!=-1) {
         unComponente = componentes.get(pos);
         int cantidad = unComponente.getCantidad();
         unComponente.setCantidad(++cantidad);
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
    // TODO Auto-generated method stub
    return false;
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



  


  

}
