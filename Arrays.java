package hilosjava;

public class Arrays extends Thread { //hacemos uso de herencia de los hilos

    //declaracion de variables 
    private int[] info;
    private String Vector;
    private int longitud;
    private int suma;
    private long sumaCuadrados;
    private double media;

    //metodo constructor
    public Arrays(String Vector, int longitud) {
        this.Vector = Vector;
        this.longitud = longitud;
        this.sumaCuadrados = 0;
        this.media = 0.0;
        this.info = new int[this.longitud];
        for (int i = 0; i < this.longitud; i++) { //realizamos el llenado del arreglo
            info[i] = (int) (Math.random() * 100.0);
        }
    }

    //realizamos los getters de los siguientes tres debido a que los tengo privaos, asi la clase principal pueda accesar a ellos 
    public int getSuma() {
        return (this.suma);
    }

    public long getSumaCuadrados() {
        return (this.sumaCuadrados);
    }

    public double getMedia() {
        return (this.media);
    }
    
    //metodo del iniciador de los hilos
    public void run() {
        for (int i = 0; i < this.longitud; i++) {
            System.out.println(this.Vector + ": " + i);
            this.suma += info[i]; //hacemos la sumatoria de los numeros aleatorios en el arreglo
            this.sumaCuadrados += info[i] * info[i]; //hacemos la sumatoria de los numeros aleatorios elevados al cuadrado
        }
        this.media = (double) this.suma / (double) this.longitud; //realizamos la division de la sumatoria de los numeros aleatorios  entre el tamaño del vector
    }
}
