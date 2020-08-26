package serviciosWeb;

import conexion.Conexion;

import estructural.Materia;

import java.sql.ResultSet;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import servicios.ServicioMateria;

@WebService(serviceName = "ServicioMateriaSW")
public class ServicioMateriaSW {
    
    public ServicioMateriaSW() {
        super();
    }

    @WebMethod
    public Materia darMateriaPorCodigo(@WebParam(name = "arg0") int pCodigo) throws Exception {
        try{
            return ServicioMateria.darMateriaPorCodigo(pCodigo);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public ArrayList<Materia> darMateriasPorGrado(@WebParam(name = "arg0") int pGrado) throws Exception {
        try{
            return ServicioMateria.darMateriasPorGrado(pGrado);
        }catch(Exception ex){
            throw ex;
        }
    }

    @WebMethod
    public ArrayList<Materia> darMaterias() throws Exception {
        try{
            return ServicioMateria.darMaterias();
        }catch(Exception ex){
            throw ex;
        }
    }
}
