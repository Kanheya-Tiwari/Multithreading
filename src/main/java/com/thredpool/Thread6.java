package com.thredpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
    private int id;
    public Processor(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("Starting...."+id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed...."+id);

    }
}
public class Thread6 {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++){
            executor.submit(new Processor(i));
        }
        executor.shutdown();
        System.out.println("All tasks submitted.");
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All tasks completed.");
    }
}


/*Thread Pool: A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource  */

/*Steps to be followed:
* 1. Create a task(Runnable Object) to execute
2. Create Executor Pool using Executors
3. Pass tasks to Executor Pool
4. Shutdown the Executor Pool */

/*Risks in using Thread Pools
* 1. Deadlock
* 2. Thread Leakage :Thread Leakage occurs if a thread is removed from the pool to execute a task but not returned to it
*  when the task completed. As an example, if the thread throws an exception and pool class does not catch this exception,
*  then the thread will simply exit, reducing the size of the thread pool by one. If this repeats many times,
* then the pool would eventually become empty and no threads would be available to execute other requests
* 3.Resource Thrashing :If the thread pool size is very large then time is wasted in context switching between threads. */

