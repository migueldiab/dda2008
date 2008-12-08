package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JDialog;

import servicios.Fachada;
import utils.Fecha;

import dominio.Articulo;
import dominio.Item;
import dominio.Presupuesto;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Font;


public class VistaItemsPresupuesto  {

	private JDialog jDialogItems = null;  //  @jve:decl-index=0:visual-constraint="9,10"
	private JPanel jContentPaneItems = null;
	private JButton jButtonFromAvailabletoItem = null;
	private JButton jButtonFromItemToAvailable = null;
	private JScrollPane jScrollPaneItemsDelPresupuesto = null;
	private static JList jListItemsDelPresupuesto = null;
	private JScrollPane jScrollPaneItemsAvailable = null;
	private JList jListItemsAvailable = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private static JTextField jTextNombre = null;
	private static JTextField jTextMedida = null;
	private static JTextField jTextCostoItem = null;
	private static JTextField jTextStock = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel12 = null;
	private JLabel jLabel13 = null;
	private JTextField jTextCantidadItem = null;
	private JButton jButtonVolverItems = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private static JTextField jTextDescripcion = null;
	private static JTextField jTextCosto = null;
	private static JTextField jTextEstado = null;
	private static JTextField jTextFechaModificacionDia = null;
	private static JTextField jTextFechaModificacionMes = null;
	private static JTextField jTextFechaModificacionAnio = null;
	private static JTextField jTextFechaEjecucionDia = null;
	private static JTextField jTextFechaEjecucionMes = null;
	private static JTextField jTextFechaEjecucionAnio = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel21 = null;
	private static JTextField jTextId = null;
	private JLabel jLabel41 = null;
	private static JTextField jTextDuenio = null;
	private static ArrayList colItemsPresup = new ArrayList();  //  @jve:decl-index=0:
	private static ArrayList colItemsAvailable = new ArrayList();  //  @jve:decl-index=0:
	static DefaultListModel modeloJList;
	static DefaultListModel modeloJListAvailable;
	private static Presupuesto presupuestoTemporal=null;
	private static VistaItemsPresupuesto instancia=null;  //  @jve:decl-index=0:
	private JButton jButtonCantidad = null;
	
