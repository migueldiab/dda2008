package dominio;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class ModeloArbol implements TreeModel{

  private ArticuloCompuesto raiz;

  public ModeloArbol(ArticuloCompuesto r){
    raiz=r;
  }
  public boolean eliminar(Componente unComponente){
//    Componente padre=raiz.getPadre(unComponente);
//    if(padre!=null){
//      return padre.eliminarComponente(unComponente);
//    }
    return false;
  }
  public Object getChild(Object nodo, int posicion) {
    try {
      Componente padre = (Componente)nodo;
      return padre.getHijo(posicion);      
    } catch (Exception e) {
      ArticuloCompuesto padre = (ArticuloCompuesto) nodo;
      return padre.getHijo(posicion);
    }
  }

  public int getChildCount(Object n) {
    try {
      Componente nodo=(Componente)n;
      return nodo.getCantidadDeHijos();
       
    } catch (Exception e) {
      ArticuloCompuesto padre = (ArticuloCompuesto) n;
      return padre.contarComponentes();
    }
  }

  public int getIndexOfChild(Object p, Object hijo) {
    Componente padre=(Componente)p;
    return padre.getIndiceHijo((Componente)hijo);
  }

  public Object getRoot() {
    return raiz;
  }

  public boolean isLeaf(Object n) {
    try {
      Componente nodo=(Componente)n;
      return nodo.esHoja();
      
    } catch (Exception e) {
      return false;
    }
  }

  public void removeTreeModelListener(TreeModelListener arg0) {
  }
  public void valueForPathChanged(TreePath arg0, Object arg1) {
  }
  public void addTreeModelListener(TreeModelListener arg0) {
  }
  
  
}
