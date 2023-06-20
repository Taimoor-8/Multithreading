package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrant_Lock {

    static int counter = 0;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                for(int i = 0; i <= 1000; i++){
                    Reentrant_Lock.counter++;
                }
                lock.unlock();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                for(int i = 0; i <= 1000; i++){
                    Reentrant_Lock.counter++;
                }
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("The value of counter after both the threads is " + Reentrant_Lock.counter);
    }
}
