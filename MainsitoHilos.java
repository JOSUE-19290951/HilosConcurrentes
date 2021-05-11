package hilosjava;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainsitoHilos {


    /*
PROGRAMADOR: JOSUE DANIEL TORRES SANTOS
TOPICOS AVANZADOS DE PROGRAMACION
ARELI PEREZ APARICIO

Implemente un programa en java que utilice hilos. El tamaño del vector es desde el main como parámetro.
El llenado del vector es aleatorio. Realizar tres hilos, el hilo 1 muestra la suma de los elementos de un vector,
el hilo 2 la suma de los cuadrados de los elementos del vector y un tercer hilo la media. Muestre los resultados.
     */
    public static void main(String[] args) {
        Arrays uno, dos, tres;
        Scanner gg = new Scanner(System.in);
        int tamVec=0;
        boolean flag = false;
        System.out.println("=============HILOS EN JAVA===========");
        System.out.println("Deme el valor de tamaño de un vector: ");
        //hacemos un uso de do while para solo permitir numeros enteros y mayores a 0
        do{
            try{
                tamVec = gg.nextInt();
                flag = true;
            }catch(InputMismatchException e){
                System.out.println("Ingrese un numero entero");
                gg.next();
            }
        }while(flag!=true);

        uno = new Arrays("Hilo vector uno", tamVec); //instanciamos el primer arreglo
        dos = new Arrays("Hilo vector dos", tamVec); //instanciamos el segundo arreglo
        tres = new Arrays("Hilo vector tres: ", tamVec); //instanciamos el tercer arreglo

        uno.start(); //iniciamos el primer hilo
        dos.start(); //iniciamos el segundo hilo
        tres.start();

        try {
            uno.join(); //hacemos el uso del join para la union de los hilo
            dos.join();
            tres.join();
        } catch (InterruptedException e) {
        }
        //impresion de los resultados 
        System.out.println("Suma del primer vector: " + uno.getSuma()); //hilo uno, mandamos la suma
        System.out.println("Suma de cuadrados de vector dos: " + dos.getSumaCuadrados()); //hilo dos mandamos la suma de los cuadrados
        System.out.println("Media del vector dos: " + tres.getMedia()); //hilo tres mandamos la media del vector

    }
}
