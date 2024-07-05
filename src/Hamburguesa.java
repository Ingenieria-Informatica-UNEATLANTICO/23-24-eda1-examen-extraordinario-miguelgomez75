package src;
import java.util.Scanner;
class Hamburguesa {
    private ListaHamburguesa lista;
    boolean ultimosAjustes = true;

    public Hamburguesa(Pan panSuperior, Pan panInferior, Carne carne) {
        this.lista = new ListaHamburguesa();
        this.lista.agregar(panSuperior, 0);
        this.lista.agregar(carne, 1);
        this.lista.agregar(panInferior, 2);
        crud();
    }

    public void agregarExtra(Extra extra, int posicion) {
        lista.agregar(extra, posicion);
    }

    public void quitarExtra(int posicion) {
        lista.quitar(posicion);
    }

    public void reorganizar(int posicion1, int posicion2) {
        lista.reorganizar(posicion1, posicion2);
    }

    public void mostrar() {
        lista.mostrar();
    }

    public String describir() {
        return lista.describir();
    }

    public void añadir(){
        int posicion;
        String estado;
        System.out.println("¿Qué ingrediente desea agregar?");
        System.out.println("1. Queso Cheddar");
        System.out.println("2. Queso Azul");
        System.out.println("3. Ketchup");
        System.out.println("4. Mayonesa");
        System.out.println("5. Huevo");
        System.out.println("6. Carne de Res");
        System.out.println("7. Carne de Pollo");
        System.out.println("8. Pan Brioche");
        System.out.println("9. Pan Integral");
        int opcion = new Scanner(System.in).nextInt();
        switch (opcion) {
            case 1:
            posicion = preguntarPosicion(1);
            lista.agregar(new Cheddar(), posicion);
            System.out.println("Queso Cheddar añadido en la posición " + posicion);
            break;
            case 2:
            posicion = preguntarPosicion(1);
            lista.agregar(new Azul(), posicion);
            System.out.println("Queso Azul añadido en la posición " + posicion);
            break;
            case 3:
            estado = preguntarEstadoIngrediente(opcion);
            posicion = preguntarPosicion(1);
            lista.agregar(new Ketchup(estado), posicion);
            System.out.println("Ketchup añadido en la posición " + posicion);
            break;
            case 4:
            estado = preguntarEstadoIngrediente(opcion);
            posicion = preguntarPosicion(1);
            lista.agregar(new Mayonesa(estado), posicion);
            System.out.println("Mayonesa añadida en la posición " + posicion);
            break;
            case 5:
            posicion = preguntarPosicion(1);
            lista.agregar(new Huevo(), posicion);
            System.out.println("Huevo añadido en la posición " + posicion);
            break;
            case 6:
            estado = preguntarEstadoIngrediente(opcion);
            posicion = preguntarPosicion(1);
            lista.agregar(new Res(estado), posicion);
            System.out.println("Carne de Res añadida en la posición " + posicion);
            break;
            case 7:
            estado = preguntarEstadoIngrediente(opcion);
            posicion = preguntarPosicion(1);
            lista.agregar(new Pollo(estado), posicion);
            System.out.println("Carne de Pollo añadida en la posición " + posicion);
            break;
            case 8:
            posicion = preguntarPosicion(1);
            lista.agregar(new Brioche(), posicion);
            System.out.println("Pan Brioche añadido en la posición " + posicion);
            break;
            case 9:
            posicion = preguntarPosicion(1);
            lista.agregar(new Integral(), posicion);
            System.out.println("Pan Integral añadido en la posición " + posicion);
            break;
            default:
            System.out.println("Opción no válida");
            break;
        }
    }

    public void retirar(){
        int posicion = preguntarPosicion(2);
        lista.quitar(posicion);
        System.out.println("Elemento de la posición " + posicion + " retirado");
    }

    public void recolocar(){
        int posicion1 = preguntarPosicion(3);
        int posicion2 = preguntarPosicion(3);
        lista.reorganizar(posicion1, posicion2);
        System.out.println("Elementos de las posiciones " + posicion1 + " y " + posicion2 + " intercambiados");
    }

    public int preguntarPosicion(int añaderetiraocambia){
        int posicion;
        switch (añaderetiraocambia) {
            case 1:
            System.out.println("¿En qué posición de la hamburguesa desea añadir el elemento?");
            break;
            case 2:
            System.out.println("¿Qué elemento desea retirar de la hamburguesa?");
            break;
            case 3:
            System.out.println("¿Qué posición desea intercambiar?");
            break;
        }
        posicion = new Scanner(System.in).nextInt();
        return posicion;
        
    }

    public String preguntarEstadoIngrediente(int alimento){
        String estado;
        switch (alimento) {
            case 3:
            System.out.println("¿Cuánto ketchup desea?");
            break;
            case 4:
            System.out.println("¿Cuánta mayonesa desea?");
            break;
            case 6:
            System.out.println("¿Cómo desea la carne de Res?");
            break;
            case 7:
            System.out.println("¿Cómo desea la carne de Pollo?");
            break;
        }
        estado = new Scanner(System.in).nextLine();
        return estado;
    }

    public void crud() {
        while(ultimosAjustes){
            System.out.println("Hamburguesa actual:");
            mostrar();
            System.out.println("Ingredientes en orden: " + describir());
            System.out.println("PD: El primer elemento tiene la posición 0");
            System.out.println("¿Desea agregar, quitar o reorganizar ingredientes?");
            System.out.println("1. Agregar");
            System.out.println("2. Quitar");
            System.out.println("3. Reorganizar");
            System.out.println("4. Terminar");
            int opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    añadir();
                break;
                case 2:
                    retirar();
                break;
                case 3:
                    recolocar();
                break;
                case 4:
                    ultimosAjustes = false;
                break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }
    }

    static void main(String[] args) {
        Pan panSuperior = new Brioche();
        Pan panInferior = new Brioche();
        Carne carne = new Res("poco hecha");
        Hamburguesa hamburguesa = new Hamburguesa(panSuperior, panInferior, carne);
        hamburguesa.mostrar();
        System.out.println(hamburguesa.describir());
    }


    
    /* 
    private Pan[] panes;
    private Carne carne;
    private Extra[] extras;
    private int extrasAgregados;

    public Hamburguesa(Pan panSuperior, Pan panInferior, Carne carne, int numeroExtras) {
        this.panes = new Pan[]{panSuperior, panInferior};
        this.carne = carne;
        this.extras = new Extra[numeroExtras];
        this.extrasAgregados = 0;
    }

    public void agregarExtra(Extra extra) {
            extras[extrasAgregados] = extra;
            extrasAgregados++;
    }

    public void mostrar() {
        panes[0].mostrar();
        carne.mostrar();
        for (int i = 0; i < extrasAgregados; i++) {
            extras[i].mostrar();
        }
        panes[1].mostrar();
    }

    public String describir() {   
        String descripcion; 
        descripcion = panes[0].describir() + ", " + carne.describir();
        for (int i = 0; i < extrasAgregados; i++) {
            descripcion = descripcion + ", " + extras[i].describir();
        }
        descripcion = descripcion + "\n";
        return descripcion;
    }
        */
}
