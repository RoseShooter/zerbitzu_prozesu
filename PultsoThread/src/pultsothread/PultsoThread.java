/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pultsothread;

/**
 *
 * @author mirei
 */
public class PultsoThread {


    public static void main(String[] args) {
        
        Mahaia mahaia = new Mahaia();
        
        Thread alex = new Thread(new Borrokalaria(mahaia, 0));
        Thread mikel = new Thread(new Borrokalaria(mahaia, 1));
        
        alex.start();
        mikel.start();
        
        try{
            mahaia.hasiBorroka();
            alex.join();
            mikel.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    
}
