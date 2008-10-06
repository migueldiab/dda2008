package dominio;

public class Medida {
  private int id;
  private String codigo;
  private String descripcion;
  
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  public boolean equals(Object arg0)
  {
    // TODO Auto-generated method stub
    return super.equals(arg0);
  }
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    // TODO Auto-generated method stub
    return this.descripcion;
  }
 
 /*
  * Get's & Sets
  */
/**
 * @return the codigo
 */
public String getCodigo()
{
  return codigo;
}
/**
 * @param codigo the codigo to set
 */
public void setCodigo(String codigo)
{
  this.codigo = codigo;
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
}
