package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.Time;

public class Fecha {
	private static Calendar c = Calendar.getInstance();
	private static Time t; 
	
	public static int MaximoDiaDeLaSemana(){
		return c.getMaximum(Calendar.DAY_OF_WEEK);
	}
	
	public static int MinimoDiaDeLaSemana(){
		return c.getMinimum(Calendar.DAY_OF_WEEK);
	}

	public static String NombreDiaDeLaSemana(int d){
		switch (d){
			case 1: return I18n.DAY_OF_WEEK_MON;
			case 2: return I18n.DAY_OF_WEEK_MON;
			case 3: return I18n.DAY_OF_WEEK_TUE;
			case 4: return I18n.DAY_OF_WEEK_WED;
			case 5: return I18n.DAY_OF_WEEK_THU;
			case 6: return I18n.DAY_OF_WEEK_FRI;
			case 7: return I18n.DAY_OF_WEEK_SAT;
			default: return "";
			}
	}
	
	public static int MaximoHorasDelDia(){
		return c.getMaximum(Calendar.HOUR_OF_DAY);
	}
	
	public static int MinimoHorasDelDia(){
		return c.getMinimum(Calendar.HOUR_OF_DAY);
		}

	public static int MaximoMinutosHora(){
		return c.getMaximum(Calendar.MINUTE);
		}
	
	public static int MinimoMinutosHora(){
		return c.getMinimum(Calendar.MINUTE);
		}

	public static boolean ValidarHoras(int h){
		if(h<MinimoHorasDelDia() || h>MaximoHorasDelDia()){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean ValidarMinutos(int m){
		if(m<MinimoMinutosHora() || m>MaximoMinutosHora()){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean ValidarDia(int d){
		if(d<MinimoDiaDeLaSemana() || d>MaximoDiaDeLaSemana()){
			return false;
		}
		else{
			return true;
		}
	}

	public static Time GetTime(int pHora, int pMinuto){
		c.set(1900, 1, 1, pHora, pMinuto, 0);
		t = new Time(c.getTimeInMillis());
		return t;
	}

  public static Calendar toDate(String fecha) {
    Date d;
    SimpleDateFormat fSimple = new SimpleDateFormat(I18n.FORMATO_FECHA);
    try {
      d = fSimple.parse(fecha);
      Calendar calendario = new GregorianCalendar();
      calendario.setTime(d);
      return calendario;
    }
    catch (ParseException e) {
      System.out.println(I18n.ERROR);     
    }
    return null;
  }
}
