import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MyFrame extends JFrame{
    JButton btn1, btn2, btn3, btn4, btn5, btn6;
    JLabel label;
    MyFrame() {
        btn1 = new JButton("Start");
        btn2 = new JButton("Leaderboard");
        btn3 = new JButton("Credit");
        btn4 = new JButton("Exit");
        btn5 = new JButton("HTP");
        btn6 = new JButton("MOU");

        btn1.setFocusPainted(false);btn2.setFocusPainted(false);btn3.setFocusPainted(false);btn4.setFocusPainted(false);btn5.setFocusPainted(false);btn6.setFocusPainted(false);
        btn1.setBounds(100, 300, 110, 40);
        btn2.setBounds(100, 350, 110, 40);
        btn3.setBounds(100, 400, 110, 40);
        btn4.setBounds(100, 450, 110, 40);
        btn5.setBounds(10, 15, 80, 40);
        btn6.setBounds(100, 15, 80, 40);


        this.setTitle("Slime Connector");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false);
        this.setSize(800, 600); // size frame
        this.setVisible(true);
        this.setLayout(null);

        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);
        this.add(btn5);
        this.add(btn6);

        this.add(label);
    }
}
