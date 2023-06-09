import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends JFrame {
    public static ScoreTime scoreTime;
    private final JButton startBtn;
    private final JButton scoreBtn;
    private final JButton creditBtn;
    private final JButton exitBtn;
    private final JButton helpBtn;
    private final JButton soundBtn;
    private final JPanel menuPanel;
    private final MusicPlayer p;
    private boolean soundOn = true;
    private int check;

    public MyFrame() {
        MyFrameEvent event = new MyFrameEvent(this);
        p = new MusicPlayer();
        p.play("/sound/Slimeconnector Music.wav");
        this.getContentPane().setPreferredSize(new Dimension(800, 600));

        // Menu Panel
        menuPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Background
                Image bgImage = new ImageIcon(getClass().getResource("/image/BG01.png")).getImage();
                g.drawImage(bgImage, 0, 0, null);
                Image slimeFront = new ImageIcon(getClass().getResource("/image/Slime front.png")).getImage();
                g.drawImage(slimeFront, 225, 80, 600, 500, null);
            }
        };
        menuPanel.setLayout(null);

        // Start Button;
        ImageIcon button1 = new ImageIcon(getClass().getResource("/image/Start button.png"));
        startBtn = new JButton();
        startBtn.setIcon(button1);
        startBtn.setBounds(100, 290, 128, 64);
        startBtn.addActionListener(event);
        menuPanel.add(startBtn);

        // ScoreBoard;
        ImageIcon button2 = new ImageIcon(getClass().getResource("/image/Scoreboard button.png"));
        scoreBtn = new JButton();
        scoreBtn.setIcon(button2);
        scoreBtn.setBounds(100, 365, 128, 64);
        scoreBtn.addActionListener(event);
        menuPanel.add(scoreBtn);

        // Credit;
        ImageIcon button3 = new ImageIcon(getClass().getResource("/image/Credit button.png"));
        creditBtn = new JButton();
        creditBtn.setIcon(button3);
        creditBtn.setBounds(100, 440, 128, 64);
        creditBtn.addActionListener(event);
        menuPanel.add(creditBtn);

        // Exit;
        ImageIcon button4 = new ImageIcon(getClass().getResource("/image/Exit button.png"));
        exitBtn = new JButton();
        exitBtn.setIcon(button4);
        exitBtn.setBounds(100, 515, 128, 64);
        exitBtn.addActionListener(event);
        menuPanel.add(exitBtn);

        // How to Play;
        ImageIcon button5 = new ImageIcon(getClass().getResource("/image/Help button.png"));
        helpBtn = new JButton();
        helpBtn.setIcon(button5);
        helpBtn.setBounds(10, 15, 50, 50);
        helpBtn.addActionListener(event);
        menuPanel.add(helpBtn);

        // Sound Setting;
        soundBtn = new JButton(new ImageIcon(getClass().getResource("/image/Sound button.png")));
        soundBtn.setBounds(80, 15, 50, 50);
        soundBtn.addActionListener(event);
        menuPanel.add(soundBtn);

        //  Logo
        JLabel logoName = new JLabel(new ImageIcon(getClass().getResource("/image/Finished logo.png")));
        logoName.setBounds(40, 110, 250, 150);
        menuPanel.add(logoName);

        // Insert Icon Image
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/image/Slimeconnector_icon.png"));
        this.setIconImage(icon2.getImage().getScaledInstance(5000, 5000, java.awt.Image.SCALE_SMOOTH));
        // Add menuPanel in JFrame
        this.add(menuPanel);
        // Score
        scoreTime = new ScoreTime();
        ScoreIO scoreIO = new ScoreIO();
        scoreIO.loadData();

        // JFrame
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                scoreIO.saveData();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        this.setTitle("Slime Connector");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyFrame::new);
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public JButton getStartBtn() {
        return startBtn;
    }

    public JButton getScoreBtn() {
        return scoreBtn;
    }

    public JButton getCreditBtn() {
        return creditBtn;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }

    public JButton getHelpBtn() {
        return helpBtn;
    }

    public JButton getSoundBtn() {
        return soundBtn;
    }

    public boolean isSoundOn() {
        return soundOn;
    }

    public void setSoundOn(boolean soundOn) {
        this.soundOn = soundOn;
    }

    public MusicPlayer getP() {
        return p;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
