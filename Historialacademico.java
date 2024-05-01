import java.util.Stack;

class HistorialAcademico {
    Stack<inscripciondecursos> HistorialAcademico;

    public HistorialAcademico() {
        HistorialAcademico = new Stack<>();
    }

    public void agregarCurso(inscripciondecursos cursosInscritos) {
        HistorialAcademico.push(cursosInscritos);
    }

    public inscripciondecursos ultimoCursoCompletado() {
        if (!HistorialAcademico.isEmpty()) {
            return HistorialAcademico.peek();
        }
        return null;
    }
}
