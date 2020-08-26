package serviciosWeb;

import estructural.Estudiante;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import servicios.ServicioEstudiante;

@WebService(serviceName = "ServicioEstudianteSW")
public class ServicioEstudianteSW {
    
    public ServicioEstudianteSW() {
        super();
    }

    @WebMethod
    public void insertarEstudiante(@WebParam(name = "arg0") Estudiante pEstudiante) throws Exception {
        try{
            ServicioEstudiante.insertarEstudiante(pEstudiante);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @WebMethod
    public boolean eliminarEstudiante(@WebParam(name = "arg0") String pDocumento) throws Exception{
        try{
            return ServicioEstudiante.eliminarEstudiante(pDocumento);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public boolean actualizarEstudiante(@WebParam(name = "arg0") String pDocumento,
                                        @WebParam(name = "arg1") Estudiante pEstudiante) throws Exception {
        try{
            return ServicioEstudiante.actualizarEstudiante(pDocumento, pEstudiante);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public Estudiante buscarEstudiante(@WebParam(name = "arg0") String pDocumento) throws Exception {
        try{
            return ServicioEstudiante.buscarEstudiante(pDocumento);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public ArrayList<Estudiante> darEstudiantes() throws Exception {
        try{
            return ServicioEstudiante.darEstudiantes();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    //En la posición 0 devuelve la cantidad de hombres, en la 1 la cantidad de mujeres
    @WebMethod
    public int[] cantidadEstudiantesPorGenero() throws Exception {
        try{
            return ServicioEstudiante.cantidadEstudiantesPorGenero();
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public ArrayList<Estudiante> darEstudiantesPorNombre(@WebParam(name = "arg0") String pNombre) throws Exception {
        try{
            return ServicioEstudiante.darEstudiantesPorNombre(pNombre);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public int darGradoEstudiante(@WebParam(name = "arg0") String pDocumento) throws Exception {
        try{
            return ServicioEstudiante.darGradoEstudiante(pDocumento);
        }catch(Exception ex){
            throw ex;
        }
    }
    
}
