class ServiciosMedidas
!!!149890.java!!!	agregar(inout unMedida : Medida) : boolean

    // TODO Auto-generated method stub
    if (medidas.indexOf(unMedida)==-1) {
      medidas.add(unMedida);
      return true;
    }
    else {
      return false;
    }        
!!!150018.java!!!	borrar(inout unMedida : Medida) : boolean

    if (medidas.indexOf(unMedida)!=-1) {
      medidas.remove(unMedida);
      return true;
    }
    else {
      return false;
    }      
!!!150146.java!!!	modificar(inout original : Medida, inout nuevo : Medida) : boolean

    if ((original == null) || (nuevo == null)) return false;
    int posOriginal = medidas.indexOf(original);
    if (posOriginal == -1) return false;
    int posNuevo = medidas.indexOf(nuevo);
    if (posNuevo > -1 && posNuevo != posOriginal) return false;
    medidas.set(posOriginal, nuevo);
    return true;
!!!150274.java!!!	cantidad() : int

    // TODO Auto-generated method stub
    return medidas.size();
!!!150402.java!!!	obtener(inout unMedida : Medida) : Object

    // TODO Auto-generated method stub
    int pos = medidas.indexOf(unMedida);
    if (pos!=-1) { 
      return medidas.get(pos);
    }
    else {
      return null;
    }  
!!!150530.java!!!	listado() : ArrayList

    // TODO Auto-generated method stub
    if (cantidad() == 0)
      return null;
    else
      return medidas;
