import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static SistemaRegistroUniversitario sistema;
    static Scanner scanner = new Scanner(System.in);
    static HistorialAcademico HistorialAcademico; // Campo para almacenar el historial académico
    public App(HistorialAcademico HistorialAcademico) {
        App.HistorialAcademico = HistorialAcademico;
    }
    public static void main(String[] args) {
        sistema = new SistemaRegistroUniversitario();
        HistorialAcademico = new HistorialAcademico(); // Crear una instancia de HistorialAcademico
        

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 10) {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    inscribirEstudianteEnCurso(scanner);
                    break;
                case 2:
                    liberarCupoDeCurso(scanner);
                    break;
                case 3:
                    consultarUltimoCursoCompletado();
                    break;
                case 4:
                    agregarNuevoEstudiante(scanner);
                    break;
                case 5:
                    eliminarEstudiante(scanner);
                    break;
                case 6:
                    buscarEstudiante(scanner);
                    break;
                case 7:
                    gestionarCursos(scanner);
                    break;
                case 8:
                    verEstudiantesCurso();
                    break;
                case 9:
                    verCursosEstudiante(scanner);
                    break;
                case 10:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Inscribir estudiante en curso");
        System.out.println("2. Liberar cupo de curso");
        System.out.println("3. Consultar último curso completado");
        System.out.println("4. Agregar nuevo estudiante");
        System.out.println("5. Eliminar estudiante");
        System.out.println("6. Buscar estudiante");
        System.out.println("7. Gestionar cursos");
        System.out.println("8. Ver estudiantes en curso");
        System.out.println("9. Ver cursos del estudiante");
        System.out.println("10. Salir");
        System.out.print("Ingrese su opción: ");
    }

    public static void inscribirEstudianteEnCurso(Scanner scanner) {
        System.out.println("\nInscribir estudiante en curso:");
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();
        System.out.print("Ingrese el nombre del curso: ");
        String nombreCurso = scanner.nextLine();

        inscripciondecursos curso = sistema.buscarCurso(nombreCurso);

        if (curso != null) {
            listadoestudiantescursos estudiante = new listadoestudiantescursos(nombreEstudiante);
            if (curso.inscribirEstudiante(estudiante)) {
                System.out.println("El estudiante ha sido inscrito en el curso exitosamente.");
                HistorialAcademico.agregarCurso(curso);
            } else {
                System.out.println("El curso está lleno. El estudiante ha sido añadido a la cola de espera.");
            }
        } else {
            System.out.println("El curso seleccionado no existe.");
        }
    }

    public static void liberarCupoDeCurso(Scanner scanner) {
        System.out.println("\nLiberar cupo de curso:");
        System.out.print("Ingrese el nombre del curso: ");
        String nombreCurso = scanner.nextLine();

        inscripciondecursos curso = sistema.buscarCurso(nombreCurso);

        if (curso != null) {
            curso.liberarCupo();
            System.out.println("Se ha liberado un cupo en el curso " + nombreCurso);
        } else {
            System.out.println("El curso seleccionado no existe.");
        }
    }

    public static void consultarUltimoCursoCompletado() {
        System.out.println("\nConsultar último curso completado:");
        /* 
        HistorialAcademico HistorialAcademico = new HistorialAcademico();
        */
        inscripciondecursos ultimoCurso = HistorialAcademico.ultimoCursoCompletado();
        
        if (ultimoCurso != null) {
            System.out.println("Último curso completado: " + ultimoCurso.getNombre());
        } else {
            System.out.println("No hay cursos en el historial académico.");
        }
    }

    public static void agregarNuevoEstudiante(Scanner scanner) {
        System.out.println("\nAgregar nuevo estudiante:");
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();

        listadoestudiantescursos estudiante = new listadoestudiantescursos(nombreEstudiante);
        sistema.agregarEstudiante(estudiante);
        System.out.println("Estudiante agregado correctamente.");
    }

    public static void eliminarEstudiante(Scanner scanner) {
        System.out.println("\nEliminar estudiante:");
        System.out.print("Ingrese el nombre del estudiante a eliminar: ");
        String nombreEstudiante = scanner.nextLine();

        listadoestudiantescursos estudiante = sistema.buscarEstudiante(nombreEstudiante);
        if (estudiante != null) {
            sistema.eliminarEstudiante(estudiante);
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("El estudiante seleccionado no existe.");
        }
    }

    public static void buscarEstudiante(Scanner scanner) {
        System.out.println("\nBuscar estudiante:");
        System.out.print("Ingrese el nombre del estudiante a buscar: ");
        String nombreEstudiante = scanner.nextLine();

        listadoestudiantescursos estudiante = sistema.buscarEstudiante(nombreEstudiante);
        if (estudiante != null) {
            System.out.println("Estudiante encontrado: " + estudiante.getNombre());
        } else {
            System.out.println("El estudiante no ha sido encontrado.");
        }
    }

    public static void gestionarCursos(Scanner scanner) {
        System.out.println("\nGestionar cursos:");
        System.out.println("1. Agregar curso");
        System.out.println("2. Quitar curso");
        System.out.print("Ingrese su opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        switch (opcion) {
            case 1:
                agregarCurso(scanner);
                break;
            case 2:
                quitarCurso(scanner);
                break;
            default:
                System.out.println("Opción no válida. Regresando al menú principal.");
                break;
        }
    }

    public static void agregarCurso(Scanner scanner) {
        System.out.println("\nAgregar curso:");
        System.out.print("Ingrese el nombre del curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Ingrese el cupo del curso: ");
        int cupoCurso = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        inscripciondecursos curso = new inscripciondecursos(nombreCurso, cupoCurso);
        sistema.agregarCurso(curso);
        System.out.println("Curso agregado correctamente.");
    }

    public static void quitarCurso(Scanner scanner) {
        System.out.println("\nQuitar curso:");
        System.out.print("Ingrese el nombre del curso a quitar: ");
        String nombreCurso = scanner.nextLine();

        inscripciondecursos curso = sistema.buscarCurso(nombreCurso);
        if (curso != null) {
            sistema.quitarCurso(curso);
            System.out.println("Curso eliminado correctamente.");
        } else {
            System.out.println("El curso seleccionado no existe.");
        }
    }


    public static void verEstudiantesCurso() {
        System.out.println("\nVer estudiantes en curso:");
        System.out.println("\nIngrese el nombre del curso:");
        String nombreCurso = scanner.nextLine();
    
        inscripciondecursos curso = sistema.buscarCurso(nombreCurso);
        if (curso != null) {
            ArrayList<listadoestudiantescursos> estudiantes = curso.getEstudiantes();
            if (estudiantes.isEmpty()) {
                System.out.println("No hay estudiantes inscritos en este curso.");
            } else {
                System.out.println("Estudiantes inscritos en " + nombreCurso + ":");
                for (listadoestudiantescursos estudiante : estudiantes) {
                    System.out.println(estudiante.getNombre());
                }
            }
        } else {
            System.out.println("El curso no existe.");
        }
    }

    public static void verCursosEstudiante(Scanner scanner) {
        System.out.println("\nVer cursos del estudiante:");
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();
    
        listadoestudiantescursos estudiante = sistema.buscarEstudiante(nombreEstudiante);
        if (estudiante != null) {
            ArrayList<inscripciondecursos> agregarCurso = sistema.getCursosInscritos();
            if (agregarCurso .isEmpty()) {
                System.out.println("El estudiante no está inscrito en ningún curso.");
            } else {
                System.out.println("Cursos inscritos por " + nombreEstudiante + ":");
                for (inscripciondecursos curso : agregarCurso) {
                    System.out.println(curso.getNombre());
                }
            }
        } else {
            System.out.println("El estudiante no existe.");
        }
    }

}
