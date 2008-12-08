package dominio;

public class Componente {

  private Articulo articulo = null;
  private int cantidad = 0;
  
  public Componente(Articulo unArticulo, int cantidad) {
    setArticulo(unArticulo);
    setCantidad(cantidad);
  }
  public Componente(Articulo unArticulo) {
    setArticulo(unArticulo);
    setCantidad(1);
  }
  
  public boolean esHoja() {
    return articulo.esHoja();
  }
  public static Componente getHijo(int posicion) { return null; }
  public static int getCantidadDeHijos() { return 0; }
  public int getIndiceHijo(Componente unComponente) { return -1; }
  public static Componente getPadre(Componente unComponente) { return null; }

  @Override
  public boolean equals(Object arg0) {
    try
    {
      Articulo articulo = (Articulo) ((Componente) arg0).getArticulo();
      if (articulo.getNombre().equals(this.articulo.getNombre())) {
        if (articulo.getMedida().equals(this.articulo.getMedida())) {
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
    return cantidad + " - " + articulo.toString();
  }
  public int getCantidad() {
    return cantidad;
  }
  public void setCantidad(int cantidad) {
    if (cantidad>0)
      this.cantidad = cantidad;
  }
  public Articulo getArticulo() {
    return articulo;
  }
  public void setArticulo(Articulo componente) {
    this.articulo = componente;
  }  

	
	
}
