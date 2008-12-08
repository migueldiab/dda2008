package vistas;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import servicios.Fachada;
import dominio.Presupuesto;

public class VistaCopiaPresupuesto implements Observer {
	private JDialog jDialog = null;  //  @jve:decl-index=0:visual-constraint="-15,10"
	private JPanel jContentPane = null;
	private JList jListPresupuesto = null;
	private DefaultListModel modeloJListPresupuestos = null;
	private DefaultListModel modeloJListItems = null;
	private JScrollPane jScrollPanePresupuestos = null;
	private JLabel jLabel = null;
	private JTextField jTextDescripcion = null;
	private JLabel jLabel2 = null;
	private JTextField jTextId = null;
	private JLabel jLabel14 = null;
	private JLabel jLabel15 = null;
	private JLabel jLabel16 = null;
	private JLabel jLabel1 = null;
	private JTextField jTextFechaEjecucionDia = null;
	private JTextField jTextFechaEjecucionMes = null;
	private JTextField jTextFechaEjecucionAnio = null;
	private JLabel jLabel3 = null;
	private JTextField jTextFechaModificacionDia = null;
	private JTextField jTextFechaModificacionMes = null;
	private JTextField jTextFechaModificacionAnio = null;
	private JLabel jLabel4 = null;
	private JTextField jTextDuenio = null;
	private JLabel jLabel5 = null;
	private JTextField jTextEstado = null;
	private JLabel jLabel6 = null;
	private JTextField jTextCosto = null;
	private JScrollPane jScrollPaneItems = null;
	private JList jListItems = null;
	private JButton jButtonCopiar = null;
	private JButton jButtonCancelar = null;
	private JLabel jLabelStatus = null;
	private ModeloPresupuesto modeloPresupuesto;
	public VistaCopiaPresupuesto(ModeloPresupuesto modeloPresupuesto) {
		this.modeloPresupuesto=modeloPresupuesto;
		modeloPresupuesto.addObserver(this);
	}

	/**
	 * This method initializes jDialog	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	public JDialog getJDialog() {
		if (jDialog == null) {
			jDialog = new JDialog();
			jDialog.setSize(new Dimension(615, 506));
			jDialog.setContentPane(getJContentPane());
			jDialog.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					borrarCamposPresupuesto();
				}
			});
		}
		return jDialog;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelStatus = new JLabel();
			jLabelStatus.setBounds(new Rectangle(12, 441, 559, 23));
			jLabelStatus.setText("JLabel");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(8, 194, 71, 22));
			jLabel6.setText("Costo");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(9, 173, 52, 16));
			jLabel5.setText("Estado");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(6, 149, 108, 17));
			jLabel4.setText("Dueño");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(4, 125, 113, 19));
			jLabel3.setText("Fecha Modificacion");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(4, 102, 95, 16));
			jLabel1.setText("Fecha Ejecucion");
			jLabel16 = new JLabel();
			jLabel16.setBounds(new Rectangle(176, 72, 38, 21));
			jLabel16.setText("Año");
			jLabel15 = new JLabel();
			jLabel15.setBounds(new Rectangle(146, 72, 27, 20));
			jLabel15.setText("Mes");
			jLabel14 = new JLabel();
			jLabel14.setBounds(new Rectangle(116, 72, 26, 16));
			jLabel14.setText("Dia");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(5, 44, 75, 19));
			jLabel2.setText("Id");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(4, 18, 76, 19));
			jLabel.setText("Descripcion");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPanePresupuestos(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTextDescripcion(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJTextId(), null);
			jContentPane.add(jLabel14, null);
			jContentPane.add(jLabel15, null);
			jContentPane.add(jLabel16, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextFechaEjecucionDia(), null);
			jContentPane.add(getJTextFechaEjecucionMes(), null);
			jContentPane.add(getJTextFechaEjecucionAnio(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJTextFechaModificacionDia(), null);
			jContentPane.add(getJTextFechaModificacionMes(), null);
			jContentPane.add(getJTextFechaModificacionAnio(), null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getJTextDuenio(), null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(getJTextEstado(), null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(getJTextCosto(), null);
			jContentPane.add(getJScrollPaneItems(), null);
			jContentPane.add(getJButtonCopiar(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(jLabelStatus, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes modeloJListPresupuestos	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 */
	private DefaultListModel getModeloJListPresupuestos() {
		if (modeloJListPresupuestos == null) {
			modeloJListPresupuestos = new DefaultListModel();
		}
		return modeloJListPresupuestos;
	}

