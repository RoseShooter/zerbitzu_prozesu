/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ariketathreads2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author mirei
 */
public class Mezua {
    
    Semaphore sem = new Semaphore(1);
    
    public void mezuaInprimatu(int kop) throws InterruptedException{
        sem.acquire(1);
        System.out.println("Kaixo, " + kop + " thread-a naiz eta exekutatzen nabil");
        sem.release(1);
    }   
}
