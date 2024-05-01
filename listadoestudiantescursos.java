import java.util.ArrayList;
import java.util.Scanner;

public class listadoestudiantescursos {
    String nombre;
    ArrayList<inscripciondecursos> cursosInscritos;
    ArrayList<inscripciondecursos> listaestudiantes = new ArrayList<>();

    
    
    public listadoestudiantescursos(String nombre) {
        this.nombre = nombre;
        this.cursosInscritos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    

    public void agregarCurso(inscripciondecursos curso) {
        cursosInscritos.add(curso);
    }
    
    public ArrayList<inscripciondecursos> getCursosInscritos() {
        return cursosInscritos;
    }

    public ArrayList<inscripciondecursos> getestudiantes() {
        // Devuelve la lista de estudiantes inscritos en este curso
        return listaestudiantes;
    }
    
     
    public String getEstudiantes() {
        return nombre;
       
        
    } 
    

    public String getColaEspera() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cola de espera de estudiantes para el curso ").append(nombre).append(":\n");
        for (inscripciondecursos estudiante : listaestudiantes) {
            stringBuilder.append(estudiante.getNombre()).append("\n");
        }
        return stringBuilder.toString();
    }
    

    
    

    
    
    
}
