package utils;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ...
 * @author Marcos Tusso - Miguel Diab
 * @author Diseño y Desarollo de Aplicaciones, Obligatorio (C) 2008
 * @version 0.05alpha 02/09/2008
 * @see         
 */
public class Consola {
	
	protected static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
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
  
  public static void setFormato(String mascara)
  {
    sdf = new SimpleDateFormat(mascara);
  }
  
  
  public static Calendar leerFecha(String msg) {
    Date d=null;
    boolean ok=false;
    do {
      try {
        d = sdf.parse(leer(msg));
        ok = true;
      } catch (ParseException e) {
        println(I18n.ERROR);
      }
      
    } while (!ok);
    Calendar calendario = new GregorianCalendar();
    calendario.setTime(d);
    return calendario;
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
	
  public static int menu(ArrayList opciones, String titulo){
    println(I18n.SEPARADOR);
    println("|   "+titulo);
    println(I18n.SEPARADOR);
    return menu(opciones);
  }
  
}
