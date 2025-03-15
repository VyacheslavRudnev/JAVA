package manager.server;

import meneger.tools.Listener;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class Main {

    int port = 8888;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    public static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        Main manager = new Main();
        manager.dialog();
    }

    private void dialog() {
        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(port);
            System.out.println( "*** SERVER STARTED *** " ); //сервер почав прослуховування
            while (true) {
                client = server.accept(); //app blocks here
                Listener listener = new Listener(client);
                Thread thread = new Thread(listener);
                thread.setDaemon(true);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}