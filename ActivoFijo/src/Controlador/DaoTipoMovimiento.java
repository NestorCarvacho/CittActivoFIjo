
package Controlador;


//se debe importar IDAOCLASE para poder usarlo en el DAO
import Interfaces.IDaoTipoMovimiento;
import Modelo.TipoMovimiento;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//para poder implementar el IDao se debe colocar 'implements'
public class DaoTipoMovimiento implements IDaoTipoMovimiento{
    
    //se crea un atributo para poder tener la conexion con la base de datos
    private Connection cone;

    //se crea un metodo custom para poder usar la conexion
    public DaoTipoMovimiento() {
        //se debe instanciar la nueva conexion para poder conectarse
        cone = new Conexion().getCone();
    }
    
    
    @Override
    public boolean Grabar(TipoMovimiento tpMov) {
        //se debe colocar un try catch para poder saber los errores que ocurren si no se cumplen las condiciones
        try {
            String sql="INSERT INTO tipo_movimiento VALUES(seq_tipo_movimiento.NEXTVAL,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, tpMov.getNombreTipoMovimiento());
            System.out.println(tpMov.getNombreTipoMovimiento());
            System.out.println(tpMov.toString());
            int afect = pstm.executeUpdate();
            return (afect > 0);
        } catch (Exception error) {
            //mensaje de error
            JOptionPane.showMessageDialog(null, "error grabar Color:" + error.getMessage());
            return false;
        }
    }

    @Override
    public TipoMovimiento Buscar(int id) {
        try {
            String sql = "SELECT * FROM tipo_movimiento WHERE ID_tipo_movimiento=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg = pstm.executeQuery();
            TipoMovimiento tpMov = null;
            while (reg.next()) {
                tpMov = new TipoMovimiento();
                tpMov.setIdTipoMovimiento(reg.getInt("ID_tipo_movimiento"));
                    tpMov.setNombreTipoMovimiento(reg.getString("NOMBRE_tipo_movimiento"));
            }
            return tpMov;
        } catch (Exception e) {
            System.out.println("error buscar tipo_movimiento:" + e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<TipoMovimiento> Listar() {
        try {
            String sql = "select ID_tipo_movimiento,NOMBRE_tipo_movimiento from tipo_movimiento";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<TipoMovimiento> listado = new ArrayList<>();
            while (reg.next()) {
                TipoMovimiento tpMov = new TipoMovimiento();
                tpMov.setIdTipoMovimiento(reg.getInt("ID_tipo_movimiento"));
                tpMov.setNombreTipoMovimiento(reg.getString("NOMBRE_tipo_movimiento"));
                listado.add(tpMov);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar tipo_movimiento:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Modificar(TipoMovimiento tpmov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoMovimiento Buscar2(String nombre) {
        try {
            String sql = "SELECT * FROM tipo_movimiento WHERE NOMBRE_tipo_movimiento=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, nombre);
            ResultSet reg = pstm.executeQuery();
            TipoMovimiento tpMov = null;
            while (reg.next()) {
                tpMov = new TipoMovimiento();
                tpMov.setIdTipoMovimiento(reg.getInt("ID_tipo_movimiento"));
                tpMov.setNombreTipoMovimiento(reg.getString("NOMBRE_tipo_movimiento"));
            }
            return tpMov;
        } catch (Exception e) {
            System.out.println("error buscar tipo_movimiento 2:" + e.getMessage());
            return null;
        }
    }
}
