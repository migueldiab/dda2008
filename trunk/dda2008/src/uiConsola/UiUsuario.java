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
    String repetir = "";
    int posGrupo = 0;
    Grupo grupo = null;
    id = Consola.leer(I18n.ID + ": ");
    nombre = Consola.leer(I18n.NOMBRE + ": ");
    apellido = Consola.leer(I18n.APELLIDO + ": ");
    do {
      clave = Consola.leer(I18n.CLAVE + ": ");
      repetir = Consola.leer(I18n.CLAVE_REPETIR + ": ");
    } while (!clave.equals(repetir));   
    ArrayList grupos = Fachada.listaGrupos();
    if (grupos.isEmpty()) {
      Consola.println(I18n.LISTA_VACIA);
      Consola.leer(I18n.PRESIONE_ENTER);
    }
    else {
      posGrupo = Consola.menu(grupos);
      grupo = (Grupo) grupos.get(posGrupo);
      Usuario unUsuario = new Usuario(id, clave, grupo, nombre, apellido);
      if (Fachada.agregarUsuario(unUsuario)) {
        Consola.println(I18n.INGRESO_OK);
        Consola.leer(I18n.PRESIONE_ENTER);
      }
      else {
        Consola.println(I18n.ERROR);
        Consola.leer(I18n.PRESIONE_ENTER);
      }
    }
  }

  public static void borrarUsuario()
  {
    // TODO Auto-generated method stub
   ArrayList usuarios = Fachada.listadoUsuarios();
   if (usuarios.isEmpty()) {
     Consola.println(I18n.LISTA_VACIA);
     Consola.leer(I18n.PRESIONE_ENTER);
   }
   else {
     int posUsuario = Consola.menu(usuarios);
     String confirma = Consola.leer(I18n.CONFIRMA_ELIMINAR);
     if (confirma.toUpperCase().equals(I18n.SI.toUpperCase()))
       if (Fachada.borrarUsuario((Usuario) usuarios.get(posUsuario))) {
         Consola.println(I18n.BORRADO_OK);
         Consola.leer(I18n.PRESIONE_ENTER);
       }
       else {
         Consola.println(I18n.ERROR);
         Consola.leer(I18n.PRESIONE_ENTER);
       }
   }
  }

  public static void modificarUsuario()
  {
    // TODO Auto-generated method stub
    ArrayList usuarios = Fachada.listadoUsuarios();
    if (usuarios.isEmpty()) {
      Consola.println(I18n.LISTA_VACIA);
      Consola.leer(I18n.PRESIONE_ENTER);
    }
    else {
      int posUsuario = Consola.menu(usuarios);
      Usuario original = (Usuario) usuarios.get(posUsuario);

      String id = "";
      String nombre = "";
      String apellido = "";
      String clave = "";
      String repetir = "";
      Grupo grupo = null;
      int posGrupo = 0;
      id = Consola.modificar(I18n.ID, original.getId());
      nombre = Consola.modificar(I18n.NOMBRE, original.getNombre());
      apellido = Consola.modificar(I18n.APELLIDO, original.getApellido());
      do {
        clave = Consola.leer(I18n.CLAVE + ": ");
        repetir = Consola.leer(I18n.CLAVE_REPETIR + ": ");
      } while (!clave.equals(repetir));   
      ArrayList grupos = Fachada.listaGrupos();
      if (grupos == null) {
        Consola.println(I18n.LISTA_VACIA);
        Consola.leer(I18n.PRESIONE_ENTER);
      }
      else {
        posGrupo = Consola.menu(grupos);
        grupo = (Grupo) grupos.get(posGrupo);
        String confirma = Consola.leer(I18n.CONFIRMA_MODIFICAR);
        if (confirma.toUpperCase().equals(I18n.SI.toUpperCase()))
        {
          if (Fachada.modificarUsuario(
               original,
               new Usuario(id, clave, grupo, nombre, apellido))) {
            Consola.println(I18n.MODIFICADO_OK);
            Consola.leer(I18n.PRESIONE_ENTER);
          }
          else
            Consola.println(I18n.ERROR);
          Consola.leer(I18n.PRESIONE_ENTER);
        }
        else {
          Consola.println(I18n.CANCELADA);
          Consola.leer(I18n.PRESIONE_ENTER);
        }
      }
    }  
  }

  public static void listadoUsuarios()
  {
    // TODO Auto-generated method stub
    ArrayList usuarios = Fachada.listadoUsuarios();
    if (usuarios.isEmpty()) {
      Consola.println(I18n.LISTA_VACIA);
      Consola.leer(I18n.PRESIONE_ENTER);
    }
    else {
      Consola.listado(usuarios);
      Consola.leer(I18n.PRESIONE_ENTER);
    }   
  }

}
