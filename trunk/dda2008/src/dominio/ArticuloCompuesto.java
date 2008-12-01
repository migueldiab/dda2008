package dominio;

import java.util.ArrayList;

public class ArticuloCompuesto  extends Articulo implements Cloneable, Comparable {

  public ArrayList<Componente> componentes = new ArrayList<Componente>();
  
  public ArticuloCompuesto(String nombre, Medida unaMedida) {
    super(nombre, unaMedida);
    // TODO Auto-generated constructor stub
  }


  

}
