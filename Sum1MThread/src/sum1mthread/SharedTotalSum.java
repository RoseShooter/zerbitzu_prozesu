/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sum1mthread;

import java.util.concurrent.Semaphore;

/**
 *
 * @author mirei
 */
public class SharedTotalSum {
    long totalSum = 0;


    public synchronized void sumTotal(long num) throws InterruptedException {
        totalSum += num;
    }

    long getSum() {
        return totalSum;
    }
}
