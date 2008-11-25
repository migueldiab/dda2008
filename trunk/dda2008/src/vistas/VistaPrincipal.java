package vistas;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import utils.I18n;

public class VistaPrincipal {

	  private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="10,10"

	  private JPanel jContentPane = null;
	  private JMenuBar jJMenuBar = null;
	  private JMenu fileMenu = null;
	  private JMenuItem exitMenuItem = null;
	  private JMenu editMenu = null;
	  private JMenuItem cutMenuItem = null;
	  private JMenuItem copyMenuItem = null;
	  private JMenuItem pasteMenuItem = null;
	  private JMenu adminMenu = null;
	  private JMenuItem usuariosMenuItem = null;
	  private JMenuItem gruposMenuItem = null;
	  

	  private JMenu operacionesMenu = null;
	  private JMenuItem articulosMenuItem = null;
	  private JMenuItem medidasMenuItem = null;
	  private JMenuItem presupuestosMenuItem = null;

	  private JMenu listadosMenu = null;
	  private JMenuItem listado1MenuItem = null;
	  private JMenuItem listado2MenuItem = null;
	  private JMenuItem listado3MenuItem = null;

	  private JMenu helpMenu = null;
	  private JMenuItem aboutMenuItem = null;
	  //private JMenuItem saveMenuItem = null;
	  private JDialog aboutDialog = null;
	  private JPanel aboutContentPane = null;
	  private JLabel aboutVersionLabel = null;

	  private JDialog dUsuario = null; 
	  /**
	   * This method initializes jFrame
	   * 
	   * @return javax.swing.JFrame
	   */
	  private JFrame getJFrame() {
	    if (jFrame == null) {
	      jFrame = new JFrame();
	      jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      jFrame.setJMenuBar(getJJMenuBar());
	      jFrame.setSize(800, 600);
	      jFrame.setContentPane(getJContentPane());
	      jFrame.setTitle("Sistema de Gestion de Presupuestos");
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
	      jContentPane = new JPanel();
	      jContentPane.setLayout(new BorderLayout());
	    }
	    return jContentPane;
	  }

	  /**
	   * This method initializes jJMenuBar	
	   * 	
	   * @return javax.swing.JMenuBar	
	   */
	  private JMenuBar getJJMenuBar() {
	    if (jJMenuBar == null) {
	      jJMenuBar = new JMenuBar();
	      jJMenuBar.add(getFileMenu());
	      jJMenuBar.add(getEditMenu());
	      jJMenuBar.add(getAdminMenu());
	      jJMenuBar.add(getOperacionesMenu());
	      jJMenuBar.add(getListadosMenu());
	      jJMenuBar.add(getHelpMenu());
	    }
	    return jJMenuBar;
	  }

	  /**
	   * This method initializes jMenu	
	   * 	
	   * @return javax.swing.JMenu	
	   */
	  private JMenu getFileMenu() {
	    if (fileMenu == null) {
	      fileMenu = new JMenu();
	      fileMenu.setText("Archivo");
	      //fileMenu.add(getSaveMenuItem());
	      fileMenu.add(getExitMenuItem());
	    }
	    return fileMenu;
	  }

	  /**
	   * This method initializes jMenu	
	   * 	
	   * @return javax.swing.JMenu	
	   */
	  private JMenu getEditMenu() {
	    if (editMenu == null) {
	      editMenu = new JMenu();
	      editMenu.setText("Edici�n");
	      editMenu.add(getCutMenuItem());
	      editMenu.add(getCopyMenuItem());
	      editMenu.add(getPasteMenuItem());
	    }
	    return editMenu;
	  }

