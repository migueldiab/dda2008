package dominio;

public class Usuario {
  private String id;
  private String nombre;
  private String apellido;
  private String clave;
  private Grupo grupo;
  

  public Usuario() {

  }
  public Usuario(String id) {
    this.setId(id);
    this.setId(this.getId());
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
    return super.equals(arg0);
  }
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
  }

}