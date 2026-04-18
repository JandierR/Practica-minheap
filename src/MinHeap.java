import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinHeap {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    private static ArrayList<Integer> heap = new ArrayList<>();

    static int getPadre(int i) {
        return (i - 1) / 2;
    }

    static int getHijoIzquierda(int i) {
        return 2 * i + 1;
    }

    static int getHijoDerecha(int i) {
        return 2 * i + 2;
    }

    public static void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void upHeapify(int i) {

        while (i > 0) {
            int padre = getPadre(i);

            if (heap.get(i) < heap.get(padre)) {
                swap(i, padre);
                i = padre;
            } else break;

        }
    }

    public static void downHeapify(int i) {
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

    public static void insertar() throws IOException {
        System.out.print("Ingrese un valor: ");
        int valor = Integer.parseInt(in.readLine());

        heap.add(valor);
        upHeapify(heap.size() - 1);
        System.out.println("Valor insertado exitosamente!");
    }

    public static int eliminarMin() {
        if (heap.isEmpty()) {
            System.out.println("El heap esta vacio.");
        }

        int min = heap.getFirst();

        heap.set(0, heap.getLast());
        heap.removeLast();

        downHeapify(0);
        System.out.println("Valor eliminado exitosamente!");

        return min;
    }

    public static void peek() {
        if (heap.isEmpty()) {
            System.out.println("El heap esta vacio.");
            return;
        }
        System.out.println("--> Minimo = " + heap.getFirst());
    }

    public static ArrayList<Integer> heapify(ArrayList<Integer> lista) {
        heap = lista;

        int size = heap.size();

        for (int i = (size / 2) - 1; i >= 0; i--) {
            downHeapify(i);
        }

        return lista;
    }

    public static void imprimirHeap() {
        System.out.println(heap.toString());
    }
}
