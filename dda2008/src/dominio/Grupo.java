package dominio;

import java.util.ArrayList;

public class Grupo {
  

  public static final String ADMIN = "Admin";
  public static final String USUARIOS = "USUARIOS";
  public static final String ARTICULOS = "ARTICULOS";
  public static final String CAMBIO_DUENIO_PRESUPUESTO = "CAMBIO_DUENIO_PRESUPUESTO";
  public static final String CONSULTAS = "CONSULTAS";
  public static final String PRESUPUESTOS = "PRESUPUESTOS";
  public static final String MEDIDAS = "MEDIDAS";
  private String nombre;
  private ArrayList<String> permisos = new ArrayList<String>();
  
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  public boolean equals(Object arg0)
  {
    try
    {
      Grupo grupo = (Grupo)arg0;
      if (grupo.getNombre().equals(this.getNombre())) {
        return true;
      }
    }
    catch (RuntimeException e)
    {
      // Probablemente es nulo
    }
    return false;

  }
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    return this.getNombre();
  }
  public Grupo(String nombre)
  {
    this.setNombre(nombre);
  }
  public Grupo(String nombre, ArrayList<String> permisos)
  {
    this.setNombre(nombre);
    this.setPermisos(permisos);
  }
  /*
   * Get's & Sets
   */
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
  public void setPermisos(ArrayList<String> permisos)
  {
    this.permisos = permisos;
  }
  public boolean agregarPermiso(String permiso) {
    permisos.add(permiso);
    return true;
  }
  public boolean tienePermiso(String permiso)
  {
    // if (permisos != null)
      return permisos.contains(permiso);
    /*
      else
      return false;
    */
  }

}
