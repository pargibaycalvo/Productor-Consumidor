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
 */
public class consumidor extends Thread{
    private Queue q;
    private int maximo;

    public consumidor(Queue p, int maximo, String nombre) {
        super(nombre);
        this.q = p;
        this.maximo = maximo;
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
