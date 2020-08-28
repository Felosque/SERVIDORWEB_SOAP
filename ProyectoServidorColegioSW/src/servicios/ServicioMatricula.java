package servicios;

import conexion.Conexion;

import constantes.UtilitiesFunctions;

import estructural.Matricula;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicioMatricula {

    public ServicioMatricula() {
        
    }

    public static void matricularEstudiante(Matricula pMatricula) throws Exception {
        String consulta = "INSERT INTO matriculas(pkestudiante, pkmateria, fecha_inscripcion, fecha_inicio, fecha_final, nota_definitiva, estado)" +
                        " VALUES ( "+pMatricula.getPkEstudiante()+", "+pMatricula.getPkMateria()+", '"+UtilitiesFunctions.fechaSQL(pMatricula.getFechaInscripcion())+"',"
                + " '"+UtilitiesFunctions.fechaSQL(pMatricula.getFechaInicio())+"', '"+UtilitiesFunctions.fechaSQL(pMatricula.getFechaFinal())+"', "+pMatricula.getNotaDefinitiva()+", "+pMatricula.getEstado()+");";
        boolean res = Conexion.getInstance().executeQuery(consulta);
        if(res == false){
            throw new Exception("No se ha podido matricular al estudiante en la asignatura de codigo: " + pMatricula.getPkMateria());
        }
    }

    public static ArrayList<Matricula> darMatriculasEstudiante(String pDocumento) throws Exception {
        String consulta = "SELECT * FROM matriculas where pkestudiante = '"+ pDocumento +"';";
        ResultSet rs = Conexion.getInstance().getQuery(consulta);
        ArrayList<Matricula> matriculasEncontradas = resultSetToArrayList(rs);
        return matriculasEncontradas;
    }

    public static ArrayList<Matricula> darMatriculas() throws Exception {
        String consulta = "SELECT * FROM matriculas;";
        ResultSet rs = Conexion.getInstance().getQuery(consulta);
        ArrayList<Matricula> matriculasEncontradas = resultSetToArrayList(rs);
        return matriculasEncontradas;
    }
    
    public static ArrayList<Matricula> darMatriculasPorFecha(Date pFecha) throws Exception {
        String consulta = "SELECT * FROM matriculas " +
                            "WHERE fecha_inicio = '"+pFecha.toString()+"' AND estado >= 1;";
        ResultSet rs = Conexion.getInstance().getQuery(consulta);
        ArrayList<Matricula> matriculasEncontradas = resultSetToArrayList(rs);
        return matriculasEncontradas;
    }

    public static int[] darMateriasPorGrado() throws Exception {
        
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

    public static void actualizarMatricula(Matricula pMatricula) throws Exception {
        String consulta = "UPDATE matriculas " +
                "SET pkestudiante='"+pMatricula.getPkEstudiante()+"', pkmateria="+pMatricula.getPkMateria()+", "
                + "fecha_inscripcion='"+UtilitiesFunctions.fechaSQL(pMatricula.getFechaInscripcion())+"', fecha_inicio='"+UtilitiesFunctions.fechaSQL(pMatricula.getFechaInicio())+"', "
                + "fecha_final='"+UtilitiesFunctions.fechaSQL(pMatricula.getFechaFinal())+"', nota_definitiva="+pMatricula.getNotaDefinitiva()+", estado="+pMatricula.getEstado()+" " +
                "WHERE codigo = "+pMatricula.getCodigo()+";";
        boolean res = Conexion.getInstance().executeQuery(consulta);
    }

    public static boolean darPazYSalvoEstudiante(int pGrado, Matricula pMatricula) throws Exception {
        try {
            String consulta = "SELECT matriculas.estado" +
                                "FROM matriculas, estudiantes, materias" +
                                "WHERE matriculas.pkestudiante = estudiantes.documento" +
                                "AND matriculas.pkmateria = materias.codigo" +
                                "AND estudiantes.documento = '"+ pMatricula.getPkEstudiante() +"'" +
                                "AND estudiantes.estado = 1" +
                                "AND materias.grado = "+pGrado+"" +
                                "ORDER BY materias.grado DESC";
            ResultSet rs = Conexion.getInstance().getQuery(consulta);
            while(rs.next()){
                if(rs.getInt(1) != 5){
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public static void borrarMatriculaCodigo(int pCodigo) throws Exception {
        String consulta = "DELETE FROM matriculas WHERE codigo = "+ pCodigo +";";
        boolean res = Conexion.getInstance().executeQuery(consulta);
        if(res == false){
            throw new Exception("No se ha podido borrar la matricula de codigo: " + pCodigo);
        }
    }

    public static Matricula darMatriculaCodigo(int pCodigo) throws Exception {
        String consulta = "select * " +
                        "from matriculas " +
                        "where matriculas.codigo = "+ pCodigo + ";";
        ResultSet rs = Conexion.getInstance().getQuery(consulta);
        ArrayList<Matricula> mati = resultSetToArrayList(rs);
        if(!mati.isEmpty()){
        return mati.get(0);}
        return null;
    }
    
    public static double darPromedioEstudiante(Matricula pMatricula) throws Exception {
        ArrayList<Matricula> matriculas = darMatriculasEstudiante(pMatricula.getPkEstudiante());
        if(matriculas.isEmpty()) return 0.0;
        double promedio = 0.0;
        for (int i = 0; i < matriculas.size(); i++) {
            promedio += matriculas.get(i).getNotaDefinitiva();
        }
        return promedio / matriculas.size();
    }

    public static ArrayList<Matricula> darMatriculasEstudianteGrado(String pDocumento, int Grado) throws Exception {
        String consulta = "SELECT matriculas.codigo, " +
                            " matriculas.pkestudiante, matriculas.pkmateria," +
                            " matriculas.fecha_inscripcion, matriculas.fecha_inicio," +
                            " matriculas.fecha_final, matriculas.nota_definitiva, matriculas.estado " +
                            "FROM matriculas, estudiantes, materias " +
                            "WHERE matriculas.pkestudiante = estudiantes.documento " +
                            "AND matriculas.pkmateria = materias.codigo " +
                            "AND estudiantes.documento = '"+pDocumento+"' " +
                            "AND materias.grado = "+Grado+";";
        System.out.println(consulta);
        ResultSet rs = Conexion.getInstance().getQuery(consulta);
        ArrayList<Matricula> matriculasEncontradas = resultSetToArrayList(rs);
        return matriculasEncontradas;
    }
    
    private static ArrayList<Matricula> resultSetToArrayList(ResultSet rs)
    {
        ArrayList<Matricula> resultado = new ArrayList<>();
        if(rs == null) return resultado;
        try {
            while(rs.next()){
                Matricula matricula = new Matricula(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getDate(6), rs.getDouble(7), rs.getInt(8));
                resultado.add(matricula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

}
