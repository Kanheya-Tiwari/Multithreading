package com.thread.countdownlatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{
    private CountDownLatch latch;
    public Processor(CountDownLatch latch){
        this.latch=latch;
    }
    public void run() {
        System.out.println("Started...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        latch.countDown();
    }
}
public class Thread7 {
    public static void main(String[] args){
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++){
            executor.submit(new Processor(countDownLatch));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed...");
    }
}


/* CountDownLatch : CountDownLatch is used to make sure that a task waits for other threads before it starts.
 CountDownLatch cannot be reused, when count arrives at zero it can't be reset.  */

/*Working of CountDownLatch: When we create an object of CountDownLatch, we specify the number of threads it should wait for,
 all such thread are required to do count down by calling CountDownLatch.countDown() once they are completed or ready to the job.
 As soon as count reaches zero, the waiting task starts running. */

/* Real Time Example:Suppose a stone can be lifted by 10 people so you will wait for all 10 to come. Then only you can lift the stone */