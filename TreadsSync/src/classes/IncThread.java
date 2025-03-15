package classes;

import manager.main.Main;

public class IncThread implements Runnable {
    int limit;
    Object lock;

    public IncThread(int limit, Object lock) {
        this.limit = limit;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 0; i < limit; i++) {
            synchronized (lock){
                Main.Counter++;
            }
        }
    }
}
