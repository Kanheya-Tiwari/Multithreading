package com.deadloack;

public class Thread11 {
    public static void main(String ar[]) {
        Thread11 test = new Thread11();

        final resource1 a = test.new resource1();
        final resource2 b = test.new resource2();

        // Thread-1
        Thread t1 = new Thread()  {
            public void run() {
                synchronized (b) {
                    try {
                        /* Adding delay so that both threads can start trying to lock resources */
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Thread-1 have resource1 but need resource2 also
                    synchronized (a) {
                        System.out.println("Thread 1: In block 1");
                    }
                }
            }
        };

// Thread-2
        Thread t2 = new Thread()  {
            public void run() {
                synchronized (b) {
                    // Thread-2 have resource2 but need resource1 also
                    synchronized (a) {
                        System.out.println("Thread 2: In block 2");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
    // resource1
    private class resource1 {
        private int i = 10;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    // resource2
    private class resource2 {
        private int i = 20;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}
