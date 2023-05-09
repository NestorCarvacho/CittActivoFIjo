
package Interfaces;
import java.util.ArrayList;
import Modelo.Empleado;

public interface IDaoEmpleado {
    boolean Grabar(Empleado emp);
    Empleado Buscar(int id);
    ArrayList<Empleado> Listar();
    boolean Modificar (Empleado emp);
    boolean Eliminar(int id);
    Empleado Buscar2(String Run);
}
