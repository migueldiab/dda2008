package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class VistaItemsPresupuesto {

	private JFrame jFrameItems = null;  //  @jve:decl-index=0:visual-constraint="15,4"
	private JPanel jContentPaneItems = null;
	private JButton jButtonFromAvailabletoItem = null;
	private JButton jButtonFromItemToAvailable = null;
	private JScrollPane jScrollPaneItemsdelPresupuesto = null;
	private JTable jTableItemsdelPresupuesto = null;
	private JScrollPane jScrollPaneItemsAvailable = null;
	private JTable jTableItemsAvailable = null;
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
	 * This method initializes jFrameItems	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrameItems() {
		if (jFrameItems == null) {
			jFrameItems = new JFrame();
			jFrameItems.setTitle("Items");
			jFrameItems.setSize(new Dimension(528, 371));
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
			jLabel13.setHorizontalAlignment(SwingConstants.LEADING);
			jLabel13.setText("Seleccione Cantidad");
			jLabel13.setVerticalAlignment(SwingConstants.CENTER);
			jLabel13.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
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
	 * This method initializes jButtonFromAvailabletoItem	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonFromAvailabletoItem() {
		if (jButtonFromAvailabletoItem == null) {
			jButtonFromAvailabletoItem = new JButton();
			jButtonFromAvailabletoItem.setBounds(new Rectangle(217, 104, 68, 20));
			jButtonFromAvailabletoItem.setText("<=");
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
			jButtonFromItemToAvailable.setBounds(new Rectangle(217, 36, 69, 21));
			jButtonFromItemToAvailable.setText("=>");
		}
		return jButtonFromItemToAvailable;
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
		}
		return jButtonCancelarItems;
	}

}
