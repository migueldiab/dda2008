package dominio;

public class Componente {

  private Articulo componente = null;
  private int cantidad = 0;
  
  public Componente(Articulo unArticulo, int cantidad) {
    setComponente(unArticulo);
    setCantidad(cantidad);
  }
  public Componente(Articulo unArticulo) {
    setComponente(unArticulo);
    setCantidad(1);
  }
  
  public boolean esHoja() {
    return componente.esHoja();
  }
  public Componente getHijo(int posicion) { return null; }
  public int getCantidadDeHijos() { return 0; }
  public int getIndiceHijo(Componente unComponente) { return -1; }
  public Componente getPadre(Componente unComponente) { return null; }

  @Override
  public boolean equals(Object arg0) {
    // TODO Auto-generated method stub
    return super.equals(arg0);
  }
  @Override
  public String toString() {
    return componente.toString() + "(" + cantidad + ")";
  }
  public int getCantidad() {
    return cantidad;
  }
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
  public Articulo getComponente() {
    return componente;
  }
  public void setComponente(Articulo componente) {
    this.componente = componente;
  }  

}
