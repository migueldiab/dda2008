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

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
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
      dAbmArticulosCompuestos.setBounds(new Rectangle(0,0,660,420));
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
      lCosto.setBounds(new Rectangle(10, 100, 90, 20));
      lCosto.setText("Costo");
      lInfo = new JLabel();
      lInfo.setBounds(new Rectangle(0, 390, 390, 30));
      lInfo.setHorizontalAlignment(SwingConstants.CENTER);
      lInfo.setHorizontalTextPosition(SwingConstants.CENTER);
      
      lInfo.setText("Esto es una prueba");
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
      pAbmArticulosCompuestos.add(lCantidad, null);
      pAbmArticulosCompuestos.add(getTCantidad(), null);
      pAbmArticulosCompuestos.add(lMedida);
      pAbmArticulosCompuestos.add(getCMedida());
      pAbmArticulosCompuestos.add(lCosto, null);
      pAbmArticulosCompuestos.add(getTCosto(), null);
      
      pAbmArticulosCompuestos.add(getPArticulos());
      pAbmArticulosCompuestos.add(getPComponentes());
      pAbmArticulosCompuestos.add(getBAgregar(), null);
      pAbmArticulosCompuestos.add(getBQuitar(), null);
      //pAbmArticulosCompuestos.add(tComponentes, null);

      pAbmArticulosCompuestos.add(getTBuscar());
      pAbmArticulosCompuestos.add(getBBuscar());
      pAbmArticulosCompuestos.add(getPArticulosCompuestos());

      pAbmArticulosCompuestos.add(getBNuevo(), null);
      pAbmArticulosCompuestos.add(getBGuardar());
      pAbmArticulosCompuestos.add(getBCancelar());
      pAbmArticulosCompuestos.add(getBEliminar());

      pAbmArticulosCompuestos.add(lInfo, null);
      cargarListas();
      
    }
    return pAbmArticulosCompuestos;
  }

  private JTextField getTNombre() {
    if (tNombre == null) {
      tNombre = new JTextField();
      tNombre.setBounds(new Rectangle(100, 20, 150, 20));
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
      bGuardar.setBounds(new Rectangle(260, 20, 100, 30));
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
      bCancelar.setBounds(new Rectangle(500, 350, 100, 30));
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
      bEliminar.setBounds(new Rectangle(260, 60, 100, 30));
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
      pArticulosCompuestos.setBounds(new Rectangle(410, 40, 230, 300));
     
    }
    return pArticulosCompuestos;
  }
  
  private JScrollPane getPArticulos() {
    listaArticulos = new DefaultListModel();
    lArticulos = new JList(listaArticulos);
    lArticulos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lArticulos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
          public void valueChanged(javax.swing.event.ListSelectionEvent e) {
            
          }
        });
    if (pArticulos == null) {
      pArticulos = new JScrollPane(lArticulos);     
      pArticulos.setBounds(new Rectangle(240, 150, 160, 230));
    }
    return pArticulos;
  }
  

  private JScrollPane getPComponentes() {
    treeComponentes = new DefaultMutableTreeNode();
    tComponentes = new JTree(treeComponentes);
    //tComponentes.setBounds(new Rectangle(10, 150, 160, 230));
    tComponentes.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
          public void valueChanged(javax.swing.event.TreeSelectionEvent e) {
          }
        });
    if (pComponentes == null) {
      pComponentes = new JScrollPane(tComponentes);  
      pComponentes.setBounds(new Rectangle(10, 150, 160, 230));
    }
    return pComponentes;
  }  
  private JTextField getTBuscar() {
    if (tBuscar == null) {
      tBuscar = new JTextField();
      tBuscar.setBounds(new Rectangle(410, 20, 210, 20));
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
      bBuscar.setBounds(new Rectangle(620, 20, 20, 20));
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
      bNuevo.setBounds(new Rectangle(260, 100, 100, 30));
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
      tCantidad.setBounds(new Rectangle(100, 45, 150, 20));
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
      tCosto.setBounds(new Rectangle(100, 100, 150, 20));
    }
    return tCosto;
  }


  
  private JButton getBAgregar() {
    if (bAgregar == null) {
      bAgregar = new JButton();
      bAgregar.setBounds(new Rectangle(180, 180, 45, 20));
      bAgregar.setText("<");
    }
    return bAgregar;
  }

  private JButton getBQuitar() {
    if (bQuitar == null) {
      bQuitar = new JButton();
      bQuitar.setBounds(new Rectangle(180, 220, 45, 20));
      bQuitar.setText(">");
    }
    return bQuitar;
  }



}
