package uiConsola;

import java.util.ArrayList;

import dominio.Articulo;
import dominio.Medida;
import servicios.Fachada;
import utils.Consola;
import utils.I18n;

public class UiArticulo
{

  public static void agregarArticulo()
  {
    // TODO Auto-generated method stub
    String nombre = "";
    int cantidad = 0;
    double costo = 0;
    int idMedida = 0;
    Medida medida = new Medida();
    nombre = Consola.leer(I18n.NOMBRE + ": ");
    cantidad = Consola.leerInt(I18n.CANTIDAD + " : ");
    costo = Consola.leerDouble(I18n.COSTO + " : ");
    //idMedida = Consola.menu(Fachada.listaMedidas());
    Articulo unArticulo = new Articulo(nombre, medida, cantidad, costo);
    if (Fachada.agregarArticulo(unArticulo))
      Consola.println(I18n.INGRESO_CORRECTO);
  }

  public static void borrarArticulo()
  {
    // TODO Auto-generated method stub
   ArrayList articulos = Fachada.listadoArticulos();
   if (articulos == null) {
     Consola.println(I18n.LISTA_VACIA);
   }
   else {
     int posArticulo = Consola.menu(articulos);
     String confirma = Consola.leer(I18n.CONFIRMA_ELIMINAR);
     if (confirma.toUpperCase().equals(I18n.SI.toUpperCase()))
       Fachada.borrarArticulo((Articulo) articulos.get(posArticulo));
   }
  }

  public static void modificarArticulo()
  {
    // TODO Auto-generated method stub
    ArrayList articulos = Fachada.listadoArticulos();
    if (articulos == null) {
      Consola.println(I18n.LISTA_VACIA);
    }
    else {
      int posArticulo = Consola.menu(articulos);
      Articulo original = (Articulo) articulos.get(posArticulo);
      String nombre = "";
      int cantidad = 0;
      double costo = 0;
      int idMedida = 0;
      Medida medida = new Medida();
      nombre = Consola.modificar(I18n.NOMBRE, original.getNombre());
      cantidad = Consola.modificarInt(I18n.CANTIDAD, original.getCantidad());
      costo = Consola.modificarDouble(I18n.COSTO, original.getCosto());
      //idMedida = Consola.menu(Fachada.listaMedidas());
      String confirma = Consola.leer(I18n.CONFIRMA_MODIFICAR);
      if (confirma.toUpperCase().equals(I18n.SI.toUpperCase()))
      {
        if (Fachada.modificarArticulo(
             original,
             new Articulo(nombre, medida, cantidad, costo))) {
          Consola.println(I18n.MODIFICADO_OK);
        }
        else
          Consola.println(I18n.ERROR);
      }
    }
  
  }

  public static void listadoArticulos()
  {
    // TODO Auto-generated method stub
   Consola.listado(Fachada.listadoArticulos());
   
  }

}
