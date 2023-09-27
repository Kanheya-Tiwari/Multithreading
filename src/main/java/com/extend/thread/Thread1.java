package com.extend.thread;

class Runner extends Thread{
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
public class Thread1 {
    public static void main(String[] args){
        Runner runner1 = new Runner();
        runner1.start();
        Runner runner2 = new Runner();
        runner2.start();
    }
}

