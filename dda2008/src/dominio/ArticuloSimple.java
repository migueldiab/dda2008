package dominio;

import java.util.ArrayList;

public class ArticuloSimple extends Articulo {

  public ArticuloSimple(String nombre, Medida unaMedida) {
    super(nombre, unaMedida);
    // TODO Auto-generated constructor stub
  }
  public ArticuloSimple(String nombre, Medida unaMedida, int cantidad, double costo) {
    super(nombre, unaMedida, cantidad, costo);
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public boolean agregarComponente(Componente unComponente) {
    return false;
  }
  @Override
  public String tipoArticulo() {
    return "Simple";
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
    return true;
  }
  @Override
  public boolean esCompuesto() {
    return false;
  }
@Override
public Articulo getPadre(Componente hijo) {
	return null;
}

  

}
