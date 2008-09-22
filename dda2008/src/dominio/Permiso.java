package dominio;

public class Permiso
{
  private int id;
  private String nombre;
  private boolean acceso;
  /*
   * Get's & Sets
   */
  /**
   * @return the acceso
   */
  public boolean isAcceso()
  {
    return acceso;
  }
  /**
   * @param acceso the acceso to set
   */
  public void setAcceso(boolean acceso)
  {
    this.acceso = acceso;
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
}
