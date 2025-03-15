package manager.chat;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Timestamp;

public class Main {
    //отримання налаштувань порту та серверу з конфігураційного файлу
    String serverAddress = ConfigLoader.getProperty("serverAddress");
    int serverPort = Integer.parseInt(ConfigLoader.getProperty("serverPort"));

    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    String message = "";
    Socket socket = null;

    public static void main(String[] args) {
    Main manager = new Main();
        try {
            manager.dialog();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void dialog() throws IOException {
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Connection OK");

            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            oos.flush();

            String response = "";
            do {
                message = JOptionPane.showInputDialog(null,"Enter your message");
                if(message == null || message.equals("exit")) {
                    System.out.println("Користувач завершив бесіду");

                    sendMessage(message);
                    break;
                }
                sendMessage(message);

                response = (String)ois.readObject();
                System.out.println("server>" + response);

            }while (!message.equals("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void sendMessage(String msg) throws IOException {
        //виправлення помилки виходу з чату - додана перевірка
        if(msg.equals("exit")) {
            oos.writeObject(msg);
            oos.flush();
        }
        msg += " - " + new Timestamp(System.currentTimeMillis());
        oos.writeObject(msg);
        oos.flush();
        System.out.println("server>" + msg);
    }
}