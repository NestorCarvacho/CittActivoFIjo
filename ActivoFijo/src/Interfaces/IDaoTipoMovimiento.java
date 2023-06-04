
package Interfaces;

//importar la clase color desde la carpeta modelo, se debe usar 
// import nombreCarpeta.Clase;
import Modelo.TipoMovimiento;
import java.util.ArrayList;

public interface IDaoTipoMovimiento {
    boolean Grabar(TipoMovimiento tpmov);
    TipoMovimiento Buscar(int id);
    TipoMovimiento Buscar2(String nombre);
    ArrayList<TipoMovimiento> Listar();
    boolean Modificar (TipoMovimiento tpmov);
    boolean Eliminar(int id);
}
