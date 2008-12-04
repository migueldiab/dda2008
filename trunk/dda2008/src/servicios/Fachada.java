package servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dominio.*;

public class Fachada {
	public static Usuario getUsuarioActual(){
	  return ServiciosUsuarios.getUsuarioActual();  
  }
  public static boolean agregarArticulo(dominio.Articulo unArticulo) {
    return ServiciosArticulos.agregar(unArticulo);
  }

  public static boolean borrarArticulo(dominio.Articulo unArticulo) {
    return ServiciosArticulos.borrar(unArticulo); 
  }

  public static boolean modificarArticulo(Articulo original,String nombre,Medida medida,int cantidad,double costo) {    
    return ServiciosArticulos.modificar(original, nombre, medida, cantidad, costo);
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
  public static boolean agregarItemPresupuesto(Presupuesto unPresupuesto,Object unArticulo, int cant){
	  return ServiciosPresupuestos.agregarItem(unPresupuesto, unArticulo,cant);
  }
  public static boolean borrarItemPresupuesto(Presupuesto unPresupuesto,Item unItem){
	  return ServiciosPresupuestos.borrarItem(unPresupuesto, unItem);
  }
  
  public static boolean borrarPresupuesto(Presupuesto unPresupuesto) {
    ServiciosPresupuestos.borrar(unPresupuesto);
    return true;
  }

  public static boolean modificarPresupuesto(Presupuesto unPresupuesto,String descripcion, Date fechaEjecucion) {
    return ServiciosPresupuestos.modificarPresupuesto(unPresupuesto, descripcion, fechaEjecucion);
  }
  public static boolean modificarItemPresupuesto(Presupuesto unPresupuesto,Item item, int cantItem){
	  return ServiciosPresupuestos.modificarItemPresupuesto(unPresupuesto,item, cantItem);
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

  

  public static boolean login(String id, String clave)
  {
    return ServiciosUsuarios.login(id, clave);
  }

  public static ArrayList obtenerPresupuestoPorArticuloEstadoConFecha(Articulo unArticulo, String unEstado)
  {
    return ServiciosPresupuestos.obtenerPresupuestoPorArticuloEstadoConFecha(unArticulo, unEstado);
  }
  public static ArrayList obtenerPresupuestos(Usuario unUsuario,int Criterio0Asc1Desc,int Criterio0XFechaMod1XFechaEje,int Criterio0EnConstr1Todos){
  	return ServiciosPresupuestos.obtenerPresupuestos(unUsuario, Criterio0Asc1Desc, Criterio0XFechaMod1XFechaEje, Criterio0EnConstr1Todos);
  }
    
  public static ArrayList obtenerItems(Presupuesto unPresupuesto){
  	return ServiciosPresupuestos.obtenerItems(unPresupuesto);
  }
  
  public static boolean finalizarPresupuesto(Presupuesto unPresupuesto) {
  	return ServiciosPresupuestos.finalizarPresupuestos(unPresupuesto);
  }
  
  public static boolean validoCantidadesFinalizacion(Presupuesto unPresupuesto){
  	return ServiciosPresupuestos.validoCantidadesFinalizacion(unPresupuesto);
  }
  
  public static Presupuesto copiarPresupuesto(Presupuesto unPresupuesto,String descripcion) {
  	return ServiciosPresupuestos.copiarPresupuesto(unPresupuesto,descripcion);
  }
  
  
  public static ArrayList listadoGestores() {
  	return ServiciosUsuarios.listadoGestores();
  }
  public static ArrayList listadoGestoresPorApellido() {
  	return ServiciosUsuarios.listadoGestoresPorApellido();
  }
  
  
  public static ArrayList listadoGestoresPorNombreUsuario() {
  	return ServiciosUsuarios.listadoGestoresPorNombreUsuario();
  }
  
  
  public static boolean cambiarDuenio(Presupuesto unPresupuesto, Usuario nuevoDuenio) {
  return ServiciosPresupuestos.cambiarDuenio(unPresupuesto,nuevoDuenio);
  	
  }
  
  
  public static ArrayList obtenerArticulosNotIn(Presupuesto unPresupuesto) {
  	return ServiciosArticulos.obtenerArticulosNotIn(unPresupuesto);
  }
  
  
  public static boolean validoPresupuesto(String descripcion,Usuario usuarioActual) {
  	return ServiciosPresupuestos.validoPresupuesto(descripcion,usuarioActual);
  }
  
  
  public static boolean validoFechaEjecucion(Presupuesto unPresupuesto) {
  	return ServiciosPresupuestos.validoFechaEjecucion(unPresupuesto);
  }
  
  
  public static boolean vistaLogin(String id, char[] password) {
    return ServiciosUsuarios.vistaLogin(id, password);
    }
  
  
  public static Usuario obtenerUsuario(Usuario u) {
    return (Usuario) ServiciosUsuarios.obtener(u);
  }
  
  
  public static Articulo obtenerArticulo(Articulo a) {
    return (Articulo) ServiciosArticulos.obtener(a);
  }
  
  
  public static ArrayList listadoArticulosCompuestos() {
    return ServiciosArticulosCompuestos.listado();
  }
  
  
  public static ArticuloCompuesto obtenerArticuloCompuesto(ArticuloCompuesto unArticuloCompuesto) {
    return (ArticuloCompuesto) ServiciosArticulosCompuestos.obtener(unArticuloCompuesto);
  }
  
  
  public static boolean agregarArticuloCompuesto(ArticuloCompuesto unArticuloCompuesto) {
    return ServiciosArticulosCompuestos.agregar(unArticuloCompuesto);
  }
  
  public static boolean borrarArticuloCompuesto(ArticuloCompuesto u) {
    return ServiciosArticulosCompuestos.borrar(u);
  }
public static ArrayList<Object[]> getArticulosStockInsuficiente(Calendar cal) {
	return ServiciosArticulos.getArticulosStockInsuficiente(cal);
}
//public static void guardarItemsPresupuesto(ArrayList obtenerItems,
	//	ArrayList items,Presupuesto presupuesto) {
	//ServiciosPresupuestos.guardarItemsPresupuesto(obtenerItems,items,presupuesto);
	
//}


}
