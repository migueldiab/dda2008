package uiConsola;

import java.util.ArrayList;

import dominio.Grupo;

import servicios.Fachada;
import servicios.ServiciosUsuarios;
import utils.I18n;
import utils.Consola;

public class UiInicio
{
  public static boolean MenuPrincipal() {
    String opcion = "";
    boolean salir = false;
    do {
      Consola.println("Bienvenido " + ServiciosUsuarios.usuarioActual.getNombre());
      ArrayList items = new ArrayList();
      if (ServiciosUsuarios.usuarioActual.getGrupo().tienePermiso(Grupo.ARTICULOS))
        items.add(I18n.ARTICULOS);
      if (ServiciosUsuarios.usuarioActual.getGrupo().tienePermiso(Grupo.PRESUPUESTOS) ||
          ServiciosUsuarios.usuarioActual.getGrupo().tienePermiso(Grupo.CAMBIO_DUENIO_PRESUPUESTO) )
        items.add(I18n.PRESUPUESTOS);
      if (ServiciosUsuarios.usuarioActual.getGrupo().tienePermiso(Grupo.CONSULTAS))
        items.add(I18n.CONSULTAS);
      if (ServiciosUsuarios.usuarioActual.getGrupo().tienePermiso(Grupo.USUARIOS))
        items.add(I18n.USUARIOS);
      items.add(I18n.CERRAR_SESION);
      items.add(I18n.SALIR);
      opcion = (String) items.get(Consola.menu(items, I18n.PRINCIPAL));
      if (opcion.equals(I18n.ARTICULOS)) MenuArticulos();
      if (opcion.equals(I18n.PRESUPUESTOS)) MenuPresupuestos();
      if (opcion.equals(I18n.CONSULTAS)) MenuConsultas();
      if (opcion.equals(I18n.USUARIOS)) MenuUsuarios();
      if (opcion.equals(I18n.CERRAR_SESION)) Fachada.cerrarSesion();
      if (opcion.equals(I18n.SALIR)) salir=true;
    } while (!salir && ServiciosUsuarios.usuarioActual != null);
    return salir;
  }

  private static void MenuArticulos()
  {
      boolean menu_anterior = false;
      // TODO Auto-generated method stub
      do {
        ArrayList items = new ArrayList();
        items.add(I18n.ALTA);
        items.add(I18n.BAJA);
        items.add(I18n.MODIFICACIONES);
        items.add(I18n.LISTADOS);
        items.add(I18n.MENU_ANTERIOR);
        String opcion = (String) items.get(Consola.menu(items, I18n.ARTICULOS));
        if (opcion.equals(I18n.ALTA)) UiArticulo.agregarArticulo();
        if (opcion.equals(I18n.BAJA)) UiArticulo.borrarArticulo();
        if (opcion.equals(I18n.MODIFICACIONES)) UiArticulo.modificarArticulo();
        if (opcion.equals(I18n.LISTADOS)) UiArticulo.listadoArticulos();
        if (opcion.equals(I18n.MENU_ANTERIOR)) menu_anterior = true;
      } while (!menu_anterior);
      
  }

  private static void MenuUsuarios()
  {
    // TODO Auto-generated method stub
      boolean menu_anterior = false;   

      
      do {
        ArrayList items = new ArrayList();
        items.add(I18n.ALTA);
        items.add(I18n.BAJA);
        items.add(I18n.MODIFICACIONES);
        items.add(I18n.LISTADOS);
        items.add(I18n.MENU_ANTERIOR);
        String opcion = (String) items.get(Consola.menu(items, I18n.USUARIOS));
        if (opcion.equals(I18n.ALTA)) UiUsuario.agregarUsuario();
        if (opcion.equals(I18n.BAJA)) UiUsuario.borrarUsuario();
        if (opcion.equals(I18n.MODIFICACIONES)) UiUsuario.modificarUsuario();
        if (opcion.equals(I18n.LISTADOS)) UiUsuario.listadoUsuarios();
        if (opcion.equals(I18n.MENU_ANTERIOR)) menu_anterior = true;
      } while (!menu_anterior);
  }

  private static void MenuConsultas()
  {
    // TODO Auto-generated method stub
      boolean menu_anterior = false;   
      do {
        ArrayList items = new ArrayList();
        items.add(I18n.PRESUPUESTOS);
        items.add(I18n.MENU_ANTERIOR);
        String opcion = (String) items.get(Consola.menu(items, I18n.CONSULTAS));
        if (opcion.equals(I18n.PRESUPUESTOS)) UiConsultas.presupuestos();
        if (opcion.equals(I18n.MENU_ANTERIOR)) menu_anterior = true;
      } while (!menu_anterior);
        
}

    private static void MenuPresupuestos()
  {
      boolean menu_anterior = false;
      do {
        ArrayList items = new ArrayList();
        if (ServiciosUsuarios.usuarioActual.getGrupo().tienePermiso(Grupo.PRESUPUESTOS))
          items.add(I18n.ALTA);
        if (ServiciosUsuarios.usuarioActual.getGrupo().tienePermiso(Grupo.PRESUPUESTOS))
          items.add(I18n.BAJA);
        if (ServiciosUsuarios.usuarioActual.getGrupo().tienePermiso(Grupo.PRESUPUESTOS))
          items.add(I18n.MODIFICACIONES);
        if (ServiciosUsuarios.usuarioActual.getGrupo().tienePermiso(Grupo.PRESUPUESTOS))
          items.add(I18n.LISTADOS);
        if (ServiciosUsuarios.usuarioActual.getGrupo().tienePermiso(Grupo.CAMBIO_DUENIO_PRESUPUESTO) )
          items.add(I18n.CAMBIAR_DUENIO);
        items.add(I18n.MENU_ANTERIOR);
        String opcion = (String) items.get(Consola.menu(items, I18n.PRESUPUESTOS));
        if (opcion.equals(I18n.ALTA)) UiPresupuesto.agregarPresupuesto();
        if (opcion.equals(I18n.BAJA)) UiPresupuesto.borrarPresupuesto();
        if (opcion.equals(I18n.MODIFICACIONES)) UiPresupuesto.modificarPresupuesto();
        if (opcion.equals(I18n.LISTADOS)) UiPresupuesto.listadoPresupuestos();
        if (opcion.equals(I18n.CAMBIAR_DUENIO)) UiPresupuesto.listadoPresupuestos();        
        if (opcion.equals(I18n.MENU_ANTERIOR)) menu_anterior = true;
      } while (!menu_anterior);
  }

  public static void login()
  {
    int intentos = ServiciosUsuarios.MAX_LOGIN;
    String id = "";
    String clave = "";
    do {
      id = Consola.leer(I18n.ID + ": ");
      clave = Consola.leer(I18n.CLAVE + ": ");
      ServiciosUsuarios.usuarioActual =  Fachada.login(id, clave);
      if (ServiciosUsuarios.usuarioActual == null) {
        Consola.println(I18n.NUMERO_INTENTOS + intentos);
        intentos--;
      }      
    } while (intentos >= 0 && ServiciosUsuarios.usuarioActual == null);
  }
}
