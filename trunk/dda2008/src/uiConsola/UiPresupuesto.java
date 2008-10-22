package uiConsola;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dominio.Articulo;
import dominio.Item;
import dominio.Presupuesto;
import dominio.Usuario;

import servicios.Fachada;
import utils.Consola;
import utils.I18n;

public class UiPresupuesto
{

	public static void agregarPresupuesto()
	{
		String descripcion ="";
		Calendar cal=null;

		descripcion=Consola.leer(I18n.DESCRIPCION +" : ");
		I18n.setFormato("dd/MM/yyyy");
		String confirma=Consola.leer(I18n.DESEA_FECHA_EJECUCION);
		Date fechaEjecucion=null;
		if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
			cal=Consola.leerFecha(I18n.FECHAEJECUCION);
			if (!(cal==null)){
				fechaEjecucion=cal.getTime();
			}
		}
		if(Fachada.validoPresupuesto(descripcion,Fachada.getUsuarioActual())){
			Presupuesto unPresupuesto=new Presupuesto(descripcion,fechaEjecucion);
			Fachada.agregarPresupuesto(unPresupuesto);
			agregarItems(unPresupuesto);  
		}
		else{
			Consola.println(I18n.PRESUPUESTO_YA_EXSTE);
			Consola.leer(I18n.PRESIONE_ENTER);
		}


	}
	public static void agregarItems(Presupuesto unPresupuesto){
		int cant=0;
		Object articulo=null;
		do{
			articulo=Consola.menu(Fachada.obtenerArticulosNotIn(unPresupuesto),I18n.SELECCIONE_ARTICULO,1);
			if(articulo!=null){
				Consola.println(((Articulo)articulo).toString());
				cant=Consola.leerInt("|  "+I18n.SELECCIONE_CANTIDAD+" : ");
				if (cant<=((Articulo)articulo).getCantidad()&& cant>0){
					Fachada.agregarItemPresupuesto(unPresupuesto, articulo,cant);
				}else{
					Consola.println("|  "+I18n.CANTIDAD_MAL+" ");
					break;
				}
				Fachada.calcularCosto(unPresupuesto);
				for(int x=0;x<unPresupuesto.getItems().size();x++){
					Consola.println(((Item) unPresupuesto.getItems().get(x)).toString());
				}
				Consola.println("Costo Total: "+unPresupuesto.getCosto());

			} 
		}while (articulo!=null);
	}
  
	private static void borrarItems(Presupuesto unPresupuesto) {
		ArrayList items=Fachada.obtenerItems(unPresupuesto);
		if (items.isEmpty()) {
			Consola.println(I18n.LISTA_VACIA);
			Consola.leer(I18n.PRESIONE_ENTER);
		}
		else {
			int posItem = Consola.menu(items, I18n.SELECCIONE_ITEM_BORRAR);
			if(posItem>=0){
				Item unItem=(Item) items.get(posItem);
				String confirma=Consola.leer(I18n.CONFIRMA_ELIMINAR);
				if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
					Fachada.borrarItemPresupuesto(unPresupuesto, unItem);
				}
				else{
					Consola.println(I18n.CANCELADA);
					Consola.leer(I18n.PRESIONE_ENTER); 
				}

			}else{
				Consola.println(I18n.CANCELADA);
				Consola.leer(I18n.PRESIONE_ENTER); 
			}
		}

	}
  public static void borrarPresupuesto()
  {
	  ArrayList presupuestos =Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(), 0, 0, 1);
	  if (presupuestos.isEmpty()) {
		  Consola.println(I18n.LISTA_VACIA);
		  Consola.leer(I18n.PRESIONE_ENTER);
	  }
	  else {

		  Presupuesto unPresupuesto = (Presupuesto) Consola.menu(presupuestos,I18n.BAJA,3);
		  if(unPresupuesto!=null){
			  Consola.println(unPresupuesto.toString());
			  String confirma=Consola.leer(I18n.CONFIRMA_ELIMINAR);
			  if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
				  if(Fachada.borrarPresupuesto(unPresupuesto)){
					  Consola.println(I18n.BORRADO_OK);
					  Consola.leer(I18n.PRESIONE_ENTER);
				  }else{
					  Consola.println(I18n.ERROR); 
					  Consola.leer(I18n.PRESIONE_ENTER);
				  }
			  }else{
				  Consola.println(I18n.CANCELADA);
				  Consola.leer(I18n.PRESIONE_ENTER); 
			  }
		  }else{
			  Consola.println(I18n.CANCELADA);
			  Consola.leer(I18n.PRESIONE_ENTER);
		  }
	  }
  }

  public static void modificarPresupuesto()
  {
	  ArrayList presupuestos =Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(), 1, 0, 0);
	  if (presupuestos.isEmpty()) {
		  Consola.println(I18n.LISTA_VACIA);
		  Consola.leer(I18n.PRESIONE_ENTER);
	  }
	  else {
		  Presupuesto original = (Presupuesto) Consola.menu(presupuestos,I18n.MODIFICACIONES,3);
		  if(original!=null){
			  Consola.println(original.toString());
			  UiPresupuesto.MenuModificacionPresupuestos(original);
		  }
	  }
  } 
    	 
  public static void modificarInformacionPresupuesto(Presupuesto original){
	  String descripcion = "";
	  Date fechaEjecucion = null;
	  Consola.println(original.toString());
	  descripcion = Consola.modificar(I18n.DESCRIPCION, original.getDescripcion());
	  fechaEjecucion = Consola.modificarFecha(I18n.FECHAEJECUCION, original.getFechaEjecucion());
	  String confirma = Consola.leer(I18n.CONFIRMA_MODIFICAR);
	  if (confirma.toUpperCase().equals(I18n.SI.toUpperCase()))
	  {
		  if (Fachada.modificarPresupuesto(original,descripcion,fechaEjecucion)){
			  Consola.println(I18n.MODIFICADO_OK); 
		  }
	  }
  }

  
  public static void MenuModificacionPresupuestos(Presupuesto unPresupuesto){
	  boolean menu_anterior = false;   

	  do {
		  ArrayList items = new ArrayList();
		  items.add(I18n.ITEM_ALTA);
		  items.add(I18n.ITEM_BAJA);
		  items.add(I18n.ITEM_MODIFICA);
		  items.add(I18n.PRESUPUESTO_MODIFICA);
		  items.add(I18n.MENU_ANTERIOR);
		  String opcion = (String) items.get(Consola.menu(items, I18n.MODIFICACIONES));
		  if (opcion.equals(I18n.ITEM_ALTA)) agregarItems(unPresupuesto);
		  if (opcion.equals(I18n.ITEM_BAJA)) borrarItems(unPresupuesto);
		  if (opcion.equals(I18n.ITEM_MODIFICA)) modificarItems(unPresupuesto);
		  if (opcion.equals(I18n.PRESUPUESTO_MODIFICA)) modificarInformacionPresupuesto(unPresupuesto);
		  if (opcion.equals(I18n.MENU_ANTERIOR)) menu_anterior = true;
	  } while (!menu_anterior);
  }

  
 
  public static void modificarItems(Presupuesto unPresupuesto){

	  Item item=null;
	  int cantItem=0;
	  ArrayList items = unPresupuesto.getItems();
	  if(items.isEmpty()){
		  Consola.println(I18n.LISTA_VACIA);
		  Consola.leer(I18n.PRESIONE_ENTER);
	  }
	  else{
		  item = (Item) Consola.menu(items, I18n.MODIFICA_ITEMS,2);
		  if(item!=null){
			  cantItem=Consola.modificarInt(I18n.CANTIDAD, item.getCantidadItem());
			  if (cantItem<=((Articulo)item.getElArticulo()).getCantidad()&& cantItem>0){
				  String confirma = Consola.leer(I18n.MODIFICA_ITEMS);
				  if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
					  Fachada.modificarItemPresupuesto(unPresupuesto,item,cantItem);
				  }else{
					  Consola.println(I18n.CANCELADA);
					  Consola.leer(I18n.PRESIONE_ENTER); 
				  }
			  }else{
				  Consola.println("|  "+I18n.CANTIDAD_MAL+" ");
				  Consola.leer(I18n.PRESIONE_ENTER);
			  }
		  }
		  else{
			  Consola.println(I18n.CANCELADA);
			  Consola.leer(I18n.PRESIONE_ENTER); 
		  }
	  }
  }
	
  public static void listadoPresupuestos()
  {

	  ArrayList presupuestos = Fachada.listadoPresupuestos();;
	  if (presupuestos.isEmpty()) {
		  Consola.println(I18n.LISTA_VACIA);
		  Consola.leer(I18n.PRESIONE_ENTER);
	  }
	  else {
		  Consola.listado(presupuestos);
		  Consola.leer(I18n.PRESIONE_ENTER);
	  }   
  }
  public static void cambiarDuenio() {

	  ArrayList gestores=Fachada.listadoGestoresPorApellido();
	  if (gestores.isEmpty()) {
		  Consola.println(I18n.LISTA_VACIA);
		  Consola.leer(I18n.PRESIONE_ENTER);
	  }else {
		  int posGestor=Consola.menu(gestores,I18n.SELECCIONE_GESTOR);
		  if(posGestor>=0){
			  Usuario unGestor=(Usuario) gestores.get(posGestor);
			  ArrayList presupuestosGestor=Fachada.obtenerPresupuestos(unGestor, 0, 0, 0);
			  if(presupuestosGestor.isEmpty()){
				  Consola.println(I18n.LISTA_VACIA);
				  Consola.leer(I18n.PRESIONE_ENTER);
			  }else {
				  Presupuesto unPresupuesto=(Presupuesto) Consola.menu(presupuestosGestor,I18n.CAMBIAR_DUENIO,3);
				  ArrayList gestoresXNombre=Fachada.listadoGestoresPorNombreUsuario();
				  int posNuevoDuenio = Consola.menu(gestoresXNombre, I18n.SELECCIONE_NUEVO_DUENIO);
				  if(posNuevoDuenio>=0){
					  Usuario nuevoDuenio=(Usuario) gestoresXNombre.get(posNuevoDuenio);
					  if(Fachada.cambiarDuenio(unPresupuesto,nuevoDuenio)){
						  Consola.println(I18n.MODIFICADO_OK);
						  Consola.println(I18n.PRESIONE_ENTER);
					  }
				  }else{
					  Consola.println(I18n.CANCELADA);
					  Consola.leer(I18n.PRESIONE_ENTER);
				  }
			  }
		  }else{
			  Consola.println(I18n.CANCELADA);
			  Consola.leer(I18n.PRESIONE_ENTER);
		  }
	  }  
  }

  public static void finalizarPresupuesto() {
	  ArrayList losPresupuestos=Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(), 1, 0, 0);
	  if (losPresupuestos.isEmpty()) {
		  Consola.println(I18n.LISTA_VACIA);
	  }
	  else {
		  Presupuesto unPresupuesto= (Presupuesto) Consola.menu(losPresupuestos,I18n.FINALIZAR_PRESUPUESTO,3);
		  if(unPresupuesto!=null){	
			  Consola.println(unPresupuesto.toString());
			  String confirma=Consola.leer(I18n.CONFIRMA_FINALIZACION);
			  if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
				  if(Fachada.validoCantidadesFinalizacion(unPresupuesto)){
					  if(Fachada.validoFechaEjecucion(unPresupuesto)){
						  Fachada.finalizarPresupuesto(unPresupuesto);
						  Consola.println(I18n.FINALIZADO_OK);
						  Consola.leer(I18n.PRESIONE_ENTER);
					  }else{
					  Consola.println(I18n.FECHAEJECUCION_MAL);
					  Consola.leer(I18n.PRESIONE_ENTER);
					  }
				  }else{
					  Consola.println(I18n.ARTICULOS_SIN_STOCK);
					  Consola.leer(I18n.PRESIONE_ENTER);
				  }
			  }else{
				  Consola.println(I18n.CANCELADA);
				  Consola.leer(I18n.PRESIONE_ENTER);
			  }
		  }else{
			  Consola.println(I18n.CANCELADA);
			  Consola.leer(I18n.PRESIONE_ENTER);
		  }
	  }
  }

  public static void copiarPresupuesto() {
	  ArrayList losPresupuestos=Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(), 0, 0, 1);
	  if (losPresupuestos.isEmpty()) {
		  Consola.println(I18n.LISTA_VACIA);
	  }
	  else {
		  Presupuesto unPresupuesto=(Presupuesto) Consola.menu(losPresupuestos,I18n.COPIAR_PRESUPUESTO,3);
		  if(unPresupuesto!=null){
			  Consola.println(unPresupuesto.toString());
			  String confirma=Consola.leer(I18n.CONFIRMA_COPIA);
			  if (confirma.toUpperCase().equals(I18n.SI.toUpperCase())){
				  String descripcion=Consola.leer(I18n.INGRESE_DESCRIPCION);
				  Consola.println(Fachada.copiarPresupuesto(unPresupuesto,descripcion).toString());
				  Consola.println(I18n.PRESIONE_ENTER);
			  }
			  else{
				  Consola.println(I18n.CANCELADA);
				  Consola.println(I18n.PRESIONE_ENTER);
			  }
		  }else{
			  Consola.println(I18n.CANCELADA);
			  Consola.leer(I18n.PRESIONE_ENTER); 
		  }
	  }
  }


}












