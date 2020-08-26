package estructural;

import static constantes.UtilitiesFunctions.*;
import java.io.Serializable;
import java.util.Date;

public class Estudiante implements Serializable{
    
    private String nombres;
    
    private String apellidos;
    
    private Date fechaNacimiento;
    
    private String documentoIdentificacion;
    
    private int genero;
    
    private String eps;

    private String telefono;
    
    private String direccion;
    
    private String correo;

    public Estudiante(String nombres, String apellidos, Date fechaNacimiento, String documentoIdentificacion, int rH, String eps, String telefonoAcudiente, String direccion, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.documentoIdentificacion = documentoIdentificacion;
        this.genero = rH;
        this.eps = eps;
        this.telefono = telefonoAcudiente;
        this.direccion = direccion;
        this.correo = correo;
    }
    
    public Estudiante() {
        
    }
    
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) throws Exception {
        if(nombres == null || nombres.isEmpty()){
            throw new Exception("¡Los nombres no pueden estar vacios!");
        }
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String pApellidos) throws Exception {
        if(pApellidos == null || pApellidos.isEmpty()){
            throw new Exception("¡Los apellidos no pueden estar vacios!");
        }
        this.apellidos = pApellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date pFechaN) throws Exception {
        if(pFechaN == null){
            throw new Exception("¡Debe seleccionar una fecha de nacimiento valida!");
        }
        if(pFechaN.after(sumarRestarAnosDate(new Date(), -EDAD_MINIMA_REGISTRO))){
            throw new Exception("¡No se puede matricular un estudiante menor a 5 años!\nVerifique la fecha de nacimiento.");
        }
        this.fechaNacimiento = pFechaN;
    }

    public String getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(String docIdent) throws Exception{
        if(docIdent == null || docIdent.isEmpty()){
            throw new Exception("¡El documento de identificación no pueden estar vacio!");
        }
        if(!esNumerico(docIdent)){
            throw new Exception("¡Solo puedes digitar numeros en el documento de identificación!");
        }
        this.documentoIdentificacion = docIdent;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int rH) {
        this.genero = rH;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) throws Exception {
        if(eps == null || eps.isEmpty()){
            throw new Exception("¡La EPS no puede estar vacia!");
        }
        this.eps = eps;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String pTelefono) throws Exception {
        if(pTelefono == null || pTelefono.isEmpty()){
            throw new Exception("¡El teléfono no puede estar vacio!");
        }
        if(!esNumerico(pTelefono)){
            throw new Exception("¡Solo puedes digitar numeros en el número de telefono!");
        }
        this.telefono = pTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) throws Exception {
        if(direccion == null || direccion.isEmpty()){
            throw new Exception("¡La dirección no puede estar vacia!");
        }
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) throws Exception {
        if(correo == null || correo.isEmpty()){
            this.correo = "";
        }else{
            if(!esEmailValido(correo)){
                throw new Exception("¡La dirección de correo no es valida!");
            }
            this.correo = correo;
        }
    }
    
    public void actualizarTodaInformacion(Estudiante pEstudiante) throws Exception
    {
        try
        {
            this.setNombres(pEstudiante.getNombres());
            this.setApellidos(pEstudiante.getApellidos());
            this.setCorreo(pEstudiante.getCorreo());
            //this.setAcudiente(pEstudiante.getAcudiente());
            this.setDireccion(pEstudiante.getDireccion());
            this.setDocumentoIdentificacion(pEstudiante.getDocumentoIdentificacion());
            this.setEps(pEstudiante.getEps());
            this.setFechaNacimiento(pEstudiante.getFechaNacimiento());
            this.setGenero(pEstudiante.getGenero());
            this.setTelefono(pEstudiante.getTelefono());
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
}

