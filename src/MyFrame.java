import javax.swing.*;
import java.awt.event.*;
public class MyFrame extends JFrame implements ActionListener{
    private JButton btn1, btn2, btn3, btn4, btn5, btn6;
    JLabel label;
    JPanel menuPanel;
    MyFrame() {

//        ImageIcon i = new ImageIcon("image/Start_button.png");
//        JButton b = new JButton();
//        p = new JPanel();
//        b.setIcon(i);
//        p.add(b);
//        this.add(p);

    // Menu Panel
    menuPanel = new JPanel();
    menuPanel.setLayout(null);

    // Logo
    label = new JLabel(new ImageIcon("image/image3.png"));
    label.setBounds(0, 50, 500, 258);
    menuPanel.add(label);

    // Start Button;
    ImageIcon button1 = new ImageIcon("image/Start_button.png");
    btn1 = new JButton();
    btn1.setIcon(button1);
    btn1.setBounds(100, 300, 128, 64);
    menuPanel.add(btn1);

    // ScoreBoard;
    ImageIcon button2 = new ImageIcon("image/Scoreboard_button.png");
    btn2 = new JButton();
    btn2.setIcon(button2);
    btn2.setBounds(100, 370, 128, 64);
    menuPanel.add(btn2);

    // Credit;
    btn3 = new JButton("Credit");
//    btn3.setIcon();
    btn3.setBounds(100, 440, 110, 40);
    menuPanel.add(btn3);

    // Exit;
    btn4 = new JButton("Exit");
//    btn4.setIcon();
    btn4.setBounds(100, 490, 110, 40);
    menuPanel.add(btn4);

    // How to Play;
    btn5 = new JButton("?");
//    btn5.setIcon();
    btn5.setBounds(10, 15, 50, 50);
    menuPanel.add(btn5);

    // Sound Setting;
    btn6 = new JButton("<))");
//    btn6.setIcon();
    btn6.setBounds(80, 15, 50, 50);
    menuPanel.add(btn6);

    // Insert Icon Image
    ImageIcon icon2 = new ImageIcon("image/image.png");
    this.setIconImage(icon2.getImage());

    // Add menuPanel in JFrame
    this.add(menuPanel);

    // JFrame
    this.setTitle("Slime Connector");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
    this.setResizable(false);
    this.setSize(800, 600); // size frame
    this.setVisible(true);
    this.setLayout(null);
    this.setLocationRelativeTo(null);

    btn1.addActionListener(this);
    btn4.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // if Click Start Button goes to GamePanel
        if (e.getSource() == btn1) {
            GamePanel gameFrame = new GamePanel();
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
