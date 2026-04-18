import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int opcion;


        do {
        imprimirMenu();
            opcion = leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    public static void imprimirMenu() {
        System.out.println();
        System.out.println("""
                -1. Insertar
                -2. Eliminar min
                -3. Ver minimo
                -4. Heapify
                -0. Salir""");
    }

    public static int leerOpcion() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    public static void procesarOpcion(int opcion) throws IOException {
        switch (opcion) {
            case 1 -> MinHeap.insertar();
            case 2 -> MinHeap.eliminarMin();
            case 3 -> MinHeap.peek();
            case 4 -> {

                System.out.print("Ingrese la cantidad de elementos a ingresar: ");
                int cantidad = Integer.parseInt(in.readLine());
                ArrayList<Integer> lista = new ArrayList<>();

                for (int i = 0; i < cantidad; i++) {
                    System.out.print("Ingrese el valor del elemento #" + (i + 1) + ": ");
                    lista.add(Integer.parseInt(in.readLine()));
                }
                System.out.println("Heap construido");

                System.out.println(MinHeap.heapify(lista));
            }
            case 5 -> MinHeap.imprimirHeap();
        }

    }
}
