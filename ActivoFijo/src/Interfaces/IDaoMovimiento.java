
package Interfaces;

import Modelo.Movimiento;
import java.util.ArrayList;


public interface IDaoMovimiento {
    boolean Grabar(Movimiento mov);
    Movimiento  Buscar(int id);
    ArrayList<Movimiento> Listar();
    boolean Modificar (Movimiento mov);
    boolean Eliminar(int id);
}
