package utils;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import dominio.Presupuesto;




/**
 * ...
 * @author Marcos Tusso - Miguel Diab
 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
 * @version 0.05alpha 02/09/2008
 * @see         
 */
public class Consola {
	
	protected static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
  public static void print(String s){
		System.out.print(s);
		
	}
	/**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
  public static void println(String s){
		
		System.out.println(s);
		
	}
  /**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
  public static void print(int i){
    System.out.print(i);
    
  }
  /**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
  public static  void println(int i){
    System.out.println(i);
  }
  /**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
  public static void print(double d){
    System.out.print(d);
    
  }
  /**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
  public static  void println(double d){
    System.out.println(d);
  }
  /**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
  public static void print(char c){
    System.out.print(c);
    
  }
  /**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
  public static  void println(char c){
    System.out.println(c);
  }  
	/**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
  public static String leer(){
		
		try{
			return in.readLine();
		}catch(Exception e){return null;}
		
	}
	/**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
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
	/**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
  public static int leerInt(){
		return leerInt(null);
	}
	/**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
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
        d = I18n.sdf.parse(leer(msg));
        
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
	/**
	 * ...
	 * 
	 * @param  
	 * @return      
	 * @author Marcos Tusso - Miguel Diab
	 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
	 * @version 0.05alpha 02/09/2008
	 * @see         
	 */
  public static int menu(ArrayList opciones){
	
		for(int x=0;x<opciones.size();x++){
			println( (x+1) + "-" + opciones.get(x).toString());
		}
		int opcion;
		do{
      println(I18n.SEPARADOR);
      opcion = leerInt("|  "+I18n.SELECCIONE_OPCION+" : ") - 1;
			
		}while(opcion < 0 || opcion >= opciones.size());
		return opcion;
	}
  public static Object agregoItems(ArrayList opciones,String titulo){
	  	int salida=opciones.size();
	  
	  	println(I18n.SEPARADOR);
	    println("|   "+titulo);
	    println(I18n.SEPARADOR);
	    
	    for(int x=0;x<opciones.size();x++){
			println( (x+1) + "-" + opciones.get(x).toString());
		}
		println((opciones.size()+1)+ " Salir ");
		int opcion;
		do{
    println(I18n.SEPARADOR);
    opcion = leerInt("|  "+I18n.SELECCIONE_OPCION+" : ") - 1;
			
		}while(opcion > opciones.size()||opcion <0);
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
  
  public static int menuPresupuestos(ArrayList opciones){

	  for(int x=0;x<opciones.size();x++){
			println( (x+1) + "-" + ((Presupuesto)opciones.get(x)).toStringIdDescFechaMod());
		}
		int opcion;
		do{
    println(I18n.SEPARADOR);
    opcion = leerInt("|  "+I18n.SELECCIONE_OPCION+" : ") - 1;
			
		}while(opcion < 0 || opcion >= opciones.size());
		return opcion;
	
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
