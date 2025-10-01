/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package milioiacontatuthread;

/**
 *
 * @author mirei
 */
public class MilioiaContatuThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kontaketa kontaketa = new Kontaketa();
        
        Thread thread1 = new Thread(new BatuketaEgin(kontaketa));
        Thread thread2 = new Thread(new BatuketaEgin(kontaketa));
        Thread thread3 = new Thread(new BatuketaEgin(kontaketa));
        Thread thread4 = new Thread(new BatuketaEgin(kontaketa));
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.print("Kontaketa: " + kontaketa.getKontaketa());
    }
    
}

class Kontaketa{
    private int count = 0;
    
    public synchronized void gehitu(){
        count++;
    }
    
    public int getKontaketa(){
        return count;
    }
}

class BatuketaEgin implements Runnable{
    private Kontaketa kontaketa;
    
    public BatuketaEgin(Kontaketa kontaketa){
        this.kontaketa = kontaketa;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 250000; i++){
            kontaketa.gehitu();
        }
    }
}
