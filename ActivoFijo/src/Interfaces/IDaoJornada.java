package Interfaces;

import Modelo.Jornada;
import java.util.ArrayList;


public interface IDaoJornada {
    boolean Grabar(Jornada jorn);
    Jornada  Buscar(int id);
    ArrayList<Jornada> Listar();
    boolean Modificar (Jornada jorn);
    boolean Eliminar(int id);
}
