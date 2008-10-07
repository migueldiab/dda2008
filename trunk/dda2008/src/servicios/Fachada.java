package servicios;

import java.util.ArrayList;

import dominio.Articulo;
import dominio.Medida;
import dominio.Usuario;

import uiConsola.UiArticulo;
import utils.Consola;

public class Fachada {
  public static boolean agregarArticulo(dominio.Articulo unArticulo) {
    return ServiciosArticulos.agregar(unArticulo);
  }

  public static boolean borrarArticulo(dominio.Articulo unArticulo) {
    return ServiciosArticulos.borrar(unArticulo); 
  }

  public static boolean modificarArticulo(Articulo original, Articulo nuevo) {    
    return ServiciosArticulos.modificar(original, nuevo);
  }

  public static ArrayList listadoArticulos() {
    return ServiciosArticulos.listado();
  }

  public static boolean agregarPresupuesto() {
    Consola.println("Agrega un presupuesto");
    return true;
  }

  public static boolean borrarPresupuesto() {
    Consola.println("Borra un articulo");
    return true;
  }

  public static boolean modificarPresupuesto() {
    Consola.println("Modifica un Presupeusto");
    return true;
  }

  public static boolean listadoPresupuestos() {
    Consola.println("Lista un Presupuesto");
    return true;
  }

  public static boolean agregarUsuario(Usuario unUsuario) {
    return ServiciosUsuarios.agregar(unUsuario);
    
  }

  public static boolean borrarUsuario(Usuario usuario) {
    Consola.println("Borra un Usuario");
    return true;
  }

  public static boolean modificarUsuario(Usuario original, Usuario usuario) {
    Consola.println("Modifica un Usuario");
    return true;
  }

  public static ArrayList listadoUsuarios() {
    Consola.println("Lista un Usuario");
    return null;
  }

  public static boolean cerrarSesion() {
    Consola.println("Cierra Sesion");
    return true;
  }

  public static ArrayList listaMedidas() {
    return ServiciosMedidas.listadoMedidas();
  }

  public static boolean agregarMedida(Medida medida) {
    return ServiciosMedidas.agregarMedida(medida);    
  }

  public static ArrayList listaGrupos()
  {
    // TODO Auto-generated method stub
    return null;
  }  
}
