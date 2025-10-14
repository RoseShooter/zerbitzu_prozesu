/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerconsumersemaphore;

import java.util.concurrent.Semaphore;

public class StockStore {

    private char store[];
    private int next = 0;

    private Semaphore empty; // hutsik dauden lekuak zenbatzen ditu
    private Semaphore full;  // beteta dauden lekiak zenbatzen ditu
    private Semaphore buffer; // biak kontrolatzen ditu

    public StockStore(int length) {
        store = new char[length];
        next = 0;
        
        // Semaphore-ak inizializatu
        empty = new Semaphore(length); //Hasieran guztiak hutsik
        full = new Semaphore(0); // Hasieran ez dago ezer beteta
        buffer = new Semaphore(1); // Biak kontrolatzeko
        
    }

    // Method to consume characters from the buffer
    public char consume() throws InterruptedException{
        full.acquire(); //Item bat dagoen arte itzaron
        buffer.acquire();
        
        char c = store[0];
        
        for(int i = 1; i < store.length; i++){
            store[i - 1] = store[i];
        }
        next--;
        
        buffer.release();
        empty.release(); 
        
        return c;
        
    }

    // Method to add characters to the store
    public void produce(char c) throws InterruptedException {
        empty.acquire();
        buffer.acquire();
        
        store[next] = c;
        next++;
        
        buffer.release();
        full.release();
        
    }
}
