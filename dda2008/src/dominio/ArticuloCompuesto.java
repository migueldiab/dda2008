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
  public String tipoArticulo() {
    // TODO Auto-generated method stub
    return "Compuesto";
  }

  public ArrayList<Componente> listarComponentes() {
    return componentes;
  }


  public boolean agregarComponente(Componente unComponente) {
    this.componentes.add(unComponente);
    return true;
  }

  @Override
  public boolean eliminar(Componente unComponente) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean esHoja() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int getCantidadDeHijos() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Componente getHijo(int posicion) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getIndiceHijo(Componente unComponente) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Componente getPadre(Componente unComponente) {
    // TODO Auto-generated method stub
    return null;
  }


  

}
