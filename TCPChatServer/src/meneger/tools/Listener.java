package meneger.tools;

import manager.server.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Timestamp;


public class Listener implements Runnable {

    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    Socket socket = null;
    String message = "";

    public Listener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("*** CONNECTED CLIENT: " + socket.getInetAddress().getHostAddress() + " ***");
        try {
            Main.semaphore.acquire();
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            oos.flush();

            while (!message.equals("exit")){
                try {
                    message = (String)ois.readObject();
                    if (message.equals("exit")){
                        System.out.println("*** DISCONNECTED CLIENT: " + socket.getInetAddress().getHostAddress() + " ***");
                        break;
                    }
                    System.out.println("client>" + message);
                    sendMessage("Your message was received ");
                }
                catch (IOException | ClassNotFoundException e) {
                    // обробка помилки під час читання
                    System.out.println("Error while reading message from client: " + e.getMessage());
                    break; // Якщо помилка при читанні — припинити з'єднання
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String msg) throws IOException {
        msg += " - " + new Timestamp(System.currentTimeMillis());
        oos.writeObject(msg);
        oos.flush();
        System.out.println("server>" + msg);
        }
}