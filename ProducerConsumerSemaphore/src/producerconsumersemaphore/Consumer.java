/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerconsumersemaphore;

import static java.lang.Thread.sleep;

/**
 *
 * @author mirei
 */
public class Consumer extends Thread{

    private StockStore store;
    private String name;

    public Consumer(StockStore store, String name) {
        this.store = store;
        this.name = name;
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()) {
            // Consume
            try {
                char c = store.consume();
                System.out.println(name + " got char '" + c + "' from store");
                // wait between 0 and 4 seconds 
                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
