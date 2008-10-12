package servicios;

import java.util.ArrayList;
import dominio.*;
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
  public static void calcularCosto(Presupuesto unPresupuesto){
		ServiciosPresupuestos.calcularCosto(unPresupuesto);
  }
  public static boolean agregarPresupuesto(Presupuesto unPresupuesto) {
    return ServiciosPresupuestos.agregar(unPresupuesto);
  }
  public static boolean agregarItemPresupuesto(Presupuesto unPresupuesto,Object unItem){
	  return ServiciosPresupuestos.agregarItem(unPresupuesto, unItem);
  }
  public static boolean borrarItemPresupuesto(Presupuesto unPresupuesto,Object unItem){
	  return ServiciosPresupuestos.borrarItem(unPresupuesto, unItem);
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
     return ServiciosUsuarios.borrar(usuario);
  }

  public static boolean modificarUsuario(Usuario original, Usuario usuario) {
    return ServiciosUsuarios.modificar(original, usuario);
  }

  public static ArrayList listadoUsuarios() {
    return ServiciosUsuarios.listado();
  }

  public static boolean cerrarSesion() {
    Consola.println("Cierra Sesion");
    return true;
  }

  public static ArrayList listaMedidas() {
    return ServiciosMedidas.listado();
  }

  public static boolean agregarMedida(Medida medida) {
    return ServiciosMedidas.agregar(medida);    
  }

  public static ArrayList listaGrupos()
  {
    return ServiciosGrupos.listado();
  }

  public static boolean agregarGrupo(Grupo grupo)
  {
    return ServiciosGrupos.agregar(grupo);
  }  
}
