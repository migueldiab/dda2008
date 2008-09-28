package utils;

import java.sql.Time;


public class Horario implements Canonic, Comparable {
	//attributes
	private int _Dia=0;
	private Time _Hora=null;

	//gets and sets
	public int get_Dia() {
		return _Dia;
	}
	public void set_Dia(int dia) {
		if(Fecha.ValidarDia(dia)){
			_Dia = dia;	
		}
	}
	public Time get_Hora() {
		return _Hora;
	}
	public void set_Hora(Time hora) {
		_Hora = hora;	
	}
	
	//constructors
	public Horario(){}
	
	public Horario(int pDia, Time pHora){
		this.set_Dia(pDia);
		this.set_Hora(pHora);
	}

	public Horario(Horario f){
		this.set_Dia(f.get_Dia());
		this.set_Hora(f.get_Hora());
	}

	//methods
	public String toString(){
		return Fecha.NombreDiaDeLaSemana(this.get_Dia()) + " " + this.get_Hora().toString();
	}

	public boolean equals(Object obj){
		Horario f;
		if(obj == this){return true;}
		if(!obj.getClass().isInstance(this)){ 
			return false; 
			}
		else{
			f = (Horario)obj;
		}
		if(f.get_Dia() == this.get_Dia() && f.get_Hora().equals(this.get_Hora())){
			return true;
			}
		else{
				return false;
			}
		}
	
	public int compareTo(Object o){
		if(o.getClass().isInstance(this)){
		    Horario f = (Horario) o;
		    if(this.get_Dia()<f.get_Dia()){
		    	return -1;
		    	}
		    else if(this.get_Dia()>f.get_Dia()){
		    	return 1;	
		    	}
		    else{
		    	return this.get_Hora().compareTo(f.get_Hora());
		    	}			
		    }
		else{
			return 1;
			}
		}
	}
