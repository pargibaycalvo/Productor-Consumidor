/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios6;

import java.util.Queue; //ordena los procesos en los que van a ser ejecutados

/**
 *
 * @author pargibaycalvo
 * 
 * Clase consumidor, consume el valor que produce el productor (así vemos que el programa va a romper al acabar el productor)
 */
public class consumidor extends Thread{
    private Queue q;
    private int max;

    public consumidor(Queue p, int max, String nombre) {
        super(nombre);
        this.q = p;
        this.max = max;
    }
    
    public void run(){ 
        while(true){
            synchronized(q){ 
                while(q.isEmpty()){ //cuando q se queda sin carga lanza el mensaje hasta que el productor
                                    //vuelva a cargarla
                    System.out.println("Advertencia: Caja vacía. Esperando a que se llene");
                try{
                    q.wait();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            //mensaje de que el consumidor va consumiendo
            System.out.println("Consumiendo... "+q.remove());
            q.notifyAll();
                
                }
            }
        }
    }

