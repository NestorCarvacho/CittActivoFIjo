
package Interfaces;

import Modelo.Usuario;


public interface IDaoUsuario {
    boolean Grabar(Usuario usu);
    Usuario  Buscar(int id);
    boolean Modificar (Usuario usu);
    boolean Eliminar(int id);
    boolean validarContrasena(String usuario, String contrasena);
}
