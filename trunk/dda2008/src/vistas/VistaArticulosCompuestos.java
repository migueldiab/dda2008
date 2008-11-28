package vistas;

import java.awt.*;

import javax.swing.*;

import servicios.Fachada;

import dominio.ArticuloCompuesto;
import dominio.Articulo;
import dominio.Medida;
import java.awt.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class VistaArticulosCompuestos extends JFrame {

  private JDialog dAbmArticulosCompuestos = null;  //  @jve:decl-index=0:visual-constraint="132,10"
  private JPanel pAbmArticulosCompuestos = null;
  private JLabel lNombre = null;
  private JTextField tNombre = null;
  private JButton bGuardar = null;
  private JButton bCancelar = null;
  private JButton bEliminar = null;
  private JComboBox cMedida = null;
  private JLabel lMedida = null;
  private JScrollPane pArticulosCompuestos = null;
  private JScrollPane pArticulos = null;
  private JScrollPane pComponentes = null;
  private JList lArticulos = null;  
  private DefaultListModel listaArticulos = null;  //  @jve:decl-index=0:visual-constraint="538,137"
  private JList lArticulosCompuestos = null;  
  private DefaultListModel listaArticulosCompuestos = null;  //  @jve:decl-index=0:visual-constraint="538,137"
  private JTextField tBuscar = null;
  private JButton bBuscar = null;
  private JButton bNuevo = null;
  private JLabel lCantidad = null;
  private JTextField tCantidad = null;
  private JLabel lInfo = null;
  private JLabel lCosto = null;
  private JTextField tCosto = null;
  private JTree tComponentes = null;
  private DefaultMutableTreeNode treeComponentes = null;  //  @jve:decl-index=0:visual-constraint="538,137"
  private JButton bAgregar = null;
  private JButton bQuitar = null;
  public JDialog getDAbmArticulosCompuestos() {
    if (dAbmArticulosCompuestos == null) {
      dAbmArticulosCompuestos = new JDialog();
      dAbmArticulosCompuestos.setBounds(new Rectangle(0, 0, 700, 500));
      dAbmArticulosCompuestos.setContentPane(getPAbmArticulosCompuestos());
      dAbmArticulosCompuestos.setTitle("ABM ArticulosCompuestos");
    }
    return dAbmArticulosCompuestos;
  }

  /**
   * This method initializes pAbmArticulosCompuestos 
   *  
   * @return javax.swing.JPanel 
   */
  private JPanel getPAbmArticulosCompuestos() {
    if (pAbmArticulosCompuestos == null) {
      lCosto = new JLabel();
      lCosto.setBounds(new Rectangle(10, 94, 90, 20));
      lCosto.setText("Cantidad");
      lInfo = new JLabel();
      lInfo.setBounds(new Rectangle(-2, 444, 697, 30));
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
      pAbmArticulosCompuestos = new JPanel();
      pAbmArticulosCompuestos.setLayout(null);
      pAbmArticulosCompuestos.add(lNombre);
      pAbmArticulosCompuestos.add(getTNombre());
      pAbmArticulosCompuestos.add(getBGuardar());
      pAbmArticulosCompuestos.add(getBCancelar());
      pAbmArticulosCompuestos.add(getBEliminar());
      pAbmArticulosCompuestos.add(getCMedida());
      pAbmArticulosCompuestos.add(lMedida);
      pAbmArticulosCompuestos.add(getPArticulosCompuestos());
      pAbmArticulosCompuestos.add(getPArticulos());
      pAbmArticulosCompuestos.add(getPComponentes());
      pAbmArticulosCompuestos.add(getTBuscar());
      pAbmArticulosCompuestos.add(getBBuscar());
      pAbmArticulosCompuestos.add(getBNuevo(), null);
      pAbmArticulosCompuestos.add(lCantidad, null);
      pAbmArticulosCompuestos.add(getTCantidad(), null);
      pAbmArticulosCompuestos.add(lInfo, null);
      pAbmArticulosCompuestos.add(lCosto, null);
      pAbmArticulosCompuestos.add(getTCosto(), null);
      pAbmArticulosCompuestos.add(getBAgregar(), null);
      pAbmArticulosCompuestos.add(getBQuitar(), null);
      pAbmArticulosCompuestos.add(lArticulos, null);
      pAbmArticulosCompuestos.add(tComponentes, null);
      cargarListas();
      
    }
    return pAbmArticulosCompuestos;
  }

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
      bGuardar.setBounds(new Rectangle(258, 21, 100, 30));
      bGuardar.setText("Guardar");
      bGuardar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          guardarArticuloCompuesto();
          
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
      bCancelar.setBounds(new Rectangle(507, 348, 100, 30));
      bCancelar.setText("Cerrar");
      bCancelar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          limpiarCampos();
          dAbmArticulosCompuestos.setVisible(false);
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
      bEliminar.setBounds(new Rectangle(258, 61, 100, 30));
      bEliminar.setText("Eliminar");
      bEliminar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          if (lArticulosCompuestos.getSelectedIndex()==-1) {
            lInfo.setForeground(new Color(190, 65, 79));
            lInfo.setText("Debe seleccionar un articulo de la lista para eliminarlo");
          }
          else {
            eliminarArticuloCompuesto((ArticuloCompuesto) lArticulosCompuestos.getSelectedValue());
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
   * This method initializes lArticulosCompuestos  
   *  
   * @return javax.swing.JList  
   */
  private JScrollPane getPArticulosCompuestos() {
    listaArticulosCompuestos = new DefaultListModel();
    lArticulosCompuestos = new JList(listaArticulosCompuestos);
    lArticulosCompuestos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lArticulosCompuestos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
          public void valueChanged(javax.swing.event.ListSelectionEvent e) {
            if (lArticulosCompuestos.getSelectedIndex()!=-1) {
              cargarArticuloCompuesto();
              lInfo.setText("");

            }
          }
        });
    if (pArticulosCompuestos == null) {
      pArticulosCompuestos = new JScrollPane(lArticulosCompuestos);     
      pArticulosCompuestos.setBounds(new Rectangle(400, 40, 210, 301));
      pArticulosCompuestos.setViewportView(getPArticulos());
    }
    return pArticulosCompuestos;
  }
  
  private JScrollPane getPArticulos() {
    listaArticulos = new DefaultListModel();
    lArticulos = new JList(listaArticulos);
    lArticulos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lArticulos.setBounds(new Rectangle(230, 150, 160, 280));
    lArticulos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
          public void valueChanged(javax.swing.event.ListSelectionEvent e) {
            
          }
        });
    if (pArticulos == null) {
      pArticulos = new JScrollPane(lArticulos);     
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
      tBuscar.setBounds(new Rectangle(400, 20, 186, 20));      
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
      bBuscar.setBounds(new Rectangle(587, 20, 20, 20));
      bBuscar.setText("...");
      bBuscar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          buscarArticuloCompuesto();
        }
      });
    }
    return bBuscar;
  }
  
  private void cargarArticuloCompuesto() {
    
    ArticuloCompuesto u = (ArticuloCompuesto) lArticulosCompuestos.getSelectedValue();    
    tNombre.setText(u.getNombre());
    tCantidad.setText(Integer.toString(u.getCantidad()));
    cMedida.setSelectedItem(u.getMedida());
  }
  private void buscarArticuloCompuesto() {
    tNombre.setText("Test2");
  }
  private void guardarArticuloCompuesto() {
    try {
      ArticuloCompuesto unArticuloCompuesto = new ArticuloCompuesto(tNombre.getText(), (Medida) cMedida.getSelectedItem());
      unArticuloCompuesto = Fachada.obtenerArticuloCompuesto(unArticuloCompuesto);
      if ((unArticuloCompuesto==null) || (JOptionPane.showConfirmDialog(
          null,"Desea guardar los cambios al articulo "+tNombre.getText()+"?",
          "Confirma guardar?",
          JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        )
      {
        if (tNombre.getText()!="" &&
            cMedida.getSelectedIndex()!=-1
          )    
        {      
          if (unArticuloCompuesto==null) unArticuloCompuesto = new ArticuloCompuesto(tNombre.getText(),(Medida) cMedida.getSelectedItem());
          unArticuloCompuesto.setCantidad(Integer.parseInt(tCantidad.getText()));
          unArticuloCompuesto.setCosto(Double.parseDouble(tCosto.getText()));
          if (Fachada.agregarArticuloCompuesto(unArticuloCompuesto)) {
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
      bNuevo.setBounds(new Rectangle(259, 99, 100, 30));
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
    listaArticulosCompuestos.clear();
    for (Object u : Fachada.listadoArticulosCompuestos()) {
      listaArticulosCompuestos.addElement((ArticuloCompuesto) u);  
    }
    listaArticulos.clear();
    for (Object u : Fachada.listadoArticulos()) {
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
    lArticulosCompuestos.clearSelection();
    
    tNombre.setText("");
    tCantidad.setText("");
    cMedida.removeAllItems();
    for (Object g : Fachada.listaMedidas()) {
      cMedida.addItem((Medida) g);        
    }
    cMedida.setSelectedItem(null);
    tNombre.requestFocus();
  }
  private void eliminarArticuloCompuesto(ArticuloCompuesto u) {
    if (JOptionPane.showConfirmDialog(
        null,"Desea eliminar el articulo "+tNombre.getText()+"?",
        "Confirma eliminar?",
        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
    { 
      if (Fachada.borrarArticuloCompuesto(u)) {
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


  
  private JScrollPane getPComponentes() {
    treeComponentes = new DefaultMutableTreeNode();
    tComponentes = new JTree(treeComponentes);
    tComponentes.setBounds(new Rectangle(10, 150, 160, 280));
    tComponentes.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
          public void valueChanged(javax.swing.event.TreeSelectionEvent e) {
          }
        });
    if (pArticulos == null) {
      pArticulos = new JScrollPane(lArticulos);     
    }
    return pArticulos;
  }
  /*private JTree getTArticulosCompuestos() {
    if (tArticulosCompuestos == null) {
      tArticulosCompuestos = new JTree();
      tArticulosCompuestos.setBounds(new Rectangle(10, 150, 160, 280));
    }
    return tArticulosCompuestos;
  }*/

  /**
   * This method initializes bAgregar 
   *  
   * @return javax.swing.JButton  
   */
  private JButton getBAgregar() {
    if (bAgregar == null) {
      bAgregar = new JButton();
      bAgregar.setBounds(new Rectangle(180, 180, 45, 20));
      bAgregar.setText("<");
    }
    return bAgregar;
  }

  /**
   * This method initializes bQuitar  
   *  
   * @return javax.swing.JButton  
   */
  private JButton getBQuitar() {
    if (bQuitar == null) {
      bQuitar = new JButton();
      bQuitar.setBounds(new Rectangle(180, 220, 45, 20));
      bQuitar.setText(">");
    }
    return bQuitar;
  }



}
