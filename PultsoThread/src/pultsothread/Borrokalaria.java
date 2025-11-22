/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pultsothread;

/**
 *
 * @author mirei
 */
public class Borrokalaria implements Runnable{
    
    Mahaia mahaia;
    int id;
    
    public Borrokalaria(Mahaia mahaia, int id){
        this.mahaia = mahaia;
        this.id = id;
    }
    
    @Override
    public void run(){
        try{
            // Borrokalariak prestatzen dira.
            mahaia.prestakuntza(id);
                    
            while(!mahaia.amaituta){
                if(id == 0){
                    mahaia.alexTxanda(id);
                } else if (id == 1){
                    mahaia.mikelTxanda(id);
                }
                
                Thread.sleep(mahaia.random.nextInt(1000) + 1000);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
