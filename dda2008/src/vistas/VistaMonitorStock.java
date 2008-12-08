package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.lang.String;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.AbstractTableModel;

import servicios.Fachada;
import utils.Fecha;

import javax.swing.JList;
import javax.swing.JDialog;

import dominio.Articulo;
import dominio.ArticuloCompuesto;
import dominio.Componente;
import dominio.Item;
import dominio.ModeloArbol;
import dominio.Presupuesto;

public class VistaMonitorStock {

	private JDialog jDialog = null;  //  @jve:decl-index=0:visual-constraint="4,-2"
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JButton jbtnCheckDate = null;
	private JLabel jlblSeleccioneFecha = null;
	private JTextField jTextDia = null;
	private JTextField jTextMes = null;
	private JTextField jTextAnio = null;
	private JLabel jlblDia = null;
	private JLabel jlblMes = null;
	private JLabel jlblAnio = null;
	private JList jList = null;
	private JTree treeComponentes;
	//private ModeloArbol arbolComponentes = null;
	private DefaultListModel modeloJList = null;
	private ArticuloCompuesto raiz = null;  //  @jve:decl-index=0:visual-constraint="981,11"
	private Calendar fechaMonitorStock(){
				Calendar cal=new GregorianCalendar();
		int anio=Integer.parseInt(getJTextAnio().toString());
		int mes=Integer.parseInt(getJTextMes().toString());
		int dia=Integer.parseInt(getJTextDia().toString());
		cal.set(anio,mes,dia);
		return cal;
	}
	
	class MiModelo extends AbstractTableModel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private String[] columnNames = {
			"Nombre","Medida","Cantidad de Stock Faltante"	
		};
		
		private ArrayList<Object[]> data = Fachada.getArticulosStockInsuficiente(fechaMonitorStock()) ;
		
		public int getColumnCount() {
			return columnNames.length;
			
		}

		public int getRowCount() {
			return data.size();
		}
		
		public String getColumnName(int col){
			return columnNames[col];
		}
		
