package servicios;

import conexion.Conexion;
import estructural.Estudiante;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicioEstudiante{
    
    private static Conexion con = Conexion.getInstance();
    
    public ServicioEstudiante() {
        
    }

    public static void insertarEstudiante(Estudiante pEstudiante) throws Exception {
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dformat.format(pEstudiante.getFechaNacimiento());
        
        String consulta = "INSERT INTO estudiantes (documento, nombres, apellidos, fecha_nacimiento, genero, eps, telefono, direccion, correo, estado)" +
"	VALUES ('"+pEstudiante.getDocumentoIdentificacion()+"', '"+pEstudiante.getNombres()+"', '"+pEstudiante.getApellidos()+"', "
                + "'"+ currentTime+"', "+pEstudiante.getGenero()+", '"+pEstudiante.getEps()+"',"
                + " '"+pEstudiante.getTelefono()+"', '"+pEstudiante.getDireccion()+"', '"+pEstudiante.getCorreo()+"', 1);";
        boolean res = con.executeQuery(consulta);
        if(!res){
            throw new Exception("Hay un error al insertar la persona la base de datos.");
        }
    }
    
    public static boolean eliminarEstudiante(String pDocumento) throws Exception{
        String consulta = "UPDATE estudiantes SET estado=0 WHERE documento = '"+ pDocumento +"';";
        boolean res = con.executeQuery(consulta);
        return res;
    }
    
    public static boolean actualizarEstudiante(String pDocumento, Estudiante pEstudiante) throws Exception
    {
        String consulta = "UPDATE estudiantes\n" +
"	SET nombres='"+ pEstudiante.getNombres() +"', apellidos='"+ pEstudiante.getApellidos() +"', " +
            "fecha_nacimiento='"+pEstudiante.getFechaNacimiento().toString()+"', genero="+ pEstudiante.getGenero() +", " +
            "eps='"+ pEstudiante.getEps() +"', telefono='" + pEstudiante.getTelefono() +"', " +
            "direccion='"+ pEstudiante.getDireccion() + "', correo='"+ pEstudiante.getCorreo()+"'" +
"	WHERE documento = '"+pEstudiante.getDocumentoIdentificacion()+ "';";
        boolean res = con.executeQuery(consulta);
        return res;
    }
    
    public static Estudiante buscarEstudiante(String pDocumento) throws Exception {
        String consulta = "SELECT * FROM estudiantes where documento = '" + pDocumento +"' and estado = 1;";
        ResultSet rs = con.getQuery(consulta);
        if(rs != null){
            Estudiante estudiante = resultSetToEstudiante(rs);
            return estudiante;
        }else{
            throw new Exception("No se han encontrado el estudiante en la base de datos.");
        }
    }
    
    public static ArrayList<Estudiante> darEstudiantes() throws Exception {
        String consulta = "SELECT * FROM estudiantes where estado = 1 ORDER BY documento ASC;";
        ResultSet rs = con.getQuery(consulta);
        if(rs != null){
            ArrayList<Estudiante> estudiantes = resultSetToArrayList(rs);
            return estudiantes;
        }else{
            throw new Exception("No se han encontrado estudiantes en la base de datos.");
        }
    }
    
    //En la posición 0 devuelve la cantidad de hombres, en la 1 la cantidad de mujeres 
    public static int[] cantidadEstudiantesPorGenero() throws Exception {
        int[] cantEstu = new int[2];
        cantEstu[0] = 0; cantEstu[1] = 0;
        String consulta = "SELECT genero, count(genero) FROM estudiantes where estado = 1 group by genero having count(genero) > 0 ORDER BY genero ASC;";
        ResultSet rs = con.getQuery(consulta);
        try {
            int i = 0;
            while (rs.next()) {
                cantEstu[i] = rs.getInt(2); i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantEstu;
    }
    
    public static ArrayList<Estudiante> darEstudiantesPorNombre(String pNombre) throws Exception {
        String consulta = "SELECT * FROM estudiantes WHERE nombres LIKE '%"+pNombre+"%' AND estado = 1;";
        ResultSet rs = con.getQuery(consulta);
        if(rs != null){
            ArrayList<Estudiante> estudiantes = resultSetToArrayList(rs);
            return estudiantes;
        }else{
            throw new Exception("No se han encontrado estudiantes en la base de datos.");
        }
    }
    
    public static int darGradoEstudiante(String pDocumento) throws Exception {
        try {
            String consulta = "SELECT materias.grado" +
                                "FROM matriculas, estudiantes, materias" +
                                "WHERE matriculas.pkestudiante = estudiantes.documento" +
                                "AND matriculas.pkmateria = materias.codigo" +
                                "AND estudiantes.documento = '"+pDocumento+"'" +
                                "AND estudiantes.estado = 1" +
                                "ORDER BY materias.grado DESC" +
                                "LIMIT 1;";
            ResultSet rs = con.getQuery(consulta);
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    private static ArrayList<Estudiante> resultSetToArrayList(ResultSet rs)
    {
        ArrayList<Estudiante> resultado = new ArrayList<>();
        try {
            while(rs.next()){
                Estudiante estudiante = new Estudiante(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(1), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                resultado.add(estudiante);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    private static Estudiante resultSetToEstudiante(ResultSet rs){
        try {
            while(rs.next()){
                Estudiante estudiante = new Estudiante(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(1), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                return estudiante;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
