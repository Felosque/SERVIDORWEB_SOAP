package estructural;
import java.io.Serializable;

public class Materia implements Serializable{
    
    private int codigo;
    
    private String nombre;
    
    private int grado;
    
    private double intensidadHoraria;

    public Materia(int codigo, String nombre, int grado, double intensidadHoraria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.grado = grado;
        this.intensidadHoraria = intensidadHoraria;
    }

    public Materia() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public double getIntensidadHoraria() {
        return intensidadHoraria;
    }

    public void setIntensidadHoraria(double intensidadHoraria) {
        this.intensidadHoraria = intensidadHoraria;
    }

}
