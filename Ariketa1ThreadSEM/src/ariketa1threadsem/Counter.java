/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ariketa1threadsem;

import java.util.concurrent.Semaphore;

/**
 *
 * @author mirei
 */
public class Counter {
    
    private int kontaketa = 0;
    Semaphore sem = new Semaphore(1);
    
    public void batuketa() throws InterruptedException{
        sem.acquire(1);
        kontaketa++;
        sem.release(1);
    }
    
    public int getKontaketa(){
        return kontaketa;
    }
    
}
