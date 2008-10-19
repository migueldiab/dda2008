package dominio;

public class Articulo implements Cloneable
{
  private int id;
  private String nombre;
  private int cantidad;
  private Medida medida;
  private double costo;
  
  /*
   * Constructores
   */
  public Articulo(String nombre, Medida unaMedida)
  {
    try {
      if (nombre == "") 
        throw new Exception("Nombre de articulo no puede ser vac�o");
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
    // TODO Auto-generated method stub
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
    return " Articulo: "+this.getNombre()+"- Medida: "+this.getMedida()+"- Cantidad: "+this.cantidad+"- Costo: "+this.costo +"\r";
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
   * @return the id
   */
  public int getId()
  {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(int id)
  {
    this.id = id;
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
  public Object clone(){
	  Object o=null;
	  try{
		  o=super.clone();
	  }catch(CloneNotSupportedException e){
			  System.err.println("No puede Clonar Articulo");
	  }
	  

	  return o;
	  
  }
  
}