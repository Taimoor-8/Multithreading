package Multithreading;

public class Use_Of_Volatile {

//    Volatile keyword is used for prevention from Cashing condition
    volatile public static int flag = 0;
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if (flag == 0){
                        System.out.println("Running");
                    }
                    else{
                        break;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag = 1;
                System.out.println();
                System.out.println("flag value is updated");
            }
        }).start();
    }
}
