package managr.main;

import classes.MyThread1;
import classes.MyThread2;

public class Main {
    public static void main(String[] args) {
        System.out.print(Thread.currentThread().getName() + "started");

        int limit = 1000;

        MyThread1 t1 = new MyThread1(limit);
        //t1.setDaemon(true);
        t1.start();

        MyThread2 runnable = new MyThread2(limit);
        Thread t2 = new Thread(runnable);
        t2.setName("thread2");
        t2.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<limit;i++){
                    System.out.print("#");
                }
            }
        }).start();

        for(int i=0;i<limit;i++){
            System.out.print("A");
        }
    }
}