
package Interfaces;

import Modelo.TipoProducto;
import java.util.ArrayList;

public interface IDaoTipoProducto {
    boolean Grabar(TipoProducto tpProd);
    TipoProducto Buscar(int id);
    ArrayList<TipoProducto> Listar();
    boolean Modificar (TipoProducto tpProd);
    boolean Eliminar(int idtipoProducto);
    TipoProducto Buscar2(String TipoProducto);
}
