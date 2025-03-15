package manager.main;

import classes.Reader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String path = "input.txt";

        try (FileReader fileReader = new FileReader(path, StandardCharsets.UTF_8)) {
            Reader reader = new Reader(fileReader);
            Thread readerThread = new Thread(reader);

            readerThread.start();
            readerThread.join(); // додано для того щоб головний потік чекав завершення роботи
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Потік був перерваний: " + e.getMessage());
        }
    }
}