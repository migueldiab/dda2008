package servicios;

import java.util.ArrayList;

import dominio.Medida;

public class ServiciosMedidas
{
  static ArrayList medidas = new ArrayList();

  public static boolean agregar(Medida unMedida)
  {
    // TODO Auto-generated method stub
    if (medidas.indexOf(unMedida)==-1) {
      medidas.add(unMedida);
      return true;
    }
    else {
      return false;
    }        
  }
  public static boolean borrar(Medida unMedida) {
    if (medidas.indexOf(unMedida)!=-1) {
      medidas.remove(unMedida);
      return true;
    }
    else {
      return false;
    }      
  }

  public static boolean modificar(Medida original, Medida nuevo) {
    if ((original == null) || (nuevo == null)) return false;
    int posOriginal = medidas.indexOf(original);
    if (posOriginal == -1) return false;
    int posNuevo = medidas.indexOf(nuevo);
    if (posNuevo > -1 && posNuevo != posOriginal) return false;
    medidas.set(posOriginal, nuevo);
    return true;
  }
  public static int cantidad()
  {
    // TODO Auto-generated method stub
    return medidas.size();
  }

  public static Object obtener(Medida unMedida)
  {
    // TODO Auto-generated method stub
    int pos = medidas.indexOf(unMedida);
    if (pos!=-1) { 
      return medidas.get(pos);
    }
    else {
      return null;
    }  
  }

  public static ArrayList listado()
  {
    // TODO Auto-generated method stub
    if (cantidad() == 0)
      return null;
    else
      return medidas;
  }

}
