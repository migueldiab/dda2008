class ServiciosGrupos
!!!149122.java!!!	agregar(inout o : Object) : boolean

    // TODO Auto-generated method stub
    if (grupos.indexOf((Grupo) o)==-1) {
      grupos.add((Grupo) o);
      return true;
    }
    else {
      return false;
    }    
!!!149250.java!!!	borrar(inout o : Object) : boolean

    if (grupos.indexOf((Grupo) o)!=-1) {
      grupos.remove((Grupo) o);
      return true;
    }
    else {
      return false;
    }      
!!!149378.java!!!	listado() : ArrayList

    if (cantidad() == 0)
      return null;
    else
      return grupos;
!!!149506.java!!!	modificar(inout original : Object, inout nuevo : Object) : boolean

    if (((Grupo) original == null) || ((Grupo) nuevo == null)) return false;
    int posOriginal = grupos.indexOf((Grupo) original);
    if (posOriginal == -1) return false;
    int posNuevo = grupos.indexOf((Grupo) nuevo);
    if (posNuevo > -1 && posNuevo != posOriginal) return false;
    grupos.set(posOriginal, (Grupo) nuevo);
    return true;
!!!149634.java!!!	cantidad() : int

    return grupos.size();
!!!149762.java!!!	obtener(inout o : Object) : Object

    // TODO Auto-generated method stub
    int pos = grupos.indexOf((Grupo) o);
    if (pos!=-1) { 
      return grupos.get(pos);
    }
    else {
      return null;
    }  
