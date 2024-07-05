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

    public void quitar(int posicion) {
        if (posicion == 0) {
            Cabeza = Cabeza.getNext();
        } else {
            Nodo actual = Cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getNext();
            }
            actual.setNext(actual.getNext().getNext());
        }
        numeroingredientes--;
    }

    public void reorganizar(int posicion1, int posicion2) {
        if (posicion1 > posicion2) {
            int temp = posicion1;
            posicion1 = posicion2;
            posicion2 = temp;
        }

        Nodo nodo1 = Cabeza;
        Nodo prevNodo1 = null;
        for (int i = 0; i < posicion1; i++) {
            prevNodo1 = nodo1;
            nodo1 = nodo1.getNext();
        }

        Nodo nodo2 = Cabeza;
        Nodo prevNodo2 = null;
        for (int i = 0; i < posicion2; i++) {
            prevNodo2 = nodo2;
            nodo2 = nodo2.getNext();
        }

        if (prevNodo1 != null) {
            prevNodo1.setNext(nodo2);
        } else {
            Cabeza = nodo2;
        }

        if (prevNodo2 != null) {
            prevNodo2.setNext(nodo1);
        } else {
            Cabeza = nodo1;
        }

        Nodo temp = nodo1.getNext();
        nodo1.setNext(nodo2.getNext());
        nodo2.setNext(temp);
    }

    public void mostrar() {
        Nodo actual = Cabeza;
        while (actual != null) {
            if (actual.getData() instanceof Pan) {
                ((Pan) actual.getData()).mostrar();
            } else if (actual.getData() instanceof Carne) {
                ((Carne) actual.getData()).mostrar();
            } else if (actual.getData() instanceof Extra) {
                ((Extra) actual.getData()).mostrar();
            }
            actual = actual.getNext();
        }
    }

    public String describir() {
        StringBuilder descripcion = new StringBuilder();
        Nodo actual = Cabeza;
        while (actual != null) {
            if (actual.getData() instanceof Pan) {
                descripcion.append(((Pan) actual.getData()).describir());
            } else if (actual.getData() instanceof Carne) {
                descripcion.append(((Carne) actual.getData()).describir());
            } else if (actual.getData() instanceof Extra) {
                descripcion.append(((Extra) actual.getData()).describir());
            }
            if (actual.getNext() != null) {
                descripcion.append(", ");
            }
            actual = actual.getNext();
        }
        descripcion.append("\n");
        return descripcion.toString();
    }

    public int getNumeroingredientes() {
        return numeroingredientes;
    }
}
