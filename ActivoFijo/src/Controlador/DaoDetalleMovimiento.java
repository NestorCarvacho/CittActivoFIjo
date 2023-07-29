package Controlador;

import Interfaces.IDaoDetalleMovimiento;
import Modelo.DetalleMovimiento;
import Modelo.Movimiento;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoDetalleMovimiento implements IDaoDetalleMovimiento {

    private Connection cone;

    public DaoDetalleMovimiento() {
        cone = new Conexion().getCone();
    }

    @Override
    public boolean Grabar(DetalleMovimiento mov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleMovimiento Buscar(int id) {
        try {
            //Colocar la sentencia sql
            String sql = "SELECT * FROM detalle_movimiento WHERE movimiento_id_movimiento=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg = pstm.executeQuery();
            DetalleMovimiento detmov = null;
            while (reg.next()) {
                detmov = new DetalleMovimiento();
                detmov.setIdMovimiento(new DaoMovimiento().Buscar(reg.getInt("MOVIMIENTO_ID_MOVIMIENTO"))); //MOVIMIENTO_ID_MOVIMIENTO
                detmov.setIdProducto(new DaoProducto().Buscar(reg.getInt("PRODUCTO_ID_PRODUCTO"))); //PRODUCTO_ID_PRODUCTO
                System.out.println(detmov);
            }
            return detmov;
        } catch (Exception e) {
            System.out.println("error buscar detalle Movimiento:" + e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<DetalleMovimiento> Listar() {
        try {
            String sql = "SELECT * FROM detalle_movimiento";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<DetalleMovimiento> listado = new ArrayList<>();
            while (reg.next()) {
                DetalleMovimiento detmov = new DetalleMovimiento();
                detmov.setIdMovimiento(new DaoMovimiento().Buscar(reg.getInt("MOVIMIENTO_ID_MOVIMIENTO"))); //MOVIMIENTO_ID_MOVIMIENTO
                detmov.setIdProducto(new DaoProducto().Buscar(reg.getInt("PRODUCTO_ID_PRODUCTO"))); //PRODUCTO_ID_PRODUCTO
                System.out.println(detmov);
                listado.add(detmov);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar Tipo Prodcuto:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Modificar(DetalleMovimiento mov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
