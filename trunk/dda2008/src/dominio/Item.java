package dominio;

public class Item implements Cloneable{
private int cantidadItem;
private Articulo elArticulo;
private double costoFinalizado;

public Item(Articulo unArticulo,int cantidadItem){
	this.setElArticulo(unArticulo);
	this.setCantidadItem(cantidadItem);
}

public Articulo getElArticulo() {
	return elArticulo;
}

public void setElArticulo(Articulo elArticulo) {
	this.elArticulo = elArticulo;
}

public int getCantidadItem() {
	return cantidadItem;
}

public void setCantidadItem(int cantidadItem) {
	this.cantidadItem = cantidadItem;
}

public void setCostoFinalizado(double costoFinalizado) {
	this.costoFinalizado = costoFinalizado;
}

public double getCostoFinalizado() {
	return costoFinalizado;
}
public String toString(){
	if(this.getCostoFinalizado()>0){
		return "Item: "+this.getElArticulo().getNombre()+" - Medida: "+this.getElArticulo().getMedida();
	}else{
		return "Item: "+this.getElArticulo().getNombre()+" - Medida: "+this.getElArticulo().getMedida();	
	}
	
}

public Object clone() throws CloneNotSupportedException {

    Item clone=(Item)super.clone();

  
    return clone;

  }


}
