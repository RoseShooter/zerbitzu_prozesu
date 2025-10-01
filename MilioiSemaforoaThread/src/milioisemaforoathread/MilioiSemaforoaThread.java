/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package milioisemaforoathread;

import java.util.concurrent.Semaphore;

/**
 *
 * @author mirei
 */
public class MilioiSemaforoaThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Kontaketa kontaketa = new Kontaketa();

        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " is using the resource.");
                
                for(int i = 0; i < 250000; i++){
                    kontaketa.gehitu();
                }
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " has finisehd using the resource.");
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Kontaketa: " + kontaketa.getKontaketa());
    }

}

class Kontaketa {

    private int count = 0;

    public synchronized void gehitu() {
        count++;
    }

    public int getKontaketa() {
        return count;
    }
}



