package com.thread.synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Worker{
    private Random random= new Random();
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();
  //Object Level Locking
    public void stageOne() throws InterruptedException {
        synchronized (lock1){
            Thread.sleep(1);
            list1.add(random.nextInt(100));
        }
    }
    public void stageTwo() throws InterruptedException {
        synchronized(lock2) {
            Thread.sleep(1);
            list2.add(random.nextInt(100));
        }
    }

    public void process() throws InterruptedException {
        for(int i=0;i<1000;i++){
            stageOne();
            stageTwo();
        }
    }

    public void main() throws InterruptedException {
        System.out.println("Starting...");
        long start = System.currentTimeMillis();
        Thread t1 =new Thread(new Runnable() {
            public void run() {
                try {
                   process();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 =new Thread(new Runnable() {
            public void run() {
                try {
                    process();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
         t1.start();
         t2.start();
         t1.join();
         t2.join();

        long end = System.currentTimeMillis();
        System.out.println("Time Taken..."+(end-start));
        System.out.println("List1: "+list1.size()+" List2:"+list2.size());
    }

}

public class Thread5{
    public static void main(String... args) throws InterruptedException {
        Worker worker = new Worker();
        worker.main();
    }
}



/*Object level locking: Object level locking means you want to synchronize non-static method or block so that it can be accessed by only one thread at a time for that instance.
It is used if you want to protect non-static data.*/


/*Class level locking:Class level locking means you want to synchronize static method or block so that it can be accessed by only one thread for whole class.
If you have 10 instances of class, only one thread will be able to access only one method or block of any one instance at a time.
It is used if you want to protect static data.*/