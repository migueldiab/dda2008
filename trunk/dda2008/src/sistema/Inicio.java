package sistema;

import java.text.ParseException;
import java.util.ArrayList;
import dominio.*;
import servicios.Fachada;
import servicios.ServiciosUsuarios;
import uiConsola.*;
import utils.I18n;
import vistas.VistaLogin;
import vistas.VistaPrincipal;

public class Inicio {

  public static VistaLogin login = new VistaLogin();
  public static VistaPrincipal principal = new VistaPrincipal();
  /**
   * @param args
   */
  public static void main(String[] args) {
    cargarDatosInicio();
    login.setVisible(true);   

  }

  private static void cargarDatosInicio() {
    
    ArrayList losArticulos = new ArrayList();

    Fachada.agregarMedida(new Medida("kg", "Kilogramo"));
    Fachada.agregarMedida(new Medida("ud", "Unidad"));
    Fachada.agregarMedida(new Medida("da", "Docena"));
    Fachada.agregarMedida(new Medida("co", "Ciento"));
    Fachada.agregarMedida(new Medida("c1", "Caja de 100"));
    
    Articulo unArticulo = new ArticuloSimple("Pintura", new Medida("ud", "Unidad"), 12, 105.34);
    Fachada.agregarArticulo(unArticulo);
    losArticulos.add(unArticulo);
    Item item1=new Item(unArticulo,7);
    
    Articulo unArticulo1 = new ArticuloSimple("Otra Pintura", new Medida("co", "Ciento"), 63, 224.88);
    Fachada.agregarArticulo(unArticulo1);
    losArticulos.add(unArticulo1);
    Item item2=new Item(unArticulo1,3);
    ArrayList items12=new ArrayList();
    
    items12.add(item1);
    items12.add(item2);
    
    Articulo unArticulo2 = new ArticuloSimple("Portland", new Medida("kg", "Kilogramo"), 12, 105.34);
    Fachada.agregarArticulo(unArticulo2);
    losArticulos.add(unArticulo2);
    Item item3=new Item(unArticulo2,4);
    
    Articulo unArticulo3 = new ArticuloSimple("Otro Portland", new Medida("c1", "Ciento"), 23, 84.33);
    Fachada.agregarArticulo(unArticulo3);
    losArticulos.add(unArticulo3);
    Item item4=new Item(unArticulo3,8);
    ArrayList items34=new ArrayList();
    
    items34.add(item3);
    items34.add(item4);
    
    Articulo unArticulo4 = new ArticuloSimple("Ceramica", new Medida("da", "Docena"), 12, 105.34);
    Fachada.agregarArticulo(unArticulo4);
    losArticulos.add(unArticulo4);
    Item item5=new Item(unArticulo4,9);
    
    Articulo unArticulo5 = new ArticuloSimple("Otra Ceramica", new Medida("ud", "Unidad"), 54, 22.15);
    Fachada.agregarArticulo(unArticulo5);
    losArticulos.add(unArticulo5);
    Item item6=new Item(unArticulo5,1);
    ArrayList items56=new ArrayList();
    
    items56.add(item5);
    items56.add(item6);
    
    Articulo unArticuloComp = new ArticuloCompuesto("Tornillo", new Medida("ud", "Unidad"), 12, 105.34);
    unArticuloComp.agregarComponente(new Componente(unArticulo));
    Fachada.agregarArticulo(unArticuloComp);
    
    Articulo unArticuloComp1 = new ArticuloCompuesto("Armario", new Medida("ud", "Unidad"), 8, 317.75);
    unArticuloComp1.agregarComponente(new Componente(unArticulo1));
    unArticuloComp1.agregarComponente(new Componente(unArticuloComp));
    Fachada.agregarArticulo(unArticuloComp1);
    
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
    
    ArticuloCompuesto unArticuloCompuesto = new ArticuloCompuesto("El Compuesto", new Medida("ud", "Unidad"));
    Fachada.agregarArticuloCompuesto(unArticuloCompuesto);
    
    
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
          items12));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba3", 
          I18n.sdf.parse("15/11/2008"),
          unUsuario,
          Presupuesto.EN_CONSTRUCCION,
          items56));
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
