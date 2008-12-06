package dominio;

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
  public String tipoArticulo() {
    // TODO Auto-generated method stub
    return "Simple";
  }
  @Override
  public boolean agregarComponente(Componente unComponente) {
    return false;
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
