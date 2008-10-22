package uiConsola;

import java.util.ArrayList;

import dominio.Articulo;
import dominio.Medida;
import dominio.Presupuesto;
import servicios.Fachada;
import utils.Consola;
import utils.I18n;

public class UiArticulo
{

  public static void agregarArticulo()
  {
    String nombre = "";
    int cantidad = 0;
    double costo = 0;
    int posMedida = 0;
    Medida medida = null;
    nombre = Consola.leer(I18n.NOMBRE + ": ");
    ArrayList medidas = Fachada.listaMedidas();
    
    posMedida = Consola.menu(medidas);
    medida = (Medida) medidas.get(posMedida);
    cantidad = Consola.leerInt(I18n.CANTIDAD + " : ");
    costo = Consola.leerDouble(I18n.COSTO + " : ");
    Articulo unArticulo = new Articulo(nombre, medida, cantidad, costo);
    if (Fachada.agregarArticulo(unArticulo)) {
      Consola.println(I18n.INGRESO_OK);
      Consola.leer(I18n.PRESIONE_ENTER);
    }
    else {
      Consola.println(I18n.ERROR);
      Consola.leer(I18n.PRESIONE_ENTER);
    }
  }

  public static void borrarArticulo()
  {
    // TODO Auto-generated method stub
   ArrayList articulos = Fachada.listadoArticulos();
   if (articulos.isEmpty()) {
     Consola.println(I18n.LISTA_VACIA);
     Consola.leer(I18n.PRESIONE_ENTER);
   }
   else {
     int posArticulo = Consola.menu(articulos);
     String confirma = Consola.leer(I18n.CONFIRMA_ELIMINAR);
     if (confirma.toUpperCase().equals(I18n.SI.toUpperCase()))
       if (Fachada.borrarArticulo((Articulo) articulos.get(posArticulo))) {
         Consola.println(I18n.BORRADO_OK);
         Consola.leer(I18n.PRESIONE_ENTER);
       }
       else {
         Consola.println(I18n.ERROR);
         Consola.leer(I18n.PRESIONE_ENTER);
       }
   }
  }

  public static void modificarArticulo()
  {
    ArrayList articulos = Fachada.listadoArticulos();
    if (articulos.isEmpty()) {
      Consola.println(I18n.LISTA_VACIA);
      Consola.leer(I18n.PRESIONE_ENTER);
    }
    else {
      int posArticulo = Consola.menu(articulos);
      Articulo original = (Articulo) articulos.get(posArticulo);
      String nombre = "";
      int cantidad = 0;
      double costo = 0;
      int posMedida = 0;
      Medida medida = null;
      
      nombre = Consola.modificar(I18n.NOMBRE, original.getNombre());
      ArrayList medidas = Fachada.listaMedidas();
      posMedida = Consola.menu(medidas);
      medida = (Medida) medidas.get(posMedida);
      cantidad = Consola.modificarInt(I18n.CANTIDAD, original.getCantidad());
      costo = Consola.modificarDouble(I18n.COSTO, original.getCosto());

      if (original.getCosto() != costo) {
        ArrayList presupuestos = new ArrayList();
        presupuestos = Fachada.obtenerPresupuestoPorArticuloEstadoConFecha(original, Presupuesto.EN_CONSTRUCCION);
        if (presupuestos.size() > 0) {
          Consola.println("El articulo se encuentra en los siguientes presupuestos "+Presupuesto.EN_CONSTRUCCION+" : ");
          Consola.listado(presupuestos);
        }
      }
      String confirma = Consola.leer(I18n.CONFIRMA_MODIFICAR);
      if (confirma.toUpperCase().equals(I18n.SI.toUpperCase()))
      {
        if (Fachada.modificarArticulo(original,nombre, medida, cantidad, costo)) {
          Consola.println(I18n.MODIFICADO_OK);
          Consola.leer(I18n.PRESIONE_ENTER);
       }
        else {
          Consola.println(I18n.ERROR);
          Consola.leer(I18n.PRESIONE_ENTER);
        }
      }      
    }  
  }

  public static void listadoArticulos()
  {
    // TODO Auto-generated method stub
    ArrayList articulos = Fachada.listadoArticulos();
    if (articulos.isEmpty()) {
      Consola.println(I18n.LISTA_VACIA);
      Consola.leer(I18n.PRESIONE_ENTER);
    }
    else {
      Consola.listado(articulos);
      Consola.leer(I18n.PRESIONE_ENTER);
    }
  }
}
