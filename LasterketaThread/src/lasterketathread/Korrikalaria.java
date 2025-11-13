/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lasterketathread;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author mirei
 */
public class Korrikalaria implements Runnable{
    
    int id;
    Helmuga helmuga;
    Random r=new Random();
    
    public Korrikalaria(Helmuga helmuga, int id){
        this.helmuga = helmuga;
        this.id = id;
    }
    
    @Override
    public void run(){
        
        try {
            //Itxaron irteera eman arte.
            helmuga.itxaronIrteera(id);
            sleep((long) (r.nextFloat()*1000));
            helmuga.iritsi(id);
            System.out.println(id + " korrikalari amaitu du.");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }   
}
