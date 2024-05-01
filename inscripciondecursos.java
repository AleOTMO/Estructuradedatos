import java.util.ArrayList;

public class inscripciondecursos {
    String nombre;
    int cupo;
    ArrayList<listadoestudiantescursos> estudiantes;
    ArrayList<listadoestudiantescursos> colaEspera;
    ArrayList<inscripciondecursos> cursosInscritos;
    

    public inscripciondecursos(String nombre, int cupo) {
        this.nombre = nombre;
        this.cupo = cupo;
        this.estudiantes = new ArrayList<>();
        this.colaEspera = new ArrayList<>();
        this.cursosInscritos = new ArrayList<>();
    }

    public boolean inscribirEstudiante(listadoestudiantescursos estudiante) {
        if (estudiantes.size() < cupo) {
            estudiantes.add(estudiante);
            return true;
        } else {
            colaEspera.add(estudiante);
            return false;
        }
    }

    public void agregarCurso(inscripciondecursos curso) {
        cursosInscritos.add(curso);
    }

    public void liberarCupo() {
        if (!colaEspera.isEmpty()) {
            listadoestudiantescursos estudiante = colaEspera.remove(0);
            estudiantes.add(estudiante);
        }
    }

    public void eliminarEstudiante(listadoestudiantescursos estudiante) {
        estudiantes.remove(estudiante);
        colaEspera.remove(estudiante);
    }

    public String getNombre() {
        return nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public ArrayList<listadoestudiantescursos> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<listadoestudiantescursos> getColaEspera() {
        return colaEspera;
    }

    
        
    public ArrayList<inscripciondecursos> getCursosInscritos() {
        return cursosInscritos;
    }

   

    

}
