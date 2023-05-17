
package Interfaces;

//importar la clase color desde la carpeta modelo, se debe usar 
// import nombreCarpeta.Clase;
import Modelo.Color;
import java.util.ArrayList;

public interface IDaoColor {
    boolean Grabar(Color col);
    Color Buscar(int id);
    Color Buscar2(String nombre);
    ArrayList<Color> Listar();
    boolean Modificar (Color col);
    boolean Eliminar(int id);
}
