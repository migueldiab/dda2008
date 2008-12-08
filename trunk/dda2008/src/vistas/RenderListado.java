package vistas;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import dominio.Presupuesto;

import java.util.Locale;
import java.awt.Component;
public class RenderListado extends DefaultListCellRenderer {


	public RenderListado() {
	}

	public Component getListCellRendererComponent(JList list, 
			Object value,
			int index, boolean isSelected,
			boolean cellHasFocus) {

		super.getListCellRendererComponent(list, 
				value, 
				index, 
				isSelected, 
				cellHasFocus);
		Presupuesto p = (Presupuesto)value;
		setText("Id: " +Integer.toString(p.getId())+" Descripcion: "+p.getDescripcion()+
				  " Apellido: "+p.getDuenio().getApellido()+" Nombre: "+p.getDuenio().getNombre()+
				  " Fecha Modif.: "+p.getFechaModificacionString()+" Fecha Ejec.: "+p.getFechaEjecucionString()+
				  " Costo: "+Double.toString(p.getCosto()));
		return this;
	}
}




	

