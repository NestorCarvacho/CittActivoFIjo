
package Controlador;

import Interfaces.IDaoUsuario;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoUsuario implements IDaoUsuario{
    private  Connection cone;

    public DaoUsuario() {
        cone = new Conexion().getCone();
    }

    @Override
    public boolean Grabar(Usuario usu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario Buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Modificar(Usuario usu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validarContrasena(String usuario, String contrasena) {
        try {
            String sql = "SELECT nombre_usuario,contrasena FROM USUARIO WHERE nombre_usuario=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, usuario);
            ResultSet resultado = pstm.executeQuery();
            Usuario user = null;
            if(resultado.next()){
                user = new Usuario();
                String contrasenaBD = resultado.getString("contrasena");
                user.setNombre_usuario(resultado.getString("nombre_usuario"));
                return contrasenaBD.equals(contrasena);
            }
            return false;
        } catch (Exception e) {
            return false;
            
        }
    }

    
    
}
