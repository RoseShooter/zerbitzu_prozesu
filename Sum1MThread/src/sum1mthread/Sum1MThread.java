/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sum1mthread;

/**
 *
 * @author mirei
 */
public class Sum1MThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         SharedTotalSum shared = new SharedTotalSum();
        
        SumThread s1 = new SumThread(1, 250000, shared);
        SumThread s2 = new SumThread(250001, 500000, shared);
        SumThread s3 = new SumThread(500001, 750000, shared);
        SumThread s4 = new SumThread(750001, 1000000, shared);
        
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);
        Thread t4 = new Thread(s4);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e){
            System.err.print("Errorea egon da: " + e);
        }
        
        System.out.print("Emaitza totala; " + shared.getSum());
              
    }
    
}
