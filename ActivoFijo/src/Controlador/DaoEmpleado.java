package Controlador;

import Interfaces.IDaoEmpleado;
import Modelo.Empleado;
import Modelo.Supervisor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoEmpleado implements IDaoEmpleado {

    private Connection cone;

    public DaoEmpleado() {
        cone = new Conexion().getCone();
    }

    @Override
    public ArrayList<Empleado> Listar() {
        try {
            String sql = "select  * from EMPLEADO";
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
                emp.setSupervisorEmpleado(new DaoSupervisor().Buscar2(reg.getInt("SUPERVISOR_ID_SUPERVISOR")));
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
        try {
            String sql1 = "insert into EMPLEADO values(SEQ_EMPLEADO.NEXTVAL,?,?,?,?,?,?,?)";
            PreparedStatement pstm1 = cone.prepareCall(sql1);
            pstm1.setString(1, emp.getRutEmpleado());//RUN_EMPLEADO
            pstm1.setString(2, emp.getNombreEmpleado());//NOMBRE_EMPLEADO
            pstm1.setString(3, emp.getTelefonoEmpleado());//TELEFONO_EMPLEADO
            pstm1.setString(4, emp.getDireccionEmpleado());//DIRECCION_EMPLEADO
            pstm1.setInt(5, emp.getCargoEmpleado().getIdTipoEmpleado());//TIPO_EMPLEADO_ID_TIPO
            pstm1.setInt(6, emp.getJornadaEmpleado().getIdJornada());//JORNADA_ID_JORNADA
            pstm1.setInt(7, emp.getSupervisorEmpleado().getId_supervisor());//SUPERVISOR_ID_SUPERVISOR
            int afect1 = pstm1.executeUpdate();

            if (emp.getCargoEmpleado().getIdTipoEmpleado() == 1) {
                String sql2 = "insert into SUPERVISOR values(SEQ_SUPERVISOR.NEXTVAL,?)";
                PreparedStatement pstm2 = cone.prepareCall(sql2);
                pstm2.setString(1, emp.getNombreEmpleado());//NOMBRE_SUPERVISOR
                int afect2 = pstm2.executeUpdate();
                return (afect1 > 0 && afect2 > 0);
            } else {
                return (afect1 > 0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error grabar Empleado:" + e.getMessage());
            return false;
        }
    }

    @Override
    public Empleado Buscar(int id) {
        try {
            String sql = "SELECT * FROM EMPLEADO WHERE Id_empleado=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg = pstm.executeQuery();
            Empleado emp = null;
            while (reg.next()) {
                emp = new Empleado();
                emp.setIdEmpleado(reg.getInt("ID_EMPLEADO"));
                emp.setRutEmpleado(reg.getString("RUN_EMPLEADO"));
                emp.setNombreEmpleado(reg.getString("NOMBRE_COMPLETO_EMPLEADO"));
                emp.setTelefonoEmpleado(reg.getString("TELEFONO_EMPLEADO"));
                emp.setDireccionEmpleado(reg.getString("DIRECCION_EMPLEADO"));
                emp.setCargoEmpleado(new DaoTipoEmpleado().Buscar2(reg.getInt("TIPO_EMPLEADO_ID_TIPO")));
                emp.setJornadaEmpleado(new DaoJornada().Buscar(reg.getInt("JORNADA_ID_JORNADA")));
            }
            return emp;
        } catch (Exception e) {
            System.out.println("error buscar Empleado:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Modificar(Empleado emp) {
        try {
            String sql = "update EMPLEADO set RUN_EMPLEADO=?,"
                    + "NOMBRE_COMPLETO_EMPLEADO=?,"
                    + "TELEFONO_EMPLEADO=?,"
                    + "DIRECCION_EMPLEADO=?,"
                    + "TIPO_EMPLEADO_ID_TIPO=?,"
                    + "JORNADA_ID_JORNADA=? where ID_EMPLEADO=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(7, emp.getIdEmpleado());
            pstm.setString(1, emp.getRutEmpleado());
            pstm.setString(2, emp.getNombreEmpleado());
            pstm.setString(3, emp.getTelefonoEmpleado());
            pstm.setString(4, emp.getDireccionEmpleado());
            pstm.setInt(5, emp.getCargoEmpleado().getIdTipoEmpleado());
            pstm.setInt(6, emp.getJornadaEmpleado().getIdJornada());
            int afect = pstm.executeUpdate();
            return afect > 0;
        } catch (Exception e) {
            System.out.println("error modificar Empleado:" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean Eliminar(int id) {
        try {
            String sql = "delete from EMPLEADO where ID_EMPLEADO=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id);
            int afect = pstm.executeUpdate();
            return afect > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error eliminar Empleado:" + e.getMessage());
            System.out.println("error eliminar Empleado:" + e.getMessage());
            return false;
        }
    }

    public Empleado Buscar2(String Run) {
        try {
            String sql = "SELECT * FROM EMPLEADO WHERE RUN_EMPLEADO=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, Run);
            ResultSet reg = pstm.executeQuery();
            Empleado emp = null;
            while (reg.next()) {
                emp = new Empleado();
                emp.setIdEmpleado(reg.getInt("ID_EMPLEADO"));
                emp.setRutEmpleado(reg.getString("RUN_EMPLEADO"));
                emp.setNombreEmpleado(reg.getString("NOMBRE_COMPLETO_EMPLEADO"));
                emp.setTelefonoEmpleado(reg.getString("TELEFONO_EMPLEADO"));
                emp.setDireccionEmpleado(reg.getString("DIRECCION_EMPLEADO"));
                emp.setCargoEmpleado(new DaoTipoEmpleado().Buscar2(reg.getInt("TIPO_EMPLEADO_ID_TIPO")));
                emp.setJornadaEmpleado(new DaoJornada().Buscar(reg.getInt("JORNADA_ID_JORNADA")));
                emp.setSupervisorEmpleado(new DaoSupervisor().Buscar2(reg.getInt("SUPERVISOR_ID_SUPERVISOR")));
            }
            return emp;
        } catch (Exception e) {
            System.out.println("error buscar Empleado2:" + e.getMessage());
            return null;
        }
    }

    public ArrayList<Empleado> Listar2() {
        try {
            String sql = "select NOMBRE_COMPLETO_EMPLEADO from EMPLEADO WHERE TIPO_EMPLEADO_ID_TIPO=1";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<Empleado> listado = new ArrayList<>();
            while (reg.next()) {
                Empleado emp = new Empleado();
                emp.setNombreEmpleado(reg.getString("NOMBRE_COMPLETO_EMPLEADO"));
                listado.add(emp);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar Empleado:" + e.getMessage());
            return null;
        }
    }

    @Override
    public Empleado Buscar3(String Run) {
        try {
            String sql = "SELECT * FROM EMPLEADO WHERE RUN_EMPLEADO=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, Run);
            ResultSet reg = pstm.executeQuery();
            Empleado emp = null;
            while (reg.next()) {
                emp = new Empleado();
                emp.setIdEmpleado(reg.getInt("ID_EMPLEADO"));
                emp.setRutEmpleado(reg.getString("RUN_EMPLEADO"));
            }
            return emp;
        } catch (Exception e) {
            System.out.println("error buscar Empleado2:" + e.getMessage());
            return null;
        }
    }

}
