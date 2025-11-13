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

    public static void main(String[] args) {
        
        int kop;
        Mezua mezu = new Mezua();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sartu sortu nahi dituzun hari kopuruak: ");
        kop = scanner.nextInt();
        
        
        for(int i = 0; i < kop; i++){
            Haria h = new Haria(mezu,i);
            Thread thread = new Thread(h);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
           
        }
       
    }
    
}
