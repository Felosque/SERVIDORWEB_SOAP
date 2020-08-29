package serviciosWeb;

import conexion.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jws.WebService;

import servicios.ServicioMatricula;
import servicios.ServiciosExtra;

@WebService(serviceName = "ServiciosExtraSW")
public class ServiciosExtraSW {
    public ServiciosExtraSW() {
        super();
    }
    
    public int cantidadEstudiantesRegistrados(){
        return ServiciosExtra.cantidadEstudiantesRegistrados();
    }
    
    public int cantidadMatriculasRegistradas(){
        return ServiciosExtra.cantidadMatriculasRegistradas();
    }
    
    public int cantidadMateriasRegistradas(){
        return ServiciosExtra.cantidadMateriasRegistradas();
    }
    
    public int[] darCantidadMateriasPorGradoCursando() throws Exception {
        return ServiciosExtra.darCantidadMateriasPorGradoCursando();
    }
    
}
