package chat.main;

import javax.swing.*;
import java.io.IOException;
import java.net.*;

public class Main {

    MulticastSocket socket = null;
    public static InetAddress mcAddress = null;
    public static int mcPort = 9999;

    public static void main(String[] args) {
        Main manager = new Main();
        manager.initializeChat();

        ChatHelper chat = new ChatHelper(manager.socket);
        chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chat.pack();
        chat.setVisible(true);

        Thread thread = new Thread(chat);
        thread.setDaemon(true);
        thread.start();
    }

    private void initializeChat() {
        try {
            mcAddress = InetAddress.getByName("225.1.2.3");
            InetSocketAddress group = new InetSocketAddress(mcAddress, mcPort);
            socket = new MulticastSocket(mcPort);
            NetworkInterface netInf = NetworkInterface.getByName("bge0");
            socket.joinGroup(group, netInf);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}