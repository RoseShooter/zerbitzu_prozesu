/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.filosofomonitoreak;

/**
 *
 * @author mirei
 */
public class FilosofoMonitoreak {

    public static void main(String[] args) throws InterruptedException{
        Mahaia mahaia = new Mahaia();
        
        Thread[] filosofoak = new Thread[5];
        for(int i = 0; i < 5; i++){
            filosofoak[i] = new Thread(new Filosofoa(mahaia, i));
            filosofoak[i].start();
        }
        
        // 20 segundu hutsi
        Thread.sleep(20000);
        
        //Filosofo guztiak gelditu
        for(Thread f : filosofoak){
            f.interrupt();
        }
        
        // Itzaron guztiak amaitu arte
        for(Thread f : filosofoak){
            f.join(1000);
        }
        
    }
}
