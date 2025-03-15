package manager.chat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();

    static {
        // Завантажуємо конфігураційний файл
        try (InputStream is = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) {
                System.out.println("Файл config.properties не знайдено!");
            }
            properties.load(is); // Завантажуємо властивості з файлу
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Метод для отримання значення по ключу
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
