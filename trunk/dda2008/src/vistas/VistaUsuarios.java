package vistas;

import java.awt.*;

import javax.swing.*;

import dominio.Grupo;
import dominio.Usuario;

import servicios.Fachada;
import servicios.ServiciosUsuarios;
import java.awt.Rectangle;

public class VistaUsuarios extends JFrame {

  private JDialog dAbmUsuarios = null;  //  @jve:decl-index=0:visual-constraint="132,10"
  private JPanel pAbmUsuarios = null;
  private JLabel lNombre = null;
  private JTextField tNombre = null;
  private JButton bGuardar = null;
  private JButton bCancelar = null;
  private JButton bEliminar = null;
  private JPasswordField tClave1 = null;
  private JPasswordField tClave2 = null;
  private JComboBox cGrupo = null;
  private JLabel lClave1 = null;
  private JLabel lClave2 = null;
  private JLabel lGrupo = null;
  private JScrollPane pUsuarios = null;
  private JList lUsuarios = null;  
  private DefaultListModel listaUsuarios = null;  //  @jve:decl-index=0:visual-constraint="538,137"
  private JTextField tBuscar = null;
  private JButton bBuscar = null;
  private JButton bNuevo = null;
  private JLabel lApellido = null;
  private JTextField tApellido = null;
  private JLabel lId = null;
  private JTextField tId = null;
  private JLabel lInfo = null;
  private Usuario shadowUsuario = null;
  public JDialog getDAbmUsuarios() {
    if (dAbmUsuarios == null) {
      dAbmUsuarios = new JDialog();
      dAbmUsuarios.setBounds(new Rectangle(0, 0, 500, 290));
      dAbmUsuarios.setContentPane(getPAbmUsuarios());
      dAbmUsuarios.setTitle("ABM Usuarios");
    }
    return dAbmUsuarios;
  }

  /**
   * This method initializes pAbmUsuarios 
   *  
   * @return javax.swing.JPanel 
   */
  private JPanel getPAbmUsuarios() {
    if (pAbmUsuarios == null) {
      lInfo = new JLabel();
      lInfo.setBounds(new Rectangle(0, 240, 481, 30));
      lInfo.setHorizontalAlignment(SwingConstants.CENTER);
      lInfo.setHorizontalTextPosition(SwingConstants.CENTER);
      
      lInfo.setText("");
      lId = new JLabel();
      lId.setBounds(new Rectangle(10, 20, 90, 20));
      lId.setText("Id Usuario");
      lApellido = new JLabel();
      lApellido.setBounds(new Rectangle(10, 70, 90, 20));
      lApellido.setText("Apellido");
      lGrupo = new JLabel();
      lGrupo.setBounds(new Rectangle(10, 145, 90, 20));
      lGrupo.setText("Grupo");
      lClave2 = new JLabel();
      lClave2.setBounds(new Rectangle(10, 120, 90, 20));
      lClave2.setText("Repetir");
      lClave1 = new JLabel();
      lClave1.setBounds(new Rectangle(10, 95, 90, 20));
      lClave1.setText("Clave");
      lNombre = new JLabel();
      lNombre.setBounds(new Rectangle(10, 45, 90, 20));
      lNombre.setText("Nombre");
      pAbmUsuarios = new JPanel();
      pAbmUsuarios.setLayout(null);
      pAbmUsuarios.add(lNombre);
      pAbmUsuarios.add(getTNombre());
      pAbmUsuarios.add(getBGuardar());
      pAbmUsuarios.add(getBCancelar());
      pAbmUsuarios.add(getBEliminar());
      pAbmUsuarios.add(getTClave1());
      pAbmUsuarios.add(getTClave2());
      pAbmUsuarios.add(getCGrupo());
      pAbmUsuarios.add(lClave1);
      pAbmUsuarios.add(lClave2);
      pAbmUsuarios.add(lGrupo);
      pAbmUsuarios.add(getPUsuarios());
      pAbmUsuarios.add(getTBuscar());
      pAbmUsuarios.add(getBBuscar());
      pAbmUsuarios.add(getBNuevo(), null);
      pAbmUsuarios.add(lApellido, null);
      pAbmUsuarios.add(getTApellido(), null);
      pAbmUsuarios.add(lId, null);
      pAbmUsuarios.add(getTId(), null);
      pAbmUsuarios.add(lInfo, null);
      cargarListas();
      
    }
    return pAbmUsuarios;
  }