	  private JMenu getAdminMenu() {
	    if (adminMenu == null) {
	      adminMenu = new JMenu();
	      adminMenu.setText("Administrar");
	      adminMenu.add(getUsuariosMenuItem());
	      adminMenu.add(getGruposMenuItem());
	    }
	    return adminMenu;
	  }
	  private JMenuItem getUsuariosMenuItem() {
	    if (usuariosMenuItem == null) {
	      usuariosMenuItem = new JMenuItem();
	      usuariosMenuItem.setText("Usuarios");
	      usuariosMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          
	          if (dUsuario == null) {
	            /*gUsuarios guiUsuario = new gUsuarios();
	            dUsuario = guiUsuario.getDAbmUsuarios();
	            dUsuario.pack();
	            Point loc = getJFrame().getLocation();
	            loc.translate(20, 20);
	            dUsuario.setLocation(loc);
	            dUsuario.setBounds(10,10,350,300);
	            dUsuario.setVisible(true);*/            
	          }
	          else {
	            dUsuario.setVisible(true);
	          }
	          
	        }
	      });
	    }
	    return usuariosMenuItem;
	  }
	  private JMenuItem getGruposMenuItem() {
	    if (gruposMenuItem == null) {
	      gruposMenuItem = new JMenuItem();
	      gruposMenuItem.setText("Grupos");
	      gruposMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          
	        }
	      });
	    }
	    return gruposMenuItem;
	  }
	  
	  private JMenu getOperacionesMenu() {
	    if (operacionesMenu == null) {
	      operacionesMenu = new JMenu();
	      operacionesMenu.setText("Operaciones");
	      operacionesMenu.add(getArticulosMenuItem());
	      operacionesMenu.add(getMedidasMenuItem());
	      operacionesMenu.add(getPrespuestosMenuItem());
	    }
	    return operacionesMenu;
	  }
	  private JMenuItem getArticulosMenuItem() {
	    if (articulosMenuItem == null) {
	      articulosMenuItem = new JMenuItem();
	      articulosMenuItem.setText(I18n.ARTICULOS);
	      articulosMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          
	        }
	      });
	    }
	    return articulosMenuItem;
	  }
	  private JMenuItem getMedidasMenuItem() {
	    if (medidasMenuItem == null) {
	      medidasMenuItem = new JMenuItem();
	      medidasMenuItem.setText(I18n.MEDIDAS);
	      medidasMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          
	        }
	      });
	    }
	    return medidasMenuItem;
	  }
	  private JMenuItem getPrespuestosMenuItem() {
	    if (presupuestosMenuItem == null) {
	      presupuestosMenuItem = new JMenuItem();
	      presupuestosMenuItem.setText(I18n.PRESUPUESTOS);
	      presupuestosMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          
	        }
	      });
	    }
	    return presupuestosMenuItem;
	  }
	  private JMenu getListadosMenu() {
	    if (listadosMenu == null) {
	      listadosMenu = new JMenu();
	      listadosMenu.setText("Listados");
	      listadosMenu.add(getListado1MenuItem());
	      listadosMenu.add(getListado2MenuItem());
	      listadosMenu.add(getListado3MenuItem());
	    }
	    return listadosMenu;
	  }
	  private JMenuItem getListado1MenuItem() {
	    if (listado1MenuItem == null) {
	      listado1MenuItem = new JMenuItem();
	      listado1MenuItem.setText("L1");
	      listado1MenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          
	        }
	      });
	    }
	    return listado1MenuItem;
	  }
	  private JMenuItem getListado2MenuItem() {
	    if (listado2MenuItem == null) {
	      listado2MenuItem = new JMenuItem();
	      listado2MenuItem.setText("L2");
	      listado2MenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          
	        }
	      });
	    }
	    return listado2MenuItem;
	  }
	  private JMenuItem getListado3MenuItem() {
	    if (listado3MenuItem == null) {
	      listado3MenuItem = new JMenuItem();
	      listado3MenuItem.setText("L3");
	      listado3MenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          
	        }
	      });
	    }
	    return listado3MenuItem;
	  }  
	  /**
	   * This method initializes jMenu	
	   * 	
	   * @return javax.swing.JMenu	
	   */
	  private JMenu getHelpMenu() {
	    if (helpMenu == null) {
	      helpMenu = new JMenu();
	      helpMenu.setText("Ayuda");
	      helpMenu.add(getAboutMenuItem());
	    }
	    return helpMenu;
	  }
	  /**
	   * This method initializes jMenuItem	
	   * 	
	   * @return javax.swing.JMenuItem	
	   */
	  private JMenuItem getExitMenuItem() {
	    if (exitMenuItem == null) {
	      exitMenuItem = new JMenuItem();
	      exitMenuItem.setText("Salir");
	      exitMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          System.exit(0);
	        }
	      });
	    }
	    return exitMenuItem;
	  }
	  /**
	   * This method initializes jMenuItem	
	   * 	
	   * @return javax.swing.JMenuItem	
	   */
	  private JMenuItem getAboutMenuItem() {
	    if (aboutMenuItem == null) {
	      aboutMenuItem = new JMenuItem();
	      aboutMenuItem.setText("Acerca de");
	      aboutMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          JDialog aboutDialog = getAboutDialog();
	          aboutDialog.pack();
	          Point loc = getJFrame().getLocation();
	          loc.translate(20, 20);
	          aboutDialog.setLocation(loc);
	          aboutDialog.setVisible(true);
	        }
	      });
	    }
	    return aboutMenuItem;
	  }

	  /**
	   * This method initializes aboutDialog	
	   * 	
	   * @return javax.swing.JDialog
	   */
	  private JDialog getAboutDialog() {
	    if (aboutDialog == null) {
	      aboutDialog = new JDialog(getJFrame(), true);
	      aboutDialog.setTitle("Acerca de");
	      aboutDialog.setContentPane(getAboutContentPane());
	    }
	    return aboutDialog;
	  }

	  /**
	   * This method initializes aboutContentPane
	   * 
	   * @return javax.swing.JPanel
	   */
	  private JPanel getAboutContentPane() {
	    if (aboutContentPane == null) {
	      aboutContentPane = new JPanel();
	      aboutContentPane.setLayout(new BorderLayout());
	      aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
	    }
	    return aboutContentPane;
	  }

	  /**
	   * This method initializes aboutVersionLabel	
	   * 	
	   * @return javax.swing.JLabel	
	   */
	  private JLabel getAboutVersionLabel() {
	    if (aboutVersionLabel == null) {
	      aboutVersionLabel = new JLabel();
	      aboutVersionLabel.setText("Versi�n 1.0");
	      aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    }
	    return aboutVersionLabel;
	  }

	  /**
	   * This method initializes jMenuItem	
	   * 	
	   * @return javax.swing.JMenuItem	
	   */
	  private JMenuItem getCutMenuItem() {
	    if (cutMenuItem == null) {
	      cutMenuItem = new JMenuItem();
	      cutMenuItem.setText("Cortar");
	      cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
	          Event.CTRL_MASK, true));
	    }
	    return cutMenuItem;
	  }

	  /**
	   * This method initializes jMenuItem	
	   * 	
	   * @return javax.swing.JMenuItem	
	   */
	  private JMenuItem getCopyMenuItem() {
	    if (copyMenuItem == null) {
	      copyMenuItem = new JMenuItem();
	      copyMenuItem.setText("Copiar");
	      copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
	          Event.CTRL_MASK, true));
	    }
	    return copyMenuItem;
	  }

	  /**
	   * This method initializes jMenuItem	
	   * 	
	   * @return javax.swing.JMenuItem	
	   */
	  private JMenuItem getPasteMenuItem() {
	    if (pasteMenuItem == null) {
	      pasteMenuItem = new JMenuItem();
	      pasteMenuItem.setText("Pegar");
	      pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
	          Event.CTRL_MASK, true));
	    }
	    return pasteMenuItem;
	  }

	  /**
	   * This method initializes jMenuItem	
	   * 	
	   * @return javax.swing.JMenuItem	
	   */
	  /*
	  private JMenuItem getSaveMenuItem() {
	    if (saveMenuItem == null) {
	      saveMenuItem = new JMenuItem();
	      saveMenuItem.setText("Save");
	      saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
	          Event.CTRL_MASK, true));
	    }
	    return saveMenuItem;
	  }
	  */

	  public static void cargar() {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        VistaPrincipal application = new VistaPrincipal();
	        application.getJFrame().setVisible(true);
	      }
	    });
	  }

}