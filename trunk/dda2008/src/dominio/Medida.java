package dominio;

public class Medida {
 private int id;
 private String codigo;
 private String descripcion;
 
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
