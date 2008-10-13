package servicios;

import java.util.ArrayList;
import java.util.Date;

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

  public static boolean modificarPresupuesto(Presupuesto unPresupuesto,String descripcion, Date fechaEjecucion) {
    Consola.println("Modifica un Presupuesto");
    return true;
  }
  public static boolean modificarItemPresupuesto(Presupuesto unPresupuesto,int cantItem){
	  return ServiciosPresupuestos.modificarItemPresupuesto(unPresupuesto, cantItem);
  }

  public static ArrayList listadoPresupuestos() {
    return ServiciosPresupuestos.listado();
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
    return ServiciosUsuarios.logout();
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

  public static void unlistado()
  {
    // TODO Auto-generated method stub
    
  }

  public static boolean login(String id, String clave)
  {
    return ServiciosUsuarios.login(id, clave);
  }

  public static ArrayList obtenerPresupuestoPorArticulo(Articulo unArticulo)
  {
    return ServiciosPresupuestos.obtenerPresupuestoPorArticulo(unArticulo);
  }

  public static ArrayList obtenerPresupuestoPorArticuloEstadoConFecha(Articulo unArticulo, String unEstado)
  {
    return ServiciosPresupuestos.obtenerPresupuestoPorArticuloEstadoConFecha(unArticulo, unEstado);
  }

  public static ArrayList obtenerPresupuestoPorUsuarioOrdenadoFecha(Usuario unUsuario)
  {
    return ServiciosPresupuestos.obtenerPresupuestoPorUsuarioOrdenadoFecha(unUsuario);
  }  
}
