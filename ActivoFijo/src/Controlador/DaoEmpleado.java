package Controlador;

import Interfaces.IDaoEmpleado;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoEmpleado implements IDaoEmpleado {

    private Connection cone;

    public DaoEmpleado() {
        cone = new Conexion().getCone();
    }

    @Override
    public ArrayList<Empleado> Listar() {
        try {
            String sql = "select  ID_EMPLEADO, RUN_EMPLEADO, NOMBRE_COMPLETO_EMPLEADO, TELEFONO_EMPLEADO, DIRECCION_EMPLEADO, TIPO_EMPLEADO_ID_TIPO, JORNADA_ID_JORNADA from EMPLEADO";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<Empleado> listado = new ArrayList<>();
            while (reg.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpleado(reg.getInt("ID_EMPLEADO"));
                emp.setRutEmpleado(reg.getString("RUN_EMPLEADO"));
                emp.setNombreEmpleado(reg.getString("NOMBRE_COMPLETO_EMPLEADO"));
                emp.setTelefonoEmpleado(reg.getString("TELEFONO_EMPLEADO"));
                emp.setDireccionEmpleado(reg.getString("DIRECCION_EMPLEADO"));
                emp.setCargoEmpleado(new DaoTipoEmpleado().Buscar2(reg.getInt("TIPO_EMPLEADO_ID_TIPO")));
                emp.setJornadaEmpleado(new DaoJornada().Buscar(reg.getInt("JORNADA_ID_JORNADA")));
                listado.add(emp);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar Empleado:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Grabar(Empleado emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado Buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Modificar(Empleado emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
