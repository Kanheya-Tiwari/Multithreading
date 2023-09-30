package com.thread.producerconsumer;

import java.util.Scanner;

public class Thread9 {
    public static void main(String args[]) {
        final Processor processor = new Processor();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}

class Processor{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread running...");
            wait();
            System.out.println("Resumed...");
        }
    }
    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this){
            System.out.println("Waiting for return key...");
            scanner.nextLine();
            System.out.println("Return key pressed...");
            notify();
            Thread.sleep(2000);
        }
    }
}

/*wait(): It tells the calling thread to give up the lock and go to sleep until some other thread enters the same monitor and calls notify().*/
/*notify(): It wakes up one single thread that called wait() on the same object.This method gives the notification for only one thread which is waiting for a particular object.
* If we use notify() method and multiple threads are waiting for the notification then only one thread get the notification and the remaining thread have to wait for further notification. */

/*notifyAll():It wakes up all the threads that called wait() on the same object.*/