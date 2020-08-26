package servicios;

import conexion.Conexion;
import estructural.Materia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author felip
 */
public class ServicioMateria {

    public ServicioMateria(){
        
    }
    
    public static Materia darMateriaPorCodigo(int pCodigo) throws Exception {
        String consulta = "SELECT * FROM materias WHERE codigo = " + pCodigo + ";";
        Materia materiaEncontrada = resultSetToMateria(Conexion.getInstance().getQuery(consulta));
        return materiaEncontrada;
    }

    public static ArrayList<Materia> darMateriasPorGrado(int pGrado) throws Exception {
        String consulta = "SELECT * FROM materias WHERE grado = " + pGrado + ";";
        ResultSet rs = Conexion.getInstance().getQuery(consulta);
        ArrayList<Materia> materias = resultSetToArrayList(rs);
        return materias;
    }

    public static ArrayList<Materia> darMaterias() throws Exception {
        String consulta = "SELECT * FROM materias;";
        ResultSet rs = Conexion.getInstance().getQuery(consulta);
        ArrayList<Materia> materias = resultSetToArrayList(rs);
        return materias;
    }
    
    private static ArrayList<Materia> resultSetToArrayList(ResultSet rs)
    {
        ArrayList<Materia> resultado = new ArrayList<>();
        try {
            while(rs.next()){
                Materia materia = new Materia(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
                resultado.add(materia);
            }
        } catch (SQLException ex) {
            return null;
        }
        return resultado;
    }
    
    private static Materia resultSetToMateria(ResultSet rs){
        try {
            while(rs.next()){
                Materia materia = new Materia(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
                return materia;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

