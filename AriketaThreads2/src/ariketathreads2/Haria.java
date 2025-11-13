/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ariketathreads2;

/**
 *
 * @author mirei
 */
public class Haria implements Runnable{
    
    int kop;
    Mezua mezu;
    
    public Haria(Mezua mezu, int kop){
        this.mezu = mezu;
        this.kop = kop;
    }
    
    @Override
    public void run(){
        
        for(int i = 0; i < kop; i++){
            try {
                mezu.mezuaInprimatu(i);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }
    
}
