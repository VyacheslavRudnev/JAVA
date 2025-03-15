package manager.main;

import classes.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ExecutorService service1 = Executors.newSingleThreadExecutor();

        Calculator calc = new Calculator(10);

        Future<Integer> future = service1.submit(calc);
        try {
            int sum = 0;
//            if (future.isDone()) {
//                sum = future.get();
//            }
            sum = future.get(500, TimeUnit.MILLISECONDS);
            System.out.println("Sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        service1.shutdown();
        int count = 10;
        ExecutorService service2 = Executors.newFixedThreadPool(count);

        List<Future<Integer>> results = new ArrayList<>();


        for (int i = 0; i < count; i++) {
            int rn = new Random().nextInt(100);
            System.out.println(rn + ", ");
            Calculator calc1 = new Calculator(rn);
            Future<Integer> future1 = service2.submit(calc1);
            results.add(future1);
        }
        for (int i = 0; i < count; i++) {
            try {
                System.out.println( i + ": " + results.get(i).get() );
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service2.shutdown();
    }
}