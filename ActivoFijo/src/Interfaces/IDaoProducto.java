
package Interfaces;

import Modelo.Producto;
import java.util.ArrayList;

public interface IDaoProducto {
    boolean Grabar(Producto pro);
    Producto Buscar(int id);
    ArrayList<Producto> Listar();
    boolean Modificar (Producto pro);
    boolean Eliminar(String NumActivo);
    Producto Buscar2(String activo);
    Producto Buscar3(String tipo);
    Producto BuscarSerie(String activo);
    ArrayList<Producto> BuscarFiltroUbicacion(String busqueda);
    ArrayList<Producto> BuscarFiltroTipoProducto(String busqueda);
}