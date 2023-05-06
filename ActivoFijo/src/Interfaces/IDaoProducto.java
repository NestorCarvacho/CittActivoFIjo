
package Interfaces;

import Modelo.Producto;
import java.util.ArrayList;

public interface IDaoProducto {
    boolean Grabar(Producto pro);
    Producto Buscar(int id);
    ArrayList<Producto> Listar();
    boolean Modificar (Producto pro);
    boolean Eliminar(int id);
}