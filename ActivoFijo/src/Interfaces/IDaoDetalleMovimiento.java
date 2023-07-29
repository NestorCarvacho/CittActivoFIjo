
package Interfaces;

import Modelo.DetalleMovimiento;
import Modelo.Movimiento;
import java.util.ArrayList;


public interface IDaoDetalleMovimiento {
    boolean Grabar(DetalleMovimiento mov);
    DetalleMovimiento  Buscar(int id);
    ArrayList<DetalleMovimiento> Listar();
    boolean Modificar (DetalleMovimiento mov);
    boolean Eliminar(int id);
}
