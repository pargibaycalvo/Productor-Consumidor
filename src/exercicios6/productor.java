/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios6;
import java.util.Queue; //ordena los procesos en los que van a ser ejecutados
import java.util.Random;
/**
 *
 * @author pargibaycalvo
 * 
 * Clase productor, produce aleatoriamente numeros hasta 10 veces (valores de 1 a 10)
 */
public class productor extends Thread{
    private Queue q; //Queue lo llamamos q
    private int maximo; //declaramos maximo (será el valor que le demos desde la main)

    public productor(Queue q, int maximo, String nombre){ //constructor con parametros que llamaremos desde la main y le pondremos sus valores
        super(nombre);
        this.q = q;
        this.maximo = maximo;
    }

    public void run(){       
        //while(true){ //este while si lo activamos al iniciar el programa no para de producir y consumir
            synchronized (q){ //sincronizamos q (Queue)
              for(int p=0; p<20; p++){//producira aleatoriamente hasta 20 veces (para que nos saque el mensaje de "caja llena")
                while (q.size() == maximo){ //q al ser igual al valor max que le añadimos en la main dirá que está lleno y no inicia más
                                            //producion hasta que el consumidor entre en juego
                    try {
                        System.out.println("Advertencia: Caja llena, esperando a que se vacíe");
                        q.wait();
                    } catch (Exception ex) {
                    }
                }
                
                //genera numeros aleatorios cuando está produciendo
                Random random = new Random();
                int i = random.nextInt(10)+1;//le sumamos 1 para que no nos saque el valor 0 
                System.out.println("Produciendo: "+i);
                q.add(i);
                q.notifyAll();
                
            }
        }
    }
}
    
    
    

