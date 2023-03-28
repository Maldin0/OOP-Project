import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
public class MyFrame extends JFrame implements ActionListener{
    JButton btn1, btn2, btn3, btn4, btn5, btn6;
    JLabel label;
    MyFrame() {
        // Set All Buttons

            // Start Button;
        ImageIcon button1 = new ImageIcon(getClass().getResource("img/Start_button.png"));
        btn1 = new JButton(button1);

            // ScoreBoard;
        ImageIcon button2 = new ImageIcon(getClass().getResource("img/Scoreboard_button.png"));
        btn2 = new JButton(button2);

            // Credit;
        btn3 = new JButton("Credit");

            // Exit;
        btn4 = new JButton("Exit");

            // How to Play;
        btn5 = new JButton("?");

            // Sound Setting;
        btn6 = new JButton("<))");


        // Set No Focus to Buttons
        btn1.setFocusPainted(false);
        btn2.setFocusPainted(false);
        btn3.setFocusPainted(false);
        btn4.setFocusPainted(false);
        btn5.setFocusPainted(false);
        btn6.setFocusPainted(false);

        // Positioning Buttons
        btn1.setBounds(100, 300, 110, 40);
        btn2.setBounds(100, 350, 110, 40);
        btn3.setBounds(100, 400, 110, 40);
        btn4.setBounds(100, 450, 110, 40);
        btn5.setBounds(10, 15, 50, 50);
        btn6.setBounds(80, 15, 50, 50);

        // Insert Image
        label = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("img/image3.png"));
        // Resize Image
//        Image img = icon.getImage().getScaledInstance(494, 258, Image.SCALE_SMOOTH);
        label.setIcon(icon);
        label.setBounds(0, 50, 500, 258);

        // Insert Icon Image
        ImageIcon icon2 = new ImageIcon(getClass().getResource("img/image.png"));
        this.setIconImage(icon2.getImage());

        // JFrame
        this.setTitle("Slime Connector");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false);
        this.setSize(800, 600); // size frame
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        // Add Button
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);
        this.add(btn5);
        this.add(btn6);
        this.add(label);

        // Click Action
        btn1.addActionListener(this);
        btn4.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // if Click Start Button goes to GameFrame
        if (e.getSource() == btn1) {
            GameFrame gameFrame = new GameFrame();
            gameFrame.setVisible(true);
            this.dispose(); // close the current frame
        }
        if (e.getSource() == btn4) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
