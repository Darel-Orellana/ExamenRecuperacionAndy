import java.util.*;

public class SistemaEducativo {
    private static final Scanner entrada = new Scanner(System.in);
    private static final List<Alumno> alumnos = new ArrayList<>();

    public static void main(String[] args) {
        int seleccion;
        do {
            mostrarMenu();
            seleccion = obtenerSeleccion();
            procesarSeleccion(seleccion);
        } while (seleccion != 3);
        entrada.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nOpciones disponibles:");
        System.out.println("1. Calculadora");
        System.out.println("2. Administrar alumnos");
        System.out.println("3. Finalizar programa");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerSeleccion() {
        return entrada.nextInt();
    }
    private static void procesarSeleccion(int seleccion) {
        switch (seleccion) {
            case 1: ejecutarCalculadora(); break;
            case 2: administrarAlumnos(); break;
            case 3: System.out.println("Programa finalizado."); break;
            default: System.out.println("Opción inválida. Intente nuevamente.");
        }
    }

    private static void ejecutarCalculadora() {
        double a = solicitarNumero("Ingrese el primer valor: ");
        double b = solicitarNumero("Ingrese el segundo valor: ");
        char operacion = solicitarOperacion();
        try {
            double resultado = calcular(a, b, operacion);
            System.out.printf("El resultado es: %.2f%n", resultado);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double solicitarNumero(String mensaje) {
        System.out.print(mensaje);
        return entrada.nextDouble();
    }

    private static char solicitarOperacion() {
        System.out.print("Ingrese la operación (+, -, *, /): ");
        return entrada.next().charAt(0);
    }

    private static double calcular(double a, double b, char operacion) {
        return switch (operacion) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new ArithmeticException("Error: División por cero.");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Operación no válida.");
        };
    }
    private static void administrarAlumnos() {
        for (int i = 0; i < 5; i++) {
            entrada.nextLine(); // Limpiar buffer
            System.out.printf("Nombre del alumno %d: ", i + 1);
            String nombre = entrada.nextLine();
            System.out.printf("Calificación del alumno %d: ", i + 1);
            double calificacion = entrada.nextDouble();
            alumnos.add(new Alumno(nombre, calificacion));
        }
        mostrarAlumnos();
    }

    private static void mostrarAlumnos() {
        System.out.println("\nListado de alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.printf("Alumno: %s, Calificación: %.2f%n",
                    alumno.obtenerNombre(), alumno.obtenerCalificacion());
        }
    }
}

class Alumno {
    private final String nombre;
    private final double calificacion;

    public Alumno(String nombre, double calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public double obtenerCalificacion() {
        return calificacion;
    }
}

