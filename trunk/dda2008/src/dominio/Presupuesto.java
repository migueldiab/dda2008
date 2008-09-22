package dominio;

import java.util.ArrayList;
import java.util.Date;

public class Presupuesto {
  private int id;
  private String descripcion;
  private Date fechaEjecucion;
  private Double costo;
  private Date fechaModificacion;
  private Usuario duenio;
  private String estado;
  private ArrayList<Item> items;

  /*
   * Get's & Sets
   */
  /**
   * @return the costo
   */
  public Double getCosto()
  {
    return costo;
  }
  /**
   * @param costo the costo to set
   */
  public void setCosto(Double costo)
  {
    this.costo = costo;
  }
  /**
   * @return the descripcion
   */
  public String getDescripcion()
  {
    return descripcion;
  }
  /**
   * @param descripcion the descripcion to set
   */
  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }
  /**
   * @return the duenio
   */
  public Usuario getDuenio()
  {
    return duenio;
  }
  /**
   * @param duenio the duenio to set
   */
  public void setDuenio(Usuario duenio)
  {
    duenio = duenio;
  }
  /**
   * @return the estado
   */
  public String getEstado()
  {
    return estado;
  }
  /**
   * @param estado the estado to set
   */
  public void setEstado(String estado)
  {
    this.estado = estado;
  }
  /**
   * @return the fechaEjecucion
   */
  public Date getFechaEjecucion()
  {
    return fechaEjecucion;
  }
  /**
   * @param fechaEjecucion the fechaEjecucion to set
   */
  public void setFechaEjecucion(Date fechaEjecucion)
  {
    this.fechaEjecucion = fechaEjecucion;
  }
  /**
   * @return the fechaModificacion
   */
  public Date getFechaModificacion()
  {
    return fechaModificacion;
  }
  /**
   * @param fechaModificacion the fechaModificacion to set
   */
  public void setFechaModificacion(Date fechaModificacion)
  {
    this.fechaModificacion = fechaModificacion;
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
   * @return the items
   */
  public ArrayList getItems()
  {
    return items;
  }

  
}
