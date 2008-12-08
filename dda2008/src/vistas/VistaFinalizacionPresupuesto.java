package vistas;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import dominio.Presupuesto;

import servicios.Fachada;

public class VistaFinalizacionPresupuesto implements Observer {

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
	private JButton jButtonFinalizar = null;
	private JButton jButtonCancelar = null;
	private JLabel jLabelStatus = null;
	private JButton jButtonSi = null;
	private JButton jButtonNo = null;
	private ModeloPresupuesto modeloPresupuesto;
	public VistaFinalizacionPresupuesto(ModeloPresupuesto modeloPresupuesto) {
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
			jContentPane.add(getJButtonFinalizar(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(jLabelStatus, null);
			jContentPane.add(getJButtonSi(), null);
			jContentPane.add(getJButtonNo(), null);
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
		if (jListPresupuesto == null) {
			ArrayList colPresup=new ArrayList();
			colPresup=Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(),1,0,0);
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
		}
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
			jTextDescripcion.setEditable(false);
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
	 * This method initializes jButtonFinalizar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonFinalizar() {
		if (jButtonFinalizar == null) {
			jButtonFinalizar = new JButton();
			jButtonFinalizar.setBounds(new Rectangle(12, 296, 84, 29));
			jButtonFinalizar.setText("Finalizar");
			jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getConfirmacion();
				}
			});
		}
		return jButtonFinalizar;
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
		getModeloJListItems().removeAllElements();
		for (int i=0;i<colItemsAvailable.size();i++){
			Object unItem=colItemsAvailable.get(i);
			getModeloJListItems().addElement(unItem);
		}
	}
	
	private void getConfirmacion(){
		jLabelStatus.setText("");
		if(jListPresupuesto.getSelectedValue()!=null){
			jLabelStatus.setText("Confirme si desea Finalizar el Presupuesto");
			jButtonSi.setVisible(true);
			jButtonNo.setVisible(true);
			jListPresupuesto.setEnabled(false);
		}
		else{
			jLabelStatus.setText("Debe seleccionar un Presupuesto");
		}
		
	}

	/**
	 * This method initializes jButtonSi	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSi() {
		if (jButtonSi == null) {
			jButtonSi = new JButton();
			jButtonSi.setBounds(new Rectangle(26, 405, 67, 28));
			jButtonSi.setText("Si");
			jButtonSi.setVisible(false);
			jButtonSi.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					finalizar();
				}
			});
		}
		return jButtonSi;
	}

	/**
	 * This method initializes jButtonNo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNo() {
		if (jButtonNo == null) {
			jButtonNo = new JButton();
			jButtonNo.setBounds(new Rectangle(114, 405, 67, 27));
			jButtonNo.setText("No");
			jButtonNo.setVisible(false);
			jButtonNo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jListPresupuesto.setEnabled(true);
					jListPresupuesto.setToolTipText("");
					jButtonSi.setVisible(false);
					jButtonNo.setVisible(false);
					jLabelStatus.setText("");
				}
			});
		}
		return jButtonNo;
	}
	
	private void finalizar(){
		if(Fachada.validoCantidadesFinalizacion((Presupuesto) jListPresupuesto.getSelectedValue())){
			if(Fachada.validoFechaEjecucion((Presupuesto) jListPresupuesto.getSelectedValue())){
				Fachada.finalizarPresupuesto((Presupuesto) jListPresupuesto.getSelectedValue());
				jLabelStatus.setText("Finalizado correctamente");
				mostrarDatos(jListPresupuesto.getSelectedValue());
			}
			else{
				jLabelStatus.setText("Sin Fecha de Ejecucion o posterior a fecha actual");
			}
		}
		else{
			jLabelStatus.setText("No hay Stock suficiente");
		}
		jListPresupuesto.setEnabled(true);
		jButtonSi.setVisible(false);
		jButtonNo.setVisible(false);
	}

	public void update(Observable arg0, Object arg1) {
		getJListPresupuesto();
	}
	
}
