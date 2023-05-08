
package Controlador;

import Interfaces.IDaoProducto;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoProducto implements IDaoProducto{
    
    private  Connection cone;
    
    public DaoProducto(){
        cone = new Conexion().getCone();
    }

    @Override
    public boolean Grabar(Producto pro) {
        
        try {
            //Colocar la sentencia sql
            String sql = "";
            PreparedStatement pstm = cone.prepareCall(sql);
            //Completar con los atributos finales
            pstm.setInt(1, pro.getNumActivoProducto());
            
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Producto Buscar(int id) {
        try {
            //Colocar la sentencia sql
            String sql = "";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg = pstm.executeQuery();
            Producto pro = null;
            while (reg.next()) {                
                pro = new Producto();
                //Completar con los atributos finales
                pro.setNumActivoProducto(reg.getInt("NUMACTIVOPRODUCTO"));
            }
            return pro;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Producto> Listar() {
        try {
            String sql = "select * from PRODUCTO";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<Producto> listado = new ArrayList<>();
            while (reg.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(reg.getInt("ID_PRODUCTO"));
                prod.setNumActivoProducto(reg.getInt("NUMERO_ACTIVO_PRODUCTO"));
                prod.setNumSerieProducto(reg.getInt("NUMERO_SERIE_PRODUCTO"));
                prod.setDescProducto(reg.getString("DESCRIPCION_PRODUCTO"));
                prod.setUbicacionProducto(new DaoUbicacion().Buscar(reg.getInt("UBICACION_ID_UBICACION")));
                prod.setTipoProducto(new DaoTipoProducto().Buscar(reg.getInt("TIPO_PRODUCTO_ID_TIPO")));
                prod.setEstadoProducto(new DaoEstado().Buscar(reg.getInt("ESTADO_ID_ESTADO")));          
                prod.setFechaLlegadaProducto(reg.getDate("FECHA_LLEGADA_PRODUCTO"));
                prod.setColorProducto(reg.getString("COLOR_PRODUCTO"));
                prod.setCostoProducto(reg.getInt("COSTO_PRODUCTO"));
                listado.add(prod);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar Producto:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Modificar(Producto pro) {
        try {
            String sql = "update producto set x=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(12, pro.getNumActivoProducto());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean Eliminar(int id) {
        try {
            String sql = "delete from producto where x=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
