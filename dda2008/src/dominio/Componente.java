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
  public static Componente getHijo(int posicion) { return null; }
  public static int getCantidadDeHijos() { return 0; }
  public int getIndiceHijo(Componente unComponente) { return -1; }
  public static Componente getPadre(Componente unComponente) { return null; }

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

	private static int x=0;
	public static  ArrayList StockSimplesPresupuestos(Item itemRoot, Componente hijo, ArrayList retorno){//art hijo en principio es null
		
		Articulo articulo=itemRoot.getElArticulo();
		
		if(hijo!=null){
			Articulo artHijo=hijo.getComponente();
			if(artHijo.esHoja()){
				int total=getTotalCantidadPadres(getPadre(hijo), itemRoot,0);
				sumarItem(hijo.getComponente(),retorno,itemRoot.getElArticulo().getCantidad()*total);
			}
		}
		else if(hijo==null&&articulo.esHoja()){
			//si el item del presupuesto es un Articulo simple. Caso mas facil.
				retorno=sumarItem(articulo, retorno, itemRoot.getCantidadItem());
				x=0;
		}
		else{		//si no es hoja
			for(int z=0;z<getCantidadDeHijos();z++){
				Componente elHijo=getHijo(z);
				StockSimplesPresupuestos(itemRoot,elHijo,retorno);
			}
		}
		return retorno;
	}
	
	
	
	
	private static int getTotalCantidadPadres(Componente componente2,Item item, int subtotal){ //devuelve la cantidad por la que se debe multiplicar el articulos hoja hasta el Item(Compuesto) 
		int total=0;
		if(componente2.getComponente().equals(item.getElArticulo())){
			total=componente2.componente.getCantidad()*subtotal;
			
			return total;
		}
		else{
			getTotalCantidadPadres(getPadre(componente2),item,subtotal*componente2.cantidad);
		}
	
	
		return total;
	}
	
	private static ArrayList sumarItem(Articulo articulo, ArrayList componentes,int cantidad){
		boolean tiene=false;
		for(int i=0;i<componentes.size()&&tiene==false;i++){
			Componente componente=((Componente) componentes.get(i));
			Articulo tmpArt=componente.getComponente();
			if(tmpArt.equals(articulo)){
				componente.setCantidad(componente.getCantidad()+cantidad);
				tiene=true;
			}
		}
		if (tiene==false){
			Componente tmpComponente=new Componente(articulo,cantidad);
			componentes.add(tmpComponente);
		}
		return componentes;
	}

	
  
  
  
  
  
  
  
}
