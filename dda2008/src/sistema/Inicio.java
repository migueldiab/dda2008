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
    login.cargar();   

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
    
    Articulo tabla = new ArticuloSimple("Tabla", new Medida("co", "Ciento"), 10, 224.88);
    Fachada.agregarArticulo(tabla);
    losArticulos.add(tabla);
    Item item2=new Item(tabla,3);
    ArrayList items12=new ArrayList();
    
    items12.add(item1);
    items12.add(item2);
    
    Articulo unArticulo2 = new ArticuloSimple("Portland", new Medida("kg", "Kilogramo"), 12, 105.34);
    Fachada.agregarArticulo(unArticulo2);
    losArticulos.add(unArticulo2);
    Item item3=new Item(unArticulo2,4);
    
    Articulo bisagra = new ArticuloSimple("Bisagra", new Medida("c1", "Ciento"), 85, 84.33);
    Fachada.agregarArticulo(bisagra);
    losArticulos.add(bisagra);
    Item item4=new Item(bisagra,8);
    ArrayList items34=new ArrayList();
    
    items34.add(item3);
    items34.add(item4);
    
    Articulo manija = new ArticuloSimple("Manija", new Medida("da", "Docena"), 12, 105.34);
    Fachada.agregarArticulo(manija);
    losArticulos.add(manija);
    Item item5=new Item(manija,9);
    
    Articulo tornillo = new ArticuloSimple("Tornillo", new Medida("ud", "Unidad"), 125, 22.15);
    Fachada.agregarArticulo(tornillo);
    losArticulos.add(tornillo);
    Item item6=new Item(tornillo,1);
    ArrayList items56=new ArrayList();
    
    items56.add(item5);
    items56.add(item6);
    
    Articulo puerta = new ArticuloCompuesto("Puerta", new Medida("ud", "Unidad"));
    puerta.agregarComponente(new Componente(tornillo,17));
    puerta.agregarComponente(new Componente(bisagra,4));
    puerta.agregarComponente(new Componente(manija,2));
    Fachada.agregarArticulo(puerta);
    
    Articulo cajon = new ArticuloCompuesto("Cajon", new Medida("ud", "Unidad"));
    cajon.agregarComponente(new Componente(tornillo,6));
    cajon.agregarComponente(new Componente(bisagra,4));
    Fachada.agregarArticulo(cajon);
    
    
    Articulo armario = new ArticuloCompuesto("Armario", new Medida("ud", "Unidad"));
    armario.agregarComponente(new Componente(tabla,3));
    armario.agregarComponente(new Componente(puerta,2));
    armario.agregarComponente(new Componente(cajon,4));
    Fachada.agregarArticulo(armario);
    
    ArrayList itemsArmario=new ArrayList();
    Item elItemArmario=new Item(armario,2);//2 armarios
    itemsArmario.add(elItemArmario);
    
    
    
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
          itemsArmario));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba2", 
          I18n.sdf.parse("12/01/2008"),
          unUsuario,
          Presupuesto.EN_CONSTRUCCION,
          itemsArmario));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba4", 
          I18n.sdf.parse("10/01/2008"),
          otroUsuario,
          Presupuesto.EN_CONSTRUCCION,
          itemsArmario));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba3", 
          I18n.sdf.parse("15/11/2008"),
          unUsuario,
          Presupuesto.EN_CONSTRUCCION,
          null));
      Fachada.agregarPresupuesto(new Presupuesto("Prueba5", 
          I18n.sdf.parse("31/12/2008"),
          otro2Usuario,
          Presupuesto.EN_CONSTRUCCION,
          null));
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    
    
  }

}
