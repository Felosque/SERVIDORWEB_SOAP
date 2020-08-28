package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
    private static Conexion conexion = null;
    private Connection con = null;

    private Statement st;

    private Conexion()
    {
        try {
            System.out.println("Realizando conexión a la base de datos");
            con = DriverManager.getConnection("jdbc:mysql://localhost/soa", "root", "");
            System.out.println("Conexión realizada con exito.");
        }
        catch (Exception e) { }
    }

    public static Conexion getInstance() {
        if(conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public ResultSet getQuery(String query) {
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }	
        return rs;
    }

    public boolean executeQuery(String query) {
        try {
            st = con.createStatement();
            st.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return false;
        } 
    }

}
