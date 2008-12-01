package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

import dominio.Presupuesto;

public class VistaPresupuestos {

	private JFrame jFramePresupuestos = null;  //  @jve:decl-index=0:visual-constraint="-7,-21"
	private JPanel jContentPanePresupuestos = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JScrollPane jScrollPanePresupuestos = null;
	private JTable jTablePresupuestos = null;
	private JScrollPane jScrollPaneItemsdelPresupuesto = null;
	private JTable jTableItemsdelPresupuesto = null;
	private JScrollPane jScrollPaneItemsAvailable = null;
	private JTable jTableItemsAvailable = null;
	private JTextField jTextDescripcion = null;
	private JTextField jTextFechaEjecucion = null;
	private JTextField jTextId = null;
	private JTextField jTextFechaModificacion = null;
	private JTextField jTextDuenio = null;
	private JTextField jTextCosto = null;
	private JTextField jTextEstado = null;
	private JButton jButtonFromAvailabletoItem = null;
	private JButton jButtonFromItemToAvailable = null;
	private JButton jButtonNuevo = null;
	private JButton jButtonGuardar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonCancelar = null;
	private JFrame jFrameItems = null;  //  @jve:decl-index=0:visual-constraint="-6,355"
	private JPanel jContentPaneItems = null;
	private JButton jButtonItems = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JTextField jTextNombre = null;
	private JTextField jTextMedida = null;
	private JTextField jTextCostoItem = null;
	private JTextField jTextStock = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel12 = null;
	private JLabel jLabel13 = null;
	private JTextField jTextCantidadItem = null;
	private JButton jButtonGuardarItems = null;
	private JButton jButtonCancelarItems = null;

