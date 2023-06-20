package Multithreading;
public class Wait_Notify {

    public static int balance = 0;
    public void withdraw(int amount){
        if (balance == 0){
            synchronized (this){
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        balance = balance - amount;
        System.out.println("Withdrawal amount is " + amount);
        System.out.println("Balance after withdrawal is " + balance);
    }

    public void deposit(int amount){
        balance = balance + amount;
        System.out.println("Deposited amount is " + amount);
        System.out.println("Balance after depositing is " + balance);

        synchronized (this){
            notifyAll();
        }
    }

    public static void main(String[] args) {

        Wait_Notify wn = new Wait_Notify();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                wn.withdraw(1000);
            }
        });
        t1.setName("Thread 1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                wn.deposit(2000);
            }
        });
        t2.setName("Thread 2");
        t2.start();
    }
}
