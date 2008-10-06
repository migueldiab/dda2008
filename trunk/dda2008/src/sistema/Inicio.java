package sistema;

import dominio.*;
import servicios.Fachada;
import uiConsola.*;

public class Inicio {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Fachada.agregarMedida(new Medida("kg", "Kilogramo"));
    Fachada.agregarMedida(new Medida("ud", "Unidad"));
    Fachada.agregarMedida(new Medida("da", "Docena"));
    Fachada.agregarMedida(new Medida("co", "Ciento"));
    Fachada.agregarMedida(new Medida("c1", "Caja de 100"));
    Fachada.agregarArticulo(new Articulo("Pintura", new Medida("ud", "Unidad"), 12, 105.34));
    Fachada.agregarArticulo(new Articulo("Portland", new Medida("kg", "Kilogramo"), 12, 105.34));
    Fachada.agregarArticulo(new Articulo("Ceramica", new Medida("da", "Docena"), 12, 105.34));
    
    UiInicio.MenuPrincipal();   

  }

}
