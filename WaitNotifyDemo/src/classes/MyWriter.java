package classes;

import manager.main.Main;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyWriter implements Runnable {
    FileWriter fwriter;
    Object lock;

    public MyWriter(FileWriter fwriter, Object lock) {
        this.fwriter = fwriter;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (Main.line != "кінець файлу") {
                    lock.wait();    //лягає спати
                    if(Main.line != "кінець файлу")
                        fwriter.write(Main.line + " (Кількість символів = " + Main.charCount + " )"
                                + System.getProperty("line.separator"));
                        Main.charCount = 0;
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
