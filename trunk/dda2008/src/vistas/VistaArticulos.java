package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import servicios.Fachada;
import dominio.Articulo;
import dominio.ArticuloSimple;
import dominio.Grupo;
import dominio.Medida;
import dominio.Usuario;

public class VistaArticulos extends JFrame {

  private JDialog dAbmArticulos = null;  //  @jve:decl-index=0:visual-constraint="132,10"
  private JPanel pAbmArticulos = null;
  private JLabel lNombre = null;
  private JTextField tNombre = null;
  private JButton bGuardar = null;
  private JButton bCancelar = null;
  private JButton bEliminar = null;
  private JComboBox cMedida = null;
  private JLabel lMedida = null;
  private JScrollPane pArticulos = null;
  private JList lArticulos = null;  
  private DefaultListModel listaArticulos = null;  //  @jve:decl-index=0:visual-constraint="538,137"
  private JTextField tBuscar = null;
  private JButton bBuscar = null;
  private JButton bNuevo = null;
  private JLabel lCantidad = null;
  private JTextField tCantidad = null;
  private JLabel lInfo = null;
  private JLabel lCosto = null;
  private JTextField tCosto = null;
  public JDialog getDAbmArticulos() {
    if (dAbmArticulos == null) {
      dAbmArticulos = new JDialog();
      dAbmArticulos.setBounds(new Rectangle(0, 0, 500, 290));
      dAbmArticulos.setContentPane(getPAbmArticulos());
      dAbmArticulos.setTitle("ABM Articulos");
    }
    return dAbmArticulos;
  }

  /**
   * This method initializes pAbmArticulos 
   *  
   * @return javax.swing.JPanel 
   */
  private JPanel getPAbmArticulos() {
    if (pAbmArticulos == null) {
      lCosto = new JLabel();
      lCosto.setBounds(new Rectangle(10, 94, 90, 20));
      lCosto.setText("Costo");
      lInfo = new JLabel();
      lInfo.setBounds(new Rectangle(0, 240, 481, 30));
      lInfo.setHorizontalAlignment(SwingConstants.CENTER);
      lInfo.setHorizontalTextPosition(SwingConstants.CENTER);
      
      lInfo.setText("");
      lCantidad = new JLabel();
      lCantidad.setBounds(new Rectangle(10, 44, 90, 20));
      lCantidad.setText("Cantidad");
      lMedida = new JLabel();
      lMedida.setBounds(new Rectangle(10, 70, 90, 20));
      lMedida.setText("Medida");
      lNombre = new JLabel();
      lNombre.setBounds(new Rectangle(10, 19, 90, 20));
      lNombre.setText("Nombre");
      pAbmArticulos = new JPanel();
      pAbmArticulos.setLayout(null);
      pAbmArticulos.add(lNombre);
      pAbmArticulos.add(getTNombre());
      pAbmArticulos.add(getBGuardar());
      pAbmArticulos.add(getBCancelar());
      pAbmArticulos.add(getBEliminar());
      pAbmArticulos.add(getCMedida());
      pAbmArticulos.add(lMedida);
      pAbmArticulos.add(getPArticulos());
      pAbmArticulos.add(getTBuscar());
      pAbmArticulos.add(getBBuscar());
      pAbmArticulos.add(getBNuevo(), null);
      pAbmArticulos.add(lCantidad, null);
      pAbmArticulos.add(getTCantidad(), null);
      pAbmArticulos.add(lInfo, null);
      pAbmArticulos.add(lCosto, null);
      pAbmArticulos.add(getTCosto(), null);
      cargarListas();
      
    }
    return pAbmArticulos;
  }

  /**
   * This method initializes tNombre  
   *  
   * @return javax.swing.JTextField 
   */
  private JTextField getTNombre() {
    if (tNombre == null) {
      tNombre = new JTextField();
      tNombre.setBounds(new Rectangle(100, 19, 150, 20));
    }
    return tNombre;
  }