	public static VistaItemsPresupuesto getInstancia(){
		if(instancia==null){
			instancia=new VistaItemsPresupuesto();
			JDialog dialogo=instancia.getJDialogItems();
			dialogo.pack();
			dialogo.setBounds(0,0,530,358);
		}
		return instancia;
	}
	
	
	/**
	 * This method initializes jDialogItems	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	JDialog getJDialogItems() {
		if (jDialogItems == null) {
			jDialogItems = new JDialog();
			jDialogItems.setSize(new Dimension(534, 401));
			jDialogItems.setTitle("Items Pesupuesto");
			jDialogItems.setContentPane(getJContentPaneItems());
			jDialogItems.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
						VistaPrincipal.dPresupuesto.setVisible(true);
						
					
				}
			});
		}
		return jDialogItems;
	}

	/**
	 * This method initializes jContentPaneItems	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneItems() {
		if (jContentPaneItems == null) {
			jLabel41 = new JLabel();
			jLabel41.setBounds(new Rectangle(7, 343, 53, 15));
			jLabel41.setText("Dueño");
			jLabel21 = new JLabel();
			jLabel21.setBounds(new Rectangle(5, 323, 50, 15));
			jLabel21.setText("Id");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(249, 198, 165, 21));
			jLabel4.setText("Datos Item Seleccionado");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(5, 259, 109, 16));
			jLabel3.setText("Fecha Modificacion");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(5, 195, 150, 16));
			jLabel2.setText("Datos del Presupuesto:");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(5, 280, 48, 16));
			jLabel5.setText("Estado");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(5, 239, 101, 16));
			jLabel1.setText("Fecha Ejecucion");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(5, 218, 74, 16));
			jLabel.setText("Descripcion");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(5, 303, 49, 16));
			jLabel6.setText("Costo");
			jLabel13 = new JLabel();
			jLabel13.setBounds(new Rectangle(191, 127, 117, 19));
			jLabel13.setHorizontalAlignment(SwingConstants.LEADING);
			jLabel13.setText("Seleccione Cantidad");
			jLabel13.setVerticalAlignment(SwingConstants.CENTER);
			jLabel13.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(248, 296, 64, 21));
			jLabel12.setText("Stock");
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(247, 273, 64, 18));
			jLabel11.setText("Costo");
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(248, 247, 64, 22));
			jLabel10.setText("Medida");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(248, 223, 64, 20));
			jLabel9.setText("Nombre");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(323, 2, 175, 17));
			jLabel8.setText("Items Disponibles");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(12, 4, 172, 15));
			jLabel7.setText("Items Presupuesto");
			jContentPaneItems = new JPanel();
			jContentPaneItems.setLayout(null);
			jContentPaneItems.add(getJButtonFromAvailabletoItem(), null);
			jContentPaneItems.add(getJButtonFromItemToAvailable(), null);
			jContentPaneItems.add(getJScrollPaneItemsDelPresupuesto(), null);
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
			jContentPaneItems.add(getJButtonVolverItems(), null);
			jContentPaneItems.add(jLabel6, null);
			jContentPaneItems.add(jLabel, null);
			jContentPaneItems.add(jLabel1, null);
			jContentPaneItems.add(jLabel5, null);
			jContentPaneItems.add(jLabel2, null);
			jContentPaneItems.add(jLabel3, null);
			jContentPaneItems.add(getJTextDescripcion(), null);
			jContentPaneItems.add(getJTextCosto(), null);
			jContentPaneItems.add(getJTextEstado(), null);
			jContentPaneItems.add(getJTextFechaModificacionDia(), null);
			jContentPaneItems.add(getJTextFechaModificacionMes(), null);
			jContentPaneItems.add(getJTextFechaModificacionAnio(), null);
			jContentPaneItems.add(getJTextFechaEjecucionDia(), null);
			jContentPaneItems.add(getJTextFechaEjecucionMes(), null);
			jContentPaneItems.add(getJTextFechaEjecucionAnio(), null);
			jContentPaneItems.add(jLabel4, null);
			jContentPaneItems.add(jLabel21, null);
			jContentPaneItems.add(getJTextId(), null);
			jContentPaneItems.add(jLabel41, null);
			jContentPaneItems.add(getJTextDuenio(), null);
			jContentPaneItems.add(getJButtonCantidad(), null);
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
			jButtonFromAvailabletoItem.setBounds(new Rectangle(217, 62, 68, 20));
			jButtonFromAvailabletoItem.setText("<=");
			jButtonFromAvailabletoItem
			.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jListItemsAvailable.getSelectedValue()!=null){
						if(!jTextCantidadItem.getText().isEmpty()){
							int cant=Integer.parseInt(jTextCantidadItem.getText());
							Object articuloARemover=jListItemsAvailable.getSelectedValue();
							Articulo articulo=(Articulo)articuloARemover;
							if(cant<=articulo.getCantidad()){
								modeloJListAvailable.removeElement(articuloARemover);
								Item item=new Item((Articulo)articulo,cant);
								modeloJList.addElement(item);
								presupuestoTemporal.setItems(itemsModificados());
								presupuestoTemporal.setCosto(Fachada.calcularCosto(presupuestoTemporal));
								jTextCosto.setText(Double.toString(Math.round(presupuestoTemporal.getCosto())));
							}
						}
					}
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
			jButtonFromItemToAvailable.setBounds(new Rectangle(217, 36, 69, 21));
			jButtonFromItemToAvailable.setText("=>");
			jButtonFromItemToAvailable
			.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jListItemsDelPresupuesto.getSelectedValue()!=null){
						Object itemARemover=jListItemsDelPresupuesto.getSelectedValue();
						modeloJList.removeElement(itemARemover);
						Item item=(Item) itemARemover;
						Articulo articulo=(Articulo) item.getElArticulo();
						modeloJListAvailable.addElement(articulo);
						//setPresupuestoItem(VistaPresupuestos.presupuestoSeleccionado);
						presupuestoTemporal.setItems(itemsModificados());
						presupuestoTemporal.setCosto(Fachada.calcularCosto(presupuestoTemporal));
						jTextCosto.setText(Double.toString(Math.round(presupuestoTemporal.getCosto())));
					}

				}
			});
		}
		return jButtonFromItemToAvailable;
	}

	/**
	 * This method initializes jScrollPaneItemsDelPresupuesto	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneItemsDelPresupuesto() {
		if (jScrollPaneItemsDelPresupuesto == null) {
			jScrollPaneItemsDelPresupuesto = new JScrollPane();
			jScrollPaneItemsDelPresupuesto.setBounds(new Rectangle(13, 28, 170, 160));
			jScrollPaneItemsDelPresupuesto.setViewportView(getJListItemsDelPresupuesto());
		}
		return jScrollPaneItemsDelPresupuesto;
	}

	/**
	 * This method initializes jListItemsDelPresupuesto	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListItemsDelPresupuesto() {

		if (jListItemsDelPresupuesto == null) {
			if(VistaPresupuestos.presupuestoSeleccionado!=null){
				colItemsPresup=Fachada.obtenerItems(VistaPresupuestos.presupuestoSeleccionado);
				modeloJList = new DefaultListModel();
				jListItemsDelPresupuesto = new JList(modeloJList);

				for (int i=0;i<colItemsPresup.size();i++){
					Object unItem=colItemsPresup.get(i);
					modeloJList.addElement(unItem);
				}	
			}
			else{
				modeloJList = new DefaultListModel();
				jListItemsDelPresupuesto = new JList(modeloJList);
			}
			jListItemsDelPresupuesto
			.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
				public void valueChanged(javax.swing.event.ListSelectionEvent e) {
					setDetallesItem(jListItemsDelPresupuesto.getSelectedValue(),1);
				}
			});
		}
		return jListItemsDelPresupuesto;
	}  



	/**
	 * This method initializes jScrollPaneItemsAvailable	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneItemsAvailable() {
		if (jScrollPaneItemsAvailable == null) {
			jScrollPaneItemsAvailable = new JScrollPane();
			jScrollPaneItemsAvailable.setBounds(new Rectangle(322, 28, 187, 163));
			jScrollPaneItemsAvailable.setViewportView(getJListItemsAvailable());
		}
		return jScrollPaneItemsAvailable;
	}

	/**
	 * This method initializes jListItemsAvailable	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListItemsAvailable() {
		if (jListItemsAvailable == null) {
			if(VistaPresupuestos.presupuestoSeleccionado!=null){
				colItemsAvailable=Fachada.obtenerArticulosNotIn(VistaPresupuestos.presupuestoSeleccionado);
				modeloJListAvailable = new DefaultListModel();
				jListItemsAvailable = new JList(modeloJListAvailable);
				jListItemsAvailable
						.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
							public void valueChanged(javax.swing.event.ListSelectionEvent e) {
								setDetallesItem(jListItemsAvailable.getSelectedValue(),0);
							}
						});
				for (int i=0;i<colItemsAvailable.size();i++){
					Object unItem=colItemsAvailable.get(i);
					modeloJListAvailable.addElement(unItem);
				}	
			}
			else{
				modeloJListAvailable = new DefaultListModel();
				jListItemsAvailable = new JList(modeloJListAvailable);
			}
		}	
		return jListItemsAvailable;
	}

	/**
	 * This method initializes jTextNombre	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextNombre() {
		if (jTextNombre == null) {
			jTextNombre = new JTextField();
			jTextNombre.setBounds(new Rectangle(332, 223, 81, 19));
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
			jTextMedida.setBounds(new Rectangle(332, 249, 80, 19));
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
			jTextCostoItem.setBounds(new Rectangle(333, 272, 79, 19));
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
			jTextStock.setBounds(new Rectangle(332, 297, 80, 20));
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
	 * This method initializes jButtonVolverItems	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonVolverItems() {
		if (jButtonVolverItems == null) {
			jButtonVolverItems = new JButton();
			jButtonVolverItems.setBounds(new Rectangle(424, 247, 87, 30));
			jButtonVolverItems.setText("Volver");
			jButtonVolverItems.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					VistaPrincipal.dPresupuesto.setVisible(true);
					getJDialogItems().setVisible(false);
					VistaPresupuestos.updateCosto();
				}
			});
		}
		return jButtonVolverItems;
	}

	public static void setPresupuestoItem(Object o){
		if (o==null){
			jTextDescripcion.setText("");
			jTextFechaEjecucionDia.setText("");
			jTextFechaEjecucionMes.setText("");
			jTextFechaEjecucionAnio.setText("");
			jTextId.setText("");
			jTextFechaModificacionDia.setText("");
			jTextFechaModificacionMes.setText("");
			jTextFechaModificacionAnio.setText("");
			jTextDuenio.setText("");
			jTextEstado.setText("");
			jTextCosto.setText("");
		}
		else{
			if(presupuestoTemporal==null){
				presupuestoTemporal=new Presupuesto("temporal",new Date());
			}
			else{
				presupuestoTemporal.setItems(itemsModificados());
			}
			Presupuesto unPresupuesto=(Presupuesto) o;
			jTextDescripcion.setText(unPresupuesto.getDescripcion());
			Calendar cal=new GregorianCalendar();
			if(unPresupuesto.getFechaEjecucion()!=null){
				cal.setTime(unPresupuesto.getFechaEjecucion());
				jTextFechaEjecucionDia.setText(Integer.toString(cal.get(cal.DAY_OF_MONTH)));
				jTextFechaEjecucionMes.setText(Integer.toString(cal.get(cal.MONTH)+1));
				jTextFechaEjecucionAnio.setText(Integer.toString(cal.get(cal.YEAR)));	
			}
			
			
			jTextId.setText(Integer.toString(unPresupuesto.getId()));
			if(unPresupuesto.getFechaModificacion()!=null){
				cal.setTime(unPresupuesto.getFechaModificacion());
				jTextFechaModificacionDia.setText(Integer.toString(cal.get(cal.DAY_OF_MONTH)));
				jTextFechaModificacionMes.setText(Integer.toString(cal.get(cal.MONTH)+1));
				jTextFechaModificacionAnio.setText(Integer.toString(cal.get(cal.YEAR)));
				jTextDuenio.setText(unPresupuesto.getDuenio().getNombre());
				
				jTextCosto.setText(Double.toString(Math.round(Fachada.calcularCosto(presupuestoTemporal))));
				colItemsPresup=Fachada.obtenerItems(unPresupuesto);
				modeloJList.removeAllElements();
				for (int i=0;i<colItemsPresup.size();i++){
					Object unItem=colItemsPresup.get(i);
					if(unItem!=null){
						modeloJList.addElement(unItem);	
					}

				}	
			}
			jTextEstado.setText(unPresupuesto.getEstado());
			colItemsAvailable=Fachada.obtenerArticulosNotIn(unPresupuesto);
			modeloJListAvailable.removeAllElements();
			for (int i=0;i<colItemsAvailable.size();i++){
				Object unItem=colItemsAvailable.get(i);
				if(unItem!=null){
					modeloJListAvailable.addElement(unItem);	
				}
				
			}	
		}

	}

	/**
	 * @param o
	 * @param Si es Item, 1, y si es Articulo, 0
	 */
	public static void setDetallesItem(Object o, int i){
		if(i==1){
			Item item=(Item) o;
			if(item!=null){
				jTextNombre.setText(item.getElArticulo().getNombre());
				jTextMedida.setText(item.getElArticulo().getMedida().toString());
				Presupuesto elPresupuesto=VistaPresupuestos.presupuestoSeleccionado;
				if(elPresupuesto!=null){
					if(elPresupuesto.getEstado()=="Finalizado"){

						jTextCostoItem.setText(Double.toString(item.getCostoFinalizado()));
					}
					else if(elPresupuesto.getEstado()=="En Construccion"){
						jTextCostoItem.setText(Double.toString(item.getElArticulo().getCosto()));	
					}
				}
				jTextStock.setText(Integer.toString(item.getCantidadItem()));	
			}
		}
		else{
			if(i==0){
				Articulo articulo=(Articulo) o;
				if(articulo!=null){
					jTextNombre.setText(articulo.getNombre());
					jTextMedida.setText(articulo.getMedida().toString());
					Presupuesto elPresupuesto=VistaPresupuestos.presupuestoSeleccionado;
					jTextCostoItem.setText(Double.toString(articulo.getCosto()));	
					jTextStock.setText(Integer.toString(articulo.getCantidad()));		
				}
			}
		}
	}


