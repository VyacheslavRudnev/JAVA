package chat.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.util.Arrays;

public class ChatHelper extends JFrame implements Runnable {

    MulticastSocket socket = null;
    JTextField tfName = null;
    JTextArea taSend = null;
    JTextArea taResponse = null;

    public ChatHelper(MulticastSocket socket) throws HeadlessException {
        this.socket = socket;
        createGui();
    }

    private void createGui() {
        JPanel left = new JPanel();
        JPanel right = new JPanel();

        Container base = this.getContentPane();
        base.setLayout(new BorderLayout());

        //left panel
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lb1 = new JLabel("Enter message:");
        taSend = new JTextArea();
        taSend.setColumns(50);
        taSend.setRows(3);
        JScrollPane sp1 = new JScrollPane(taSend);

        JLabel lb2 = new JLabel("All messages:");
        taResponse = new JTextArea();
        taResponse.setColumns(50);
        taResponse.setRows(3);
        JScrollPane sp2 = new JScrollPane(taResponse);

        left.add(lb1);
        left.add(sp1);
        left.add(lb2);
        left.add(sp2);

        //right panel
        right.setLayout(new BorderLayout());
        right.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        tfName = new JTextField();
        tfName.setSize(100, 30);

        JButton btSend = new JButton("Send Message");
        btSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfName.getText().length() == 0 | taSend.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Name and Message cannot be empty!");
                }
                else{
                    sendMessage();
                }
            }
        });
        right.add(tfName, BorderLayout.NORTH);
        right.add(btSend, BorderLayout.SOUTH);

        base.add(left, BorderLayout.WEST);
        base.add(right, BorderLayout.EAST);
    }

    private void sendMessage() {
        String message = tfName.getText().trim() + " > " + taSend.getText().trim();
        byte[] buf = message.getBytes();
        DatagramPacket send = new DatagramPacket(buf, buf.length, Main.mcAddress, Main.mcPort);
        try {
            socket.send(send);
            taSend.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message = "";
        byte[] buf = new byte[10240];
        while (true) {
            DatagramPacket recv = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(recv);
                message = new String(recv.getData());
                taResponse.append(message + System.lineSeparator());
                Arrays.fill(buf, 0, message.length(), (byte) 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
