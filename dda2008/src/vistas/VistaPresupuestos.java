package vistas;

import javax.swing.JPanel;
import java.awt.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Collections;
import java.util.Observer;

import javax.swing.SwingConstants;
import servicios.Fachada;
import utils.Fecha;
import dominio.Item;
import dominio.Presupuesto;
import javax.swing.JDialog;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

	 
public class VistaPresupuestos extends JFrame {

	private ArrayList observadores=new ArrayList();
	private static final long serialVersionUID = 1L;
	private JDialog jDialogPresupuestos = null;  //  @jve:decl-index=0:visual-constraint="7,7"
	private JPanel jContentPanePresupuestos = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JTextField jTextDescripcion = null;
	private JTextField jTextFechaEjecucionDia = null;
	private JTextField jTextId = null;
	private JTextField jTextFechaModificacionDia = null;
	private JTextField jTextDuenio = null;
	private static JTextField jTextCosto = null;
	private JTextField jTextEstado = null;
	private JButton jButtonNuevo = null;
	private JButton jButtonGuardar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonCancelar = null;
	private JButton jButtonItems = null;
	private JTextField jTextFechaModificacionMes = null;
	private JTextField jTextFechaModificacionAnio = null;
	private JTextField jTextFechaEjecucionMes = null;
	private JTextField jTextFechaEjecucionAnio = null;
	private JLabel jLabel14 = null;
	private JLabel jLabel15 = null;
	private JLabel jLabel16 = null;
	private JLabel jLabelStatusPresupuesto = null;
	private JList jListPresupuesto = null;
	private JScrollPane jScrollPanePresupuesto = null;
	private JDialog dItemsPresupuesto = null;
	private static ArrayList colPresup = new ArrayList();
	DefaultListModel modeloJList;
	public static Presupuesto presupuestoSeleccionado=null;
	private JButton jButtonConfirmDeleteYes = null;
	private JButton jButtonConfirmDeleteNo = null;
	
	
	
	private void nuevoPresupuesto() {
		this.jTextDescripcion.setEditable(true);
		this.jTextFechaEjecucionDia.setEditable(true);
		this.jTextFechaEjecucionMes.setEditable(true);
		this.jTextFechaEjecucionAnio.setEditable(true);
		this.borrarCamposPresupuesto();
		this.jLabelStatusPresupuesto.setText("");
	}
	
	private void guardarPresupuesto(){
		Date fechaEjecucion=new Date();
		try{
			fechaEjecucion=Fecha.ValidarFecha(Integer.parseInt(jTextFechaEjecucionDia.getText()),Integer.parseInt(jTextFechaEjecucionMes.getText()),Integer.parseInt(jTextFechaEjecucionAnio.getText()));	
		}
		catch(Exception e){
			fechaEjecucion=null;
		}

		if (this.jTextId.getText().isEmpty()){ //si es nuevo y no se apreto en items
			if(Fachada.validoPresupuesto(this.jTextDescripcion.getText(),Fachada.getUsuarioActual())&&!this.jTextDescripcion.getText().isEmpty()){
				Presupuesto tmpPresupuesto=new Presupuesto(this.jTextDescripcion.getText(),fechaEjecucion);
				Fachada.agregarPresupuesto(tmpPresupuesto);
				mostrarDatos(tmpPresupuesto);
				modeloJList.addElement(tmpPresupuesto);
				jListPresupuesto.setSelectedIndex(modeloJList.indexOf(tmpPresupuesto));
				this.jLabelStatusPresupuesto.setText("Guardado Correctamente");
			}
			else{
				this.jLabelStatusPresupuesto.setText("Error");
			}
		}
		else{			//si es una modificacion o tiene items
			Presupuesto tmpPresupuesto=presupuestoSeleccionado;
			if(Fachada.agregarPresupuesto(tmpPresupuesto)){
				modeloJList.addElement(tmpPresupuesto);
				ArrayList items=VistaItemsPresupuesto.getInstancia().itemsModificados();
				tmpPresupuesto.setItems(items);
				Double elCosto = Fachada.calcularCosto(tmpPresupuesto);
				tmpPresupuesto.setCosto(elCosto);
				jTextCosto.setText(Double.toString(tmpPresupuesto.getCosto()));
				jListPresupuesto.setSelectedIndex(modeloJList.indexOf(tmpPresupuesto));
				this.jLabelStatusPresupuesto.setText("Guardado Correctamente");
			}
			else{
				if(Fachada.modificarPresupuesto((Presupuesto) jListPresupuesto.getSelectedValue(),this.jTextDescripcion.getText(),fechaEjecucion)){
					ArrayList items=VistaItemsPresupuesto.getInstancia().itemsModificados();
					tmpPresupuesto= (Presupuesto)jListPresupuesto.getSelectedValue();
					tmpPresupuesto.setItems(items);
					Double elCosto = Fachada.calcularCosto(tmpPresupuesto);
					tmpPresupuesto.setCosto(elCosto);
					jTextCosto.setText(Double.toString(tmpPresupuesto.getCosto()));
					this.jLabelStatusPresupuesto.setText("Modificado Correctamente");
				}
				else{
					this.jLabelStatusPresupuesto.setText("Error");
				}
			}
		}

	}

	

