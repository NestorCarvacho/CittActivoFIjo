
package Interfaces;

import Modelo.Estado;
import java.util.ArrayList;


public interface IDaoEstado {
    boolean Grabar(Estado jorn);
    Estado  Buscar(int id);
    ArrayList<Estado> Listar();
    boolean Modificar (Estado jorn);
    boolean Eliminar(int id);
    Estado Buscar2(String estado);
}
