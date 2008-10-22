class ServiciosUsuarios
!!!152066.java!!!	login(in usuario : String, in clave : String) : Usuario

    Usuario unUsuario = new Usuario(usuario);
    unUsuario = (Usuario) ServiciosUsuarios.obtener(unUsuario);
    if (unUsuario != null) { 
      if (unUsuario.getClave().equals(clave)) {
        return unUsuario;
      }
      else {
        return null;
      }
    }
    else {
      return null;
    }      
!!!152194.java!!!	logout() : boolean

    usuarioActual = null;
    return true;
!!!152322.java!!!	agregar(inout unUsuario : Usuario) : boolean

    // TODO Auto-generated method stub
    if (usuarios.indexOf(unUsuario)==-1) {
      usuarios.add(unUsuario);
      return true;
    }
    else {
      return false;
    }        
!!!152450.java!!!	borrar(inout unUsuario : Usuario) : boolean

    if (usuarios.indexOf(unUsuario)!=-1) {
      usuarios.remove(unUsuario);
      return true;
    }
    else {
      return false;
    }      
!!!152578.java!!!	modificar(inout original : Usuario, inout nuevo : Usuario) : boolean

    if ((original == null) || (nuevo == null)) return false;
    int posOriginal = usuarios.indexOf(original);
    if (posOriginal == -1) return false;
    int posNuevo = usuarios.indexOf(nuevo);
    if (posNuevo > -1 && posNuevo != posOriginal) return false;
    
    // No se puede modificar el rol de un usuario gestor que sea dueño de algun presupuesto
    if (!original.getGrupo().equals(nuevo.getGrupo())) {
      ArrayList presupuestos = null;
      presupuestos = ServiciosPresupuestos.obtenerPresupuestoPorUsuario(original);
      if (presupuestos.size() > 0) {
        return false;
      }
    }
    usuarios.set(posOriginal, nuevo);
    return true;
!!!152706.java!!!	cantidad() : int

    // TODO Auto-generated method stub
    return usuarios.size();
!!!152834.java!!!	obtener(inout unUsuario : Usuario) : Object

    // TODO Auto-generated method stub
    int pos = usuarios.indexOf(unUsuario);
    if (pos!=-1) { 
      return usuarios.get(pos);
    }
    else {
      return null;
    }  
!!!152962.java!!!	listado() : ArrayList

    // TODO Auto-generated method stub
    if (cantidad() == 0)
      return null;
    else
      return usuarios;
