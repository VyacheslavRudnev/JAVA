package classes;

import manager.main.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyReader implements Runnable {
    FileReader freader;
    BufferedReader reader = null;
    Object lock;

    public MyReader(FileReader freader, Object lock) {
        this.freader = freader;
        this.lock = lock;
        this.reader = new BufferedReader(freader);
    }

    @Override
    public void run() {
        String str = null;
        try {
            synchronized (lock) {
                while((str = reader.readLine()) != null) {
                    Main.line = str;
                    Main.charCount = str.replace(" ", "").length(); //не враховуємо пробіли
                    lock.notify(); //будить поток письменника
                    lock.wait();    //переход до режиму сну
                }
                Main.line = "кінець файлу";
                lock.notify();
            }




        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
