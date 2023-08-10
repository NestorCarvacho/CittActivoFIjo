package Controlador;

import Interfaces.IDaoMovimiento;
import Modelo.Movimiento;
import Modelo.Ubicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DaoMovimiento implements IDaoMovimiento {

    private Connection cone;

    public DaoMovimiento() {
        cone = new Conexion().getCone();
    }

    @Override
    public boolean Grabar(Movimiento mov) {
        try {
            String sql="INSERT INTO MOVIMIENTO VALUES(seq_movimiento.NEXTVAL,?,?,SYSDATE)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, mov.getTpMovIdTipoMovimiento().getIdTipoMovimiento());
            pstm.setInt(2, mov.getUbicacionFinal().getIdUbicacion());
            int afect = pstm.executeUpdate();
            return (afect > 0);
        } catch (Exception e) {
            System.out.println("Error bd: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Movimiento Buscar(int id) {
        try {
            //Colocar la sentencia sql
            String sql = "SELECT * FROM movimiento WHERE PRODUCTO_ID_PRODUCTO=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg = pstm.executeQuery();
            Movimiento mov = null;
            while (reg.next()) {
                mov = new Movimiento();
                mov.setIdMovimiento(reg.getInt("ID_MOVIMIENTO")); //ID_MOVIMIENTO
                mov.setTpMovIdTipoMovimiento(new DaoTipoMovimiento().Buscar(reg.getInt("TP_MOV_ID_TIPO_MOVIMIENTO")));//DESCRIPCION_MOVIMIENTO
                //prod.setTipoProducto(new DaoTipoProducto().Buscar(reg.getInt("TIPO_PRODUCTO_ID_TIPO")));
                //mov.setUbicacionInicio(new DaoUbicacion().Buscar(reg.getInt("UBICACION_INICIO")));
                mov.setUbicacionFinal(new DaoUbicacion().Buscar(reg.getInt("UBICACION_FINAL")));
                mov.setFechaMovimiento(reg.getDate("FECHA_MOVIMIENTO"));//FECHA_MOVIMIENTO
                System.out.println(mov);
            }
            return mov;
        } catch (Exception e) {
            System.out.println("error buscar Movimiento de pructo:" + e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Movimiento> Listar() {
        try {
            String sql = "SELECT * FROM movimiento order by id_movimiento desc";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<Movimiento> listado = new ArrayList<>();
            while (reg.next()) {
                Movimiento mov = new Movimiento();
                mov.setIdMovimiento(reg.getInt("ID_MOVIMIENTO")); //ID_MOVIMIENTO
                mov.setTpMovIdTipoMovimiento(new DaoTipoMovimiento().Buscar(reg.getInt("TP_MOV_ID_TIPO_MOVIMIENTO")));//DESCRIPCION_MOVIMIENTO
                //prod.setTipoProducto(new DaoTipoProducto().Buscar(reg.getInt("TIPO_PRODUCTO_ID_TIPO")));
                //mov.setUbicacionInicio(new DaoUbicacion().Buscar(reg.getInt("UBICACION_INICIO")));
                mov.setUbicacionFinal(new DaoUbicacion().Buscar(reg.getInt("UBICACION_FINAL")));
                mov.setFechaMovimiento(reg.getDate("FECHA_MOVIMIENTO"));//FECHA_MOVIMIENTO
                listado.add(mov);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar movimiento:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Modificar(Movimiento mov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } 

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int ultimoMovimiento() {
       try {
            //Colocar la sentencia sql
            String sql = "SELECT MAX(id_movimiento) AS id_movimiento FROM movimiento";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            Movimiento mov = null;
            while (reg.next()) {
                mov = new Movimiento();
                mov.setIdMovimiento(reg.getInt("ID_MOVIMIENTO")); //ID_MOVIMIENTO
            }
            return mov.getIdMovimiento();
        } catch (Exception e) {
            System.out.println("error buscar ultimo movimiento: " + e.getMessage());
            return 0;
        }
    }
    
    
}
 