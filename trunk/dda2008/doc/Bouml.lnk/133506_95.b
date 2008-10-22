class ServiciosPresupuestos
!!!150658.java!!!	agregar(inout unPresupuesto : Presupuesto) : boolean

  Date now=new Date();
  	 if (presupuestos.indexOf(unPresupuesto)==-1){
  		 
  		 unPresupuesto.setFechaModificacion(now);
  		 unPresupuesto.setDuenio(ServiciosUsuarios.usuarioActual);
  		 
  
  
  		 presupuestos.add(unPresupuesto);
  	 return true;
  	 }
  	 else
  	 {
  		 return false;
  	 }
!!!150786.java!!!	borrar(inout o : Object) : boolean

  	 if(presupuestos.indexOf((Presupuesto)o)==-1){
  		 presupuestos.remove((Presupuesto)o);
  		 return true;
  	 }
  	 else{
  		 return false;
  	 }
!!!150914.java!!!	calcularCosto(inout unPresupuesto : Presupuesto) : void

  int x = 0;
  double costo=0;
  	 for(x=0;x<unPresupuesto.getItems().size();x++){
  		 Articulo item=(Articulo) unPresupuesto.getItems().get(x);
  		 costo+=item.getCosto()*item.getCantidad();
  		}
  		unPresupuesto.setCosto(costo);
  		System.out.println("Tostring con Costo "+unPresupuesto.toString());
!!!151042.java!!!	listado() : ArrayList

  	 if(presupuestos.size()==0){
  		 return null;
  	 }
  	 else{
  	 return presupuestos;
  	 }
!!!151170.java!!!	agregarItem(inout unPresupuesto : Presupuesto, inout unItem : Object) : boolean

  		 if(unPresupuesto.getItems().contains(unItem)){
  			 return false;
  			 }
  		 else{
  			unPresupuesto.agregarItem(unItem);
  			return true;
  		 }
  	 
!!!151298.java!!!	borrarItem(inout unPresupuesto : Presupuesto, inout unItem : Object) : boolean

  	 int indice=presupuestos.indexOf(unPresupuesto);
  	 if (indice==-1){
  		 return false;
  	 }
  	 else{
  		 if(!unPresupuesto.getItems().contains(unItem)){
  			 return false;
  			 }
  		 else{
  			unPresupuesto.borrarItem((Articulo)unItem); 
  			return true;
  		 }
  	 }
!!!151426.java!!!	modificarItemPresupuesto(inout unPresupuesto : Presupuesto, in cantItem : int) : boolean

  	return false;
  	 
!!!151554.java!!!	obtenerPresupuestoPorArticulo(inout unArticulo : Articulo) : ArrayList

   // TODO Auto-generated method stub
   ArrayList losPresupuestos = new ArrayList();
   
   for (int i = 0; i < presupuestos.size(); i++) {
    Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
    ArrayList items = new ArrayList();
    items = unPresupuesto.getItems();
    for (int j = 0; j < presupuestos.size(); j++) {
      Articulo unItem = (Articulo) items.get(j);
      if (unItem.equals(unArticulo)) {
       losPresupuestos.add(unItem);
      }    
    }
   }
   return losPresupuestos;
!!!151682.java!!!	obtenerPresupuestoPorUsuario(inout unUsuario : Usuario) : ArrayList

    // TODO Auto-generated method stub
    ArrayList losPresupuestos = new ArrayList();
     
    for (int i = 0; i < presupuestos.size(); i++) {
      Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
      if (unPresupuesto.getDuenio().equals(unUsuario)) {
        losPresupuestos.add(unPresupuesto);
      }
    }
    return losPresupuestos;
!!!151810.java!!!	obtenerPresupuestoPorArticuloEstadoConFecha(inout unArticulo : Articulo, in unEstado : String) : ArrayList

    ArrayList losPresupuestos = new ArrayList();
   
    for (int i = 0; i < presupuestos.size(); i++) {
      Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
      if (unPresupuesto.getEstado().equals(unEstado) && unPresupuesto.getFechaEjecucion() != null) {
        ArrayList items = new ArrayList();
        items = unPresupuesto.getItems();
        for (int j = 0; j < presupuestos.size(); j++) {
          Articulo unItem = (Articulo) items.get(j);
          if (unItem.equals(unArticulo)) {
            losPresupuestos.add(unItem);
          }    
        }
      }
    }
    return losPresupuestos;
!!!151938.java!!!	obtenerPresupuestoPorUsuarioOrdenadoFecha(inout unUsuario : Usuario) : ArrayList

    ArrayList losPresupuestos = new ArrayList();
    for (int i = 0; i < presupuestos.size(); i++) {
      Presupuesto unPresupuesto = (Presupuesto) presupuestos.get(i);
      if (unPresupuesto.getDuenio().equals(unUsuario) || !unUsuario.getGrupo().equals("Gestor")) {
        losPresupuestos.add(unPresupuesto);
      }
    }    
    // Falta ordenar por Fecha descendiente
    return losPresupuestos;
