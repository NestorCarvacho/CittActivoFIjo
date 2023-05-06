package Interfaces;
import Modelo.Ubicacion;
import java.util.ArrayList;

public interface IDaoUbicacion {
    boolean Grabar(Ubicacion ubi);
    Ubicacion Buscar(int id);
    ArrayList<Ubicacion> Listar();
    boolean Modificar (Ubicacion ubi);
    boolean Eliminar(int id);
}
