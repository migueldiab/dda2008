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
    try
    {
      Articulo articulo = (Articulo) ((Componente) arg0).getComponente();
      if (articulo.getNombre().equals(this.componente.getNombre())) {
        if (articulo.getMedida().equals(this.componente.getMedida())) {
          return true;
        }
      }
    }
    catch (RuntimeException e)
    {

    }
    return false;
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
