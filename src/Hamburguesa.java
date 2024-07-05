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
        System.out.println("¿Qué ingrediente desea agregar?");
        System.out.println("1. Queso");
        System.out.println("2. Ketchup");
        System.out.println("3. Mayonesa");
        System.out.println("4. Huevo");
        System.out.println("5. Más Carne");
        System.out.println("6. Más Pan");
        int opcion = new Scanner(System.in).nextInt();
        switch (opcion) {
            case 1:
            
            break;
            case 2:

            break;
            case 3:

            break;
            case 4:

            break;
            case 5:

            break;
            case 6:

            break;
            default:
            System.out.println("Opción no válida");
            break;
        }
    }

    public void retirar(){
        System.out.println("¿En qué posición está el ingrediente que desea retirar? (Ten en cuenta la distribución actual de la hamburguesa)");
        int posicion = new Scanner(System.in).nextInt();
        lista.quitar(posicion);
    }

    public void recolocar(){

    }

    public void crud() {
        while(ultimosAjustes){
            System.out.println("Hamburguesa actual:");
            mostrar();
            describir();
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
        hamburguesa.agregarExtra(new Cheddar(), 3);
        hamburguesa.agregarExtra(new Ketchup("poco"), 4);
        hamburguesa.agregarExtra(new Mayonesa("mucho"), 5);
        hamburguesa.agregarExtra(new Huevo(), 6);
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
