/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lasterketathread;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author mirei
 */
public class Helmuga {
    
    Semaphore sem = new Semaphore(1);
    Semaphore irteeraSem=new Semaphore(0);
    Random random = new Random();
    int irabazi=0;
   
    public void iritsi(int id) throws InterruptedException{
        sem.acquire();
        if(irabazi==0){
            irabazi=id;
        }
        sem.release();
    }

    void itxaronIrteera(int id) {
        System.out.println(id+". Korrikalaria prest.");
        try {
            irteeraSem.acquire();
        } catch (InterruptedException ex) {
            System.getLogger(Helmuga.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    void irteeraEman(){
        irteeraSem.release(4);
    }
    
    int irabazlea(){
            return irabazi;
    }
}
