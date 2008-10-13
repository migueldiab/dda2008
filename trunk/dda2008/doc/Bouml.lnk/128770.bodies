class Fachada
!!!145026.java!!!	agregarArticulo(inout unArticulo : Articulo) : boolean

    return ServiciosArticulos.agregar(unArticulo);
!!!145154.java!!!	borrarArticulo(inout unArticulo : Articulo) : boolean

    return ServiciosArticulos.borrar(unArticulo); 
!!!145282.java!!!	modificarArticulo(inout original : Articulo, inout nuevo : Articulo) : boolean
    
    return ServiciosArticulos.modificar(original, nuevo);
!!!145410.java!!!	listadoArticulos() : ArrayList

    return ServiciosArticulos.listado();
!!!145538.java!!!	calcularCosto(inout unPresupuesto : Presupuesto) : void

		ServiciosPresupuestos.calcularCosto(unPresupuesto);
!!!145666.java!!!	agregarPresupuesto(inout unPresupuesto : Presupuesto) : boolean

    return ServiciosPresupuestos.agregar(unPresupuesto);
!!!145794.java!!!	agregarItemPresupuesto(inout unPresupuesto : Presupuesto, inout unItem : Object) : boolean

	  return ServiciosPresupuestos.agregarItem(unPresupuesto, unItem);
!!!145922.java!!!	borrarItemPresupuesto(inout unPresupuesto : Presupuesto, inout unItem : Object) : boolean

	  return ServiciosPresupuestos.borrarItem(unPresupuesto, unItem);
!!!146050.java!!!	borrarPresupuesto() : boolean

    Consola.println("Borra un articulo");
    return true;
!!!146178.java!!!	modificarPresupuesto(inout unPresupuesto : Presupuesto, in descripcion : String, inout fechaEjecucion : Date) : boolean

    Consola.println("Modifica un Presupuesto");
    return true;
!!!146306.java!!!	modificarItemPresupuesto(inout unPresupuesto : Presupuesto, in cantItem : int) : boolean

	  return ServiciosPresupuestos.modificarItemPresupuesto(unPresupuesto, cantItem);
!!!146434.java!!!	listadoPresupuestos() : ArrayList

    return ServiciosPresupuestos.listado();
!!!146562.java!!!	agregarUsuario(inout unUsuario : Usuario) : boolean

    return ServiciosUsuarios.agregar(unUsuario);
    
!!!146690.java!!!	borrarUsuario(inout usuario : Usuario) : boolean

     return ServiciosUsuarios.borrar(usuario);
!!!146818.java!!!	modificarUsuario(inout original : Usuario, inout usuario : Usuario) : boolean

    return ServiciosUsuarios.modificar(original, usuario);
!!!146946.java!!!	listadoUsuarios() : ArrayList

    return ServiciosUsuarios.listado();
!!!147074.java!!!	cerrarSesion() : boolean

    return ServiciosUsuarios.logout();
!!!147202.java!!!	listaMedidas() : ArrayList

    return ServiciosMedidas.listado();
!!!147330.java!!!	agregarMedida(inout medida : Medida) : boolean

    return ServiciosMedidas.agregar(medida);    
!!!147458.java!!!	listaGrupos() : ArrayList

    return ServiciosGrupos.listado();
!!!147586.java!!!	agregarGrupo(inout grupo : Grupo) : boolean

    return ServiciosGrupos.agregar(grupo);
!!!147714.java!!!	unlistado() : void

    // TODO Auto-generated method stub
    
!!!147842.java!!!	login(in id : String, in clave : String) : Usuario

    return ServiciosUsuarios.login(id, clave);
!!!147970.java!!!	obtenerPresupuestoPorArticulo(inout unArticulo : Articulo) : ArrayList

    return ServiciosPresupuestos.obtenerPresupuestoPorArticulo(unArticulo);
!!!148098.java!!!	obtenerPresupuestoPorArticuloEstadoConFecha(inout unArticulo : Articulo, in unEstado : String) : ArrayList

    return ServiciosPresupuestos.obtenerPresupuestoPorArticuloEstadoConFecha(unArticulo, unEstado);
!!!148226.java!!!	obtenerPresupuestoPorUsuarioOrdenadoFecha(inout unUsuario : Usuario) : ArrayList

    return ServiciosPresupuestos.obtenerPresupuestoPorUsuarioOrdenadoFecha(unUsuario);