	/**
	 * This method initializes jTextDescripcion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextDescripcion() {
		if (jTextDescripcion == null) {
			jTextDescripcion = new JTextField();
			jTextDescripcion.setBounds(new Rectangle(117, 217, 121, 20));
			jTextDescripcion.setEditable(false);
		}
		return jTextDescripcion;
	}

	/**
	 * This method initializes jTextCosto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextCosto() {
		if (jTextCosto == null) {
			jTextCosto = new JTextField();
			jTextCosto.setBounds(new Rectangle(117, 297, 110, 20));
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
			jTextEstado.setBounds(new Rectangle(117, 276, 107, 19));
			jTextEstado.setEditable(false);
		}
		return jTextEstado;
	}

	/**
	 * This method initializes jTextFechaModificacionDia	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaModificacionDia() {
		if (jTextFechaModificacionDia == null) {
			jTextFechaModificacionDia = new JTextField();
			jTextFechaModificacionDia.setBounds(new Rectangle(117, 259, 21, 15));
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
			jTextFechaModificacionMes.setBounds(new Rectangle(155, 259, 19, 16));
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
			jTextFechaModificacionAnio.setBounds(new Rectangle(185, 261, 37, 14));
			jTextFechaModificacionAnio.setEditable(false);
		}
		return jTextFechaModificacionAnio;
	}

	/**
	 * This method initializes jTextFechaEjecucionDia	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFechaEjecucionDia() {
		if (jTextFechaEjecucionDia == null) {
			jTextFechaEjecucionDia = new JTextField();
			jTextFechaEjecucionDia.setBounds(new Rectangle(117, 241, 23, 14));
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
			jTextFechaEjecucionMes.setBounds(new Rectangle(155, 241, 20, 16));
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
			jTextFechaEjecucionAnio.setBounds(new Rectangle(185, 241, 37, 17));
			jTextFechaEjecucionAnio.setEditable(false);
		}
		return jTextFechaEjecucionAnio;
	}

	/**
	 * This method initializes jTextId	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextId() {
		if (jTextId == null) {
			jTextId = new JTextField();
			jTextId.setBounds(new Rectangle(117, 323, 111, 16));
			jTextId.setEditable(false);
		}
		return jTextId;
	}

	/**
	 * This method initializes jTextDuenio	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextDuenio() {
		if (jTextDuenio == null) {
			jTextDuenio = new JTextField();
			jTextDuenio.setBounds(new Rectangle(117, 343, 109, 16));
			jTextDuenio.setEditable(false);
		}
		return jTextDuenio;
	}

	public static ArrayList itemsModificados(){
		ArrayList retorno=new ArrayList();
		for(int i=0;i<modeloJList.getSize();i++){
			if(modeloJList.isEmpty()==false){
				retorno.add(modeloJList.getElementAt(i));	
			}
			
		}
		return retorno;
		
	}


	/**
	 * This method initializes jButtonCantidad	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCantidad() {
		if (jButtonCantidad == null) {
			jButtonCantidad = new JButton();
			jButtonCantidad.setBounds(new Rectangle(187, 90, 128, 22));
			jButtonCantidad.setFont(new Font("Dialog", Font.BOLD, 10));
			jButtonCantidad.setText("Cambiar Cantidad");
			jButtonCantidad.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jListItemsDelPresupuesto.getSelectedValue()!=null){
						cambiarCantidad();
					}
				}
			});
		}
		return jButtonCantidad;
	}

	private void cambiarCantidad(){
		if(Fecha.isInteger(jTextCantidadItem.getText())){
			Object articuloARemover=jListItemsDelPresupuesto.getSelectedValue();
			Item itemARemover=(Item)articuloARemover;
			int cant=Integer.parseInt(jTextCantidadItem.getText());
			if(cant<=Fachada.obtenerArticulo(itemARemover.getElArticulo()).getCantidad()){
				modeloJList.removeElement(articuloARemover);
				Item item=new Item((Articulo)itemARemover.getElArticulo(),cant);
				modeloJList.addElement(item);
				presupuestoTemporal.setItems(itemsModificados());
				presupuestoTemporal.setCosto(Fachada.calcularCosto(presupuestoTemporal));
				jTextCosto.setText(Double.toString(Math.round(presupuestoTemporal.getCosto())));
			}
		}
	}
}
