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
    
    public synchronized void hartuZotzak(int filosofoId) throws InterruptedException {
        
        int ezkerZotza = filosofoId;
        int eskumaZotza = (filosofoId + 1) % FILOSOFO_KOP;
        
        // Itzaron bi zotzak libre egon arte
        while(!zotzak[ezkerZotza] || !zotzak[eskumaZotza]){
            wait();
        }
        
        // Bi zotzak artuta daude
        zotzak[ezkerZotza] = false;
        zotzak[eskumaZotza] = false;
    }
    
    public synchronized void hutsiZotzak(int filosofoId){
        int ezkerZotza = filosofoId;
        int eskumaZotza = (filosofoId + 1) % FILOSOFO_KOP;
        
        // Hutsi bi zotzak
        zotzak[ezkerZotza] = true;
        zotzak[eskumaZotza] = true;
        
        // Itzaroten dauden guztiei abisatu zotzak libre daudela
        notifyAll();
             
    }
    
}
