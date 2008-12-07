package dominio;

import java.util.ArrayList;

public abstract class Articulo implements Cloneable, Comparable
{
  private String nombre;
  private int cantidad;
  private Medida medida;
  private double costo;
  
  public abstract boolean agregarComponente(Componente unComponente);
  public abstract ArrayList<Componente> listarComponentes();
  public abstract boolean eliminarComponente(Componente unComponente);
  public abstract boolean esHoja();
  public abstract boolean esCompuesto();
  
  public abstract String tipoArticulo();  
  /*
   * Constructores
   */
  public Articulo(String nombre, Medida unaMedida)
  {
    try {
      if (nombre == "") 
        throw new Exception("Nombre de articulo no puede ser vacío");
      if (nombre.length()<4) 
        throw new Exception("Nombre de articulo no puede tener menos de 4 caracteres");
      if (nombre == null)
        throw new Exception("Articulo debe recibir nombre como parametro");
      if (unaMedida == null) 
        throw new Exception("Articulo debe recibir Medida como parametro");
      
      this.setNombre(nombre);
      this.setMedida(unaMedida);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
  public Articulo(String nombre, Medida unaMedida, int cantidad, double costo)
  {
    this(nombre, unaMedida);
    this.setCantidad(cantidad);
    this.setCosto(costo);    
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  public boolean equals(Object arg0)
  {
    try
    {
      Articulo articulo = (Articulo)arg0;
      if (articulo.nombre.equals(this.nombre)) {
        if (articulo.medida.equals(this.medida)) {
          return true;
        }
      }
    }
    catch (RuntimeException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return false;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    // TODO Auto-generated method stub
    return this.getNombre()+" ("+this.getMedida()+")";
  }
    
  /*
   * Get's & Sets
   */
  /**
   * @return the cantidad
   */
  public int getCantidad()
  {
    return cantidad;
  }
  /**
   * @param cantidad the cantidad to set
   */
  public void setCantidad(int cantidad)
  {
    this.cantidad = cantidad;
  }
  /**
   * @return the costo
   */
  public double getCosto()
  {
    return costo;
  }
  /**
   * @param costo the costo to set
   */
  public void setCosto(double costo)
  {
    this.costo = costo;
  }
  /**
   * @return the medida
   */
  public Medida getMedida()
  {
    return medida;
  }
  /**
   * @param medida the medida to set
   */
  public void setMedida(Medida medida)
  {
    this.medida = medida;
  }
  /**
   * @return the nombre
   */
  public String getNombre()
  {
    return nombre;
  }
  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }
  
  public int compareTo(Object o) {
  	{
  	    try
  	    {
  	      Articulo articulo = (Articulo)o;
  	      int retorno= articulo.getNombre().toUpperCase().compareTo(this.getNombre().toUpperCase())*-1;
  	      if (retorno==0){
  	    	  retorno=articulo.getMedida().getDescripcion().toUpperCase().compareTo(this.getMedida().getDescripcion().toUpperCase())*-1;
  	      }
  	      return retorno;
  	    }
  	    catch (RuntimeException e)
  	    {
  	      //e.printStackTrace();
  	    }
  	    return 0;
  	  }
  }
    

  
  
	

  

}
