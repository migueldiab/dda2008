package utils;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import dominio.Articulo;
import dominio.Presupuesto;
import dominio.Item;





public class Consola {
	
	protected static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
  public static void print(String s){
		System.out.print(s);
		
	}
	
  public static void println(String s){
		
		System.out.println(s);
		
	}
  
  public static void print(int i){
    System.out.print(i);
    
  }
  
  public static  void println(int i){
    System.out.println(i);
  }
 
  public static void print(double d){
    System.out.print(d);
    
  }
 
  public static  void println(double d){
    System.out.println(d);
  }
 
  public static void print(char c){
    System.out.print(c);
    
  }
 
  public static  void println(char c){
    System.out.println(c);
  }  
	
  public static String leer(){
		
		try{
			return in.readLine();
		}catch(Exception e){return null;}
		
	}
	
  public static  String leer(String s){
		print(s);
		return leer();
	}

  public static String modificar(String s, String actual){
    
    try{
      print(s + "[" + actual + "] : ");
      String nuevo = leer();
      if (nuevo.equals(""))
        return actual;
      else if (nuevo.equals(" "))
        return "";
      else
        return nuevo;
    }catch(Exception e){return null;}
    
  }  
 
  public static int modificarInt(String msg, int actual)
  {
    int num = -1;
    while(true){
      try{
        print(msg + "[" + actual + "] : ");
        String nuevo = leer();
        if (nuevo.equals(""))
          return actual;
        else {
          num = Integer.parseInt(nuevo);
          return num;
        }        
      }catch(Exception e){}
    }
  }
  
  public static Date modificarFecha(String msg, Date actual)
  {
    Date fecha = null;
    while(true){
      try{
        print(msg + "[" + actual + "] : ");
        String nuevo = leer();
        if (nuevo.equals(""))
          return actual;
        else {
          fecha = I18n.sdf.parse(nuevo);
          return fecha;
        }        
      }catch(Exception e){}
    }
  }
  
  public static double modificarDouble(String msg, double actual)
  {
    double num = 0.0;
    while(true){
      try{
        print(msg + "[" + actual + "] : ");
        String nuevo = leer();
        if (nuevo.equals(""))
          return actual;
        else {
          num = Double.parseDouble(nuevo);
          return num;
        }        
      }catch(Exception e){}
    }
  }  
	
  public static int leerInt(){
		return leerInt(null);
	}
	
  public static int leerInt(String msg){
		int num = -1;
		boolean ok = false;
		while(!ok){
			try{
				if (msg!=null){print(msg);}
				num = Integer.parseInt(leer());
				ok = true;
			}catch(Exception e){}
		}
		return num;
	}
    
  public static Calendar leerFecha(String msg) {
    Date d=null;
    boolean ok=false;
    do {
      try {
    	  String fechaInput=leer(msg);
        d = I18n.sdf.parse(fechaInput);
        
        ok = true;
      } catch (ParseException e) {
        println(I18n.ERROR);
        
      }
    } while (!ok);
    Calendar calendario = new GregorianCalendar();
    calendario.setTime(d);
    return calendario;
  }
  
  public static void printFecha(Date fecha) {
    System.out.println(I18n.sdf.format(fecha));
  }
	
  public static int menu(ArrayList opciones){
	  int salida=opciones.size();
		for(int x=0;x<opciones.size();x++){
			println( (x+1) + "-" + opciones.get(x).toString());
		}
		int opcion;
		do{
      println(I18n.SEPARADOR);
      opcion = leerInt("|  "+I18n.SELECCIONE_OPCION+" : ") - 1;
			
		}while(opcion < 0 || opcion > opciones.size());
		 if (opcion!=salida){
		return opcion;
		 }
		 return -1;
	}
  

  
  /**
 * @param ArrayList opciones
 * @param String titulo
 * @param 0 Any - 1 Articulo - 2 Item - 3 Presupuesto Id,Descripcion,FechaModificacion - 4 Presupuesto toString sin Items
 * @return
 */
  public static Object menu(ArrayList opciones,String titulo,int tipo){
	  int salida=opciones.size();

	  println(I18n.SEPARADOR);
	  println("|   "+titulo);
	  println(I18n.SEPARADOR);

	  for(int x=0;x<opciones.size();x++){
		  if(tipo==1){
			  println( (x+1) + "-" + ((Articulo) opciones.get(x)).toStringNombreMedida());
		  }
		  else if(tipo==2){
			  println( (x+1) + "-" + ((Item) opciones.get(x)).getElArticulo().toStringNombreMedida());
		  }
		  else if(tipo==3)	{
			  println( (x+1) + "-" + ((Presupuesto)opciones.get(x)).toStringIdDescFechaMod());
		  }
		  else if(tipo==4)	{
			  println( (x+1) + "-" + ((Presupuesto)opciones.get(x)).toStringSinItems());
		  }
		  else{
			  println( (x+1) + "-" + opciones.get(x).toString());
		  }
	  }
	  println((opciones.size()+1)+ " Salir ");
	  int opcion;
	  do{
		  println(I18n.SEPARADOR);
		  opcion = leerInt("|  "+I18n.SELECCIONE_OPCION+" : ") - 1;

	  }while(opcion < 0 || opcion > opciones.size());
	  if (opcion!=salida){
		  return opciones.get(opcion);
	  }
	  return null;
  }

public static int menu(ArrayList opciones, String titulo){
    println(I18n.SEPARADOR);
    println("|   "+titulo);
    println(I18n.SEPARADOR);
    return menu(opciones);
  }
  
  
  
  public static double leerDouble(String msg)
  {
    double doble = 0;    
    
    boolean ok = false;
    while(!ok){
      try
      {
        doble = Double.parseDouble(leer(msg));
        ok = true;
      }
      catch (NumberFormatException e)
      {
        e.printStackTrace();
      }    
    }
    return doble;
  }
  public static void listado(ArrayList lista){    
    for(int x=0;x<lista.size();x++){
      println(lista.get(x).toString());
    }
  }

}