  /**
   * This method initializes tNombre  
   *  
   * @return javax.swing.JTextField 
   */
  private JTextField getTNombre() {
    if (tNombre == null) {
      tNombre = new JTextField();
      tNombre.setBounds(new Rectangle(100, 45, 150, 20));
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
      bGuardar.setBounds(new Rectangle(10, 200, 100, 30));
      bGuardar.setText("Guardar");
      bGuardar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          guardarUsuario();
          
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
      bCancelar.setBounds(new Rectangle(250, 200, 100, 30));
      bCancelar.setText("Cerrar");
      bCancelar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          limpiarCampos();
          dAbmUsuarios.setVisible(false);
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
      bEliminar.setBounds(new Rectangle(130, 200, 100, 30));
      bEliminar.setText("Eliminar");
      bEliminar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          if (lUsuarios.getSelectedIndex()==-1) {
            lInfo.setForeground(new Color(190, 65, 79));
            lInfo.setText("Debe seleccionar un usuario de la lista para eliminarlo");
          }
          else {
            eliminarUsuario((Usuario) lUsuarios.getSelectedValue());
          }
        }
      });
    }
    return bEliminar;
  }

  /**
   * This method initializes tClave1  
   *  
   * @return javax.swing.JPasswordField 
   */
  private JPasswordField getTClave1() {
    if (tClave1 == null) {
      tClave1 = new JPasswordField();
      tClave1.setBounds(new Rectangle(100, 95, 90, 20));
    }
    return tClave1;
  }

  /**
   * This method initializes tClave2  
   *  
   * @return javax.swing.JPasswordField 
   */
  private JPasswordField getTClave2() {
    if (tClave2 == null) {
      tClave2 = new JPasswordField();
      tClave2.setBounds(new Rectangle(100, 120, 90, 20));
    }
    return tClave2;
  }

  /**
   * This method initializes cGrupo 
   *  
   * @return javax.swing.JComboBox  
   */
  private JComboBox getCGrupo() {
    if (cGrupo == null) {
      cGrupo = new JComboBox();
      cGrupo.setBounds(new Rectangle(100, 145, 150, 20));
    }
    return cGrupo;
  }

  /**
   * This method initializes lUsuarios  
   *  
   * @return javax.swing.JList  
   */
  private JScrollPane getPUsuarios() {
    listaUsuarios = new DefaultListModel();
    lUsuarios = new JList(listaUsuarios);
    lUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
          public void valueChanged(javax.swing.event.ListSelectionEvent e) {
            if (lUsuarios.getSelectedIndex()!=-1) {
              cargarUsuario();
              lInfo.setText("");

            }
          }
        });
    if (pUsuarios == null) {
      pUsuarios = new JScrollPane(lUsuarios);     
      pUsuarios.setBounds(new Rectangle(260, 40, 210, 120));
    }
    return pUsuarios;
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
          buscarUsuario();
        }
      });
    }
    return bBuscar;
  }
  
  private void cargarUsuario() {
    
    shadowUsuario = (Usuario) lUsuarios.getSelectedValue();    
    tId.setText(shadowUsuario.getId());
    tNombre.setText(shadowUsuario.getNombre());
    tApellido.setText(shadowUsuario.getApellido());
    tClave1.setText(shadowUsuario.getClave());
    tClave2.setText(shadowUsuario.getClave());
    cGrupo.setSelectedItem(shadowUsuario.getGrupo());
  }
  private void buscarUsuario() {
    tNombre.setText("Test2");
  }
  private void guardarUsuario() {
    Usuario unUsuario = new Usuario(tId.getText());
    if (shadowUsuario == null) shadowUsuario = Fachada.obtenerUsuario(unUsuario);    
    if ((shadowUsuario==null) || (JOptionPane.showConfirmDialog(
        null,"Desea guardar los cambios al usuario "+tId.getText()+"?",
        "Confirma guardar?",
        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
      )
    {
      if (tId.getText()!="" &&
          tClave1.getText().equals(tClave2.getText()) &&
          tClave1.getText().length() > 4 &&
          cGrupo.getSelectedIndex()!=-1
        )    
      {      
        unUsuario.setNombre(tNombre.getText());
        unUsuario.setApellido(tApellido.getText());
        unUsuario.setClave(tClave1.getText());
        unUsuario.setGrupo((Grupo) cGrupo.getSelectedItem());
        if (shadowUsuario==null) {
          if (Fachada.agregarUsuario(unUsuario)) {
            lInfo.setForeground(new Color(65, 190, 79));
            lInfo.setText("Usuario " + tId.getText() + " guardado");
            cargarListas();
            limpiarCampos();
          }
          else {
            lInfo.setForeground(new Color(190, 65, 79));
            lInfo.setText("No se pudo guardar el medio.");           
          }          
        }
        else {
          if (Fachada.modificarUsuario(shadowUsuario, unUsuario)) {
            lInfo.setForeground(new Color(65, 190, 79));
            lInfo.setText("Usuario " + tId.getText() + " modificado");
            cargarListas();
            limpiarCampos();
          }
          else {
            lInfo.setForeground(new Color(190, 65, 79));
            lInfo.setText("No se pudo modificar el medio.");           
          }          
        }
      }
      else {
        lInfo.setForeground(new Color(190, 65, 79));
        lInfo.setText("Complete los datos del usuario antes de guardarlo");        
      }
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
      bNuevo.setBounds(new Rectangle(366, 163, 100, 20));
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
    listaUsuarios.clear();
    for (Object u : Fachada.listadoUsuarios()) {
      listaUsuarios.addElement((Usuario) u);  
    }
    cGrupo.removeAllItems();
    for (Object g : Fachada.listaGrupos()) {
      cGrupo.addItem((Grupo) g);        
    }    
  }

  /**
   * This method initializes tApellido  
   *  
   * @return javax.swing.JTextField 
   */
  private JTextField getTApellido() {
    if (tApellido == null) {
      tApellido = new JTextField();
      tApellido.setBounds(new Rectangle(100, 70, 150, 20));
    }
    return tApellido;
  }

  /**
   * This method initializes tId  
   *  
   * @return javax.swing.JTextField 
   */
  private JTextField getTId() {
    if (tId == null) {
      tId = new JTextField();
      tId.setBounds(new Rectangle(100, 20, 100, 20));
    }
    return tId;
  }
  private void limpiarCampos() {
    lUsuarios.clearSelection();
    
    tId.setText("");
    tNombre.setText("");
    tApellido.setText("");
    tClave1.setText("");
    tClave2.setText("");
    cGrupo.removeAllItems();
    for (Object g : Fachada.listaGrupos()) {
      cGrupo.addItem((Grupo) g);        
    }
    cGrupo.setSelectedItem(null);
    tId.requestFocus();
    shadowUsuario = null;
  }
  private void eliminarUsuario(Usuario u) {
    if (JOptionPane.showConfirmDialog(
        null,"Desea eliminar el usuario "+tId.getText()+"?",
        "Confirma eliminar?",
        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
    { 
      if (Fachada.borrarUsuario(u)) {
        cargarListas();
        limpiarCampos();
      }
      else {
        lInfo.setForeground(new Color(190, 65, 79));
        lInfo.setText("No se pudo eliminar el medio.");           
      }      
    }
  }

}
