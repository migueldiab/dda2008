package testeo;

import java.util.Date;

import junit.framework.TestCase;
import dominio.*;
import servicios.ServiciosArticulos;
import servicios.ServiciosPresupuestos;

public class TestPresupuesto extends TestCase {
	private Medida unaMedida;
	private Articulo unArticulo;
	private Presupuesto unPresupuesto;
	
	public void setUp(){
	 unaMedida = new Medida("kg", "Kilogramo");
	 unArticulo = new Articulo("art1", unaMedida, 10, 105.30);
	 ServiciosArticulos.agregar(unArticulo);
	 Date fecha=new Date();
	 unPresupuesto=new Presupuesto("nuevoPresupuesto1",fecha);
	 ServiciosPresupuestos.agregar(unPresupuesto);
	 
	}
	
	public void testAgregarPresupuesto(){
		
	}
	
	
	
	
}
