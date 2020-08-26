package serviciosWeb;

import estructural.Matricula;
import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import servicios.ServicioMatricula;

@WebService(serviceName = "ServicioMatriculaSW")
public class ServicioMatriculaSW {
    
    public ServicioMatriculaSW() {
        super();
    }

    @WebMethod
    public void matricularEstudiante(@WebParam(name = "arg0") Matricula pMatricula) throws Exception {
        try{
            ServicioMatricula.matricularEstudiante(pMatricula);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @WebMethod
    public ArrayList<Matricula> darMatriculasEstudiante(@WebParam(name = "arg0") String pDocumento) throws Exception {
        try{
            return ServicioMatricula.darMatriculasEstudiante(pDocumento);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public ArrayList<Matricula> darMatriculas() throws Exception {
        try{
            return ServicioMatricula.darMatriculas();
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public ArrayList<Matricula> darMatriculasPorFecha(@WebParam(name = "arg0") Date pFecha) throws Exception {
        try{
            return ServicioMatricula.darMatriculasPorFecha(pFecha);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public int[] darMateriasPorGrado() throws Exception {
        try{
            return ServicioMatricula.darMateriasPorGrado();
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public void actualizarMatricula(@WebParam(name = "arg0") Matricula pMatricula) throws Exception {
        try{
            ServicioMatricula.actualizarMatricula(pMatricula);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public boolean darPazYSalvoEstudiante(@WebParam(name = "arg0") int pGrado,
                                          @WebParam(name = "arg1") Matricula pMatricula) throws Exception {
        try{
            return ServicioMatricula.darPazYSalvoEstudiante(pGrado, pMatricula);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public void borrarMatriculaCodigo(@WebParam(name = "arg0") int pCodigo) throws Exception {
        try{
            ServicioMatricula.borrarMatriculaCodigo(pCodigo);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public Matricula darMatriculaCodigo(@WebParam(name = "arg0") int pCodigo) throws Exception {
        try{
            return ServicioMatricula.darMatriculaCodigo(pCodigo);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public double darPromedioEstudiante(@WebParam(name = "arg0") Matricula pMatricula) throws Exception {
        try{
            return ServicioMatricula.darPromedioEstudiante(pMatricula);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public ArrayList<Matricula> darMatriculasEstudianteGrado(@WebParam(name = "arg0") String pDocumento,
                                                             @WebParam(name = "arg1") int Grado) throws Exception {
        try{
            return ServicioMatricula.darMatriculasEstudianteGrado(pDocumento, Grado);
        }catch(Exception ex){
            throw ex;
        }
    }
}
