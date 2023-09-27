package com.synchronization;

import java.util.Scanner;

class Processor extends Thread{
        private volatile boolean running = true;
    public void run(){
        while(running){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void shutdown(){
        running = false;
    }

}
public class Thread3 {
    public static void main(String[] args){
        Processor processor1 = new Processor();
        processor1.start();
        System.out.println("Press return to stop ...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        processor1.shutdown();
    }
}

//Synchronization: Java Synchronization is better option where we want to allow only one thread to access the shared resource.

/*Why use Synchronization.
* 1.To prevent thread interference.
* 2.To prevent consistency problem. */

//volatile:The volatile keyword in Java is used to indicate that a variable's value may be modified by multiple threads simultaneously. It ensures that the variable is always read from and written to the main memory, rather than from thread-specific caches, ensuring visibility across threads.