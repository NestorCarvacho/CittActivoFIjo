
package Controlador;

import Interfaces.IDaoProducto;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoProducto implements IDaoProducto{
    
    private  Connection cone;
    
    public DaoProducto(){
        cone = new Conexion().getCone();
    }

    @Override
    public boolean Grabar(Producto pro) {
        try {
            String sql="insert into PRODUCTO values(SEQ_PRODUCTO.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1, pro.getNumActivoProducto());//NUMERO_ACTIVO
            pstm.setInt(2, pro.getNumSerieProducto());//NUMERO DE SERIE
            pstm.setString(3 , pro.getDescProducto());//DESCRIPCION
            pstm.setInt(4, pro.getUbicacionProducto().getIdUbicacion());//UBICACION
            pstm.setInt(5, pro.getTipoProducto().getIdTipoProducto());//TIPO PRODUCTO
            java.sql.Date fecha=new java.sql.Date(pro.getFechaLlegadaProducto().getTime());
            pstm.setDate(6, fecha);//FECHA LLEGADA
            pstm.setString(7, pro.getColorProducto());//COLOR PRODUCTO
            pstm.setInt(8, pro.getCostoProducto());//COSTO PRODUCTO
            pstm.setInt(9, pro.getEstadoProducto().getIdEstado());//ESTADO PRODUCTO
            pstm.setInt(10, pro.getContNetoProducto());//LITROS
            int afect = pstm.executeUpdate();
            return afect>0;            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error grabar Producto:"+e.getMessage());
            return false;
        }
    }

    @Override
    public Producto Buscar(int id) {
        try {
            //Colocar la sentencia sql
            String sql = "select * from PRODUCTO where ID_PRODUCTO = ?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg = pstm.executeQuery();
            Producto produ=null;
            while (reg.next()) {                
                produ = new Producto();
                produ.setIdProducto(reg.getInt("ID_PRODUCTO"));
                produ.setNumActivoProducto(reg.getInt("NUMERO_ACTIVO_PRODUCTO"));
                produ.setNumSerieProducto(reg.getInt("NUMERO_SERIE_PRODUCTO"));
                produ.setDescProducto(reg.getString("DESCRIPCION_PRODUCTO"));
                produ.setUbicacionProducto(new DaoUbicacion().Buscar(reg.getInt("UBICACION_ID_UBICACION")));
                produ.setTipoProducto(new DaoTipoProducto().Buscar(reg.getInt("TIPO_PRODUCTO_ID_TIPO")));
                produ.setEstadoProducto(new DaoEstado().Buscar(reg.getInt("ESTADO_ID_ESTADO")));          
                produ.setFechaLlegadaProducto(reg.getDate("FECHA_LLEGADA_PRODUCTO"));
                produ.setColorProducto(reg.getString("COLOR_PRODUCTO"));
                produ.setCostoProducto(reg.getInt("COSTO_PRODUCTO"));
                produ.setContNetoProducto(reg.getInt("LITROS_PRODUCTO"));
            }
            return produ;
        } catch (Exception e) {
            System.out.println("error buscarProducto2:"+e.getMessage());
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
            String sql="update PRODUCTO set NUMERO_ACTIVO_PRODUCTO=?,"
                    + "NUMERO_SERIE_PRODUCTO=?,"
                    + "DESCRIPCION_PRODUCTO=?,"
                    + "UBICACION_ID_UBICACION=?,"
                    + "TIPO_PRODUCTO_ID_TIPO=?,"
                    + "ESTADO_ID_ESTADO=?,"
                    + "FECHA_LLEGADA_PRODUCTO=?,"
                    + "COLOR_PRODUCTO=?,"
                    + "COSTO_PRODUCTO=? where NUMERO_ACTIVO_PRODUCTO=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(10, pro.getNumActivoProducto());
            pstm.setInt(1, pro.getNumActivoProducto());
            pstm.setInt(2, pro.getNumSerieProducto());
            pstm.setString(3, pro.getDescProducto());
            pstm.setInt(4 , pro.getUbicacionProducto().getIdUbicacion());
            pstm.setInt(5 , pro.getTipoProducto().getIdTipoProducto());
            pstm.setInt(6, pro.getEstadoProducto().getIdEstado());
            java.sql.Date fecha=new java.sql.Date(pro.getFechaLlegadaProducto().getTime());
            pstm.setDate(7, fecha);
            pstm.setString(8, pro.getColorProducto());
            pstm.setInt(9, pro.getCostoProducto());
            int afect = pstm.executeUpdate();
            return afect>0;            
        } catch (Exception e) {
            System.out.println("error modificar reser:"+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean Eliminar(int NumActivo) {
         try {
            String sql="delete from PRODUCTO where NUMERO_ACTIVO_PRODUCTO=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1, NumActivo);            
            int afect = pstm.executeUpdate();
            return afect>0;            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error eliminar Prodcuto:"+e.getMessage());
             System.out.println("error eliminar Prodcuto:"+e.getMessage());
            return false;
        }
    }

    @Override
    public Producto Buscar2(int activo) {
        try {
            //Colocar la sentencia sql
            String sql = "select * from PRODUCTO where NUMERO_ACTIVO_PRODUCTO = ?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1, activo);
            ResultSet reg = pstm.executeQuery();
            Producto prod=null;
            while (reg.next()) {                
                prod = new Producto();
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
            }
            return prod;
        } catch (Exception e) {
            System.out.println("error buscarProducto2:"+e.getMessage());
            return null;
        }
    }
    
    
    @Override
    public Producto Buscar3(String tipo) {
        try {
            //Colocar la sentencia sql
            String sql = "SELECT COUNT(p.id_PRODUCTO) \n"
                    + "FROM PRODUCTO P \n"
                    + "JOIN TIPO_PRODUCTO TPPROD \n"
                    + "on p.TIPO_PRODUCTO_ID_TIPO=TPPROD.ID_TIPO_PRODUCTO \n"
                    + "WHERE TPPROD.DESCRIPCION_TIPO_PRODUCTO=?  ";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, tipo);
            ResultSet reg = pstm.executeQuery();
            Producto prod=null;
            while (reg.next()) {                
                prod = new Producto();
                prod.setStockProducto(reg.getInt("COUNT(p.id_PRODUCTO)"));
            }
            return prod;
        } catch (Exception e) {
            System.out.println("error buscarProducto3:"+e.getMessage());
            return null;
        }
    }
    
}
