package vistas;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;

import dominio.Presupuesto;
import dominio.Usuario;

import servicios.Fachada;

public class VistaCambioDuenio implements Observer {

	private JDialog jDialog = null;  //  @jve:decl-index=0:visual-constraint="7,-10"
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneUsuarios = null;
	private JList jListUsuarios = null;
	private JScrollPane jScrollPanePresupuestos = null;
	private JList jListPresupuestos = null;
	private JLabel jLabelStatus = null;
	private JScrollPane jScrollPaneNuevoDuenio = null;
	private JList jListNuevoDuenio = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JButton jButtonCambiar = null;
	private JButton jButtonCerrar = null;
	private DefaultListModel modeloJListPresupuestos = null;
	private DefaultListModel modeloJListUsuarios = null;
	private DefaultListModel modeloJListNuevoDuenio= null;
	private ModeloPresupuesto modeloPresupuesto;
	public VistaCambioDuenio(ModeloPresupuesto modeloPresupuesto) {
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
			jDialog.setSize(new Dimension(576, 493));
			jDialog.setContentPane(getJContentPane());
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
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(8, 237, 288, 19));
			jLabel2.setText("Seleccione Presupuesto a cambiar dueño");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(269, 4, 239, 18));
			jLabel1.setText("Seleccione Nuevo Dueño");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(12, 5, 152, 16));
			jLabel.setText("Seleccione Usuario");
			jLabelStatus = new JLabel();
			jLabelStatus.setBounds(new Rectangle(8, 424, 513, 29));
			jLabelStatus.setText("");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneUsuarios(), null);
			jContentPane.add(getJScrollPanePresupuestos(), null);
			jContentPane.add(jLabelStatus, null);
			jContentPane.add(getJScrollPaneNuevoDuenio(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJButtonCambiar(), null);
			jContentPane.add(getJButtonCerrar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneUsuarios	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneUsuarios() {
		if (jScrollPaneUsuarios == null) {
			jScrollPaneUsuarios = new JScrollPane();
			jScrollPaneUsuarios.setBounds(new Rectangle(7, 26, 254, 211));
			jScrollPaneUsuarios.setViewportView(getJListUsuarios());
		}
		return jScrollPaneUsuarios;
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
	 * This method initializes modeloJListUsuarios	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 */
	private DefaultListModel getModeloJListUsuarios() {
		if (modeloJListUsuarios == null) {
			modeloJListUsuarios = new DefaultListModel();
		}
		return modeloJListUsuarios;
	}
	
	/**
	 * This method initializes modeloJListNuevoDuenio	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 */
	private DefaultListModel getModeloJListNuevoDuenio() {
		if (modeloJListNuevoDuenio == null) {
			modeloJListNuevoDuenio = new DefaultListModel();
		}
		return modeloJListNuevoDuenio;
	}
	
	/**
	 * This method initializes jListUsuarios	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListUsuarios() {
		if (jListUsuarios == null) {
			jListUsuarios = new JList(getModeloJListUsuarios());
			actualizarListaUsuarios();
			jListUsuarios
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							mostrarPresupuestos();
							
						}
					});
		}
		return jListUsuarios;
	}

	/**
	 * This method initializes jScrollPanePresupuestos	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPanePresupuestos() {
		if (jScrollPanePresupuestos == null) {
			jScrollPanePresupuestos = new JScrollPane();
			jScrollPanePresupuestos.setBounds(new Rectangle(8, 258, 293, 162));
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
							jLabelStatus.setText("Seleccione nuevo Dueño");
						}
					});
		}
		return jListPresupuestos;
	}

	/**
	 * This method initializes jScrollPaneNuevoDuenio	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneNuevoDuenio() {
		if (jScrollPaneNuevoDuenio == null) {
			jScrollPaneNuevoDuenio = new JScrollPane();
			jScrollPaneNuevoDuenio.setBounds(new Rectangle(266, 27, 290, 210));
			jScrollPaneNuevoDuenio.setViewportView(getJListNuevoDuenio());
		}
		return jScrollPaneNuevoDuenio;
	}

	/**
	 * This method initializes jListNuevoDuenio	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListNuevoDuenio() {
		if (jListNuevoDuenio == null) {
			jListNuevoDuenio = new JList(getModeloJListNuevoDuenio());
			jListNuevoDuenio
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							if(jListPresupuestos.getSelectedValue()!=null){
								jLabelStatus.setText("Presione Cambiar Dueño");
							}
						}
					});
			actualizarListaNuevoDuenio();
		}
		return jListNuevoDuenio;
	}

	/**
	 * This method initializes jButtonCambiar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCambiar() {
		if (jButtonCambiar == null) {
			jButtonCambiar = new JButton();
			jButtonCambiar.setBounds(new Rectangle(382, 283, 138, 29));
			jButtonCambiar.setText("Cambiar Dueño");
			jButtonCambiar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cambiarDuenio();
				}
			});
		}
		return jButtonCambiar;
	}

	/**
	 * This method initializes jButtonCerrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCerrar() {
		if (jButtonCerrar == null) {
			jButtonCerrar = new JButton();
			jButtonCerrar.setBounds(new Rectangle(383, 321, 139, 29));
			jButtonCerrar.setText("Cerrar");
			jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jDialog.setVisible(false);
				}
			});
		}
		return jButtonCerrar;
	}

	private void actualizarListaUsuarios(){
		getModeloJListUsuarios().removeAllElements();
		ArrayList losUsuariosGestores=new ArrayList();
		losUsuariosGestores=Fachada.listadoGestoresPorApellido();
		for(int i=0;i<losUsuariosGestores.size();i++){
			Usuario unGestor=(Usuario)losUsuariosGestores.get(i);
			getModeloJListUsuarios().addElement(unGestor);
			getModeloJListPresupuestos().removeAllElements();
		}
		
	}
	
	private void mostrarPresupuestos(){
		getModeloJListPresupuestos().removeAllElements();
		ArrayList losPresupuestos=new ArrayList();
		losPresupuestos=Fachada.obtenerPresupuestos((Usuario) jListUsuarios.getSelectedValue(), 0, 0, 0);
		for(int i=0;i<losPresupuestos.size();i++){
			Presupuesto unPresupuesto=(Presupuesto)losPresupuestos.get(i);
			getModeloJListPresupuestos().addElement(unPresupuesto);
			
		}
	}
	private void actualizarListaNuevoDuenio(){
		getModeloJListNuevoDuenio().removeAllElements();
		ArrayList losGestores=new ArrayList();
		losGestores=Fachada.listadoGestoresPorApellido();
		for(int i=0;i<losGestores.size();i++){
			Usuario unGestor=(Usuario)losGestores.get(i);
			getModeloJListNuevoDuenio().addElement(unGestor);
		}
	}
	private void cambiarDuenio(){
		jLabelStatus.setText("");
		if(jListUsuarios.getSelectedValue()!=null&&jListPresupuestos.getSelectedValue()!=null&&jListNuevoDuenio.getSelectedValue()!=null){
			if(Fachada.cambiarDuenio((Presupuesto)jListPresupuestos.getSelectedValue(),(Usuario)jListNuevoDuenio.getSelectedValue())){;
			mostrarPresupuestos();
			jLabelStatus.setText("Cambiado correctamente");
			

			}

		}
		else{
			jLabelStatus.setText("Debe seleccionar Usuario, Presupuesto y nuevo Dueño");
		}
	}

	public void update(Observable o, Object arg) {
		if(jListUsuarios.getSelectedValue()!=null){
			mostrarPresupuestos();
		}
		
	}
}