  /**
   * This method initializes bGuardar 
   *  
   * @return javax.swing.JButton  
   */
  private JButton getBGuardar() {
    if (bGuardar == null) {
      bGuardar = new JButton();
      bGuardar.setBounds(new Rectangle(40, 150, 100, 30));
      bGuardar.setText("Guardar");
      bGuardar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          guardarArticulo();
          
        }
      });
    }
    return bGuardar;
  }
  

  /**
   * This method initializes bCancelar  
   *  
   * @return javax.swing.JButton  
   */
  private JButton getBCancelar() {
    if (bCancelar == null) {
      bCancelar = new JButton();
      bCancelar.setBounds(new Rectangle(150, 190, 100, 30));
      bCancelar.setText("Cerrar");
      bCancelar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          limpiarCampos();
          dAbmArticulos.setVisible(false);
        }
      });
    }
    return bCancelar;
  }

  /**
   * This method initializes bEliminar  
   *  
   * @return javax.swing.JButton  
   */
  private JButton getBEliminar() {
    if (bEliminar == null) {
      bEliminar = new JButton();
      bEliminar.setBounds(new Rectangle(40, 190, 100, 30));
      bEliminar.setText("Eliminar");
      bEliminar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          if (lArticulos.getSelectedIndex()==-1) {
            lInfo.setForeground(new Color(190, 65, 79));
            lInfo.setText("Debe seleccionar un articulo de la lista para eliminarlo");
          }
          else {
            eliminarArticulo((Articulo) lArticulos.getSelectedValue());
          }
        }
      });
    }
    return bEliminar;
  }

  /**
   * This method initializes cMedida 
   *  
   * @return javax.swing.JComboBox  
   */
  private JComboBox getCMedida() {
    if (cMedida == null) {
      cMedida = new JComboBox();
      cMedida.setBounds(new Rectangle(100, 70, 150, 20));
    }
    return cMedida;
  }

  /**
   * This method initializes lArticulos  
   *  
   * @return javax.swing.JList  
   */
  private JScrollPane getPArticulos() {
    listaArticulos = new DefaultListModel();
    lArticulos = new JList(listaArticulos);
    lArticulos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lArticulos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
          public void valueChanged(javax.swing.event.ListSelectionEvent e) {
            if (lArticulos.getSelectedIndex()!=-1) {
              cargarArticulo();
              lInfo.setText("");

            }
          }
        });
    if (pArticulos == null) {
      pArticulos = new JScrollPane(lArticulos);     
      pArticulos.setBounds(new Rectangle(260, 40, 210, 197));
    }
    return pArticulos;
  }
  
  /**
   * This method initializes tBuscar  
   *  
   * @return javax.swing.JTextField 
   */
  private JTextField getTBuscar() {
    if (tBuscar == null) {
      tBuscar = new JTextField();
      tBuscar.setBounds(new Rectangle(260, 20, 186, 20));      
    }
    return tBuscar;
  }

  /**
   * This method initializes bBuscar  
   *  
   * @return javax.swing.JButton  
   */
  private JButton getBBuscar() {
    if (bBuscar == null) {
      bBuscar = new JButton();
      bBuscar.setBounds(new Rectangle(447, 20, 20, 20));
      bBuscar.setText("...");
      bBuscar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          buscarArticulo();
        }
      });
    }
    return bBuscar;
  }
  
  private void cargarArticulo() {
    
    Articulo u = (Articulo) lArticulos.getSelectedValue();    
    tNombre.setText(u.getNombre());
    tCantidad.setText(Integer.toString(u.getCantidad()));
    tCosto.setText(Double.toString(u.getCosto()));
    cMedida.setSelectedItem(u.getMedida());
  }
  private void buscarArticulo() {
    tNombre.setText("Test2");
  }
  private void guardarArticulo() {
    try {
      Articulo unArticulo = new ArticuloSimple(tNombre.getText(), (Medida) cMedida.getSelectedItem());
      unArticulo = Fachada.obtenerArticulo(unArticulo);
      if ((unArticulo==null) || (JOptionPane.showConfirmDialog(
          null,"Desea guardar los cambios al articulo "+tNombre.getText()+"?",
          "Confirma guardar?",
          JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        )
      {
        if (tNombre.getText()!="" &&
            cMedida.getSelectedIndex()!=-1
          )    
        {      
          if (unArticulo==null) unArticulo = new ArticuloSimple(tNombre.getText(),(Medida) cMedida.getSelectedItem());
          unArticulo.setCantidad(Integer.parseInt(tCantidad.getText()));
          unArticulo.setCosto(Double.parseDouble(tCosto.getText()));
          if (Fachada.agregarArticulo(unArticulo)) {
            lInfo.setForeground(new Color(65, 190, 79));
            lInfo.setText("Articulo " + tNombre.getText() + " guardado");
            cargarListas();
            limpiarCampos();
          }
          else {
            lInfo.setForeground(new Color(190, 65, 79));
            lInfo.setText("No se pudo eliminar el medio.");           
          }
        }
        else {
          lInfo.setForeground(new Color(190, 65, 79));
          lInfo.setText("Complete los datos del articulo antes de guardarlo");        
        }
      }      
    } catch (Exception e) {

        lInfo.setForeground(new Color(190, 65, 79));
        lInfo.setText("Verifique que los valores numéricos sean correctos");        
    }
    
  }

  /**
   * This method initializes bNuevo 
   *  
   * @return javax.swing.JButton  
   */
  private JButton getBNuevo() {
    if (bNuevo == null) {
      bNuevo = new JButton();
      bNuevo.setBounds(new Rectangle(150, 150, 100, 30));
      bNuevo.setText("Nuevo");
      bNuevo.addActionListener(new java.awt.event.ActionListener() {   
        public void actionPerformed(java.awt.event.ActionEvent e) {    
          limpiarCampos();
        }      
      });
    }
    return bNuevo;
  }
  private void cargarListas() {
    listaArticulos.clear();
    for (Object u : Fachada.listadoArticulosSimples()) {
      listaArticulos.addElement((Articulo) u);  
    }
    cMedida.removeAllItems();
    for (Object g : Fachada.listaMedidas()) {
      cMedida.addItem((Medida) g);        
    }    
  }

  /**
   * This method initializes tCantidad  
   *  
   * @return javax.swing.JTextField 
   */
  private JTextField getTCantidad() {
    if (tCantidad == null) {
      tCantidad = new JTextField();
      tCantidad.setBounds(new Rectangle(100, 44, 150, 20));
    }
    return tCantidad;
  }

  private void limpiarCampos() {
    lArticulos.clearSelection();
    
    tNombre.setText("");
    tCantidad.setText("");
    cMedida.removeAllItems();
    for (Object g : Fachada.listaMedidas()) {
      cMedida.addItem((Medida) g);        
    }
    cMedida.setSelectedItem(null);
    tNombre.requestFocus();
  }
  private void eliminarArticulo(Articulo u) {
    if (JOptionPane.showConfirmDialog(
        null,"Desea eliminar el articulo "+tNombre.getText()+"?",
        "Confirma eliminar?",
        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
    { 
      if (Fachada.borrarArticulo(u)) {
        cargarListas();
        limpiarCampos();
      }
      else {
        lInfo.setForeground(new Color(190, 65, 79));
        lInfo.setText("No se pudo eliminar el medio.");           
      }      
    }
  }

  /**
   * This method initializes tCosto	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTCosto() {
    if (tCosto == null) {
      tCosto = new JTextField();
      tCosto.setBounds(new Rectangle(100, 94, 150, 20));
    }
    return tCosto;
  }


}
