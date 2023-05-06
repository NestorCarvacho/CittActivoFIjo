
package Interfaces;

import Modelo.Bodega;
import java.util.ArrayList;

public interface IDaoBodega {
    boolean Grabar(Bodega bod);
    Bodega Buscar(int id);
    ArrayList<Bodega> Listar();
    boolean Modificar (Bodega bpd);
    boolean Eliminar(int id);
}
