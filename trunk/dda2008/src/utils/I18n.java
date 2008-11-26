package utils;

import java.text.SimpleDateFormat;

public class I18n
{
  public static final String LISTA_VACIA = "No existen elementos en la lista";

  public static final String FORMATO_FECHA = "dd/MM/yyyy";
  public static SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);

  public static String FINALIZAR_PRESUPUESTO="Finalizar Presupuesto";
  public static String FINALIZADO="Finalizado";
  
  public static final String ERROR = "Error";
  
  public static final String DAY_OF_WEEK_SUN = "Domingo";
  public static final String DAY_OF_WEEK_MON = "Lunes";
  public static final String DAY_OF_WEEK_TUE = "Martes";
  public static final String DAY_OF_WEEK_WED = "Miercoles";
  public static final String DAY_OF_WEEK_THU = "Jueves";
  public static final String DAY_OF_WEEK_FRI = "Viernes";
  public static final String DAY_OF_WEEK_SAT = "Sabado";

  public static final String PRINCIPAL = "Principal";
  public static final String ARTICULOS = "Articulos";
  public static final String PRESUPUESTOS = "Presupuestos";
  public static final String USUARIOS = "Usuarios";
  public static final String CERRAR_SESION = "Cerrar Sessión";
  public static final String LISTADOS = "Listados";
  public static final String ALTA = "Crear Nuevo";
  public static final String BAJA = "Eliminar";
  public static final String MODIFICACIONES = "Modificar";
  public static final String MENU_ANTERIOR = "Menu Anterior";
  public static final String SELECCIONE_OPCION = "Seleccione Opción";
  public static final String SEPARADOR = "------------------------------";
  public static final String SELECCIONE_CANTIDAD = "Seleccione Cantidad del Item";
  public static final String CANTIDAD_MAL="Debe seleccionar una cantidad inferior o igual al total y al menos 1, operacion cancelada";
  public static final String SALIR = "Salir";
  public static final Object CANCELAR = "Cancelar";
  public static final String SI = "S";
  public static final String NO = "N";
  public static final String CONFIRMA_ELIMINAR = "Confirma que desea eliminar ("+SI+"/"+NO+") : ";
  public static final String NOMBRE = "Nombre";
  public static final String CANTIDAD = "Cantidad";
  public static final String COSTO = "Costo";
  public static final String DESCRIPCION= "Descripcion";
  public static final String FECHAEJECUCION="Fecha de Ejecucion (Opcional) dd/mm/aaaa : ";
  public static final String MODIFICA_ITEMS="Desea modificar los items? ("+SI+"/"+NO+") :";
  public static final String CONFIRMA_MODIFICAR = "Confirma que desea modifcar ("+SI+"/"+NO+") : ";
  public static final String CANTIDAD_MAYOR = "La cantidad no puede ser superior al stock del articulo.";
  public static final String MODIFICADO_OK = "Objeto modificado correctamente";
  public static final String INGRESO_OK = "Objeto ingresado correctamente";
  public static final String BORRADO_OK = "Objeto eliminado correctamente";
  public static final String APELLIDO = "Apellido";
  public static final String CLAVE = "Clave";
  public static final String ID = "Id";
  public static final String CLAVE_REPETIR = "Repetir " + CLAVE;
  public static final String CANCELADA = "Operacion Cancelada";
  public static final String NUMERO_INTENTOS = "Error al validar credenciales,\n # de intentos restante : ";
  public static final String CONSULTAS = "Consultas";
  public static final String CAMBIAR_DUENIO = "Cambiar Dueño";
  public static final String PRESIONE_ENTER = "Presione enter para Continuar";
  public static final String CONFIRMA_FINALIZACION = "Esta seguro que desea Finalizar el presupuesto (esta operacion es irreversible) ("+SI+"/"+NO+"):  ";
  public static final String ARTICULOS_SIN_STOCK = "No hay Stock suficiente de articulos en alguno de los items del presupuesto o no existe e Articulo";
  public static final String FINALIZADO_OK = "Se ha Finalizado correctamente";
  public static final String COPIAR_PRESUPUESTO = "Copiar Presupuesto";
  public static final String CONFIRMA_COPIA = "Desea crear una copiar del Presupuesto?("+SI+"/"+NO+"): ";
  public static final String INGRESE_DESCRIPCION = "Ingrese descripcion de la Copia : ";
  public static final String SELECCIONE_GESTOR = "Seleccione un Dueño : ";
  public static final String SELECCIONE_PRESUPUESTO = "Seleccione un Presupuesto : ";
  public static final String SELECCIONE_NUEVO_DUENIO = "Seleccione un nuevo dueño para el Presupuesto : ";
  public static final String ITEM_ALTA = "Agregar un Item";
  public static final String ITEM_BAJA = "Eliminar un Item";
  public static final String ITEM_MODIFICA = "Modificar un Item";
  public static final String PRESUPUESTO_MODIFICA = "Modificar datos del Presupuesto";
  public static final String SELECCIONE_ITEM_BORRAR = "Seleccione item a Borrar : ";

public static final String DESEA_FECHA_EJECUCION = "Desea ingresar una fecha de ejecucion?("+SI+"/"+NO+"): " ;

public static final String SELECCIONE_ARTICULO = " Seleccione Articulo: ";

public static final String PRESUPUESTO_YA_EXSTE = "Ya existe un presupuesto con el mismo dueño y descripcion. ";

public static final String FECHAEJECUCION_MAL = "Fecha de Ejecucion no existe o es mayor a actual.";

public static final String MEDIDAS = "Medidas";

public static final String ARTICULOS_COMPUESTOS = "Articulos Compuestos";

public static final String MONITOR_STOCK = "Monitor de Stock";


  public static void setFormato(String mascara)
  {
    sdf = new SimpleDateFormat(mascara);
  }

  

}
