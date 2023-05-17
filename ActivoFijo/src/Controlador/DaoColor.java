
package Controlador;


//se debe importar IDAOCLASE para poder usarlo en el DAO
import Interfaces.IDaoColor;
import Modelo.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//para poder implementar el IDao se debe colocar 'implements'
public class DaoColor implements IDaoColor{
    
    //se crea un atributo para poder tener la conexion con la base de datos
    private Connection cone;

    //se crea un metodo custom para poder usar la conexion
    public DaoColor() {
        //se debe instanciar la nueva conexion para poder conectarse
        cone = new Conexion().getCone();
    }
    
    
    @Override
    public boolean Grabar(Color col) {
        //se debe colocar un try catch para poder saber los errores que ocurren si no se cumplen las condiciones
        try {
            String sql="INSERT INTO COLOR VALUES(SEQ_COLOR.NEXTVAL,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            //el primer valor es un index, el segundo es el valor que se ingresa
            pstm.setString(1, col.getNombreColor());//NOMBRE COLOR
            System.out.println(col.getNombreColor());
            System.out.println(col.toString());
            int afect = pstm.executeUpdate();
            return (afect > 0);
        } catch (Exception error) {
            //mensaje de error
            JOptionPane.showMessageDialog(null, "error grabar Color:" + error.getMessage());
            return false;
        }
    }

    @Override
    public Color Buscar(int id) {
        try {
            String sql = "SELECT * FROM COLOR WHERE ID_COLOR=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet reg = pstm.executeQuery();
            Color col = null;
            while (reg.next()) {
                col = new Color();
                col.setIdColor(reg.getInt("ID_COLOR"));
                    col.setNombreColor(reg.getString("NOMBRE_COLOR"));
            }
            return col;
        } catch (Exception e) {
            System.out.println("error buscar COLOR:" + e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Color> Listar() {
        try {
            String sql = "select ID_COLOR,NOMBRE_COLOR from COLOR";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<Color> listado = new ArrayList<>();
            while (reg.next()) {
                Color col = new Color();
                col.setIdColor(reg.getInt("ID_COLOR"));
                col.setNombreColor(reg.getString("NOMBRE_COLOR"));
                listado.add(col);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar Color:" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean Modificar(Color col) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Color Buscar2(String nombre) {
        try {
            String sql = "SELECT * FROM COLOR WHERE NOMBRE_COLOR=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, nombre);
            ResultSet reg = pstm.executeQuery();
            Color col = null;
            while (reg.next()) {
                col = new Color();
                col.setIdColor(reg.getInt("ID_COLOR"));
                col.setNombreColor(reg.getString("NOMBRE_COLOR"));
            }
            return col;
        } catch (Exception e) {
            System.out.println("error buscar COLOR 2:" + e.getMessage());
            return null;
        }
    }
}