		public Object getValueAt(int row, int col) {
			return data.get(row)[col];
			
		}
		
		
		
	}

	private void getArticulosSinStock() {
		Date fecha=	Fecha.ValidarFecha(Integer.parseInt(jTextDia.getText()),Integer.parseInt(jTextMes.getText()),Integer.parseInt(jTextAnio.getText()));
		ArrayList losArticulosSimples=Fachada.getArticulosSimplesDePresupuestosAntesDe(fecha);
	}

	/**
	 * This method initializes jDialog	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	JDialog getJDialog() {
		if (jDialog == null) {
			jDialog = new JDialog();
			jDialog.setSize(new Dimension(569, 482));
			jDialog.setContentPane(getJContentPane());
		}
		return jDialog;
	}

	private DefaultListModel getModeloJList() {
		if (modeloJList == null) {
			modeloJList = new DefaultListModel();
		}
		return modeloJList;
	}
	
	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jlblAnio = new JLabel();
			jlblAnio.setBounds(new Rectangle(268, 53, 35, 17));
			jlblAnio.setText("Año");
			jlblMes = new JLabel();
			jlblMes.setBounds(new Rectangle(225, 53, 34, 14));
			jlblMes.setText("Mes");
			jlblDia = new JLabel();
			jlblDia.setBounds(new Rectangle(182, 53, 26, 13));
			jlblDia.setText("Dia");
			jlblSeleccioneFecha = new JLabel();
			jlblSeleccioneFecha.setBounds(new Rectangle(113, 10, 338, 28));
			jlblSeleccioneFecha.setText("Seleccione Fecha para Prevision de suficiencia de Stock");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJbtnCheckDate(), null);
			jContentPane.add(jlblSeleccioneFecha, null);
			jContentPane.add(getJTextDia(), null);
			jContentPane.add(getJTextMes(), null);
			jContentPane.add(getJTextAnio(), null);
			jContentPane.add(jlblDia, null);
			jContentPane.add(jlblMes, null);
			jContentPane.add(jlblAnio, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(12, 140, 530, 295));
			jScrollPane.setViewportView(getJList());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jbtnCheckDate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbtnCheckDate() {
		if (jbtnCheckDate == null) {
			jbtnCheckDate = new JButton();
			jbtnCheckDate.setBounds(new Rectangle(170, 101, 141, 29));
			jbtnCheckDate.setText("Chequear Stock");
			jbtnCheckDate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarStockInsuficiente();
				}
			});
		}
		return jbtnCheckDate;
	}

	/**
	 * This method initializes jTextDia	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextDia() {
		if (jTextDia == null) {
			jTextDia = new JTextField();
			jTextDia.setBounds(new Rectangle(183, 73, 28, 22));
			jTextDia.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					mostrarStockInsuficiente();
				}
			});
		}
		return jTextDia;
	}

	/**
	 * This method initializes jTextMes	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextMes() {
		if (jTextMes == null) {
			jTextMes = new JTextField();
			jTextMes.setBounds(new Rectangle(223, 73, 31, 21));
			jTextMes.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					mostrarStockInsuficiente();
				}
			});
		}
		return jTextMes;
	}

	/**
	 * This method initializes jTextAnio	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextAnio() {
		if (jTextAnio == null) {
			jTextAnio = new JTextField();
			jTextAnio.setBounds(new Rectangle(268, 73, 31, 21));
			jTextAnio.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					mostrarStockInsuficiente();
				}
			});
		}
		return jTextAnio;
	}

	/**
	 * This method initializes jList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList() {
		if (jList == null) {
			jList = new JList(getModeloJList());
		}
		return jList;
	}
	private Date getFecha(){
		Date fechaMonitoreo=new Date();
		try{
			fechaMonitoreo=Fecha.ValidarFecha(Integer.parseInt(jTextDia.getText()),Integer.parseInt(jTextMes.getText()),Integer.parseInt(jTextAnio.getText()));	
		}
		catch(Exception e){
			fechaMonitoreo=null;
		}
		return fechaMonitoreo;
	}

	private void mostrarStockInsuficiente(){
		getModeloJList().removeAllElements();
		Date fecha=getFecha();
		if(fecha!=null){
			ArrayList losPresupuestos=Fachada.obtenerPresupuestosAntesDe(fecha);
			ArrayList retorno=new ArrayList();
			ArrayList articulosSimplesUnPresupuesto=new ArrayList();
			for(int i=0;i<losPresupuestos.size();i++){//recorro todos los presupuestos con fecha de finalizacion antes de.. 
				Presupuesto unPresupuesto=(Presupuesto)losPresupuestos.get(i);
				for(int j=0;j<unPresupuesto.getItems().size();j++){
					Item item=(Item) unPresupuesto.getItems().get(j);
					articulosSimplesUnPresupuesto=Fachada.StockSimplesPresupuestos(item,articulosSimplesUnPresupuesto);
					//retorna arraylist con todos los simples en esos presupuestos, sumados cuando repetidos.
				}
			}
			//recorro todos los articulos simples
			ArrayList todosLosArticulosSimples=Fachada.listadoArticulosSimples();
			for(int k=0;k<articulosSimplesUnPresupuesto.size();k++){
				Componente componenteConTotalSimplesEnPresupuestos=(Componente) articulosSimplesUnPresupuesto.get(k);
				for (int w=0;w<todosLosArticulosSimples.size();w++){
					Articulo articuloSimples=(Articulo)todosLosArticulosSimples.get(w);
					if(componenteConTotalSimplesEnPresupuestos.getArticulo().equals(articuloSimples)){
						if(componenteConTotalSimplesEnPresupuestos.getCantidad()>articuloSimples.getCantidad()){
							int deficit=componenteConTotalSimplesEnPresupuestos.getCantidad()-articuloSimples.getCantidad();
							retorno.add(new Componente(articuloSimples,deficit));
						}
					}
				}
			}
			if(retorno!=null){
				for(int h=0;h<retorno.size();h++){
					modeloJList.addElement(retorno.get(h));
				}
			}
		}
	}


		
		
	
	
}




