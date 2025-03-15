package manager.main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container base = frame.getContentPane();
        base.setLayout(new FlowLayout());
        JButton button1 = new JButton("Click Me");
        JButton button2 = new JButton("No, Click Me");
        base.add(button1);
        base.add(button2);


        frame.setVisible(true);
    }
}