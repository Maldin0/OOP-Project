import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MyFrame extends JFrame implements ActionListener{
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, pauseButton;
    private JLabel label;
    private JPanel menuPanel;
    private boolean soundOn = true;
    private MusicPlayer p;
    public MyFrame() {
        p = new MusicPlayer();
        p.play("sound/Slimeconnector Music.wav");
        this.getContentPane().setPreferredSize(new Dimension(800, 600));

        // Menu Panel
        menuPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Background
                Image bgImage = new ImageIcon("image/BG01.png").getImage();
                g.drawImage(bgImage, 0, 0, null);

                Image slimeFront = new ImageIcon("image/Slime front.png").getImage();
                g.drawImage(slimeFront, 225, 80, 600, 500, null);
            }
        };
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

        // Insert Icon Image
        ImageIcon icon2 = new ImageIcon("image/Slimeconnector_icon.png");
        this.setIconImage(icon2.getImage().getScaledInstance(5000, 5000, java.awt.Image.SCALE_SMOOTH));
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
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn6.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // if Click Start Button goes to GamePanel

        pauseButton = new JButton(new ImageIcon("image/Pause button.png"));
        pauseButton.setBounds(10, 10, 50, 50);
        pauseButton.addActionListener(ee -> {
            if (ee.getSource() == pauseButton) {
                pausePanel2 pp = new pausePanel2();
                if (pp.bb == 1) {

                }
            }
        });

        if (e.getSource().equals(btn1)) {
            ChoosePanel c = new ChoosePanel();
            this.remove(menuPanel);
            this.revalidate();
            this.add(pauseButton);

            if (c.difficulty == 0) {
                this.add(new GamePanel(4, 4));
            } else if (c.difficulty == 1) {
                this.add(new GamePanel(6, 6));
            } else if (c.difficulty == 2) {
                this.add(new GamePanel(8, 8));
            }

            this.repaint();
            this.pack();
        }
        //Credit Button
        if (e.getSource().equals((btn3))) {
            new CreditPanel();
        }
        // if Click Exit Button Exit game or Close JFrame
        if (e.getSource().equals(btn4)) {
            System.exit(0);
        }
        if (e.getSource().equals(btn6)) {
            if (soundOn) {
                ImageIcon button6_2 = new ImageIcon("image/Sound off button.png");
                btn6.setIcon(button6_2);
                soundOn = false;
                p.mute();

            } else {
                ImageIcon button6 = new ImageIcon("image/Sound button.png");
                btn6.setIcon(button6);
                soundOn = true;
                p.unmute();
            }
        }
    }
    public static void main(String[] args) {
        new MyFrame();
    }

    public JPanel menuPanel() {
        return menuPanel;
    }
}
