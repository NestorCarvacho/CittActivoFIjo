
package Interfaces;

import Modelo.Producto;
import java.util.ArrayList;

public interface IDaoProducto {
    boolean Grabar(Producto pro);
    Producto Buscar(int id);
    ArrayList<Producto> Listar();
    boolean Modificar (Producto pro);
    boolean Eliminar(int NumActivo);
    Producto Buscar2(int activo);
    Producto Buscar3(String tipo);
    Producto BuscarSerie(int activo);
}