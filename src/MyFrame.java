import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MyFrame extends JFrame implements ActionListener{
    private JButton btn1, btn2, btn3, btn4, btn5, btn6;
    private JLabel label, label1;
    private JPanel menuPanel;
    private boolean soundOn = true;
    public MyFrame() {

    this.getContentPane().setPreferredSize(new Dimension(800, 600));

    // Menu Panel
    menuPanel = new JPanel();
    menuPanel.setLayout(null);

    // Start Button;
    ImageIcon button1 = new ImageIcon("image/Start button.png");
    btn1 = new JButton();
    btn1.setIcon(button1);
    btn1.setBounds(100, 290, 128, 64);
    menuPanel.add(btn1);

    // ScoreBoard;
    ImageIcon button2 = new ImageIcon("image/Scoreboard button.png");
    btn2 = new JButton();
    btn2.setIcon(button2);
    btn2.setBounds(100, 365, 128, 64);
    menuPanel.add(btn2);

    // Credit;
    ImageIcon button3 = new ImageIcon("image/Credit button.png");
    btn3 = new JButton();
    btn3.setIcon(button3);
    btn3.setBounds(100, 440, 128, 64);
    menuPanel.add(btn3);

    // Exit;
    ImageIcon button4 = new ImageIcon("image/Exit button.png");
    btn4 = new JButton();
    btn4.setIcon(button4);
    btn4.setBounds(100, 515, 128, 64);
    menuPanel.add(btn4);

    // How to Play;
    ImageIcon button5 = new ImageIcon("image/Help button.png");
    btn5 = new JButton();
    btn5.setIcon(button5);
    btn5.setBounds(10, 15, 50, 50);
    menuPanel.add(btn5);

    // Sound Setting;
    btn6 = new JButton(new ImageIcon("image/Sound button.png"));
    btn6.setBounds(80, 15, 50, 50);
    menuPanel.add(btn6);

    //  Logo
    label = new JLabel(new ImageIcon("image/Finished logo.png"));
    label.setBounds(40, 110, 250, 150);
    menuPanel.add(label);

    // Background
    label1 = new JLabel(new ImageIcon("image/BG01.png"));
//    label1.setSize(new Dimension(800, 600));
    label1.setBounds(0, 0, 800, 600);
    menuPanel.add(label1);

    // Insert Icon Image
    ImageIcon icon2 = new ImageIcon("image/image.png");
    this.setIconImage(icon2.getImage());
    // Add menuPanel in JFrame
    this.add(menuPanel);

    // JFrame
    this.setTitle("Slime Connector");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
    this.setResizable(false);
//    this.setSize(800, 600);
    this.pack();
    this.setVisible(true);
    this.setLayout(null);
    this.setLocationRelativeTo(null);

    btn1.addActionListener(this);
    btn4.addActionListener(this);
    btn6.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // if Click Start Button goes to GamePanel
        if (e.getSource() == btn1) {
            // if Click Start Button Change to GamePanel
            this.remove(menuPanel);
            this.add(new GamePanel());
            this.revalidate();
            this.repaint();
            this.pack();
        }

        // if Click Exit Button Exit game or Close JFrame
        if (e.getSource() == btn4) {
            System.exit(0);
        }
        if (e.getSource() == btn6) {
            if (soundOn) {
                ImageIcon button6_2 = new ImageIcon("image/Sound off button.png");
                btn6.setIcon(button6_2);
                soundOn = false;
            } else {
                ImageIcon button6 = new ImageIcon("image/Sound button.png");
                btn6.setIcon(button6);
                soundOn = true;
            }
        }
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
