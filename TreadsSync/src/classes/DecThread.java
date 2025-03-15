package classes;

import manager.main.Main;

public class DecThread implements Runnable {

    int limit;
    Object lock;

    public DecThread(int limit, Object lock) {
         this.limit = limit;
         this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 0; i < limit; i++) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("I was asked to stop, and I will stop");
                return;
            }
            synchronized (lock){
                Main.Counter--;
            }

        }
    }
}
