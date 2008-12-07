package vistas;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTextPane;

import dominio.Presupuesto;

import servicios.Fachada;
import utils.Consola;
import utils.I18n;

public class VistaListado extends JDialog {

  private static final long serialVersionUID = 1L;
  private JDialog dListados = null;  //  @jve:decl-index=0:visual-constraint="132,10"
  private JPanel jContentPane = null;
  private JTextPane tListado = null;


  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      jContentPane = new JPanel();
      jContentPane.setLayout(new BorderLayout());
      jContentPane.add(getTListado(), BorderLayout.CENTER);
    }
    return jContentPane;
  }

  /**
   * This method initializes tListado	
   * 	
   * @return javax.swing.JTextPane	
   */
  private JTextPane getTListado() {
    if (tListado == null) {
      tListado = new JTextPane();
      tListado.setEnabled(false);
      mostrarListado();
    }
    return tListado;
  }
  private void mostrarListado() {
    //tListado.setText(Fachada.listadoPresupuestos());
    ArrayList losPresupuestos=new ArrayList();
    if(Fachada.getUsuarioActual().getGrupo().toString().equals("Gestor"))    {
      losPresupuestos=Fachada.obtenerPresupuestos(Fachada.getUsuarioActual(), 1, 1, 1);
    }
    else {
      losPresupuestos = Fachada.obtenerPresupuestos(null, 1, 1, 1);
    }
    for (Object o : losPresupuestos) {
      Presupuesto unPresupuesto = (Presupuesto) o;
      
      tListado.setText(tListado.getText()+"\n"+unPresupuesto.toString());
      for (Object i : unPresupuesto.getItems()) {
        tListado.setText(tListado.getText()+"\n"+i.toString());
      }
          
    }
  }

  public JDialog getDListados() {
    if (dListados == null) {
      dListados = new JDialog();
      dListados.setBounds(new Rectangle(0, 0, 500, 290));
      dListados.setContentPane(getJContentPane());
      dListados.setTitle("Listado");
    }
    return dListados;
  }

}  //  @jve:decl-index=0:visual-constraint="10,10"
