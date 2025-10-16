/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filosofisem;

import java.util.Random;

/**
 *
 * @author mirei
 */
public class Filosofoa implements Runnable{
    private Mahaia mahaia;
    private int id;
    private Random random = new Random();
    
    public Filosofoa(Mahaia mahaia, int id){
        this.mahaia = mahaia;
        this.id = id;
    }
    
    @Override
    public void run(){
        try{
            while(true){
                // Pentsatu denbora random bat
                System.out.println("Filosofo " + id + " pentsatzen ari da.");
                Thread.sleep(random.nextInt(3000) + 1000);
                
                
                // Saitu jaten
                mahaia.hartuZotzak(id);
                
                
                // Jan denbora random batean
                System.out.println("Filosofo " + id + " jaten ari da.");
                Thread.sleep(random.nextInt(3000) + 1000);
                
                mahaia.utziZotzak(id);
                
            }
        } catch (InterruptedException e){
            System.out.println("Filosofo " + id + " etenda");
        }
    }
    
}
