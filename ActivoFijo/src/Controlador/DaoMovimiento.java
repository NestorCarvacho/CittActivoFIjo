package Controlador;

import Interfaces.IDaoMovimiento;
import Modelo.Movimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.internal.ResultSetCache;

public class DaoMovimiento implements IDaoMovimiento {

    private Connection cone;

    public DaoMovimiento() {
        cone = new Conexion().getCone();
    }

    @Override
    public boolean Grabar(Movimiento mov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
                mov.setDetalleMovimiento(reg.getString("DESCRIPCION_MOVIMIENTO"));//DESCRIPCION_MOVIMIENTO
                //prod.setTipoProducto(new DaoTipoProducto().Buscar(reg.getInt("TIPO_PRODUCTO_ID_TIPO")));
                mov.setProductoIdProducto(new DaoProducto().Buscar(reg.getInt("PRODUCTO_ID_PRODUCTO")));//PRODUCTO_ID_PRODUCTO
                mov.setUbicacionInicio(reg.getString("UBICACION_INICIO"));//UBICACION_INICIO
                mov.setUbicacionFinal(reg.getString("UBICACION_FINAL"));//UBICACION_FINAL
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
            String sql = "SELECT * FROM movimiento";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<Movimiento> listado = new ArrayList<>();
            while (reg.next()) {
                Movimiento mov = new Movimiento();
                mov.setIdMovimiento(reg.getInt("ID_MOVIMIENTO")); //ID_MOVIMIENTO
                mov.setDetalleMovimiento(reg.getString("DESCRIPCION_MOVIMIENTO"));//DESCRIPCION_MOVIMIENTO
                //prod.setTipoProducto(new DaoTipoProducto().Buscar(reg.getInt("TIPO_PRODUCTO_ID_TIPO")));
                mov.setProductoIdProducto(new DaoProducto().Buscar(reg.getInt("PRODUCTO_ID_PRODUCTO")));//PRODUCTO_ID_PRODUCTO
                mov.setUbicacionInicio(reg.getString("UBICACION_INICIO"));//UBICACION_INICIO
                mov.setUbicacionFinal(reg.getString("UBICACION_FINAL"));//UBICACION_FINAL
                mov.setFechaMovimiento(reg.getDate("FECHA_MOVIMIENTO"));//FECHA_MOVIMIENTO
                listado.add(mov);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar Tipo Prodcuto:" + e.getMessage());
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
}
