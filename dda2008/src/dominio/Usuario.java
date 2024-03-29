package dominio;

public class Usuario implements Comparable { 
  private String id;
  private String nombre;
  private String apellido;
  private String clave;
  private Grupo grupo;
  

  public Usuario(String id, String clave, Grupo grupo) {
    this(id);
    this.setClave(clave);
    this.setGrupo(grupo);
  }
  public Usuario(String id, String clave, Grupo grupo, String nombre, String apellido) {
    this(id, clave, grupo);
    this.setApellido(apellido);
    this.setNombre(nombre);
  }

  public Usuario(String id)
  {
    // TODO Auto-generated constructor stub
    this.setId(id);
  }
  /*
   * Get's & Sets
   */
  /**
   * @return the apellido
   */
  public String getApellido() {
    return apellido;
  }
  /**
   * @param apellido the apellido to set
   */
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  /**
   * @return the clave
   */
  public String getClave() {
    return clave;
  }
  /**
   * @param clave the clave to set
   */
  public void setClave(String clave) {
    this.clave = clave;
  }
  /**
   * @return the grupo
   */
  public Grupo getGrupo() {
    return grupo;
  }
  /**
   * @param grupo the grupo to set
   */
  public void setGrupo(Grupo grupo) {
    this.grupo = grupo;
  }
  /**
   * @return the id
   */
  public String getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }
  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }
  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /*
   * Overrides
   */
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  public boolean equals(Object arg0) {
    // TODO Auto-generated method stub
    try
    {
      Usuario usuario = (Usuario)arg0;
      if (usuario.id.equals(this.id)) {
        return true;
      }
    }
    catch (RuntimeException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return false;
  }
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString() {
    // TODO Auto-generated method stub
    return this.getId() + "(" + this.getGrupo().toString() + ")";
  }
public int compareTo(Object o) {
	try
    {
      Usuario usuario = (Usuario)o;
      int retorno=usuario.getApellido().toUpperCase().compareTo(this.getApellido().toUpperCase())*-1;
      if (retorno==0){
    	  retorno=usuario.getNombre().toUpperCase().compareTo(this.getNombre().toUpperCase())*-1;
      }
      return retorno;
    }
    catch (RuntimeException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return 0;
}

	public int compare(Object unUsuario1, Object unUsuario2) {
		Usuario u1=(Usuario)unUsuario1;
		Usuario u2=(Usuario)unUsuario2;
		return u1.getId().toUpperCase().compareTo(u2.getId().toUpperCase());
	}
}




