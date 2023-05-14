package Controlador;

import Interfaces.IDaoSupervisor;
import Modelo.Supervisor;
import Modelo.TipoEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoSupervisor implements IDaoSupervisor {
    private  Connection cone;

    public DaoSupervisor() {
        cone = new Conexion().getCone();
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Grabar(Supervisor emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Modificar(Supervisor sup) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Supervisor Buscar(String nombre) {
        try {
            String sql="SELECT * FROM SUPERVISOR WHERE NOMBRE_COMPLETO_SUPERVISOR=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, nombre);
            ResultSet reg=pstm.executeQuery();
            Supervisor sup=null;
            while (reg.next()) {                
                sup=new Supervisor();
                sup.setId_supervisor(reg.getInt("ID_SUPERVISOR"));
            }
            return sup;
        } catch (Exception e) {
            System.out.println("error buscar tipo empleado:"+e.getMessage());
            return null;
        }
    }
    @Override
    public Supervisor Buscar2(int id) {
        try {
            String sql="SELECT * FROM SUPERVISOR WHERE ID_SUPERVISOR=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg=pstm.executeQuery();
            Supervisor sup=null;
            while (reg.next()) {                
                sup=new Supervisor();
                sup.setNombreSupervisor(reg.getString("NOMBRE_COMPLETO_SUPERVISOR"));
            }
            return sup;
        } catch (Exception e) {
            System.out.println("error buscar tipo empleado:"+e.getMessage());
            return null;
        }
    }
    @Override
    public ArrayList<Supervisor> Listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
