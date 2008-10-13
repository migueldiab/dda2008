package sistema;

import java.util.ArrayList;

import dominio.*;
import servicios.Fachada;
import servicios.ServiciosUsuarios;
import uiConsola.*;

public class Inicio {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Fachada.agregarMedida(new Medida("kg", "Kilogramo"));
    Fachada.agregarMedida(new Medida("ud", "Unidad"));
    Fachada.agregarMedida(new Medida("da", "Docena"));
    Fachada.agregarMedida(new Medida("co", "Ciento"));
    Fachada.agregarMedida(new Medida("c1", "Caja de 100"));
    Fachada.agregarArticulo(new Articulo("Pintura", new Medida("ud", "Unidad"), 12, 105.34));
    Fachada.agregarArticulo(new Articulo("Portland", new Medida("kg", "Kilogramo"), 12, 105.34));
    Fachada.agregarArticulo(new Articulo("Ceramica", new Medida("da", "Docena"), 12, 105.34));
    
    ArrayList permisos = new ArrayList();
    //permisos.add(Grupo.ADMIN);
    permisos.add(Grupo.USUARIOS);
    permisos.add(Grupo.ARTICULOS);
    permisos.add(Grupo.CAMBIO_DUENIO_PRESUPUESTO);
    permisos.add(Grupo.CONSULTAS);
    Grupo unGrupo = new Grupo("Administradores", permisos);
    Fachada.agregarGrupo(unGrupo);
    Fachada.agregarUsuario(new Usuario("admin", "admin", unGrupo, "Administrador", "Por Defecto"));

    permisos = new ArrayList();
    permisos.add(Grupo.PRESUPUESTOS);
    permisos.add(Grupo.CONSULTAS);
    unGrupo = new Grupo("Gestor", permisos);
    Fachada.agregarGrupo(unGrupo);
    Fachada.agregarUsuario(new Usuario("gestor", "gestor", unGrupo, "Gestor", "Por Defecto"));
    
    boolean salir = false;
    while (!salir) {
      UiInicio.login();
      if (ServiciosUsuarios.usuarioActual != null) {
        salir = UiInicio.MenuPrincipal();                 
      }
      else {
        salir = true;
      }
    }

  }

}
