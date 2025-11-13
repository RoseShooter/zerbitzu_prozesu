/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lasterketathread;

import static java.lang.Thread.sleep;

/**
 *
 * @author mirei
 */
public class LasterketaThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Helmuga helmuga = new Helmuga();

        Korrikalaria h1 = new Korrikalaria(helmuga, 1);
        Korrikalaria h2 = new Korrikalaria(helmuga, 2);
        Korrikalaria h3 = new Korrikalaria(helmuga, 3);
        Korrikalaria h4 = new Korrikalaria(helmuga, 4);
        
        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 = new Thread(h3);
        Thread t4 = new Thread(h4);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try{
            sleep(3000);
            helmuga.irteeraEman();
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e){
            
        }
        int irabazlea=helmuga.irabazlea();
        System.out.println(irabazlea + " korrikalari irabazi du.");
        
    }
    
}
