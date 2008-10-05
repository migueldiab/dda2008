package servicios;

import java.util.ArrayList;

import dominio.Medida;

import uiConsola.UiArticulo;
import utils.Consola;

public class Fachada {
  public static boolean agregarArticulo(dominio.Articulo unArticulo) {
    return servicios.ServiciosArticulos.agregarArticulo(unArticulo);
  }

  public static boolean borrarArticulo(dominio.Articulo unArticulo) {
    return servicios.ServiciosArticulos.borrarArticulo(unArticulo); 
  }

  public static boolean modificarArticulo()
  {
    Consola.println("Modificar un articulo");
    return true;
  }

  public static ArrayList listadoArticulos() {
    return ServiciosArticulos.listadoArticulos();
  }

  public static boolean agregarPresupuesto()
  {
    Consola.println("Agrega un presupuesto");
    return true;
  }

  public static boolean borrarPresupuesto()
  {
    Consola.println("Borra un articulo");
    return true;
  }

  public static boolean modificarPresupuesto()
  {
    Consola.println("Modifica un Presupeusto");
    return true;
  }

  public static boolean listadoPresupuestos()
  {
    Consola.println("Lista un Presupuesto");
    return true;
  }

  public static boolean agregarUsuario()
  {
    Consola.println("Agrega un usuario");
    return true;
  }

  public static boolean borrarUsuario()
  {
    Consola.println("Borra un Usuario");
    return true;
  }

  public static boolean modificarUsuario()
  {
    Consola.println("Modifica un Usuario");
    return true;
  }

  public static boolean listadoUsuarios()
  {
    Consola.println("Lista un Usuario");
    return true;
  }

  public static boolean cerrarSesion()
  {
    Consola.println("Cierra Sesion");
    return true;
  }

  public static ArrayList listaMedidas()
  {
    // TODO Auto-generated method stub
    return null;
  }


  
}
