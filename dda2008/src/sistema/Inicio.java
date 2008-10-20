package sistema;

import java.text.ParseException;
import java.util.ArrayList;
import dominio.*;
import servicios.Fachada;
import servicios.ServiciosUsuarios;
import uiConsola.*;
import utils.I18n;

public class Inicio {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    ArrayList losItems = new ArrayList();

    Fachada.agregarMedida(new Medida("kg", "Kilogramo"));
    Fachada.agregarMedida(new Medida("ud", "Unidad"));
    Fachada.agregarMedida(new Medida("da", "Docena"));
    Fachada.agregarMedida(new Medida("co", "Ciento"));
    Fachada.agregarMedida(new Medida("c1", "Caja de 100"));
    
    Articulo unArticulo = new Articulo("Pintura", new Medida("ud", "Unidad"), 12, 105.34);
    Fachada.agregarArticulo(unArticulo);
    losItems.add(unArticulo);
    
    unArticulo = new Articulo("Portland", new Medida("kg", "Kilogramo"), 12, 105.34);
    Fachada.agregarArticulo(unArticulo);
    losItems.add(unArticulo);
    
    unArticulo = new Articulo("Ceramica", new Medida("da", "Docena"), 12, 105.34);
    Fachada.agregarArticulo(unArticulo);
    losItems.add(unArticulo);
    
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
    Usuario unUsuario = new Usuario("gestor", "gestor", unGrupo, "Gestor", "gestor");
    Fachada.agregarUsuario(unUsuario);
    Usuario otroUsuario = new Usuario("AlbertoPerez", "gestor", unGrupo, "Alberto", "Perez");
    Fachada.agregarUsuario(otroUsuario);
    Usuario otro2Usuario = new Usuario("JuanGonzalez", "gestor", unGrupo, "Juan", "Gonzalez");
    Fachada.agregarUsuario(otro2Usuario);
    Usuario otro3Usuario = new Usuario("CarlosGonzalez", "gestor", unGrupo, "Carlos", "Gonzalez");
    Fachada.agregarUsuario(otro3Usuario);
    
    
    
    try
    {
      
      Fachada.agregarPresupuesto(new Presupuesto("Prueba1", 
          I18n.sdf.parse("27/01/2008"),
          unUsuario,
          Presupuesto.EN_CONSTRUCCION,
          losItems));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba2", 
          I18n.sdf.parse("12/01/2008"),
          unUsuario,
          Presupuesto.EN_CONSTRUCCION,
          losItems));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba4", 
          I18n.sdf.parse("10/01/2008"),
          otroUsuario,
          Presupuesto.EN_CONSTRUCCION,
          losItems));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba3", 
          I18n.sdf.parse("15/11/2008"),
          unUsuario,
          Presupuesto.EN_CONSTRUCCION,
          losItems));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba4", 
          I18n.sdf.parse("31/12/2008"),
          otro2Usuario,
          Presupuesto.EN_CONSTRUCCION,
          losItems));
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    

    boolean salir = false;
    while (!salir) {
      UiInicio.login();
      if (ServiciosUsuarios.getUsuarioActual() != null) {
        salir = UiInicio.MenuPrincipal();                 
      }
      else {
        salir = true;
      }
    }

  }

}
