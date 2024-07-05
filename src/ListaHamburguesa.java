package src;

public class ListaHamburguesa {
    private Nodo Cabeza;
    private int numeroingredientes;

    public ListaHamburguesa() {
        this.Cabeza = null;
        this.numeroingredientes = 0;
    }

    public void agregar(Object data, int posicion) {
        Nodo nuevoNodo = new Nodo(data);
        if (posicion == 0) {
            nuevoNodo.setNext(Cabeza);
            Cabeza = nuevoNodo;
        } else {
            Nodo actual = Cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getNext();
            }
            nuevoNodo.setNext(actual.getNext());
            actual.setNext(nuevoNodo);
        }
        numeroingredientes++;
    }
}