	/**
	 * This method initializes jFramePresupuestos	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFramePresupuestos() {
		if (jFramePresupuestos == null) {
			jFramePresupuestos = new JFrame();
			jFramePresupuestos.setSize(new Dimension(554, 368));
			jFramePresupuestos.setTitle("Presupuesto");
			jFramePresupuestos.setContentPane(getJContentPanePresupuestos());
		}
		return jFramePresupuestos;
	}

	/**
	 * This method initializes jContentPanePresupuestos	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPanePresupuestos() {
		if (jContentPanePresupuestos == null) {
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(8, 175, 88, 25));
			jLabel6.setText("Costo");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(8, 149, 100, 23));
			jLabel5.setText("Estado");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(8, 124, 99, 22));
			jLabel4.setText("Dueño");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(8, 93, 114, 25));
			jLabel3.setText("Fecha Modificacion");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(8, 67, 90, 22));
			jLabel2.setText("Id");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(8, 38, 102, 23));
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
			jContentPanePresupuestos.add(getJScrollPanePresupuestos(), null);
			jContentPanePresupuestos.add(getJTextDescripcion(), null);
			jContentPanePresupuestos.add(getJTextFechaEjecucion(), null);
			jContentPanePresupuestos.add(getJTextId(), null);
			jContentPanePresupuestos.add(getJTextFechaModificacion(), null);
			jContentPanePresupuestos.add(getJTextDuenio(), null);
			jContentPanePresupuestos.add(getJTextCosto(), null);
			jContentPanePresupuestos.add(getJTextEstado(), null);
			jContentPanePresupuestos.add(getJButtonNuevo(), null);
			jContentPanePresupuestos.add(getJButtonGuardar(), null);
			jContentPanePresupuestos.add(getJButtonEliminar(), null);
			jContentPanePresupuestos.add(getJButtonCancelar(), null);
			jContentPanePresupuestos.add(getJButtonItems(), null);
		}
		return jContentPanePresupuestos;
	}

	/**
	 * This method initializes jScrollPanePresupuestos	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPanePresupuestos() {
		if (jScrollPanePresupuestos == null) {
			jScrollPanePresupuestos = new JScrollPane();
			jScrollPanePresupuestos.setBounds(new Rectangle(274, 7, 263, 319));
			jScrollPanePresupuestos.setViewportView(getJTablePresupuestos());
		}
		return jScrollPanePresupuestos;
	}

	/**
	 * This method initializes jTablePresupuestos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTablePresupuestos() {
		if (jTablePresupuestos == null) {
			jTablePresupuestos = new JTable();
		}
		return jTablePresupuestos;
	}

	/**
	 * This method initializes jScrollPaneItemsdelPresupuesto	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneItemsdelPresupuesto() {
		if (jScrollPaneItemsdelPresupuesto == null) {
			jScrollPaneItemsdelPresupuesto = new JScrollPane();
			jScrollPaneItemsdelPresupuesto.setBounds(new Rectangle(13, 22, 170, 170));
			jScrollPaneItemsdelPresupuesto.setViewportView(getJTableItemsdelPresupuesto());
		}
		return jScrollPaneItemsdelPresupuesto;
	}

	/**
	 * This method initializes jTableItemsdelPresupuesto	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableItemsdelPresupuesto() {
		if (jTableItemsdelPresupuesto == null) {
			jTableItemsdelPresupuesto = new JTable();
		}
		return jTableItemsdelPresupuesto;
	}

	/**
	 * This method initializes jScrollPaneItemsAvailable	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneItemsAvailable() {
		if (jScrollPaneItemsAvailable == null) {
			jScrollPaneItemsAvailable = new JScrollPane();
			jScrollPaneItemsAvailable.setBounds(new Rectangle(322, 28, 187, 164));
			jScrollPaneItemsAvailable.setViewportView(getJTableItemsAvailable());
		}
		return jScrollPaneItemsAvailable;
	}

	/**
	 * This method initializes jTableItemsAvailable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableItemsAvailable() {
		if (jTableItemsAvailable == null) {
			jTableItemsAvailable = new JTable();
		}
		return jTableItemsAvailable;
	}

	/**
	 * This method initializes jTextDescripcion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextDescripcion() {
		if (jTextDescripcion == null) {
			jTextDescripcion = new JTextField();
			jTextDescripcion.setBounds(new Rectangle(131, 11, 115, 23));
			jTextDescripcion.setEditable(false);
		}
		return jTextDescripcion;
	}

	/**
	 * This method initializes jTextFechaEjecucion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaEjecucion() {
		if (jTextFechaEjecucion == null) {
			jTextFechaEjecucion = new JTextField();
			jTextFechaEjecucion.setBounds(new Rectangle(131, 39, 114, 21));
			jTextFechaEjecucion.setEditable(false);
		}
		return jTextFechaEjecucion;
	}

	/**
	 * This method initializes jTextId	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextId() {
		if (jTextId == null) {
			jTextId = new JTextField();
			jTextId.setBounds(new Rectangle(131, 68, 114, 22));
			jTextId.setEditable(false);
		}
		return jTextId;
	}

	/**
	 * This method initializes jTextFechaModificacion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaModificacion() {
		if (jTextFechaModificacion == null) {
			jTextFechaModificacion = new JTextField();
			jTextFechaModificacion.setBounds(new Rectangle(131, 94, 115, 23));
			jTextFechaModificacion.setEditable(false);
		}
		return jTextFechaModificacion;
	}

	/**
	 * This method initializes jTextDuenio	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextDuenio() {
		if (jTextDuenio == null) {
			jTextDuenio = new JTextField();
			jTextDuenio.setBounds(new Rectangle(131, 123, 116, 21));
			jTextDuenio.setEditable(false);
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
			jTextCosto.setBounds(new Rectangle(131, 175, 115, 25));
			jTextCosto.setEditable(false);
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
			jTextEstado.setBounds(new Rectangle(131, 149, 117, 20));
			jTextEstado.setEditable(false);
		}
		return jTextEstado;
	}

	/**
	 * This method initializes jButtonFromAvailabletoItem	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonFromAvailabletoItem() {
		if (jButtonFromAvailabletoItem == null) {
			jButtonFromAvailabletoItem = new JButton();
			jButtonFromAvailabletoItem.setText("<=");
			jButtonFromAvailabletoItem.setBounds(new Rectangle(217, 104, 68, 20));
			jButtonFromAvailabletoItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return jButtonFromAvailabletoItem;
	}

	/**
	 * This method initializes jButtonFromItemToAvailable	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonFromItemToAvailable() {
		if (jButtonFromItemToAvailable == null) {
			jButtonFromItemToAvailable = new JButton();
			jButtonFromItemToAvailable.setText("=>");
			jButtonFromItemToAvailable.setBounds(new Rectangle(217, 36, 69, 21));
			jButtonFromItemToAvailable
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return jButtonFromItemToAvailable;
	}

	/**
	 * This method initializes jButtonNuevo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNuevo() {
		if (jButtonNuevo == null) {
			jButtonNuevo = new JButton();
			jButtonNuevo.setBounds(new Rectangle(8, 232, 87, 27));
			jButtonNuevo.setText("Nuevo");
			jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					this.nuevoPresupuesto();
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
			jButtonGuardar.setBounds(new Rectangle(8, 266, 86, 28));
			jButtonGuardar.setText("Guardar");
			jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					this.guardarPresupuesto();
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
			jButtonEliminar.setBounds(new Rectangle(8, 303, 86, 26));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
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
			jButtonCancelar.setBounds(new Rectangle(120, 274, 92, 27));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonCancelar;
	}

	/**
	 * This method initializes jFrameItems	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrameItems() {
		if (jFrameItems == null) {
			jFrameItems = new JFrame();
			jFrameItems.setSize(new Dimension(523, 346));
			jFrameItems.setTitle("Items");
			jFrameItems.setContentPane(getJContentPaneItems());
		}
		return jFrameItems;
	}

	/**
	 * This method initializes jContentPaneItems	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneItems() {
		if (jContentPaneItems == null) {
			jLabel13 = new JLabel();
			
			jLabel13.setBounds(new Rectangle(191, 127, 117, 19));
			jLabel13.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel13.setHorizontalAlignment(SwingConstants.LEADING);
			jLabel13.setVerticalAlignment(SwingConstants.CENTER);
			jLabel13.setText("Seleccione Cantidad");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(179, 284, 64, 21));
			jLabel12.setText("Stock");
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(178, 261, 64, 18));
			jLabel11.setText("Costo");
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(179, 235, 64, 22));
			jLabel10.setText("Medida");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(179, 211, 64, 20));
			jLabel9.setText("Nombre");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(324, 7, 175, 17));
			jLabel8.setText("Items Disponibles");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(12, 4, 172, 15));
			jLabel7.setText("Items Presupuesto");
			jContentPaneItems = new JPanel();
			jContentPaneItems.setLayout(null);
			jContentPaneItems.add(getJButtonFromAvailabletoItem(), null);
			jContentPaneItems.add(getJButtonFromItemToAvailable(), null);
			jContentPaneItems.add(getJScrollPaneItemsdelPresupuesto(), null);
			jContentPaneItems.add(getJScrollPaneItemsAvailable(), null);
			jContentPaneItems.add(jLabel7, null);
			jContentPaneItems.add(jLabel8, null);
			jContentPaneItems.add(getJTextNombre(), null);
			jContentPaneItems.add(getJTextMedida(), null);
			jContentPaneItems.add(getJTextCostoItem(), null);
			jContentPaneItems.add(getJTextStock(), null);
			jContentPaneItems.add(jLabel9, null);
			jContentPaneItems.add(jLabel10, null);
			jContentPaneItems.add(jLabel11, null);
			jContentPaneItems.add(jLabel12, null);
			jContentPaneItems.add(jLabel13, null);
			jContentPaneItems.add(getJTextCantidadItem(), null);
			jContentPaneItems.add(getJButtonGuardarItems(), null);
			jContentPaneItems.add(getJButtonCancelarItems(), null);
		}
		return jContentPaneItems;
	}

	/**
	 * This method initializes jButtonItems	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonItems() {
		if (jButtonItems == null) {
			jButtonItems = new JButton();
			jButtonItems.setBounds(new Rectangle(120, 234, 118, 29));
			jButtonItems.setText("Lista de Items");
			jButtonItems.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonItems;
	}

	/**
	 * This method initializes jTextNombre	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextNombre() {
		if (jTextNombre == null) {
			jTextNombre = new JTextField();
			jTextNombre.setBounds(new Rectangle(263, 211, 81, 19));
			jTextNombre.setEditable(false);
		}
		return jTextNombre;
	}

	/**
	 * This method initializes jTextMedida	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextMedida() {
		if (jTextMedida == null) {
			jTextMedida = new JTextField();
			jTextMedida.setBounds(new Rectangle(263, 237, 80, 19));
			jTextMedida.setEditable(false);
		}
		return jTextMedida;
	}

	/**
	 * This method initializes jTextCostoItem	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextCostoItem() {
		if (jTextCostoItem == null) {
			jTextCostoItem = new JTextField();
			jTextCostoItem.setBounds(new Rectangle(264, 260, 79, 19));
			jTextCostoItem.setEditable(false);
		}
		return jTextCostoItem;
	}

	/**
	 * This method initializes jTextStock	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextStock() {
		if (jTextStock == null) {
			jTextStock = new JTextField();
			jTextStock.setBounds(new Rectangle(263, 285, 80, 20));
			jTextStock.setEditable(false);
		}
		return jTextStock;
	}

	/**
	 * This method initializes jTextCantidadItem	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextCantidadItem() {
		if (jTextCantidadItem == null) {
			jTextCantidadItem = new JTextField();
			jTextCantidadItem.setBounds(new Rectangle(232, 149, 34, 27));
		}
		return jTextCantidadItem;
	}

	/**
	 * This method initializes jButtonGuardarItems	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGuardarItems() {
		if (jButtonGuardarItems == null) {
			jButtonGuardarItems = new JButton();
			jButtonGuardarItems.setBounds(new Rectangle(377, 218, 87, 30));
			jButtonGuardarItems.setText("Guardar");
			jButtonGuardarItems.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonGuardarItems;
	}

	/**
	 * This method initializes jButtonCancelarItems	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelarItems() {
		if (jButtonCancelarItems == null) {
			jButtonCancelarItems = new JButton();
			jButtonCancelarItems.setBounds(new Rectangle(378, 259, 86, 29));
			jButtonCancelarItems.setText("Cancelar");
			jButtonCancelarItems.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonCancelarItems;
	}

	private void nuevoPresupuesto() {
		this.jTextDescripcion.setEditable(true);
		this.jTextFechaEjecucion.setEditable(true);
		this.borrarCamposPresupuesto();
		
	}
	
	private void guardarPresupuesto(){
		if (this.jTextId.getText()==""){ //si es nuevo
			
			Presupuesto tmpPresupuesto
			
		}
		else{  				//si es una modificacion
			
		}
	}
	
	private void borrarCamposPresupuesto(){
		this.jTextDescripcion.setText("");
		this.jTextFechaEjecucion.setText("");
		this.jTextId.setText("");
		this.jTextFechaModificacion.setText("");
		this.jTextDuenio.setText("");
		this.jTextEstado.setText("");
		this.jTextCosto.setText("");
				
	}
	
}
