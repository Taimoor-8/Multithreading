package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class thread extends Thread{
    private String name;

    public thread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("thread is started " + name);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread ended " + name);
    }
}

public class Thread_Pool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        thread t1 = new thread("thread 2");
        thread t2 = new thread("thread 3");
        thread t3 = new thread("thread 4");
        thread t4 = new thread("thread 5");
        thread t5 = new thread("thread 6");
        thread t6 = new thread("thread 7");
        thread t7 = new thread("thread 8");
        thread t8 = new thread("thread 9");
        thread t9 = new thread("thread 10");
        thread t10 = new thread("thread 11");
        thread t11 = new thread("thread 12");
        thread t12 = new thread("thread 13");

        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);
        executorService.submit(t4);
        executorService.submit(t5);
        executorService.submit(t6);
        executorService.submit(t7);
        executorService.submit(t8);
        executorService.submit(t9);
        executorService.submit(t10);
        executorService.submit(t11);
        executorService.submit(t12);

        executorService.shutdown();


    }
}
