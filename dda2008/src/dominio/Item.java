package dominio;

public class Item {
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
		return "Item: "+this.getElArticulo().getNombre()+" - Medida: "+this.getElArticulo().getMedida()+" - Cantidad: "+this.getCantidadItem()+" - Costo Articulo: "+this.getCostoFinalizado() + " - Costo Item: "+ this.getCostoFinalizado()*this.getCantidadItem()+"\r";
	}else{
		return "Item: "+this.getElArticulo().getNombre()+" - Medida: "+this.getElArticulo().getMedida()+" - Cantidad: "+this.getCantidadItem()+" - Costo Articulo: "+this.getElArticulo().getCosto() + " - Costo Item: "+ this.getElArticulo().getCosto()*this.getCantidadItem()+"\r";	
	}
	
	
}


}
