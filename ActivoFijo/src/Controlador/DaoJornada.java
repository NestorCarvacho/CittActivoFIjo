
package Controlador;

import Interfaces.IDaoJornada;
import Modelo.Jornada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DaoJornada implements IDaoJornada{
    private  Connection cone;

    public DaoJornada() {
        cone = new Conexion().getCone();
    }

    
    @Override
    public ArrayList<Jornada> Listar() {
        try {
            String sql = "select ID_JORNADA,DESCRIPCION_JORNADA from JORNADA";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<Jornada> listado = new ArrayList<>();
            while (reg.next()) {
                Jornada jorn = new Jornada();
                jorn.setIdJornada(reg.getInt("ID_JORNADA"));
                jorn.setDescripcionJornada(reg.getString("DESCRIPCION_JORNADA"));
                listado.add(jorn);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar Jornada:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Grabar(Jornada jorn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Jornada Buscar(int id) {
        try {
            String sql="SELECT * FROM JORNADA WHERE ID_JORNADA=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg=pstm.executeQuery();
            Jornada jor=null;
            while (reg.next()) {                
                jor=new Jornada();
                jor.setIdJornada(reg.getInt("ID_JORNADA"));
                jor.setDescripcionJornada(reg.getString("DESCRIPCION_JORNADA"));
            }
            return jor;
        } catch (Exception e) {
            System.out.println("error buscar Jornada:"+e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Modificar(Jornada jorn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Jornada Buscar2(String jorn) {
        try {
            String sql="SELECT ID_JORNADA FROM JORNADA WHERE DESCRIPCION_JORNADA=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, jorn);
            ResultSet reg=pstm.executeQuery();
            Jornada jor=null;
            while (reg.next()) {                
                jor=new Jornada();
                jor.setIdJornada(reg.getInt("ID_JORNADA"));
            }
            return jor;
        } catch (Exception e) {
            System.out.println("error buscar Jornada:"+e.getMessage());
            return null;
        }
    }    
}
