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
    // TODO Auto-generated method stub
    return null;
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



  


  

}
