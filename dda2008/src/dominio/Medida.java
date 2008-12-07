package dominio;

public class Medida
{
  private String codigo;
  private String descripcion;
  
  /*
   * Constructores
   */
  public Medida(String codigo, String descripcion)
  {
    try {
      if (codigo == "") 
        throw new Exception("Codigo de medida no puede ser vacío");
      if (codigo == null)
        throw new Exception("Medida debe recibir codigo como parametro");
      if (descripcion == "") 
        throw new Exception("Descripcion de medida no puede ser vacío");
      if (descripcion == null)
        throw new Exception("Medida debe recibir descripcion como parametro");
      
      this.setCodigo(codigo);
      this.setDescripcion(descripcion);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
  
  /*
   * Overrides
   */
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  public boolean equals(Object arg0)
  {
    try
    {
      Medida medida = (Medida)arg0;
      if (!medida.codigo.equals(this.codigo)) {
        return false;
      }
      if (!medida.descripcion.equals(this.descripcion)) {
        return false;
      }
    }
    catch (RuntimeException e)
    {
      return false;
    }
    return true;
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
}
