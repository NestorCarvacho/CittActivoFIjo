package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    private Connection cone; // Declarar la variable a nivel de clase

    public Conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cone = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ACTIVOFIJO","ACTIVOFIJO");
        } catch (Exception e) {
            System.out.println("Error conexion:"+e.getMessage());
        }
    }
    
    public Connection getCone() {
        return cone;
    }
}
