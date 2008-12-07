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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.sun.org.apache.bcel.internal.util.JavaWrapper;

import dominio.Grupo;

import servicios.Fachada;
import sistema.Inicio;
import utils.I18n;
import java.awt.Dimension;

public class VistaPrincipal {


    private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="10,10"

	  private JPanel jContentPane = null;
	  private JMenuBar jJMenuBar = null;
	  private JMenu fileMenu = null;
    private JMenuItem cambiarUsuarioMenuItem = null;
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
    private JMenuItem articulosCompuestosMenuItem = null;
	  private JMenuItem medidasMenuItem = null;
    private JMenuItem presupuestosMenuItem = null;
    private JMenuItem monitorStockMenuItem = null;

	  private JMenu listadosMenu = null;
	  private JMenuItem listadoPresupuestosMenuItem = null;
	  private JMenuItem listado2MenuItem = null;
	  private JMenuItem listado3MenuItem = null;

	  private JMenu helpMenu = null;
	  private JMenuItem aboutMenuItem = null;
	  //private JMenuItem saveMenuItem = null;
	  private JDialog aboutDialog = null;
	  private JPanel aboutContentPane = null;
	  private JLabel aboutVersionLabel = null;

    private JDialog dUsuario = null; 
    private JDialog dGrupo = null; 
    private JDialog dArticulos = null; 
    private JDialog dArticulosCompuestos = null; 
    private JDialog dMedidas = null; 
    public static JDialog dPresupuesto = null; 
    private JDialog dMontitorStock = null;
    private JDialog dFinalizarPresupuesto = null;
    private JDialog dCopiarPresupuesto = null;
    private JDialog dCambioDuenio = null;
    private JDialog dMonitorStock = null;
    private JMenuItem finalizarMenuItem = null;

	private JMenuItem copiarMenuItem = null;

