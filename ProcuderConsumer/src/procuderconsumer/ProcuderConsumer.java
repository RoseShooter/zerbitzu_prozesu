/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package procuderconsumer;

/**
 *
 * @author mirei
 */
public class ProcuderConsumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        StockStore s = new StockStore(10);
        
        // Create 2 producers
        Producer p1 = new Producer(s, "Producer-1");
        Producer p2 = new Producer(s, "Producer-2");
        
        // Create 3 consumers
        Consumer c1 = new Consumer(s, "Consumer-1");
        Consumer c2 = new Consumer(s, "Consumer-2");
        Consumer c3 = new Consumer(s, "Consumer-3");
        
        try {
            // Start all threads
            p1.start();
            p2.start();
            c1.start();
            c2.start();
            c3.start();
            
            // Let the program run for 20 seconds
            Thread.sleep(20000);
            
            // Interrupt all threads
            p1.interrupt();
            p2.interrupt();
            c1.interrupt();
            c2.interrupt();
            c3.interrupt();
            
            // Wait for threads to finish
            p1.join();
            p2.join();
            c1.join();
            c2.join();
            c3.join();
            
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Program completed after 20 seconds");
    }
    
}