	/**
	 * This method initializes modeloJListItems	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 */
	private DefaultListModel getModeloJListItems() {
		if (modeloJListItems == null) {
			modeloJListItems = new DefaultListModel();
		}
		return modeloJListItems;
	}
	
	
	/**
	 * This method initializes jListPresupuesto	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListPresupuesto() {
		//if (jListPresupuesto == null) {
			ArrayList colPresup=new ArrayList();
			colPresup=Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(),0,0,1);
			jListPresupuesto = new JList(getModeloJListPresupuestos());
			jListPresupuesto
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							mostrarDatos(jListPresupuesto.getSelectedValue());
						}
					});
			getModeloJListPresupuestos().removeAllElements();
			for (int i=0;i<colPresup.size();i++){
				Object unPresu=colPresup.get(i);
				getModeloJListPresupuestos().addElement(unPresu);
			}
		//}
		return jListPresupuesto;
	}

	/**
	 * This method initializes jScrollPanePresupuestos	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPanePresupuestos() {
		if (jScrollPanePresupuestos == null) {
			jScrollPanePresupuestos = new JScrollPane();
			jScrollPanePresupuestos.setBounds(new Rectangle(244, 10, 353, 204));
			jScrollPanePresupuestos.setViewportView(getJListPresupuesto());
		}
		return jScrollPanePresupuestos;
	}

	/**
	 * This method initializes jTextDescripcion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextDescripcion() {
		if (jTextDescripcion == null) {
			jTextDescripcion = new JTextField();
			jTextDescripcion.setBounds(new Rectangle(116, 22, 119, 19));
			jTextDescripcion.setEditable(true);
		}
		return jTextDescripcion;
	}

	/**
	 * This method initializes jTextId	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextId() {
		if (jTextId == null) {
			jTextId = new JTextField();
			jTextId.setBounds(new Rectangle(116, 44, 109, 20));
			jTextId.setEditable(false);
		}
		return jTextId;
	}

	/**
	 * This method initializes jTextFechaEjecucionDia	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaEjecucionDia() {
		if (jTextFechaEjecucionDia == null) {
			jTextFechaEjecucionDia = new JTextField();
			jTextFechaEjecucionDia.setBounds(new Rectangle(116, 102, 23, 18));
			jTextFechaEjecucionDia.setEditable(false);
		}
		return jTextFechaEjecucionDia;
	}

	/**
	 * This method initializes jTextFechaEjecucionMes	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaEjecucionMes() {
		if (jTextFechaEjecucionMes == null) {
			jTextFechaEjecucionMes = new JTextField();
			jTextFechaEjecucionMes.setBounds(new Rectangle(146, 102, 24, 22));
			jTextFechaEjecucionMes.setEditable(false);
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
			jTextFechaEjecucionAnio.setBounds(new Rectangle(176, 102, 35, 22));
			jTextFechaEjecucionAnio.setEditable(false);
		}
		return jTextFechaEjecucionAnio;
	}

	/**
	 * This method initializes jTextFechaModificacionDia	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaModificacionDia() {
		if (jTextFechaModificacionDia == null) {
			jTextFechaModificacionDia = new JTextField();
			jTextFechaModificacionDia.setBounds(new Rectangle(116, 127, 24, 17));
			jTextFechaModificacionDia.setEditable(false);
		}
		return jTextFechaModificacionDia;
	}

	/**
	 * This method initializes jTextFechaModificacionMes	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaModificacionMes() {
		if (jTextFechaModificacionMes == null) {
			jTextFechaModificacionMes = new JTextField();
			jTextFechaModificacionMes.setBounds(new Rectangle(146, 127, 25, 20));
			jTextFechaModificacionMes.setEditable(false);
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
			jTextFechaModificacionAnio.setBounds(new Rectangle(176, 127, 37, 20));
			jTextFechaModificacionAnio.setEditable(false);
		}
		return jTextFechaModificacionAnio;
	}

	/**
	 * This method initializes jTextDuenio	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextDuenio() {
		if (jTextDuenio == null) {
			jTextDuenio = new JTextField();
			jTextDuenio.setBounds(new Rectangle(116, 149, 98, 19));
			jTextDuenio.setEditable(false);
		}
		return jTextDuenio;
	}

	/**
	 * This method initializes jTextEstado	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextEstado() {
		if (jTextEstado == null) {
			jTextEstado = new JTextField();
			jTextEstado.setBounds(new Rectangle(116, 175, 125, 15));
			jTextEstado.setEditable(false);
		}
		return jTextEstado;
	}

	/**
	 * This method initializes jTextCosto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextCosto() {
		if (jTextCosto == null) {
			jTextCosto = new JTextField();
			jTextCosto.setBounds(new Rectangle(116, 195, 84, 17));
			jTextCosto.setEditable(false);
		}
		return jTextCosto;
	}

	/**
	 * This method initializes jScrollPaneItems	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneItems() {
		if (jScrollPaneItems == null) {
			jScrollPaneItems = new JScrollPane();
			jScrollPaneItems.setBounds(new Rectangle(245, 217, 350, 222));
			jScrollPaneItems.setViewportView(getJListItems());
		}
		return jScrollPaneItems;
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

	/**
	 * This method initializes jButtonCopiar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCopiar() {
		if (jButtonCopiar == null) {
			jButtonCopiar = new JButton();
			jButtonCopiar.setBounds(new Rectangle(12, 296, 84, 29));
			jButtonCopiar.setText("Copiar");
			jButtonCopiar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					copiar();
				}
			});
		}
		return jButtonCopiar;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(13, 336, 98, 28));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					borrarCamposPresupuesto();
					jDialog.setVisible(false);
					
				}
			});
		}
		return jButtonCancelar;
	}
	private void mostrarDatos(Object o){
		if(o!=null){
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
			this.jLabelStatus.setText("");
			mostrarDatosItems(i);
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
		this.jLabelStatus.setText("");
	}
		
	private void mostrarDatosItems(Presupuesto p){
		ArrayList colItemsAvailable=new ArrayList();
		colItemsAvailable=Fachada.obtenerItems(p);
		modeloJListItems.removeAllElements();
		for (int i=0;i<colItemsAvailable.size();i++){
			Object unItem=colItemsAvailable.get(i);
			modeloJListItems.addElement(unItem);
		}
	}
	


	private void copiar(){
		Presupuesto presupuestoSeleccionado=(Presupuesto)jListPresupuesto.getSelectedValue();
		if(!jTextDescripcion.getText().equals(presupuestoSeleccionado.getDescripcion())){
			Presupuesto nuevoPresupuesto=Fachada.copiarPresupuesto(presupuestoSeleccionado, jTextDescripcion.getText());
			modeloJListPresupuestos.addElement(nuevoPresupuesto);
			jListPresupuesto.setSelectedIndex(modeloJListPresupuestos.indexOf(nuevoPresupuesto));
			jLabelStatus.setText("Copiado correctamente");
		}
		else{
			jLabelStatus.setText("No pueden tener la misma descripcion");
		}
	}

	public void update(Observable o, Object arg) {
		getJListPresupuesto();
		
	}
}
