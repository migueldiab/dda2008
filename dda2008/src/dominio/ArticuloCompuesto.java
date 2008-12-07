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
    this.componentes.add(unComponente);
    return true;
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



  


  

}
