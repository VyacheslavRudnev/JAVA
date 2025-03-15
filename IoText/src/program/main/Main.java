package program.main;

import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {

        String text = ReadFile("text1.txt");
        //System.out.println(text);

        String[] words = text.split("\\s+");

    }

    private static String ReadFile(String file) {
        String text = "";
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8"));
             BufferedReader br = new BufferedReader(reader);

        ){
            String line = "";
            while ((line = br.readLine()) != null) {
                text += line + System.getProperty("line.separator");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}