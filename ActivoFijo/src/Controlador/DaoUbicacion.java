
package Controlador;

import Interfaces.IDaoUbicacion;
import Modelo.Ubicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ubicacion Buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Modificar(Ubicacion ubi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
