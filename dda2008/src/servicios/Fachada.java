package servicios;

import java.util.ArrayList;
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
  public static boolean borrarItemPresupuesto(Presupuesto unPresupuesto,Articulo unItem){
	  return ServiciosPresupuestos.borrarItem(unPresupuesto, unItem);
  }
  
  public static boolean borrarPresupuesto(Presupuesto unPresupuesto) {
    ServiciosPresupuestos.borrar(unPresupuesto);
    return true;
  }

  public static boolean modificarPresupuesto(Presupuesto unPresupuesto,String descripcion, Date fechaEjecucion) {
    return ServiciosPresupuestos.modificarPresupuesto(unPresupuesto, descripcion, fechaEjecucion);
  }
  public static boolean modificarItemPresupuesto(Presupuesto unPresupuesto,Articulo item, int cantItem){
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


}
