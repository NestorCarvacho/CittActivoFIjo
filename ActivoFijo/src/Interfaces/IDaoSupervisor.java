
package Interfaces;

import Modelo.Supervisor;
import java.util.ArrayList;


public interface IDaoSupervisor {
    boolean Grabar(Supervisor emp);
    Supervisor Buscar(String nombre);
    ArrayList<Supervisor> Listar();
    boolean Modificar (Supervisor sup);
    boolean Eliminar(int id);
    Supervisor Buscar2(int id);
}
