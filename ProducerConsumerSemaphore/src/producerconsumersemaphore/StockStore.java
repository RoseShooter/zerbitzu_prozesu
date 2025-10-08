/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerconsumersemaphore;

/**
 *
 * @author mirei
 */
public class StockStore {

    private char store[];
    private int next;

    private boolean isFull;
    private boolean isEmpty;

    public StockStore(int lenght) {
        store = new char[lenght];
        next = 0;
        isFull = false;
        isEmpty = true;
        
        
    }

    // Method to consume characters from the buffer
    public char consume() {
        
    }

    // Method to add characters to the store
    public void produce(char c) {
        
    }
}
