/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filosofomonitoreak;
/**
 *
 * @author mirei
 */
public class Mahaia {
    private static final int FILOSOFO_KOP = 5;
    private boolean[] zotzak; // true filosofoa jaten badago
    
    
    public Mahaia(){
        zotzak = new boolean[FILOSOFO_KOP];
        for(int i = 0; i < FILOSOFO_KOP; i++){
            zotzak[i] = true; // hasieran guztiak daude libre
        }
    }
    
    private int ezkerZotza(int i){
        return i;
    }
    
    private int eskumaZotza(int i){
        return i == 0 ? zotzak.length - 1 : i - 1;
    }
  
    
    public synchronized void hartuZotzak(int filosofoId) throws InterruptedException {
            
        // Itzaron bi zotzak libre egon arte
        while(!zotzak[ezkerZotza(filosofoId)] || !zotzak[eskumaZotza(filosofoId)]){
            wait();
        }
        
        // Bi zotzak artuta daude
        zotzak[ezkerZotza(filosofoId)] = false;
        zotzak[eskumaZotza(filosofoId)] = false;
    }
    
    public void hutsiZotzak(int filosofoId){
        // Hutsi bi zotzak
        zotzak[ezkerZotza(filosofoId)] = true;
        zotzak[eskumaZotza(filosofoId)] = true;
        
        // Itzaroten dauden guztiei abisatu zotzak libre daudela
        notifyAll();
             
    }
    
}
