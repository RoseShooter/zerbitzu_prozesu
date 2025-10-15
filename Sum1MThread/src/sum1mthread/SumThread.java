/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sum1mthread;

/**
 *
 * @author mirei
 */
public class SumThread implements Runnable{
    int min, max;
    SharedTotalSum shared;
    long sum;

    public SumThread(int min, int max, SharedTotalSum shared) {
        this.min = min;
        this.max = max;
        this.shared = shared;
    }

    @Override
    public void run(){
        for(int i = min; i <= max; i++){
            sum += i;
        }
        try {
            shared.sumTotal(sum);
        } catch (InterruptedException ex) {
            System.getLogger(SumThread.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
