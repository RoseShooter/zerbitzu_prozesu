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
        
        Runnable task = () -> {
            try {
                sem.acquire();
                
            
        }
        
        System.out.println("Program completed after 20 seconds");
    }
    }
    
}


class StockStore {
    private char store[];
    private int next;
     
    // Flags about store situation
    private boolean isFull;
    private boolean isEmpty;
    
    public StockStore(int lenght) {
        store = new char[lenght];
        next= 0;
        isFull= false;
        isEmpty = true;
    }

    // Method to consume characters from the buffer
    public synchronized char consume() {
        // Cannot consume if the buffer is empty
        while (isEmpty == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        // Decrement the count, as a character is being consumed
        next--;
        
        char c = store[next];
        // Check if the last character has been removed
        if (next == 0) {
            isEmpty = true;
        }
        // The store cannot be full because we just consumed
        isFull = false;
        notifyAll();
 
        // Return the character to the consuming thread
        return (store[next]);
    }
 
    // Method to add characters to the store
    public synchronized void produce(char c) {
        // Wait until there is space for another character
        while (isFull == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        // Add a character at the next available position
        store[next] = c;
        // Move to the next available position
        next++;
        isEmpty = false;
        // Check if the buffer is full
        if (next == this.store.length) {
            isFull = true;
        }
        isEmpty = false;
        notifyAll();
    }
    
    public synchronized int getCurrentSize(){
        return next;
    }
}

class Producer extends Thread {
    private StockStore store;
    private final String words= "abcdefghijklmnopqrstuvxyz";
    private String name;
    
    public Producer(StockStore store, String name) {
        this.store = store;
        this.name = name;
    }
    
    public void run() {
        while (true) {
            // Get randomly words
            char c = words.charAt((int) (Math.random() * words.length()));
            // Produce
            store.produce(c);
            System.out.println(name + " added char '" + c + "' to store (size: " + store.getCurrentSize() + ")");
            try {
                // wait between 0 and 4 seconds 
                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException e) { }
        }
    }
}

class Consumer extends Thread {
    private StockStore store;
    private String name;
    
    public Consumer(StockStore store, String name) {
        this.store = store;
        this.name = name;
    }
    
    public void run() {
        while (true) {
            // Consume
            char c= store.consume();
            System.out.println(name + " got char '" + c + "' from store (size:" + store.getCurrentSize() + ")");
            try {
                // wait between 0 and 4 seconds 
                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException e) { 
                break;
            }
        }
    }
}
