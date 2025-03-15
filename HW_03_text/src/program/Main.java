package program;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        int result[] = ReadFile("text_hw.txt");
        System.out.println("В тексті знайдено " + result[1] + " чисел");
        System.out.println("Сума всіх чисел в тексті = " + result[0]);
    }

    private static int[] ReadFile(String file) {

        int sum = 0;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))
// таким записом позбавляємось зайвої змінної reader,
// скорочуємо запис коду,
// та оптимізуємо за допомогою вбудованих інструментів (об'єктів) StandardCharsets.UTF_8
// що швидше і безпечніше

//             попередній запис із додатковою змінною reader
//            try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8"));
//             BufferedReader br = new BufferedReader(reader);
        ){
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); //розділення тексту на слова
                for (String word : words) {
                    if (word.matches("\\d+")){ //використання регулярного виразу для перевірки, чи складається слово лише з чисел
                        sum += Integer.parseInt(word);
                        count++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[]{sum, count};
    }
}