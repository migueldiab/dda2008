class ServiciosArticulos
!!!148354.java!!!	agregar(inout o : Object) : boolean

    // TODO Auto-generated method stub
    if (articulos.indexOf((Articulo) o)==-1) {
      articulos.add((Articulo) o);
      return true;
    }
    else {
      return false;
    }    
!!!148482.java!!!	borrar(inout unArticulo : Articulo) : boolean

    if (articulos.indexOf(unArticulo)!=-1) {
      ArrayList presupuestos = null;
      presupuestos = ServiciosPresupuestos.obtenerPresupuestoPorArticulo(unArticulo);
      if (presupuestos.size() > 0) {
        return false;
      }
      else {
        articulos.remove(unArticulo);
        return true;        
      }     
    }
    else {
      return false;
    }      
!!!148610.java!!!	listado() : ArrayList

    if (cantidad() == 0)
      return null;
    else
      return articulos;
!!!148738.java!!!	modificar(inout original : Articulo, inout nuevo : Articulo) : boolean

    if (( original == null) || ( nuevo == null)) return false;
    int posOriginal = articulos.indexOf( original);
    if (posOriginal == -1) return false;
    int posNuevo = articulos.indexOf( nuevo);
    if (posNuevo > -1 && posNuevo != posOriginal) return false;
    
    // Medida : No se puede modificar si el articulo esta involucrado en algun presupuesto
    ArrayList presupuestos = null;
    presupuestos = ServiciosPresupuestos.obtenerPresupuestoPorArticulo(original);
    if (presupuestos.size() > 0 && !original.getMedida().equals(nuevo.getMedida())) {
          return false;
    }
    articulos.set(posOriginal, nuevo);
    return true;
!!!148866.java!!!	cantidad() : int

    return articulos.size();
!!!148994.java!!!	obtener(inout o : Object) : Object

    // TODO Auto-generated method stub
    int pos = articulos.indexOf((Articulo) o);
    if (pos!=-1) { 
      return articulos.get(pos);
    }
    else {
      return null;
    }  
