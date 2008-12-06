package vistas;

import java.util.Observable;

public class ModeloPresupuesto extends Observable {
	public void fueModificado(){
		setChanged();
		notifyObservers();
	}
	
	
	
}
