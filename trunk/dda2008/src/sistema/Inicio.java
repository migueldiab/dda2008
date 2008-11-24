package sistema;

import java.text.ParseException;
import java.util.ArrayList;
import dominio.*;
import servicios.Fachada;
import servicios.ServiciosUsuarios;
import uiConsola.*;
import utils.I18n;
import vistas.VistaLogin;

public class Inicio {

  public static VistaLogin ventana = new VistaLogin();
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    cargarDatosInicio();
    ventana.setVisible(true);   

  }

  private static void cargarDatosInicio() {
    
    ArrayList losArticulos = new ArrayList();

    Fachada.agregarMedida(new Medida("kg", "Kilogramo"));
    Fachada.agregarMedida(new Medida("ud", "Unidad"));
    Fachada.agregarMedida(new Medida("da", "Docena"));
    Fachada.agregarMedida(new Medida("co", "Ciento"));
    Fachada.agregarMedida(new Medida("c1", "Caja de 100"));
    
    Articulo unArticulo = new Articulo("Pintura", new Medida("ud", "Unidad"), 12, 105.34);
    Fachada.agregarArticulo(unArticulo);
    losArticulos.add(unArticulo);
    Item item1=new Item(unArticulo,7);
    
    Articulo unArticulo1 = new Articulo("Otra Pintura", new Medida("co", "Ciento"), 63, 224.88);
    Fachada.agregarArticulo(unArticulo1);
    losArticulos.add(unArticulo1);
    Item item2=new Item(unArticulo1,3);
    ArrayList items12=new ArrayList();
    
    items12.add(item1);
    items12.add(item2);
    
    unArticulo = new Articulo("Portland", new Medida("kg", "Kilogramo"), 12, 105.34);
    Fachada.agregarArticulo(unArticulo);
    losArticulos.add(unArticulo);
    Item item3=new Item(unArticulo,4);
    
    unArticulo = new Articulo("Otro Portland", new Medida("c1", "Ciento"), 23, 84.33);
    Fachada.agregarArticulo(unArticulo);
    losArticulos.add(unArticulo);
    Item item4=new Item(unArticulo,8);
    ArrayList items34=new ArrayList();
    
    items34.add(item3);
    items34.add(item4);
    
    unArticulo = new Articulo("Ceramica", new Medida("da", "Docena"), 12, 105.34);
    Fachada.agregarArticulo(unArticulo);
    losArticulos.add(unArticulo);
    Item item5=new Item(unArticulo,9);
    
    unArticulo = new Articulo("Otra Ceramica", new Medida("ud", "Unidad"), 54, 22.15);
    Fachada.agregarArticulo(unArticulo);
    losArticulos.add(unArticulo);
    Item item6=new Item(unArticulo,1);
    ArrayList items56=new ArrayList();
    
    items56.add(item5);
    items56.add(item6);
    
    
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
          items12));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba2", 
          I18n.sdf.parse("12/01/2008"),
          unUsuario,
          Presupuesto.EN_CONSTRUCCION,
          items34));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba4", 
          I18n.sdf.parse("10/01/2008"),
          otroUsuario,
          Presupuesto.EN_CONSTRUCCION,
          items56));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba3", 
          I18n.sdf.parse("15/11/2008"),
          unUsuario,
          Presupuesto.EN_CONSTRUCCION,
          items12));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba5", 
          I18n.sdf.parse("31/12/2008"),
          otro2Usuario,
          Presupuesto.EN_CONSTRUCCION,
          items56));
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    
    
  }

}
