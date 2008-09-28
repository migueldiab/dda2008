package dominio;

import java.util.ArrayList;

public class Grupo {
  private int id;
  private String nombre;
  private ArrayList permisos;
  
  /*
   * Get's & Sets
   */
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
  /**
   * @return the permisos
   */
  public ArrayList getPermisos()
  {
    return permisos;
  }
  /**
   * @param permisos the permisos to set
   */
  public void setPermisos(ArrayList permisos)
  {
    this.permisos = permisos;
  }
  

}
