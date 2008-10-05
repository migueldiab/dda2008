package uiConsola;

import java.util.ArrayList;

import servicios.Fachada;
import utils.I18n;
import utils.Consola;

public class UiInicio
{
  public static void MenuPrincipal() {
    int opcion = 0;
    boolean salir = false, menu_anterior = false;
    do {
      ArrayList items = new ArrayList();
      items.add(I18n.ARTICULOS);
      items.add(I18n.PRESUPUESTOS);
      items.add(I18n.LISTADOS);
      items.add(I18n.USUARIOS);
      items.add(I18n.CERRAR_SESION);
      items.add(I18n.SALIR);
      opcion = Consola.menu(items, I18n.PRINCIPAL);
      switch (opcion) {
        case 0:
          do {
            items = new ArrayList();
            items.add(I18n.ALTA);
            items.add(I18n.BAJA);
            items.add(I18n.MODIFICACIONES);
            items.add(I18n.LISTADOS);
            items.add(I18n.MENU_ANTERIOR);
            items.add(I18n.SALIR);
            opcion = Consola.menu(items, I18n.ARTICULOS);
            switch (opcion) {
              case 0:
                UiArticulo.agregarArticulo();
                break;
              case 1:
                UiArticulo.borrarArticulo();
                break;
              case 2:
                UiArticulo.modificarArticulo();
                break;
              case 3:
                UiArticulo.listadoArticulos();
                break;
              case 4:
                menu_anterior = true;
                break;
              case 5:
                salir = true;
                break;
            }            
          } while (!menu_anterior && !salir);
          break;
        case 1:
          do {
            items = new ArrayList();
            items.add(I18n.ALTA);
            items.add(I18n.BAJA);
            items.add(I18n.MODIFICACIONES);
            items.add(I18n.LISTADOS);
            items.add(I18n.MENU_ANTERIOR);
            items.add(I18n.SALIR);
            opcion = Consola.menu(items, I18n.PRESUPUESTOS);
            switch (opcion) {
              case 0:
                UiPresupuesto.agregarPresupuesto();
                break;
              case 1:
                UiPresupuesto.borrarPresupuesto();
                break;
              case 2:
                UiPresupuesto.modificarPresupuesto();
                break;
              case 3:
                UiPresupuesto.listadoPresupuestos();
                break;
              case 4:
                menu_anterior = true;
                break;
              case 5:
                salir = true;
                break;
            }            
          } while (!menu_anterior && !salir);
          break;
        case 2:
          do {
            items = new ArrayList();
            items.add(I18n.LISTADOS);
            items.add(I18n.LISTADOS);
            items.add(I18n.LISTADOS);
            items.add(I18n.LISTADOS);
            items.add(I18n.MENU_ANTERIOR);
            items.add(I18n.SALIR);
            opcion = Consola.menu(items, I18n.LISTADOS);
            switch (opcion) {
              case 0:
                // Fachada.unlistado
                break;
              case 1:
//              Fachada.unlistado
                break;
              case 2:
//              Fachada.unlistado
                break;
              case 3:
//              Fachada.unlistado
                break;
              case 4:
                menu_anterior = true;
                break;
              case 5:
                salir = true;
                break;
            }            
          } while (!menu_anterior && !salir);
          break;
        case 3:
          do {
            items = new ArrayList();
            items.add(I18n.ALTA);
            items.add(I18n.BAJA);
            items.add(I18n.MODIFICACIONES);
            items.add(I18n.LISTADOS);
            items.add(I18n.MENU_ANTERIOR);
            items.add(I18n.SALIR);
            opcion = Consola.menu(items, I18n.USUARIOS);
            switch (opcion) {
              case 0:
                UiUsuario.agregarUsuario();
                break;
              case 1:
                UiUsuario.borrarUsuario();
                break;
              case 2:
                UiUsuario.modificarUsuario();
                break;
              case 3:
                UiUsuario.listadoUsuarios();
                break;
              case 4:
                menu_anterior = true;
                break;
              case 5:
                salir = true;
                break;
            }            
          } while (!menu_anterior && !salir);
          break;
        case 4:
          Fachada.cerrarSesion();
          break;
        case 5:
          salir=true;
          break;
      }
    } while (!salir);

  }
}
