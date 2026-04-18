import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) {
        int opcion;

        do {

        } while (opcion != 0);
    }

    public void imprimirMenu() {
        System.out.println("""
                -1. Insertar
                -2. Eliminar min
                -3. Ver minimo
                -4. Heapify
                -0. Salir""");
    }

    public int leerOpcion() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    public void procesarOpcion(int opcion) throws IOException {
        switch (opcion) {
            case 1 -> insertar();
            case 2 -> eliminarMin();
            case 3 -> peek();
            case 4 -> {

                //Revisar si esto funciona correctamente
                //Decidir si hacer todo esto del menu en una clase Main o no.
                System.out.print("Ingrese la cantidad de elementos a ingresar: ");
                int cantidad = Integer.parseInt(in.readLine());
                ArrayList<Integer> lista = new ArrayList<>();

                for (int i = 0; i < cantidad; i++) {
                    System.out.print("Ingrese el valor del elemento #" + (i + 1) + ": ");
                    lista.add(Integer.parseInt(in.readLine()));
                }
                System.out.println("Heap construido");

                //Revisar si imprime bien la lista
                System.out.println(heapify(lista).toString());
            }
        }

    }
}
