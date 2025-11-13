/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ariketa1threadsem;

/**
 *
 * @author mirei
 */
public class Ariketa1ThreadSEM {


    public static void main(String[] args) {

        Counter counter = new Counter();
        
        Haria h1 = new Haria(counter);
        Haria h2 = new Haria(counter);
        Haria h3 = new Haria(counter);
        Haria h4 = new Haria(counter);
        Haria h5 = new Haria(counter);
        
        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 = new Thread(h3);
        Thread t4 = new Thread(h4);
        Thread t5 = new Thread(h5);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("Guztira: " + counter.getKontaketa());
       
        
    }
    
}
