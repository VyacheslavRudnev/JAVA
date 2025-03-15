package manager.main;

import classes.MyReader;
import classes.MyWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {

    public static String line;
    public static int charCount;

    public static void main(String[] args) {
        String path1 = "input.txt";
        String path2 = "output.txt";
        Object lock = new Object();

        FileReader freader = null;
        FileWriter fwriter = null;

        try {
            freader = new FileReader(path1, StandardCharsets.UTF_8);
            fwriter = new FileWriter(path2, StandardCharsets.UTF_8);

            MyReader runReader = new MyReader(freader, lock);
            MyWriter runWriter = new MyWriter(fwriter, lock);

            Thread reader = new Thread(runReader);
            Thread writer = new Thread(runWriter);

            writer.start();
            Thread.sleep(100);
            reader.start();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}