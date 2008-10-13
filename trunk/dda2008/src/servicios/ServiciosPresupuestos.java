package servicios;

import java.util.ArrayList;
import java.util.Date;


import dominio.Articulo;
import dominio.Presupuesto;

public class ServiciosPresupuestos
{
 private static ArrayList presupuestos = new ArrayList();

 public static boolean agregar(Presupuesto unPresupuesto){
Date now=new Date();
	 if (presupuestos.indexOf(unPresupuesto)==-1){
		 
		 unPresupuesto.setFechaModificacion(now);
		 unPresupuesto.setDuenio(ServiciosUsuarios.usuarioActual);
		 


		 presupuestos.add(unPresupuesto);
	 return true;
	 }
	 else
	 {
		 return false;
	 }
 }
 public static boolean borrar(Object o){
	 if(presupuestos.indexOf((Presupuesto)o)==-1){
		 presupuestos.remove((Presupuesto)o);
		 return true;
	 }
	 else{
		 return false;
	 }
 }
 
 public static void calcularCosto(Presupuesto unPresupuesto){
int x = 0;
double costo=0;
	 for(x=0;x<unPresupuesto.getItems().size();x++){
		 Articulo item=(Articulo) unPresupuesto.getItems().get(x);
		 costo+=item.getCosto()*item.getCantidad();
		}
		unPresupuesto.setCosto(costo);
		System.out.println("Tostring con Costo "+unPresupuesto.toString());
 }
 
 public static ArrayList listado(){
	 if(presupuestos.size()==0){
		 return null;
	 }
	 else{
	 return presupuestos;
	 }
 }
 
 public static boolean agregarItem(Presupuesto unPresupuesto,Object unItem){
		 if(unPresupuesto.getItems().contains(unItem)){
			 return false;
			 }
		 else{
			unPresupuesto.agregarItem(unItem);
			return true;
		 }
	 
 }
 
 public static boolean borrarItem(Presupuesto unPresupuesto,Object unItem){
	 int indice=presupuestos.indexOf(unPresupuesto);
	 if (indice==-1){
		 return false;
	 }
	 else{
		 if(!unPresupuesto.getItems().contains(unItem)){
			 return false;
			 }
		 else{
			unPresupuesto.borrarItem((Articulo)unItem); 
			return true;
		 }
	 }
 }
 
 public static boolean modificarItemPresupuesto(Presupuesto unPresupuesto,int cantItem){
	return false;
	 
 }
public static ArrayList obtenerPresupuestoPorArticulo(Articulo unArticulo)
{
  // TODO Auto-generated method stub
  ArrayList losPresupuestos = new ArrayList();
  
  for (int i = 0; i < presupuestos.size(); i++) {
    Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
    ArrayList items = new ArrayList();
    items = unPresupuesto.getItems();
    for (int j = 0; j < presupuestos.size(); j++) {
      Articulo unItem = (Articulo) items.get(j);
      if (unItem.equals(unArticulo)) {
        losPresupuestos.add(unItem);
      }      
    }
  }
  return losPresupuestos;
}
}
