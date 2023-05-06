package Interfaces;

import Modelo.TipoEmpleado;
import java.util.ArrayList;


public interface IDaoTipoEmpleado {
    boolean Grabar(TipoEmpleado tpEmp);
    TipoEmpleado  Buscar(int id);
    ArrayList<TipoEmpleado> Listar();
    boolean Modificar (TipoEmpleado tpEmp);
    boolean Eliminar(int id);
}
