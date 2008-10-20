package dominio;

import java.util.ArrayList;

public class Grupo {
  

  public static final String ADMIN = "Admin";
//  public static final String ALTA_USUARIO = "ALTA_USUARIO";
//  public static final String BAJA_USUARIO = "BAJA_USUARIO";
//  public static final String MODI_USUARIO = "MODI_USUARIO";
//  public static final String LIST_USUARIO = "LIST_USUARIO";
  public static final String USUARIOS = "USUARIOS";
  public static final String ARTICULOS = "ARTICULOS";
  public static final String CAMBIO_DUENIO_PRESUPUESTO = "CAMBIO_DUENIO_PRESUPUESTO";
  public static final String CONSULTAS = "CONSULTAS";
  public static final String PRESUPUESTOS = "PRESUPUESTOS";
  private String nombre;
  private ArrayList permisos = new ArrayList();
  
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  public boolean equals(Object arg0)
  {
    // TODO Auto-generated method stub
    try
    {
      Grupo grupo = (Grupo)arg0;
      if (grupo.getNombre().equals(this.getNombre())) {
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
  public String toString()
  {
    // TODO Auto-generated method stub
    return this.getNombre();
  }
  public Grupo(String nombre)
  {
    // TODO Auto-generated constructor stub
    this.setNombre(nombre);
  }
  public Grupo(String nombre, ArrayList permisos)
  {
    // TODO Auto-generated constructor stub
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
  public void setPermisos(ArrayList permisos)
  {
    this.permisos = permisos;
  }
  public boolean agregarPermiso(String permiso) {
    permisos.add(permiso);
    return true;
  }
  public boolean tienePermiso(String permiso)
  {
    // TODO Auto-generated method stub
    // if (permisos != null)
      return permisos.contains(permiso);
    /*
      else
      return false;
    */
  }

}
