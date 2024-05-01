import java.util.ArrayList;

public class SistemaRegistroUniversitario {
    ArrayList<listadoestudiantescursos> listaEstudiantes;
    ArrayList<inscripciondecursos> cursosInscritos;

    public SistemaRegistroUniversitario() {
        listaEstudiantes = new ArrayList<>();
        cursosInscritos = new ArrayList<>();
    }

    public void agregarEstudiante(listadoestudiantescursos estudiante) {
        listaEstudiantes.add(estudiante);
    }

    public void eliminarEstudiante(listadoestudiantescursos estudiante) {
        listaEstudiantes.remove(estudiante);
        for (inscripciondecursos curso : cursosInscritos) {
            curso.eliminarEstudiante(estudiante);
        }
    }

    public void agregarCurso(inscripciondecursos curso) {
        cursosInscritos.add(curso);
    }
    public ArrayList<inscripciondecursos> getCursosInscritos() {
        return cursosInscritos;
    }

    public void quitarCurso(inscripciondecursos curso) {
        cursosInscritos.remove(curso);
    }

    public ArrayList<listadoestudiantescursos> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public ArrayList<inscripciondecursos> getListaCursos() {
        return cursosInscritos;
    }

    public void agregarlistadoestudiantescursos(listadoestudiantescursos curso) {
    }

    public inscripciondecursos buscarCurso(String nombreCurso) {
        for (inscripciondecursos curso : cursosInscritos) {
            if (curso.getNombre().equals(nombreCurso)) {
                return curso; // Devolver el curso si se encuentra
            }
        }
        return null; // Devolver null si el curso no se encuentra
    }
        
    

    public listadoestudiantescursos buscarEstudiante(String nombreEstudiante) {
        // Iterar sobre la lista de estudiantes y buscar el estudiante por nombre
    for (listadoestudiantescursos estudiante : listaEstudiantes) {
        if (estudiante.getNombre().equals(nombreEstudiante)) {
            return estudiante; // Devolver el estudiante si se encuentra
        }
    }
    return null; // Devolver null si el estudiante no se encuentra
    }

    
}
