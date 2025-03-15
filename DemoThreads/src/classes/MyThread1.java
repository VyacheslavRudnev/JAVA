package classes;

public class MyThread1 extends Thread {

    int limit;

    public MyThread1(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName() + "started");
        for(int i=0;i<limit;i++){
            System.out.print(".");
        }


    }
}