	private void mostrarDatos(Object o) {
		if(o!=null){
			this.jTextDescripcion.setEditable(true);
			this.jTextFechaEjecucionDia.setEditable(true);
			this.jTextFechaEjecucionMes.setEditable(true);
			this.jTextFechaEjecucionAnio.setEditable(true);
			Presupuesto i=(Presupuesto) o;
			this.jTextDescripcion.setText(i.getDescripcion());
			Calendar cal=new GregorianCalendar();
			if(i.getFechaEjecucion()!=null){
				cal.setTime(i.getFechaEjecucion());
				this.jTextFechaEjecucionDia.setText(Integer.toString(cal.get(cal.DAY_OF_MONTH)));
				this.jTextFechaEjecucionMes.setText(Integer.toString(cal.get(cal.MONTH)+1));
				this.jTextFechaEjecucionAnio.setText(Integer.toString(cal.get(cal.YEAR)));
			}
			else{
				this.jTextFechaEjecucionDia.setText(null);
				this.jTextFechaEjecucionMes.setText(null);
				this.jTextFechaEjecucionAnio.setText(null);
			}
			this.jTextId.setText(Integer.toString(i.getId()));
			if(i.getFechaModificacion()!=null){
				cal.setTime(i.getFechaModificacion());
				this.jTextFechaModificacionDia.setText(Integer.toString(cal.get(cal.DAY_OF_MONTH)));
				this.jTextFechaModificacionMes.setText(Integer.toString(cal.get(cal.MONTH)+1));
				this.jTextFechaModificacionAnio.setText(Integer.toString(cal.get(cal.YEAR)));
				this.jTextDuenio.setText(i.getDuenio().getNombre());
				if(!Double.isNaN(i.getCosto())){
					this.jTextCosto.setText(Double.toString(i.getCosto()));	
				}

			}
			else{
				this.jTextFechaModificacionDia.setText(null);
				this.jTextFechaModificacionMes.setText(null);
				this.jTextFechaModificacionAnio.setText(null);
				this.jTextDuenio.setText(null);
				this.jTextCosto.setText(null);
			}
			this.jTextEstado.setText(i.getEstado());
			this.jLabelStatusPresupuesto.setText("");
		}
		else{
			borrarCamposPresupuesto();
		}
	}

	

	private void borrarCamposPresupuesto(){
		this.jTextDescripcion.setText("");
		this.jTextFechaEjecucionDia.setText("");
		this.jTextFechaEjecucionMes.setText("");
		this.jTextFechaEjecucionAnio.setText("");
		this.jTextId.setText("");
		this.jTextFechaModificacionDia.setText("");
		this.jTextFechaModificacionMes.setText("");
		this.jTextFechaModificacionAnio.setText("");
		this.jTextDuenio.setText("");
		this.jTextEstado.setText("");
		this.jTextCosto.setText("");
		this.jLabelStatusPresupuesto.setText("");
	}

	

