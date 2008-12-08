package dominio;

import java.util.ArrayList;

import servicios.ServiciosArticulos;

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
  public Componente getHijo(int posicion) {
    ArrayList componentes = articulo.listarComponentes();
    if (componentes==null) {
      return null;
    }
    else {
      return (Componente) componentes.get(posicion);
    }
  }
  public int getCantidadDeHijos() {
    return articulo.listarComponentes().size(); 
  }
  public int getIndiceHijo(Componente unComponente) {
    ArrayList componentes = articulo.listarComponentes();
    if (componentes==null) {
      return -1;
    }
    else {
      return componentes.indexOf(unComponente);
    }
    
  }
  public static Articulo getPadre(Componente unComponente) {
    for (Articulo articulo : ServiciosArticulos.listadoCompuestos()) {
      if (articulo.esCompuesto()) {
        for (Componente componente : articulo.listarComponentes()) {
          if (componente == unComponente) {
            return articulo;
          }
        }
      }      
    }
    return null; 
  }

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
