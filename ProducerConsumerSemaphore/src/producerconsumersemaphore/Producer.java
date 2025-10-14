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
public class Producer extends Thread {

    private StockStore store;
    private final String words = "abcdefghijklmnopqrstuvxyz";
    private String name;

    public Producer(StockStore store, String name) {
        this.store = store;
        this.name = name;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // Get randomly words
                char c = words.charAt((int) (Math.random() * words.length()));
                // Produce
                store.produce(c);
                System.out.println(name + " added char '" + c + "' to store");
                // wait between 0 and 4 seconds 
                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException e) {
                Thread.currentThread().isInterrupted();
                break;
            }
        }
    }
}
