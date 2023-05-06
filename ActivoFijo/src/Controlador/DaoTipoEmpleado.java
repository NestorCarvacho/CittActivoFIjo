package Controlador;

import Interfaces.IDaoTipoEmpleado;
import Modelo.TipoEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoTipoEmpleado implements IDaoTipoEmpleado {
    private  Connection cone;

    public DaoTipoEmpleado() {
        cone = new Conexion().getCone();
    }


    @Override
    public ArrayList<TipoEmpleado> Listar() {
        try {
            String sql = "select ID_TIPO_EMPLEADO,DESCRIPCION_TIPO_EMPLEADO from TIPO_EMPLEADO";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<TipoEmpleado> listado = new ArrayList<>();
            while (reg.next()) {
                TipoEmpleado tpemp = new TipoEmpleado();
                tpemp.setIdTipoEmpleado(reg.getInt("ID_TIPO_EMPLEADO"));
                tpemp.setDescripcionTipoEmpleado(reg.getString("DESCRIPCION_TIPO_EMPLEADO"));
                listado.add(tpemp);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar tipo empleado:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Grabar(TipoEmpleado tpEmp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoEmpleado Buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Modificar(TipoEmpleado tpEmp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