	/**
	 * This method initializes jDialogPresupuestos	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	public JDialog getJDialogPresupuestos() {
		if (jDialogPresupuestos == null) {
			jDialogPresupuestos = new JDialog();
			jDialogPresupuestos.setBounds(new Rectangle(0, 0, 714, 484));
			jDialogPresupuestos.setSize(new Dimension(714, 480));
			jDialogPresupuestos.setTitle("ABM Presupuestos");
			jDialogPresupuestos.setContentPane(getJContentPanePresupuestos());
		}
		return jDialogPresupuestos;
	}

	/**
	 * This method initializes jContentPanePresupuestos	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPanePresupuestos() {
		if (jContentPanePresupuestos == null) {
			jLabelStatusPresupuesto = new JLabel();
			jLabelStatusPresupuesto.setText("JLabel");
			jLabelStatusPresupuesto.setBounds(new Rectangle(8, 352, 565, 30));
			jLabel16 = new JLabel();
			jLabel16.setText("Año");
			jLabel16.setBounds(new Rectangle(196, 70, 29, 16));
			jLabel15 = new JLabel();
			jLabel15.setText("Mes");
			jLabel15.setBounds(new Rectangle(157, 69, 32, 16));
			jLabel14 = new JLabel();
			jLabel14.setText("Dia");
			jLabel14.setBounds(new Rectangle(129, 68, 25, 16));
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(9, 203, 88, 25));
			jLabel6.setText("Costo");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(9, 177, 100, 23));
			jLabel5.setText("Estado");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(9, 152, 99, 22));
			jLabel4.setText("Dueño");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(9, 121, 114, 20));
			jLabel3.setText("Fecha Modificacion");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(8, 35, 90, 22));
			jLabel2.setText("Id");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(8, 93, 102, 23));
			jLabel1.setText("Fecha Ejecucion");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(8, 10, 91, 23));
			jLabel.setText("Descripcion");
			jContentPanePresupuestos = new JPanel();
			jContentPanePresupuestos.setLayout(null);
			jContentPanePresupuestos.add(jLabel, null);
			jContentPanePresupuestos.add(jLabel1, null);
			jContentPanePresupuestos.add(jLabel2, null);
			jContentPanePresupuestos.add(jLabel3, null);
			jContentPanePresupuestos.add(jLabel4, null);
			jContentPanePresupuestos.add(jLabel5, null);
			jContentPanePresupuestos.add(jLabel6, null);
			jContentPanePresupuestos.add(jLabelStatusPresupuesto, null);
			jContentPanePresupuestos.add(jLabel16, null);
			jContentPanePresupuestos.add(jLabel15, null);
			jContentPanePresupuestos.add(jLabel14, null);
			jContentPanePresupuestos.add(getJTextFechaModificacionMes(), null);
			jContentPanePresupuestos.add(getJTextFechaModificacionDia(), null);
			jContentPanePresupuestos.add(getJTextFechaModificacionAnio(), null);
			jContentPanePresupuestos.add(getJTextFechaEjecucionDia(), null);
			jContentPanePresupuestos.add(getJTextFechaEjecucionMes(), null);
			jContentPanePresupuestos.add(getJTextFechaEjecucionAnio(), null);
			jContentPanePresupuestos.add(getJButtonEliminar(), null);
			jContentPanePresupuestos.add(getJButtonCancelar(), null);
			jContentPanePresupuestos.add(getJTextDescripcion(), null);
			jContentPanePresupuestos.add(getJTextEstado(), null);
			jContentPanePresupuestos.add(getJTextDuenio(), null);
			jContentPanePresupuestos.add(getJButtonGuardar(), null);
			jContentPanePresupuestos.add(getJTextCosto(), null);
			jContentPanePresupuestos.add(getJButtonNuevo(), null);
			jContentPanePresupuestos.add(getJButtonItems(), null);
			jContentPanePresupuestos.add(getJTextId(), null);
			jContentPanePresupuestos.add(getJScrollPanePresupuesto(), null);
			jContentPanePresupuestos.add(getJButtonConfirmDeleteYes(), null);
			jContentPanePresupuestos.add(getJButtonConfirmDeleteNo(), null);
		}
		return jContentPanePresupuestos;
	}

	/**
	 * This method initializes jTextDescripcion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextDescripcion() {
		if (jTextDescripcion == null) {
			jTextDescripcion = new JTextField();
			jTextDescripcion.setEditable(false);
			jTextDescripcion.setBounds(new Rectangle(115, 12, 103, 20));
		}
		return jTextDescripcion;
	}

	/**
	 * This method initializes jTextFechaEjecucionDia	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaEjecucionDia() {
		if (jTextFechaEjecucionDia == null) {
			jTextFechaEjecucionDia = new JTextField();
			jTextFechaEjecucionDia.setEditable(false);
			jTextFechaEjecucionDia.setBounds(new Rectangle(129, 91, 22, 20));
		}
		return jTextFechaEjecucionDia;
	}

	/**
	 * This method initializes jTextId	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextId() {
		if (jTextId == null) {
			jTextId = new JTextField();
			jTextId.setEditable(false);
			jTextId.setBounds(new Rectangle(115, 35, 104, 20));
		}
		return jTextId;
	}

	/**
	 * This method initializes jTextFechaModificacionDia	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaModificacionDia() {
		if (jTextFechaModificacionDia == null) {
			jTextFechaModificacionDia = new JTextField();
			jTextFechaModificacionDia.setEditable(false);
			jTextFechaModificacionDia.setBounds(new Rectangle(128, 122, 23, 20));
		}
		return jTextFechaModificacionDia;
	}

	/**
	 * This method initializes jTextDuenio	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextDuenio() {
		if (jTextDuenio == null) {
			jTextDuenio = new JTextField();
			jTextDuenio.setEditable(false);
			jTextDuenio.setBounds(new Rectangle(115, 150, 102, 20));
		}
		return jTextDuenio;
	}

	/**
	 * This method initializes jTextCosto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextCosto() {
		if (jTextCosto == null) {
			jTextCosto = new JTextField();
			jTextCosto.setEditable(false);
			jTextCosto.setBounds(new Rectangle(115, 206, 102, 20));
		}
		return jTextCosto;
	}

	/**
	 * This method initializes jTextEstado	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextEstado() {
		if (jTextEstado == null) {
			jTextEstado = new JTextField();
			jTextEstado.setEditable(false);
			jTextEstado.setBounds(new Rectangle(115, 178, 102, 20));
		}
		return jTextEstado;
	}

	/**
	 * This method initializes jButtonNuevo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNuevo() {
		if (jButtonNuevo == null) {
			jButtonNuevo = new JButton();
			jButtonNuevo.setText("Nuevo");
			jButtonNuevo.setBounds(new Rectangle(100, 242, 69, 26));
			jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					nuevoPresupuesto();
				}
			});
		}
		return jButtonNuevo;
	}

	/**
	 * This method initializes jButtonGuardar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setText("Guardar");
			jButtonGuardar.setBounds(new Rectangle(6, 241, 80, 26));
			jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					guardarPresupuesto();
				}
			});
		}
		return jButtonGuardar;
	}

	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.setBounds(new Rectangle(8, 275, 80, 26));
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jListPresupuesto.getSelectedValue()!=null){
						jButtonConfirmDeleteYes.setVisible(true);
						jButtonConfirmDeleteNo.setVisible(true);
						jLabelStatusPresupuesto.setText("Aprete en \"Si\" si desea eliminar o en \"No\" para cancelar");
					}	
				}
				
			});
		}
		return jButtonEliminar;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setBounds(new Rectangle(6, 313, 85, 26));
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					jDialogPresupuestos.dispose();
				}
			
			});
		}
		return jButtonCancelar;
	}

	/**
	 * This method initializes jButtonItems	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonItems() {
		if (jButtonItems == null) {
			jButtonItems = new JButton();
			jButtonItems.setText("Lista de Items");
			jButtonItems.setBounds(new Rectangle(99, 277, 120, 26));
			jButtonItems.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarItems();
				}
			});
		}
		return jButtonItems;
	}

	/**
	 * This method initializes jTextFechaModificacionMes	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaModificacionMes() {
		if (jTextFechaModificacionMes == null) {
			jTextFechaModificacionMes = new JTextField();
			jTextFechaModificacionMes.setEditable(false);
			jTextFechaModificacionMes.setBounds(new Rectangle(158, 122, 22, 20));
		}
		return jTextFechaModificacionMes;
	}

	/**
	 * This method initializes jTextFechaModificacionAnio	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaModificacionAnio() {
		if (jTextFechaModificacionAnio == null) {
			jTextFechaModificacionAnio = new JTextField();
			jTextFechaModificacionAnio.setEditable(false);
			jTextFechaModificacionAnio.setBounds(new Rectangle(190, 122, 36, 20));
		}
		return jTextFechaModificacionAnio;
	}

	/**
	 * This method initializes jTextFechaEjecucionMes	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaEjecucionMes() {
		if (jTextFechaEjecucionMes == null) {
			jTextFechaEjecucionMes = new JTextField();
			jTextFechaEjecucionMes.setEditable(false);
			jTextFechaEjecucionMes.setBounds(new Rectangle(158, 92, 21, 20));
		}
		return jTextFechaEjecucionMes;
	}

	/**
	 * This method initializes jTextFechaEjecucionAnio	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaEjecucionAnio() {
		if (jTextFechaEjecucionAnio == null) {
			jTextFechaEjecucionAnio = new JTextField();
			jTextFechaEjecucionAnio.setEditable(false);
			jTextFechaEjecucionAnio.setBounds(new Rectangle(192, 93, 35, 20));
		}
		return jTextFechaEjecucionAnio;
	}

	/**
	 * This method initializes jListPresupuesto	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListPresupuesto() {
		if (jListPresupuesto == null) {
			colPresup=Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(),1,0,0);
			Object[] presu =colPresup.toArray();
			modeloJList = new DefaultListModel();
			jListPresupuesto = new JList(modeloJList);

			for (int i=0;i<colPresup.size();i++){
				Object unPresu=colPresup.get(i);
				modeloJList.addElement(unPresu);
			}

			jListPresupuesto
			.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
				public void valueChanged(javax.swing.event.ListSelectionEvent e) {
					mostrarDatos(jListPresupuesto.getSelectedValue());
					presupuestoSeleccionado=(Presupuesto) jListPresupuesto.getSelectedValue();
					VistaItemsPresupuesto.getInstancia().setPresupuestoItem(jListPresupuesto.getSelectedValue());
					jButtonConfirmDeleteYes.setVisible(false);
					jButtonConfirmDeleteNo.setVisible(false);
				}
			});
		}
		return jListPresupuesto;
	}

	/**
	 * This method initializes jScrollPanePresupuesto	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPanePresupuesto() {
		if (jScrollPanePresupuesto == null) {
			jScrollPanePresupuesto = new JScrollPane();
			jScrollPanePresupuesto.setBounds(new Rectangle(238, 17, 342, 308));
			jScrollPanePresupuesto.setViewportView(getJListPresupuesto());
		}
		return jScrollPanePresupuesto;
	}

	/**
	 * This method initializes jButtonConfirmDeleteYes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonConfirmDeleteYes() {
		if (jButtonConfirmDeleteYes == null) {
			jButtonConfirmDeleteYes = new JButton();
			jButtonConfirmDeleteYes.setBounds(new Rectangle(199, 389, 77, 30));
			jButtonConfirmDeleteYes.setText("Yes");
			jButtonConfirmDeleteYes.setVisible(false);
			jButtonConfirmDeleteYes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(Fachada.borrarPresupuesto((Presupuesto)jListPresupuesto.getSelectedValue())){
						modeloJList.removeElement(jListPresupuesto.getSelectedValue());
						jLabelStatusPresupuesto.setText("Presupuesto Eliminado");
					}
					else{
						jLabelStatusPresupuesto.setText("Presupuesto Nuevo Eliminado");
					}
					jButtonConfirmDeleteYes.setVisible(false);
					jButtonConfirmDeleteNo.setVisible(false);
				}
			});
		}
		return jButtonConfirmDeleteYes;
	}

	/**
	 * This method initializes jButtonConfirmDeleteNo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonConfirmDeleteNo() {
		if (jButtonConfirmDeleteNo == null) {
			jButtonConfirmDeleteNo = new JButton();
			jButtonConfirmDeleteNo.setBounds(new Rectangle(309, 389, 77, 30));
			jButtonConfirmDeleteNo.setText("No");
			jButtonConfirmDeleteNo.setVisible(false);
			jButtonConfirmDeleteNo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jLabelStatusPresupuesto.setText("Operacion Cancelada");
					jButtonConfirmDeleteYes.setVisible(false);
					jButtonConfirmDeleteNo.setVisible(false);
				}
			});
		}
		return jButtonConfirmDeleteNo;
	}

	private void mostrarItems(){
		if(jTextDescripcion.isEditable()){
			if(jTextId.getText().isEmpty()){
				if(jTextDescripcion.getText().isEmpty()){
					jLabelStatusPresupuesto.setText("Debe ingresar una descripcion");
				}
				else{
					jLabelStatusPresupuesto.setText("");
					Date fechaEjecucion=null;
					try{
						fechaEjecucion=Fecha.ValidarFecha(Integer.parseInt(jTextFechaEjecucionDia.getText()),Integer.parseInt(jTextFechaEjecucionMes.getText()),Integer.parseInt(jTextFechaEjecucionAnio.getText()));
					}
					catch( Exception z) {
					}
					Presupuesto tmpNuevoPresupuesto=new Presupuesto(jTextDescripcion.getText(),fechaEjecucion);
					Date now=new Date();
					tmpNuevoPresupuesto.setFechaModificacion(now);
					mostrarDatos(tmpNuevoPresupuesto);
					presupuestoSeleccionado=tmpNuevoPresupuesto;
					VistaItemsPresupuesto.getInstancia().setPresupuestoItem(tmpNuevoPresupuesto);
					
					VistaItemsPresupuesto.getInstancia().getJDialogItems().setVisible(true);
					jDialogPresupuestos.setVisible(false);	
				}
			}
			else{
				VistaItemsPresupuesto.getInstancia().getJDialogItems().setVisible(true);
				jDialogPresupuestos.setVisible(false);
				VistaItemsPresupuesto.getInstancia().setPresupuestoItem(jListPresupuesto.getSelectedValue());
				presupuestoSeleccionado=(Presupuesto) jListPresupuesto.getSelectedValue();
			}

		}
		
	}

	public static void updateCosto() {
		
		jTextCosto.setText(Double.toString(Fachada.calcularCosto(presupuestoSeleccionado)));
		
	}



}
