package dominio;

import java.util.ArrayList;

public class Componente {

  private Articulo componente = null;
  private int cantidad = 0;
  
  public Componente(Articulo unArticulo, int cantidad) {
    setComponente(unArticulo);
    setCantidad(cantidad);
  }
  public Componente(Articulo unArticulo) {
    setComponente(unArticulo);
    setCantidad(1);
  }
  
  public boolean esHoja() {
    return componente.esHoja();
  }
  public Componente getHijo(int posicion) { return null; }
  public int getCantidadDeHijos() { return 0; }
  public int getIndiceHijo(Componente unComponente) { return -1; }
  public Componente getPadre(Componente unComponente) { return null; }

  @Override
  public boolean equals(Object arg0) {
    try
    {
      Articulo articulo = (Articulo) ((Componente) arg0).getComponente();
      if (articulo.getNombre().equals(this.componente.getNombre())) {
        if (articulo.getMedida().equals(this.componente.getMedida())) {
          return true;
        }
      }
    }
    catch (RuntimeException e)
    {

    }
    return false;
  }
  @Override
  public String toString() {
    return componente.toString() + "(" + cantidad + ")";
  }
  public int getCantidad() {
    return cantidad;
  }
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
  public Articulo getComponente() {
    return componente;
  }
  public void setComponente(Articulo componente) {
    this.componente = componente;
  }  

	/*private static int x=0;
	public ArrayList StockSimplesPresupuestos(Item itemRoot, Articulo hijo){//art hijo en principio es null
		ArrayList retorno=new ArrayList();
		
		if(this.esHoja()){
			if(this.equals(item.getElArticulo())){//si el item del presupuesto es un Articulo simple. Caso mas facil.
				retorno=sumarItem(retorno, x);
				x=0;
			}
			else{  //si es hoja pero no es del tipo del item, buscar el total con el parent 
				int total=getTotalCantidadPadres(getPadre(this), itemRoot);
				sumarItem(retorno,this.cantidad*total);
			}
		}
		else{		//si no es hoja
			for(int z=0;z<getCantidadDeHijos();z++){
				Articulo elHijo=getHijo(z);
				StockSimplesPresupuestos(itemRoot,elHijo);
			}
		}
		return retorno;
	}
	
	
	
	
	private int getTotalCantidadPadres(Articulo padre,Item item, int subtotal){ //devuelve la cantidad por la que se debe multiplicar el articulos hoja hasta el Item(Compuesto) 
		int total=0;
		if(padre.equals(item.getElArticulo())){
			total=padre.getCantidad()*subtotal;
			
			return total;
		}
		else{
			getTotalCantidadPadres(getPadre(padre),item,subtotal*padre.cantidad);
		}
	
	
		return total;
	}
	
	private ArrayList sumarItem(ArrayList items,int cantidad){
		boolean tiene=false;
		for(int i=0;i<items.size()&&tiene==false;i++){
			Item item=((Item) items.get(i));
			Articulo tmpArt=item.getElArticulo();
			if(tmpArt.equals(this)){
				item.setCantidadItem(item.getCantidadItem()+cantidad);
				tiene=true;
			}
			return items;
		}
		Item tmpItem=new Item(this,cantidad);
		items.add(tmpItem);
		return items;
	}
	
	
  
  */
  
  
  
  
  
}
