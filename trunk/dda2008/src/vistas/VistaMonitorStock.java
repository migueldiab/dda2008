package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.lang.String;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import servicios.Fachada;

public class VistaMonitorStock {

	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="12,24"
	private JPanel jContentPane = null;
	private JTextField jTextDia = null;
	private JTextField jTextMes = null;
	private JTextField jTextAnio = null;
	private JLabel jlblDia = null;
	private JLabel jlblMes = null;
	private JLabel jlblAnio = null;
	private JLabel jlblSeleccioneFecha = null;
	private JButton jbtnCheckDate = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setSize(new Dimension(510, 437));
			jFrame.setTitle("Monitor de Prevision de Stock Insuficiente");
			jFrame.setContentPane(getJContentPane());
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jlblSeleccioneFecha = new JLabel();
			jlblSeleccioneFecha.setBounds(new Rectangle(87, 3, 337, 19));
			jlblSeleccioneFecha.setText("Seleccione Fecha para Prevision de suficiencia de Stock");
			jlblAnio = new JLabel();
			jlblAnio.setBounds(new Rectangle(255, 29, 40, 16));
			jlblAnio.setText("Año");
			jlblMes = new JLabel();
			jlblMes.setBounds(new Rectangle(218, 29, 28, 16));
			jlblMes.setText("Mes");
			jlblDia = new JLabel();
			jlblDia.setBounds(new Rectangle(176, 29, 30, 15));
			jlblDia.setText("Dia");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextDia(), null);
			jContentPane.add(getJTextMes(), null);
			jContentPane.add(getJTextAnio(), null);
			jContentPane.add(jlblDia, null);
			jContentPane.add(jlblMes, null);
			jContentPane.add(jlblAnio, null);
			jContentPane.add(jlblSeleccioneFecha, null);
			jContentPane.add(getJbtnCheckDate(), null);
			jContentPane.add(getJScrollPane(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextDia	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextDia() {
		if (jTextDia == null) {
			jTextDia = new JTextField();
			jTextDia.setBounds(new Rectangle(176, 45, 26, 19));
			jTextDia.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
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
			jTextMes.setBounds(new Rectangle(218, 45, 25, 19));
			jTextMes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
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
			jTextAnio.setBounds(new Rectangle(256, 45, 45, 19));
			jTextAnio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jTextAnio;
	}

	/**
	 * This method initializes jbtnCheckDate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbtnCheckDate() {
		if (jbtnCheckDate == null) {
			jbtnCheckDate = new JButton();
			jbtnCheckDate.setBounds(new Rectangle(167, 70, 141, 27));
			jbtnCheckDate.setText("Chequear Stock");
			jbtnCheckDate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jbtnCheckDate;
	}

	private Calendar fechaMonitorStock(){
				Calendar cal=new GregorianCalendar();
		int anio=Integer.parseInt(getJTextAnio().toString());
		int mes=Integer.parseInt(getJTextMes().toString());
		int dia=Integer.parseInt(getJTextDia().toString());
		cal.set(anio,mes,dia);
		return cal;
	}
	
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(29, 113, 442, 272));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(new MiModelo());
		}
		return jTable;
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
	
}
