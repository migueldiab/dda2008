package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import servicios.Fachada;
import servicios.ServiciosUsuarios;
import sistema.Inicio;
import utils.I18n;
import utils.MultiLineLabelUI;
import java.awt.Rectangle;


public class VistaLogin extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	private JTextField tUsuario = null;

  private JPasswordField tClave = null;
  private JButton bLogin = null;
  private JLabel jLabel = null;
  private JLabel lPassword = null;
  private JLabel lError = null;	

	/**
	 * @param owner
	 */
	public VistaLogin() {
		super();
		initialize();
		//VistaPrincipal.cargar();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(250, 180);
		this.setContentPane(getJContentPane());
		this.setTitle("Acceso a Sistema de Presupuestos");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	}

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      lError = new JLabel();
      lError.setBounds(new Rectangle(25, 4, 194, 41));
      
      lError.setForeground(new Color(200,10,10));
      lError.setUI(new MultiLineLabelUI());

      lPassword = new JLabel();      
      lPassword.setBounds(new Rectangle(25, 72, 60, 20));
      lPassword.setText("Clave");
      jLabel = new JLabel();
      jLabel.setBounds(new Rectangle(25, 42, 60, 20));
      jLabel.setText("Usuario");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(getTUsuario(), null);
      jContentPane.add(getTClave(), null);
      jContentPane.add(getBLogin(), null);
      jContentPane.add(jLabel, null);
      jContentPane.add(lPassword, null);
      jContentPane.add(lError, null);
    }
    return jContentPane;
  }

  /**
   * This method initializes tUsuario 
   *  
   * @return javax.swing.JTextField 
   */
  private JTextField getTUsuario() {
    if (tUsuario == null) {
      tUsuario = new JTextField();
      tUsuario.setBounds(new Rectangle(90, 42, 110, 20));
      tUsuario.setText("");
    }
    return tUsuario;
  }

  /**
   * This method initializes tClave 
   *  
   * @return javax.swing.JPasswordField 
   */
  private JPasswordField getTClave() {
    if (tClave == null) {
      tClave = new JPasswordField();
      tClave.setBounds(new Rectangle(90, 72, 110, 20));
    }
    return tClave;
  }

  /**
   * This method initializes bLogin 
   *  
   * @return javax.swing.JButton  
   */
  private JButton getBLogin() {
    if (bLogin == null) {
      bLogin = new JButton();
      bLogin.setBounds(new Rectangle(90, 102, 110, 30));
      bLogin.setText("Login");
      bLogin.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          int intentos = ServiciosUsuarios.MAX_LOGIN;
          if (!Fachada.vistaLogin(tUsuario.getText(), tClave.getPassword())) {
            lError.setText(I18n.NUMERO_INTENTOS + intentos);
            intentos--;
          } 
          else {
            VistaPrincipal.cargar();            
            lError.setText("");
            Inicio.ventana.setVisible(false);
          }
          
            
        }
      });
      bLogin.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
        }
      });
    }
    
    
    return bLogin;
  }
}
