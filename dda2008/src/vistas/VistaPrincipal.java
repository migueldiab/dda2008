package vistas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class VistaPrincipal extends JFrame {

  private static final long serialVersionUID = 1L;

  private JPanel jContentPane = null;

  /**
   * This is the default constructor
   */
  public VistaPrincipal() {
    super();
    initialize();
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(300, 200);
    this.setContentPane(getJContentPane());
    this.setTitle("JFrame");
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

  public static void cargar() {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        VistaPrincipal application = new VistaPrincipal();
        application.getJContentPane().setVisible(true);
      }
    });
   
  }

}
