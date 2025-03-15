package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader implements Runnable {
    private FileReader fileReader;

    public Reader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public void run() {
        int sum = 0;
        int numWordsCounter = 0;

        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            Pattern pattern = Pattern.compile("\\b\\d+\\b"); // Регулярний вираз для пошуку слів виключно із цифр

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line); //об'єкт для пошуку збігів з регулярним виразом у рядку
                while (matcher.find()) { //пошук по тексту збігів.
                    String numberStr = matcher.group(); //повертаємо знайдені числа у вигляді рядка
                    sum += Integer.parseInt(numberStr);
                    numWordsCounter++; // лічильник слів
                }
            }

            System.out.println("Кількість 'цифрових' слів: " + numWordsCounter);
            System.out.println("Сума 'цифрових' слів: " + sum);

        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}