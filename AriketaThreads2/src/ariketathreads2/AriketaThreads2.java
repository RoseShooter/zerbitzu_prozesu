/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ariketathreads2;

import java.util.Scanner;

/**
 * Create a program that starts N threads.
 * Each thread prints a message like:
 */
public class AriketaThreads2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Mezua mezua = new Mezua();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sartu sortu nahi dituzun thread kopurua: ");
        int kop = scanner.nextInt();
        
        for(int i = 0; i <= kop; i++){
            final int threadZen = i;
            
            Thread thread = new Thread(() -> {
                mezua.mezuaInprimatu(threadZen);
            });
            
            thread.start();
        }
    }
    
}
