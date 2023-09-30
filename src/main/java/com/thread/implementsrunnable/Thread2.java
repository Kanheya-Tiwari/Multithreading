package com.thread.implementsrunnable;

class RunnerEx implements Runnable{
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Thread:"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Thread2 {
    public static void main(String[] args) {
        /*Thread thread1 = new Thread(new RunnerEx());
        thread1.start();
        Thread thread2 = new Thread(new RunnerEx());
        thread2.start();*/

        //anonymous
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println("Thread:"+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t3.start();
    }
}
