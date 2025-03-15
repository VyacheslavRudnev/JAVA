package manager.main;

import classes.DecThread;
import classes.IncThread;

public class Main {

    public static int Counter = 0;

    public static void main(String[] args) {

        int limit = 10000000;
        Object lock = new Object();

        IncThread inc = new IncThread(limit, lock);
        DecThread dec = new DecThread(limit, lock);

        Thread tinc = new Thread(inc);
        Thread tdec = new Thread(dec);

        tdec.interrupt();

        tinc.start();
        tdec.start();
//перший спосіб - неправильний спосіб очікування потоків
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//другий спосіб - неправильний спосіб очікування потоків
        //while (tinc.isAlive() || tdec.isAlive()) {}

//третій спосіб - найкращий
        try {
            tinc.join();
            tdec.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter = " + Counter);
    }
}