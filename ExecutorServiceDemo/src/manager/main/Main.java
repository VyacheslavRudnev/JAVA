package manager.main;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //Перший приклад - підходить для використання коли потрібно використати виконання послідовних операцій в одному потоці
        ExecutorService service1 = Executors.newSingleThreadExecutor();

        service1.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " перший поток запущено");
            }
        });

        service1.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " другий поток запущено");
            }
        });

        service1.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " третій поток запущено");
            }
        });
        System.out.println("----------------------------------------");
        service1.shutdown();

        //Другий приклад - використовуємо задану кількість потоків
        ExecutorService service2 = Executors.newFixedThreadPool(10);

        service2.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 100; i++) {
                    System.out.print("A");
                }
            }
        });

        service2.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 100; i++) {
                    System.out.print(".");
                }
            }
        });
        service2.shutdown();
    //Третій приклад
        ScheduledExecutorService service3 = Executors.newScheduledThreadPool(10);

        service3.schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println(System.getProperty("line.separator") + Thread.currentThread() + " from schedule");
            }
        }, 2, TimeUnit.SECONDS);

        service3.shutdown();
    }
}