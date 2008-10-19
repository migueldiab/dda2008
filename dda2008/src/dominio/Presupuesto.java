package dominio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import utils.I18n;

/**
 * @author Marcos
 *
 */
public class Presupuesto implements Comparable {
  

  public static final String EN_CONSTRUCCION = "En Construccion";
  private static SimpleDateFormat sdf = new SimpleDateFormat(I18n.FORMATO_FECHA);

  
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
    this.estado=EN_CONSTRUCCION; 
  }
  public Presupuesto (String descripcion, Date fechaEjecucion, Usuario duenio, String estado, ArrayList items){
    this(descripcion, fechaEjecucion);
    this.setDuenio(duenio);
    this.setEstado(estado);
    for (int i=0; i<items.size(); i++) {
      this.agregarItem(items.get(i));
    }
  }
    
  public Presupuesto() {
	
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
    return I18n.sdf.format(this.getFechaEjecucion());
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
  public void setItems(ArrayList newItems)
  {
   this.items=newItems;
  }
  
  public boolean agregarItem(Object object){
  	return items.add(object);
  }
  public boolean borrarItem(Articulo art){
  	return items.remove(art);
  }
    
  
/*
 * Overrides
 */
  
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  

  public String toString(){
    String retorno=this.getDescripcion() + " - Id: "+this.getId() + " - Estado: "+this.getEstado();
  retorno+=" - Costo: " +this.getCosto() + " - Dueño: "+this.getDuenio()+ " - FechaEjecucion : " ;
  retorno+=this.getFechaEjecucionString() + " - Fechamodificacion: "+this.getFechaModificacionString() +"\r" +this.getItems();
  return retorno;
  }

  public String toStringIdDescFechaMod(){
	  return "Id: "+this.getId() + "- Descripcion: "+this.getDescripcion() + " - Fecha Modificacion: "+ this.getFechaModificacionString();
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
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return 0;
  }
  public class CriterioComparacionPorFechaModificacionAsc implements Comparator{

		public int compare(Object unPresupuesto1, Object unPresupuesto2) {
			Presupuesto p1=(Presupuesto)unPresupuesto1;
			Presupuesto p2=(Presupuesto)unPresupuesto2;
			return p1.getFechaModificacion().compareTo(p2.getFechaModificacion())*-1;
		}
}
}
