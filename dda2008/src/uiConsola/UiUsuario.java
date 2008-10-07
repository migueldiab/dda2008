package uiConsola;

import java.util.ArrayList;

import dominio.Grupo;
import dominio.Usuario;

import servicios.Fachada;
import utils.Consola;
import utils.I18n;

public class UiUsuario
{

  public static void agregarUsuario()
  {
    // TODO Auto-generated method stub
    String id = "";
    String nombre = "";
    String apellido = "";
    String clave = "";
    Grupo grupo = null;
    nombre = Consola.leer(I18n.NOMBRE + ": ");
    ArrayList grupos = Fachada.listaGrupos();
    Usuario unUsuario = new Usuario(id, clave, grupo, nombre, apellido);
    if (Fachada.agregarUsuario(unUsuario))
      Consola.println(I18n.INGRESO_OK);
    else
      Consola.println(I18n.ERROR);
  }

  public static void borrarUsuario()
  {
    // TODO Auto-generated method stub
   ArrayList usuarios = Fachada.listadoUsuarios();
   if (usuarios == null) {
     Consola.println(I18n.LISTA_VACIA);
   }
   else {
     int posUsuario = Consola.menu(usuarios);
     String confirma = Consola.leer(I18n.CONFIRMA_ELIMINAR);
     if (confirma.toUpperCase().equals(I18n.SI.toUpperCase()))
       if (Fachada.borrarUsuario((Usuario) usuarios.get(posUsuario)))
         Consola.println(I18n.BORRADO_OK);
       else
         Consola.println(I18n.ERROR);
   }
  }

  public static void modificarUsuario()
  {
    // TODO Auto-generated method stub
    ArrayList usuarios = Fachada.listadoUsuarios();
    if (usuarios == null) {
      Consola.println(I18n.LISTA_VACIA);
    }
    else {
      int posUsuario = Consola.menu(usuarios);
      Usuario original = (Usuario) usuarios.get(posUsuario);

      String id = "";
      String nombre = "";
      String apellido = "";
      String clave = "";
      Grupo grupo = null;
      nombre = Consola.modificar(I18n.NOMBRE, original.getNombre());
      ArrayList grupos = Fachada.listaGrupos();
      Usuario unUsuario = new Usuario(id, clave, grupo, nombre, apellido);
      
      int posGrupo = Consola.menu(grupos);
      grupo = (Grupo) grupos.get(posGrupo);
      String confirma = Consola.leer(I18n.CONFIRMA_MODIFICAR);
      if (confirma.toUpperCase().equals(I18n.SI.toUpperCase()))
      {
        if (Fachada.modificarUsuario(
             original,
             new Usuario(id, clave, grupo))) {
          Consola.println(I18n.MODIFICADO_OK);
        }
        else
          Consola.println(I18n.ERROR);
      }      
    }  
  }

  public static void listadoUsuarios()
  {
    // TODO Auto-generated method stub
   Consola.listado(Fachada.listadoUsuarios());   
  }

}