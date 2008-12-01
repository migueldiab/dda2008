package dominio;

public class Componente extends Articulo implements Cloneable, Comparable {

  private int cantidad = 0;
  
  public Componente(String nombre, Medida unaMedida) {
    super(nombre, unaMedida);
    // TODO Auto-generated constructor stub
  }

}
