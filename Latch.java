package Multithreading;

import java.util.concurrent.CountDownLatch;

class someThread extends Thread{
    private CountDownLatch latch;

    public someThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running");
        System.out.println("Thread execution is completed");
        System.out.println("******************");
        latch.countDown();
    }
}

public class Latch {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(4);

        someThread t1 = new someThread(latch);
        someThread t2 = new someThread(latch);
        someThread t3 = new someThread(latch);
        someThread t4 = new someThread(latch);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            latch.await();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inside main thread");
    }
}
