import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinHeap {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    private ArrayList<Integer> heap;

    int getPadre(int i) {
        return (i - 1) / 2;
    }

    int getHijoIzquierda(int i) {
        return 2 * i + 1;
    }

    int getHijoDerecha(int i) {
        return 2 * i + 2;
    }

    public void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void upHeapify(int i) {

        while (i > 0) {
            int padre = getPadre(i);

            if (heap.get(i) < heap.get(padre)) {
                swap(i, padre);
                i = padre;
            } else break;

        }
    }

    public void downHeapify(int i) {
        while (true) {

            int hijoIzquierda = getHijoIzquierda(i);
            int hijoDerecha = getHijoDerecha(i);
            int menor = i;

            if (hijoIzquierda < heap.size() && heap.get(hijoIzquierda) < heap.get(menor)) menor = hijoIzquierda;
            if (hijoDerecha < heap.size() && heap.get(hijoDerecha) < heap.get(menor)) menor = hijoDerecha;

            if (menor == i) {
                break;
            }

            swap(i, menor);

            i = menor;
        }


    }

    public void insertar() throws IOException {
        System.out.print("Ingrese un valor: ");
        int valor = Integer.parseInt(in.readLine());

        heap.add(valor);
        upHeapify(heap.size() - 1);
    }

    public int eliminarMin() {
        if (heap.isEmpty()) {
            System.out.println("El heap esta vacio.");
        }

        int min = heap.getFirst();

        heap.set(0, heap.getLast());
        heap.removeLast();

        downHeapify(0);

        return min;
    }

    public int peek() {
        return heap.getFirst();
    }

    public ArrayList<Integer> heapify(ArrayList<Integer> lista) {
        heap = lista;

        int size = heap.size();

        for (int i = (size / 2) - 1; i >= 0; i--) {
            downHeapify(i);
        }

        return lista;
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
        };
    }

}
