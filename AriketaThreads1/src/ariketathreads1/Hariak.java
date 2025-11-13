/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ariketathreads1;

/**
 *
 * @author mirei
 */
public class Hariak implements Runnable{
    
    Counter counter;
    
    public Hariak(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        
        for(int i = 0; i < 100000; i++){
            counter.gehiketa();
        }
        
    }
}
