/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package producerconsumersemaphore;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * @author mirei
 */
public class ProducerConsumerSemaphore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        StockStore s = new StockStore(10);

        // Create 2 producers
        Producer p1 = new Producer(s, "Producer-1");
        Producer p2 = new Producer(s, "Producer-2");

        // Create 3 consumers
        Consumer c1 = new Consumer(s, "Consumer-1");
        Consumer c2 = new Consumer(s, "Consumer-2");
        Consumer c3 = new Consumer(s, "Consumer-3");

        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Stoping all threads...");

        p1.interrupt();
        p2.interrupt();
        c1.interrupt();
        c2.interrupt();
        c3.interrupt();
        
        try{
            p1.join();
            p2.join();
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
