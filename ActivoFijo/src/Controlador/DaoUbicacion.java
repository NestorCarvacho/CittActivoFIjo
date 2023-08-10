
package Controlador;

import Interfaces.IDaoUbicacion;
import Modelo.Ubicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoUbicacion implements IDaoUbicacion{
    
    private  Connection cone;
    
    public DaoUbicacion(){
        cone = new Conexion().getCone();
    }

    @Override
    public ArrayList<Ubicacion> Listar() {
        try {
            String sql = "select ID_UBICACION,DESCRIPCION_UBICACION from UBICACION";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<Ubicacion> listado = new ArrayList<>();
            while (reg.next()) {
                Ubicacion jorn = new Ubicacion();
                jorn.setIdUbicacion(reg.getInt("ID_UBICACION"));
                jorn.setDescripcionUbicacion(reg.getString("DESCRIPCION_UBICACION"));
                listado.add(jorn);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar Ubicacion:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Grabar(Ubicacion ubi) {
        try {
            String sql="INSERT INTO ubicacion VALUES (SEQ_BODEGA.NEXTVAL,?)";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, ubi.getDescripcionUbicacion());
            int afect = pstm.executeUpdate();
            return afect>0;            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error grabar Ubicacion:"+e.getMessage());
            return false;
        }
    }

    @Override
    public Ubicacion Buscar(int id) {
        try {
            String sql = "SELECT * FROM UBICACION WHERE ID_UBICACION=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg = pstm.executeQuery();
            Ubicacion ubi = null;
            while (reg.next()) {
                ubi = new Ubicacion();
                ubi.setIdUbicacion(reg.getInt("ID_UBICACION"));
                ubi.setDescripcionUbicacion(reg.getString("DESCRIPCION_UBICACION"));
            }
            return ubi;
        } catch (Exception e) {
            System.out.println("error buscar Jornada:" + e.getMessage());
            return null;
        }
    }

    @Override
    public Ubicacion Buscar2(String descUbicacion) {
        try {
            String sql = "SELECT * FROM UBICACION WHERE DESCRIPCION_UBICACION=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, descUbicacion);
            ResultSet reg = pstm.executeQuery();
            Ubicacion ubi = null;
            while (reg.next()) {
                ubi = new Ubicacion();
                ubi.setIdUbicacion(reg.getInt("ID_UBICACION"));
                ubi.setDescripcionUbicacion(reg.getString("DESCRIPCION_UBICACION"));
            }
            return ubi;
        } catch (Exception e) {
            System.out.println("error buscar ubicacion:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Modificar(Ubicacion ubi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
         try {
            String sql="DELETE from UBICACION where ID_UBICACION=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1, id);            
            int afect = pstm.executeUpdate();
            return afect>0;            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error eliminar Ubicacion:"+e.getMessage());
             System.out.println("error eliminar Prodcuto:"+e.getMessage());
            return false;
        }
    }
}
