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
