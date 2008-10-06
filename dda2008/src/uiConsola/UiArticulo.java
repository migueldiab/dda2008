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
    int posMedida = 0;
    Medida medida = null;
    nombre = Consola.leer(I18n.NOMBRE + ": ");
    ArrayList medidas = Fachada.listaMedidas();
    posMedida = Consola.menu(medidas);
    medida = (Medida) medidas.get(posMedida);
    cantidad = Consola.leerInt(I18n.CANTIDAD + " : ");
    costo = Consola.leerDouble(I18n.COSTO + " : ");
    Articulo unArticulo = new Articulo(nombre, medida, cantidad, costo);
    if (Fachada.agregarArticulo(unArticulo))
      Consola.println(I18n.INGRESO_OK);
    else
      Consola.println(I18n.ERROR);
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
       if (Fachada.borrarArticulo((Articulo) articulos.get(posArticulo)))
         Consola.println(I18n.BORRADO_OK);
       else
         Consola.println(I18n.ERROR);
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
      int posMedida = 0;
      Medida medida = null;
      
      nombre = Consola.modificar(I18n.NOMBRE, original.getNombre());
      ArrayList medidas = Fachada.listaMedidas();
      posMedida = Consola.menu(medidas);
      medida = (Medida) medidas.get(posMedida);
      cantidad = Consola.modificarInt(I18n.CANTIDAD, original.getCantidad());
      costo = Consola.modificarDouble(I18n.COSTO, original.getCosto());
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
