package fibonnaccithread;

import java.util.Scanner;

public class FibonnacciThread extends Thread {
    
    @Override
    public void run() {
        calculateFibonacci();
    }
    
    public void calculateFibonacci() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many Fibonacci numbers do you want? ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("The number must be positive");
            scanner.close();
            return;
        }
        
        System.out.println("\nFibonacci's first " + n + " numbers:");
        
        if (n == 1) {
            System.out.println("1");
            scanner.close();
            return;
        }
        
        int fbNum1 = 1;
        int fbNum2 = 1;
        
        System.out.print(fbNum1);
        if (n >= 2) {
            System.out.print(" " + fbNum2);
        }
        
        // Calculate remaining numbers
        for (int i = 3; i <= n; i++) {
            int fbResult = fbNum1 + fbNum2;
            System.out.print(" " + fbResult);
            
            fbNum1 = fbNum2;
            fbNum2 = fbResult;
        }
        System.out.println(); 
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        
        FibonnacciThread fibThread = new FibonnacciThread();
        fibThread.start();
        
        
        try {
            fibThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Program completed!");
    }
}