	private JMenuItem cambioDuenioMenuItem = null; 
	ModeloPresupuesto modeloPresupuesto=new ModeloPresupuesto();  //  @jve:decl-index=0:
	
	
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
	      fileMenu.add(getCambiarUsuarioMenuItem());
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
	      editMenu.setText("Edición");
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
	        	  VistaUsuarios guiUsuario = new VistaUsuarios();
	            dUsuario = guiUsuario.getDAbmUsuarios();
	            dUsuario.pack();
	            Point loc = getJFrame().getLocation();
	            loc.translate(20, 20);
	            dUsuario.setLocation(loc);
	            dUsuario.setBounds(10,10,500,290);
	            dUsuario.setVisible(true);            
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
			  operacionesMenu.setPreferredSize(new Dimension(85, 21));
			  operacionesMenu.add(getArticulosMenuItem());
			  operacionesMenu.add(getArticulosCompuestosMenuItem());
			  operacionesMenu.add(getMedidasMenuItem());
			  operacionesMenu.add(getPrespuestosMenuItem());  
			  operacionesMenu.add(getFinalizarMenuItem());
			  operacionesMenu.add(getCopiarMenuItem());
			  operacionesMenu.add(getMonitorStockMenuItem());
			  operacionesMenu.add(getCambioDuenioMenuItem());
		  }
		  return operacionesMenu;
	  }
	  private JMenuItem getArticulosMenuItem() {
	    if (articulosMenuItem == null) {
	      articulosMenuItem = new JMenuItem();
	      articulosMenuItem.setText(I18n.ARTICULOS);
	      articulosMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
            
            if(Fachada.getUsuarioActual().getGrupo().tienePermiso(Grupo.ARTICULOS)) {

              if (dArticulos == null) {
              VistaArticulos guiArticulo = new VistaArticulos();
                dArticulos = guiArticulo.getDAbmArticulos();
                dArticulos.pack();
                Point loc = getJFrame().getLocation();
                loc.translate(20, 20);
                dArticulos.setLocation(loc);
                dArticulos.setBounds(10,10,500,290);
                dArticulos.setVisible(true);            
              }
              else {
                dArticulos.setVisible(true);
              }
            }
            else {
              JOptionPane.showInternalMessageDialog(Inicio.principal.jContentPane, "No tiene permisos para acceder a esta área");
            }
	        }
	      });
	    }
	    return articulosMenuItem;
	  }
    private JMenuItem getArticulosCompuestosMenuItem() {
      if (articulosCompuestosMenuItem == null) {
        articulosCompuestosMenuItem = new JMenuItem();
        articulosCompuestosMenuItem.setText(I18n.ARTICULOS_COMPUESTOS);
        articulosCompuestosMenuItem.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            
            if(Fachada.getUsuarioActual().getGrupo().tienePermiso(Grupo.ARTICULOS)) {
              if (dArticulosCompuestos == null) {
                VistaArticulosCompuestos guiArticuloCompuesto = new VistaArticulosCompuestos();
                dArticulosCompuestos = guiArticuloCompuesto.getDAbmArticulosCompuestos();
                dArticulosCompuestos.pack();
                Point loc = getJFrame().getLocation();
                loc.translate(20, 20);
                dArticulosCompuestos.setLocation(loc);
                dArticulosCompuestos.setBounds(10,10,660,420);
                dArticulosCompuestos.setVisible(true);            
              }
              else {
                dArticulosCompuestos.setVisible(true);
              }                    

            }
            else {
              JOptionPane.showInternalMessageDialog(Inicio.principal.jContentPane, "No tiene permisos para acceder a esta área");
            }
          }
        });
      }
      return articulosCompuestosMenuItem;
    }    
	  private JMenuItem getMedidasMenuItem() {
	    if (medidasMenuItem == null) {
	      medidasMenuItem = new JMenuItem();
	      medidasMenuItem.setText(I18n.MEDIDAS);
	      medidasMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
            if(Fachada.getUsuarioActual().getGrupo().tienePermiso(Grupo.MEDIDAS)) {

            }
            else {
              JOptionPane.showInternalMessageDialog(Inicio.principal.jContentPane, "No tiene permisos para acceder a esta área");
            }
	          
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
            if(Fachada.getUsuarioActual().getGrupo().tienePermiso(Grupo.PRESUPUESTOS)) {
              if (dPresupuesto == null) {
                VistaPresupuestos guiPresupuestos = new VistaPresupuestos(modeloPresupuesto);
                dPresupuesto = guiPresupuestos.getJDialogPresupuestos();
                dPresupuesto.pack();
                Point loc = getJFrame().getLocation();
                loc.translate(20, 20);
                dPresupuesto.setLocation(loc);
                dPresupuesto.setBounds(10,10,704,474);
                dPresupuesto.setVisible(true);            
              }
              else {
                dPresupuesto.setVisible(true);
              }                    

            }
            else {
              JOptionPane.showInternalMessageDialog(Inicio.principal.jContentPane, "No tiene permisos para acceder a esta área");
            }
	        }
	      });
	    }
	    return presupuestosMenuItem;
	  }
	  private JMenuItem getMonitorStockMenuItem() {
		  if (monitorStockMenuItem == null) {
			  monitorStockMenuItem = new JMenuItem();
			  monitorStockMenuItem.setText(I18n.MONITOR_STOCK);
			  monitorStockMenuItem.addActionListener(new ActionListener() {   
				  public void actionPerformed(java.awt.event.ActionEvent e) {    
					  if (dMonitorStock == null) { 
						  VistaMonitorStock guiMonitorStock = new VistaMonitorStock();
						  dMonitorStock = guiMonitorStock.getJDialog();
						  dMonitorStock.pack();
						  Point loc = getJFrame().getLocation();
						  loc.translate(20, 20);
						  dMonitorStock.setLocation(loc);
						  dMonitorStock.setBounds(10,10,704,474);
						  dMonitorStock.setVisible(true);            
					  }
					  else {
						  dMonitorStock.setVisible(true);
					  }                  
				  }

			  });
		  }
		  return monitorStockMenuItem;
	  }    
    
	  private JMenu getListadosMenu() {
	    if (listadosMenu == null) {
	      listadosMenu = new JMenu();
	      listadosMenu.setText("Listados");
	      listadosMenu.add(getListadoPresupuestosMenuItem());
	      listadosMenu.add(getListado2MenuItem());
	      listadosMenu.add(getListado3MenuItem());
	    }
	    return listadosMenu;
	  }
	  private JMenuItem getListadoPresupuestosMenuItem() {
	    if (listadoPresupuestosMenuItem == null) {
        listadoPresupuestosMenuItem = new JMenuItem();
        listadoPresupuestosMenuItem.setText(I18n.PRESUPUESTOS);
        listadoPresupuestosMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          
	        }
	      });
	    }
	    return listadoPresupuestosMenuItem;
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
    private JMenuItem getCambiarUsuarioMenuItem() {
      if (cambiarUsuarioMenuItem == null) {
        cambiarUsuarioMenuItem = new JMenuItem();
        cambiarUsuarioMenuItem.setText("Cambiar Usuario");
        cambiarUsuarioMenuItem.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Inicio.login.cargar();  
            //vistas.VistaPrincipal.cerrar();
            Inicio.principal.cerrar();
          }
        });
      }
      return cambiarUsuarioMenuItem;
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
	      aboutVersionLabel.setText("Versión 1.0");
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
	    sistema.Inicio.principal.getJFrame().setVisible(true);
	  }
    public void cerrar() {
      sistema.Inicio.principal.jFrame.dispose();
      
    }

	/**
	 * This method initializes finalizarMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getFinalizarMenuItem() {
		if (finalizarMenuItem == null) {
			finalizarMenuItem = new JMenuItem();
			finalizarMenuItem.setText("Finalizar Presupuesto");
			finalizarMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					   if (dFinalizarPresupuesto == null) {
				            VistaFinalizacionPresupuesto guiFinalizarPresupuesto = new VistaFinalizacionPresupuesto(modeloPresupuesto);
				            dFinalizarPresupuesto = guiFinalizarPresupuesto.getJDialog();
				            dFinalizarPresupuesto.pack();
				              Point loc = getJFrame().getLocation();
				              loc.translate(20, 20);
				              dFinalizarPresupuesto.setLocation(loc);
				              dFinalizarPresupuesto.setBounds(10,10,625,516);
				              dFinalizarPresupuesto.setVisible(true);            
				            }
				            else {
				            	dFinalizarPresupuesto.setVisible(true);
				            }	
				}
			});
		}
		return finalizarMenuItem;
	}

	/**
	 * This method initializes copiarMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCopiarMenuItem() {
		if (copiarMenuItem == null) {
			copiarMenuItem = new JMenuItem();
			copiarMenuItem.setText("Copiar Presupuesto");
			copiarMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (dCopiarPresupuesto == null) {
			            VistaCopiaPresupuesto guiCopiaPresupuesto = new VistaCopiaPresupuesto(modeloPresupuesto);
			            dCopiarPresupuesto = guiCopiaPresupuesto.getJDialog();
			            dCopiarPresupuesto.pack();
			              Point loc = getJFrame().getLocation();
			              loc.translate(20, 20);
			              dCopiarPresupuesto.setLocation(loc);
			              dCopiarPresupuesto.setBounds(10,10,625,516);
			              dCopiarPresupuesto.setVisible(true);            
			            }
			            else {
			            	dCopiarPresupuesto.setVisible(true);
			            }	
				}
			});
		}
		return copiarMenuItem;
	}

	/**
	 * This method initializes cambioDuenioMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCambioDuenioMenuItem() {
		if (cambioDuenioMenuItem == null) {
			cambioDuenioMenuItem = new JMenuItem();
			cambioDuenioMenuItem.setText("Cambiar Dueño");
			cambioDuenioMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (dCambioDuenio == null) {
			            VistaCambioDuenio guiCambioDuenio = new VistaCambioDuenio(modeloPresupuesto);
			            dCambioDuenio = guiCambioDuenio.getJDialog();
			            dCambioDuenio.pack();
			              Point loc = getJFrame().getLocation();
			              loc.translate(20, 20);
			              dCambioDuenio.setLocation(loc);
			              dCambioDuenio.setBounds(10,10,625,516);
			              dCambioDuenio.setVisible(true);            
			            }
			            else {
			            	dCambioDuenio.setVisible(true);
			            }	
				}
			});
		}
		return cambioDuenioMenuItem;
	}
}
