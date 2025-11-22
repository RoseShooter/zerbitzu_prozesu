/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pultsothread;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author mirei
 */
public class Mahaia {

    boolean amaituta = false;
    Semaphore hasiera = new Semaphore(0);
    Semaphore borroka = new Semaphore(1);
    String izena;
    Random random = new Random();
    int totala = 0;

    public void prestakuntza(int id) {
        String izenLokala;
        if (id == 0) {
            izenLokala = "Alex";
            System.out.println(izenLokala + " prest dago.");
        } else if (id == 1) {
            izenLokala = "Mikel";
            System.out.println(izenLokala + " prest dago.");
        }
        
        try {
            hasiera.acquire(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void hasiBorroka() {
        hasiera.release(2);
    }

    public void alexTxanda(int id) {
        if(amaituta) return;
        int zenbakia = random.nextInt(6) + 2;
        
        try {
            
            Thread.sleep(random.nextInt(1000) + 1000);
            
            borroka.acquire(1);
            
            if(amaituta){
                borroka.release();
                return;
            }
            
            if (id == 0) {
                totala += zenbakia;
                System.out.println("Alex-en txanda = +"+ zenbakia + " / Borrokaren totala: " + totala);
            }
            
            if(totala >= 20 || totala <= -20){
                amaituta = true;
                amaituta();
            }
            
            borroka.release(1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public void mikelTxanda(int id) {
        if(amaituta) return;
        int zenbakia = random.nextInt(6) + 2;
        
        try {
            
            Thread.sleep(random.nextInt(1000) + 1000);
            
            borroka.acquire(1);
            
            if(amaituta){
                borroka.release();
                return;
            }
            
            
            if (id == 1) {
                totala -= zenbakia;
                System.out.println("Mikel-en txanda = -"+ zenbakia + " / Borrokaren totala: " + totala);
            }
            
            if(totala >= 20 || totala <= -20){
                amaituta = true;
                amaituta();
            }
            
            borroka.release(1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void amaituta() {
        if (totala >= 20) {
            System.out.println("Alex-ek irabazi du");
        } else if (totala <= -20) {
            System.out.println("Mikel-ek irabazi du");
        }
    }

}
