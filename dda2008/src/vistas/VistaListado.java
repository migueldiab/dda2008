package vistas;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTextPane;

import dominio.Item;
import dominio.Presupuesto;

import servicios.Fachada;
import utils.Consola;
import utils.I18n;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class VistaListado extends JDialog {

  private static final long serialVersionUID = 1L;
  private JDialog dListados = null;  //  @jve:decl-index=0:visual-constraint="19,3"
  private JPanel jContentPanePresupuestos = null;
private JScrollPane jScrollPanePresupuestos = null;
private JList jListPresupuestos = null;
private JScrollPane jScrollPaneItems = null;
private JList jListItems = null;
private DefaultListModel modeloJListPresupuestos = null;
private DefaultListModel modeloJListItems = null;

  /**
   * This method initializes jContentPanePresupuestos
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPanePresupuestos() {
    if (jContentPanePresupuestos == null) {
      jContentPanePresupuestos = new JPanel();
      jContentPanePresupuestos.setLayout(null);
      jContentPanePresupuestos.add(getJScrollPanePresupuestos(), null);
      jContentPanePresupuestos.add(getJScrollPaneItems(), null);
    }
    return jContentPanePresupuestos;
  }

  private void mostrarListado() {
	  RenderListado renderListado=new RenderListado();
	  ArrayList losPresupuestos=new ArrayList();
	  getModeloJListPresupuestos().removeAllElements();
	  if(Fachada.getUsuarioActual().getGrupo().toString().equals("Gestor"))    {
		  losPresupuestos=Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(), 1, 1, 1);
	  }
	  else {
		  losPresupuestos = Fachada.obtenerPresupuestos(null, 1, 1, 1);
	  }
	  for(int i=0;i<losPresupuestos.size();i++){
		  Presupuesto presupuesto=(Presupuesto)losPresupuestos.get(i);
		  getModeloJListPresupuestos().addElement(presupuesto);
	  }
	  jListPresupuestos.setCellRenderer(renderListado);
  }
  
    
  private void mostrarItems(){
	  
	  
	  
	  ArrayList losItems=new ArrayList();
	  getModeloJListItems().removeAllElements();
	  if(jListPresupuestos.getSelectedValue()!=null){
		 
		  Presupuesto tmpPresupuesto=(Presupuesto)jListPresupuestos.getSelectedValue();
		  losItems=tmpPresupuesto.getItems();
		  for(int i=0;i<losItems.size();i++){
			  Item unItem=(Item)losItems.get(i);
			  getModeloJListItems().addElement(unItem);
			
		  }
		  
		
	  }
	  
  }
  
  
  public JDialog getDListados() {
    if (dListados == null) {
      dListados = new JDialog();
      dListados.setBounds(new Rectangle(0, 0, 611, 513));
      dListados.setContentPane(getJContentPanePresupuestos());
      dListados.setTitle("Listado");
    }
    return dListados;
  }

/**
 * This method initializes jScrollPanePresupuestos	
 * 	
 * @return javax.swing.JScrollPane	
 */
private JScrollPane getJScrollPanePresupuestos() {
	if (jScrollPanePresupuestos == null) {
		jScrollPanePresupuestos = new JScrollPane();
		jScrollPanePresupuestos.setBounds(new Rectangle(7, 7, 571, 227));
		jScrollPanePresupuestos.setViewportView(getJListPresupuestos());
	}
	return jScrollPanePresupuestos;
}

/**
 * This method initializes jListPresupuestos	
 * 	
 * @return javax.swing.JList	
 */
private JList getJListPresupuestos() {
	if (jListPresupuestos == null) {
		jListPresupuestos = new JList(getModeloJListPresupuestos());
		jListPresupuestos
				.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
					public void valueChanged(javax.swing.event.ListSelectionEvent e) {
						mostrarItems();
					}
				});
		mostrarListado();
	}
	return jListPresupuestos;
}

/**
 * This method initializes jScrollPaneItems	
 * 	
 * @return javax.swing.JScrollPane	
 */
private JScrollPane getJScrollPaneItems() {
	if (jScrollPaneItems == null) {
		jScrollPaneItems = new JScrollPane();
		jScrollPaneItems.setBounds(new Rectangle(8, 236, 540, 235));
		jScrollPaneItems.setViewportView(getJListItems());
	}
	return jScrollPaneItems;
}

private DefaultListModel getModeloJListItems() {
	if (modeloJListItems == null) {
		modeloJListItems = new DefaultListModel();
	}
	return modeloJListItems;
}

private DefaultListModel getModeloJListPresupuestos() {
	if (modeloJListPresupuestos == null) {
		modeloJListPresupuestos = new DefaultListModel();
	}
	return modeloJListPresupuestos;
}

/**
 * This method initializes jListItems	
 * 	
 * @return javax.swing.JList	
 */
private JList getJListItems() {
	if (jListItems == null) {
		jListItems = new JList(getModeloJListItems());
	}
	return jListItems;
}

}  //  @jve:decl-index=0:visual-constraint="606,10"
