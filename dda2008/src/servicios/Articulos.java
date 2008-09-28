package servicios;

import java.util.ArrayList;

import dominio.Articulo;

public class Articulos implements Servicios
{
  ArrayList articulos = new ArrayList();
  
  public boolean nuevo(Object o) {
    return true;
  }
  
}
