/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sum1msem;

import java.util.concurrent.Semaphore;

/**
 *
 * @author mirei
 */
public class SharedSumTotal implements Runnable{
    long sumTotal;
    Semaphore sem;
    
    public SharedSumTotal(){
        sem = new Semaphore(1, true);
    }
    
    void sumTotal(long num) throws InterruptedException{
        sem.acquire();
        sumTotal += num;
        sem.release();
    }
    
    long getSum(){
        return sumTotal;
    }
    
    @Override
    public void run(){
        
    }
}
