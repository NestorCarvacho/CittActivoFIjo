package Controlador;

import Interfaces.IDaoTipoProducto;
import Modelo.TipoProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoTipoProducto implements IDaoTipoProducto {

    private Connection cone;

    public DaoTipoProducto() {
        cone = new Conexion().getCone();
    }

    @Override
    public ArrayList<TipoProducto> Listar() {
        try {
            String sql = "select ID_TIPO_PRODUCTO,DESCRIPCION_TIPO_PRODUCTO from TIPO_PRODUCTO";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<TipoProducto> listado = new ArrayList<>();
            while (reg.next()) {
                TipoProducto jorn = new TipoProducto();
                jorn.setIdTipoProducto(reg.getInt("ID_TIPO_PRODUCTO"));
                jorn.setDescripcionTipoProducto(reg.getString("DESCRIPCION_TIPO_PRODUCTO"));
                listado.add(jorn);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar Tipo Prodcuto:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Grabar(TipoProducto tpProd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoProducto Buscar(int id) {
        try {
            String sql = "SELECT * FROM TIPO_PRODUCTO WHERE ID_TIPO_PRODUCTO=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg = pstm.executeQuery();
            TipoProducto tpProd = null;
            while (reg.next()) {
                tpProd = new TipoProducto();
                tpProd.setIdTipoProducto(reg.getInt("ID_TIPO_PRODUCTO"));
                tpProd.setDescripcionTipoProducto(reg.getString("DESCRIPCION_TIPO_PRODUCTO"));
            }
            return tpProd;
        } catch (Exception e) {
            System.out.println("error buscar TIpo Producto:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Modificar(TipoProducto tpProd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public TipoProducto Buscar2(String TipoProducto) {
        try {
            String sql = "SELECT ID_TIPO_PRODUCTO FROM TIPO_PRODUCTO WHERE DESCRIPCION_TIPO_PRODUCTO=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, TipoProducto);
            ResultSet reg = pstm.executeQuery();
            TipoProducto tpProd = null;
            while (reg.next()) {
                tpProd = new TipoProducto();
                tpProd.setIdTipoProducto(reg.getInt("ID_TIPO_PRODUCTO"));
            }
            return tpProd;
        } catch (Exception e) {
            System.out.println("error buscar TIpo Producto:" + e.getMessage());
            return null;
        }
    }
}
