/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ariketathreads1;

/**
 * Create a class Counter that holds an integer shared among multiple threads.
 * Start 5 threads that each increment the counter 1,000 times.
 * Ensure the final result is correct using synchronized blocks or semaphores.
 */
public class AriketaThreads1 {

   
    public static void main(String[] args) throws InterruptedException{
       
        Counter counter = new Counter();
        
        // 5 thread dituen array bat sortu
        Thread[] threads = new Thread[5];
        
        for (int i = 0; i < 5; i++){
            threads[i] = new Thread(() -> { // Lambdak runnable-a sortzen du
                for(int j = 0; j < 1000; j++){
                counter.gehiketa();
                }
            });
            
           // Thread-ak abiarazten ditugu.
            threads[i].start();
            
        }
        
        // Thread guztiak amaitu harte itzaron
        for(Thread thread : threads){
            thread.join();
        }
        
        System.out.println("Azken kontaketa: " + counter.getKontaketa());
        
        
        
    }
    
}
