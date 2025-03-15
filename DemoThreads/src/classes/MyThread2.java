package classes;

public class MyThread2 implements Runnable {

    int limit;

    public MyThread2(int limit) {
            this.limit = limit;
        }

        @Override
        public void run() {
            System.out.print(Thread.currentThread().getName() + "started");
            for(int i=0;i<limit;i++){
                System.out.print("x");
            }



    }
}
