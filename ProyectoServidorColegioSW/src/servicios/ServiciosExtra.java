package servicios;

import conexion.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiciosExtra {
    
    
    private static Conexion con = Conexion.getInstance();

    public ServiciosExtra() {
        super();
    }
    
    public static int cantidadEstudiantesRegistrados(){
        String consulta = "SELECT count(*) FROM estudiantes;";
        ResultSet rs = Conexion.getInstance().getQuery(consulta);
        try {
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int cantidadMatriculasRegistradas(){
        int registrados = 0;
        String consulta = "SELECT count(*) FROM matriculas;";
        ResultSet rs = Conexion.getInstance().getQuery(consulta);
        try {
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int cantidadMateriasRegistradas(){
        String consulta = "SELECT count(*) FROM materias;";
        ResultSet rs = Conexion.getInstance().getQuery(consulta);
        try {
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int[] darCantidadMateriasPorGradoCursando() throws Exception {
        
        int[] notasMatriculas = new int[11];
        String consulta = "select materias.grado, count(materias.grado) " +
                            "from matriculas, materias " +
                            "where matriculas.pkmateria = materias.codigo " +
                            "group by materias.grado;";
        ResultSet rs = Conexion.getInstance().getQuery(consulta);
        try {
            int i = 0;
            while(rs.next()){
                notasMatriculas[i] = rs.getInt(2);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return notasMatriculas;
    }
    
}
