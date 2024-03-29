package dominio;

import java.util.ArrayList;
import java.util.Date;

import servicios.ServiciosUsuarios;
import utils.I18n;

/**
 * @author Marcos
 *
 */
public class Presupuesto implements Comparable {
  

  public static final String EN_CONSTRUCCION = "En Construccion";
  public static final String FINALIZADO = "Finalizado";
  
  private int id;
  private String descripcion;
  private Date fechaEjecucion;
  private double costo;
  private Date fechaModificacion;
  private Usuario duenio;
  private String estado;
  private ArrayList<Item> items=new ArrayList<Item>();
  private static int ultimoId;

/*
 *  Contructores
 */
  
  public Presupuesto (String descripcion, Date fechaEjecucion){
	  Date now=new Date();
	  this.descripcion=descripcion;
	  this.fechaEjecucion=fechaEjecucion;
	  this.id=nuevoId();
	  this.estado=EN_CONSTRUCCION; 
	  this.setFechaModificacion(now);
	  this.setDuenio(ServiciosUsuarios.getUsuarioActual());
  }
  public Presupuesto (String descripcion, Date fechaEjecucion, Usuario duenio, String estado, ArrayList items){
	  this(descripcion, fechaEjecucion);
	  this.setDuenio(duenio);
	  this.setEstado(estado);
	  if(items!=null){
		  for (int i=0; i<items.size(); i++) {
			  this.agregarItem(items.get(i));
		  }  
	  }
	  
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
  public String getFechaEjecucionString()
  {
	  try{
		  return I18n.sdf.format(this.getFechaEjecucion());
	  }
      catch (RuntimeException e){
    	  return "empty";
      }
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
  public String getFechaModificacionString()
  {
    return I18n.sdf.format(this.getFechaModificacion());
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
  public void setItems(ArrayList<Item> newItems)
  {
   this.items=newItems;
  }
  
  public boolean agregarItem(Object object){
	  if(!items.contains(object)){
	    return items.add((Item) object);
	  }
	  return false;
  }
  public boolean borrarItem(Item item){
  	return items.remove(item);
  }
    
  
/*
 * Overrides
 */
  
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  

  public String toString(){
    String retorno="Id: "+this.getId()+ " " + this.getDescripcion() +" - Fecha de modificacion: "+this.getFechaModificacionString();
  return retorno;
  }

  public boolean equals(Object arg0)
  {
    try
    {
      Presupuesto presupuesto = (Presupuesto)arg0;
      if (presupuesto.getDescripcion().equals(this.getDescripcion())) {
        if (presupuesto.getDuenio().equals(this.getDuenio())) {
          return true;
        }
      }
    }
    catch (RuntimeException e)
    {
      e.printStackTrace();
    }
    return false;
  }
  public int compareTo(Object arg0)
  {
    try
    {
      Presupuesto presupuesto = (Presupuesto)arg0;
      return presupuesto.getFechaModificacion().compareTo(this.getFechaModificacion());      
    }
    catch (RuntimeException e)
    {
      e.printStackTrace();
    }
    return 0;
  }

 
}