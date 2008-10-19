package dominio;

import java.util.Comparator;

public class CriterioComparacionPorNombreUsuarioAsc implements Comparator{

  public int compare(Object unUsuario1, Object unUsuario2) {
    Usuario u1=(Usuario)unUsuario1;
    Usuario u2=(Usuario)unUsuario2;
    return u1.getId().compareTo(u2.getId());
  }
}
