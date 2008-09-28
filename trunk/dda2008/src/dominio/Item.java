package dominio;

public class Item {
  private int id;
  private String nombre;
  private int cantidad;
  private Medida medida;
  private double costo;
  
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
  
  public Item(String nombre, int cantidad, double costo, Medida medida){
    setNombre(nombre);
    setCantidad(cantidad);
    setCosto(costo);
    setMedida(medida);
  }
  
  
  
}
