/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ariketathreads1;

/**
 *
 * @author mirei
 */
public class Counter {
    
    public int kontaketa = 0;
    
    // Gehiketaren metodoa sortu
    public synchronized void gehiketa(){
        kontaketa++;
    }
    
    // Totala lortzeko metodoa sortu
    public int getKontaketa(){
        return kontaketa;
    }
    
    
}
