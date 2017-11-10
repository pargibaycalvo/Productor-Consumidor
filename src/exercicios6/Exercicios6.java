/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios6;
import java.util.LinkedList;
import java.util.Queue; //ordena los procesos en los que van a ser ejecutados
/**
 *
 * @author pargibaycalvo
 */
public class Exercicios6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){

        Queue ma = new LinkedList<>(); //para listas doblemente enlazadas
        int maximo = 1;//valor maximo de producion y consumicion
        
        //llamamos al productor y consumidor y le decimos que sus listas producidas las introduzca en el linkedlist
        //su valor maximo de producion, consumicion y su nombre
        Thread productor = new productor(ma, maximo, "productor");
        Thread consumidor = new consumidor(ma, maximo, "consumidor");
        
        //inicimaos las clases productor y consumidor
        productor.start();
        consumidor.start();
    }
    
}
