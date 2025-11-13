/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ariketa1threadsem;

/**
 *
 * @author mirei
 */
public class Haria implements Runnable{
    
    Counter counter;
    
    public Haria(Counter counter){
        this.counter = counter;
    }
    
    @Override
    public void run(){
        
        for(int i = 0; i < 1000; i++){
            try {
                counter.batuketa();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        
    }
    
}
