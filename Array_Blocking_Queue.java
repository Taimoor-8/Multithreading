package Multithreading;

import java.util.concurrent.ArrayBlockingQueue;

class producer implements Runnable{
    private ArrayBlockingQueue <Integer> queue;

    public producer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                queue.put(Array_Blocking_Queue.counter++);
                System.out.println("Value added to the queue is " + Array_Blocking_Queue.counter);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class consumer implements Runnable{

    private ArrayBlockingQueue <Integer> queue;

    public consumer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5000);
                queue.take();
                Array_Blocking_Queue.counter--;
                System.out.println("value removed from queue is " + Array_Blocking_Queue.counter);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Array_Blocking_Queue {
    static int counter = 0;

    public static void main(String[] args) {

        ArrayBlockingQueue <Integer> queue = new ArrayBlockingQueue<>(10);

        producer producer = new producer(queue);

        Thread producerThread = new Thread(producer);
        producerThread.start();


        consumer consumer = new consumer(queue);

        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }
}
