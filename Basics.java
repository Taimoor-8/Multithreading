package Multithreading;

class threads extends Thread{
    private int threadNo;

    public threads(int threadNo) {
        this.threadNo = threadNo;
    }

    public void run(){
        count();
    }

    public void count(){
        for (int i = 0; i < 20; i++){
            try {
                sleep(500);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("The value of i is %d and the thread number is %d" , i , threadNo);
            System.out.println();
        }
    }
}

public class Basics {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        threads t1 = new threads(1);
        threads t2 = new threads(2);

        t1.start();
        System.out.println();
        t2.start();

        long endTime = System.currentTimeMillis();

        System.out.println("Total time is " + (endTime - startTime));
    }
}
