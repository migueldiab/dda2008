package dominio;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Marcos
 *
 */
public class Presupuesto {
  private int id;
  private String descripcion;
  private Date fechaEjecucion;
  private double costo;
  private Date fechaModificacion;
  private Usuario duenio;
  private String estado;
  private ArrayList items=new ArrayList();
  private static int ultimoId;

/*
 *  Contructores
 */
  
  public Presupuesto (String descripcion, Date fechaEjecucion){
	  this.descripcion=descripcion;
	  this.fechaEjecucion=fechaEjecucion;
	  this.id=nuevoId();
	  this.estado="En Construccion";
	  
  }
    
  /*
   * Get's & Sets
   */
  /**
   * @return the costo
   */
  public double getCosto()
  {
    return costo;
  }
  /**
   * @param costo2 the costo to set
   */
  public void setCosto(double costo2)
  {
    this.costo = costo2;
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
    this.duenio = duenio;
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
  public static int nuevoId(){
	  return ++ultimoId;
	  	  
  }
  
  /**
   * @return the items
   */
  public ArrayList getItems()
  {
    return items;
  }
public boolean agregarItem(Object object){
	return items.add(object);
}
public boolean borrarItem(Articulo art){
	return items.remove(art);
}
  
  
  
}
