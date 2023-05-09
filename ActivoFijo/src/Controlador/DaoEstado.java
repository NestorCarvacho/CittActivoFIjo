
package Controlador;

import Interfaces.IDaoEstado;
import Modelo.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoEstado implements IDaoEstado{
    private  Connection cone;

    public DaoEstado() {
        cone = new Conexion().getCone();
    }

    
    @Override
    public ArrayList<Estado> Listar() {
        try {
            String sql = "select ID_ESTADO,DESCRIPCION_ESTADO from ESTADO";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<Estado> listado = new ArrayList<>();
            while (reg.next()) {
                Estado esta = new Estado();
                esta.setIdEstado(reg.getInt("ID_ESTADO"));
                esta.setDescripcionEstado(reg.getString("DESCRIPCION_ESTADO"));
                listado.add(esta);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar Estados:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Grabar(Estado jorn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Estado Buscar(int id) {
        try {
            String sql="SELECT * FROM ESTADO WHERE ID_ESTADO=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg=pstm.executeQuery();
            Estado est=null;
            while (reg.next()) {                
                est = new Estado();
                est.setIdEstado(reg.getInt("ID_ESTADO"));
                est.setDescripcionEstado(reg.getString("DESCRIPCION_ESTADO"));
            }
            return est;
        } catch (Exception e) {
            System.out.println("error buscar Jornada:"+e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Modificar(Estado jorn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Estado Buscar2(String estado) {
        try {
            String sql="SELECT ID_ESTADO FROM ESTADO WHERE DESCRIPCION_ESTADO=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, estado);
            ResultSet reg=pstm.executeQuery();
            Estado est=null;
            while (reg.next()) {                
                est = new Estado();
                est.setIdEstado(reg.getInt("ID_ESTADO"));
            }
            return est;
        } catch (Exception e) {
            System.out.println("error buscar Jornada:"+e.getMessage());
            return null;
        }
    }
}
