/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filosofisem;

import java.util.concurrent.Semaphore;

/**
 *
 * @author mirei
 */
public class Mahaia {
    private static final int FILOSOFO_KOP = 5;
    private boolean[] zotzak;
    Semaphore[] zotzakSem;
    
    public Mahaia(){
        zotzak = new boolean[FILOSOFO_KOP];
        zotzakSem = new Semaphore[FILOSOFO_KOP];
        for(int i = 0; i < FILOSOFO_KOP; i++){
            zotzak[i] = true; // hasieran guztiak daude libre
            zotzakSem[i] = new Semaphore(1, true);
        }
    }
    
    // Ezkerreko zotza filosofoaren id berdina edukiko du
    private int ezkerZotza(int i){
        return i;
    }
    
    // Eskumako zotza filosofoak eskuman duen filosofoaren id-a edukiko du
    private int eskumaZotza(int i){
        return i == 0 ? zotzak.length - 1 : i - 1;
    }
    
    public void hartuZotzak(int filosofoId) throws InterruptedException {
         
         
    }
}
