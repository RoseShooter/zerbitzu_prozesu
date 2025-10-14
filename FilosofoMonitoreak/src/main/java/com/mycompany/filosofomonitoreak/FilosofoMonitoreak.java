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
        
        // 5 Filosofo sortu
        Filosofoa[] filosofoak = new Filosofoa[5];
        for(int i = 0; i < 5; i++){
            filosofoak[i] = new Filosofoa(mahaia, i);
            filosofoak[i].start();
        }
        
        // 20 segundu hutsi
        Thread.sleep(20000);
        
        //Filosofo guztiak gelditu
        for(Filosofoa f : filosofoak){
            f.interrupt();
        }
        
        // Itzaron guztiak amaitu arte
        for(Filosofoa f : filosofoak){
            f.join(1000);
        }
        
    }
}
