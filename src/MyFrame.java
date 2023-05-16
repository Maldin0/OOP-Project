import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    private JButton startBtn, scoreBtn, creditBtn, exitBtn, helpBtn, soundBtn, pauseBtn;
    private JLabel logoName;
    private JPanel menuPanel;
    private boolean soundOn = true;
    private MusicPlayer p;
    private int check;
    public MyFrame() {
        MyFrameEvent event = new MyFrameEvent(this);
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
        startBtn = new JButton();
        startBtn.setIcon(button1);
        startBtn.setBounds(100, 290, 128, 64);
        startBtn.addActionListener(event);
        menuPanel.add(startBtn);

        // ScoreBoard;
        ImageIcon button2 = new ImageIcon("image/Scoreboard button.png");
        scoreBtn = new JButton();
        scoreBtn.setIcon(button2);
        scoreBtn.setBounds(100, 365, 128, 64);
        scoreBtn.addActionListener(event);
        menuPanel.add(scoreBtn);

        // Credit;
        ImageIcon button3 = new ImageIcon("image/Credit button.png");
        creditBtn = new JButton();
        creditBtn.setIcon(button3);
        creditBtn.setBounds(100, 440, 128, 64);
        creditBtn.addActionListener(event);
        menuPanel.add(creditBtn);

        // Exit;
        ImageIcon button4 = new ImageIcon("image/Exit button.png");
        exitBtn = new JButton();
        exitBtn.setIcon(button4);
        exitBtn.setBounds(100, 515, 128, 64);
        exitBtn.addActionListener(event);
        menuPanel.add(exitBtn);

        // How to Play;
        ImageIcon button5 = new ImageIcon("image/Help button.png");
        helpBtn = new JButton();
        helpBtn.setIcon(button5);
        helpBtn.setBounds(10, 15, 50, 50);
        helpBtn.addActionListener(event);
        menuPanel.add(helpBtn);

        // Sound Setting;
        soundBtn = new JButton(new ImageIcon("image/Sound button.png"));
        soundBtn.setBounds(80, 15, 50, 50);
        soundBtn.addActionListener(event);
        menuPanel.add(soundBtn);

        //  Logo
        logoName = new JLabel(new ImageIcon("image/Finished logo.png"));
        logoName.setBounds(40, 110, 250, 150);
        menuPanel.add(logoName);

        // Pause
        pauseBtn = new JButton(new ImageIcon("image/Pause button.png"));
        pauseBtn.setBounds(10, 10, 50, 50);

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

        pauseBtn.addActionListener(ee -> {
            new PausePanel(this);
        });
    }

    public static void main(String[] args) {
        new MyFrame();
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public JButton getStartBtn() {
        return startBtn;
    }

    public void setStartBtn(JButton startBtn) {
        this.startBtn = startBtn;
    }

    public JButton getScoreBtn() {
        return scoreBtn;
    }

    public void setScoreBtn(JButton scoreBtn) {
        this.scoreBtn = scoreBtn;
    }

    public JButton getCreditBtn() {
        return creditBtn;
    }

    public void setCreditBtn(JButton creditBtn) {
        this.creditBtn = creditBtn;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }

    public void setExitBtn(JButton exitBtn) {
        this.exitBtn = exitBtn;
    }

    public JButton getHelpBtn() {
        return helpBtn;
    }

    public void setHelpBtn(JButton helpBtn) {
        this.helpBtn = helpBtn;
    }

    public JButton getSoundBtn() {
        return soundBtn;
    }

    public void setSoundBtn(JButton soundBtn) {
        this.soundBtn = soundBtn;
    }

    public JButton getPauseBtn() {
        return pauseBtn;
    }

    public void setPauseBtn(JButton pauseBtn) {
        this.pauseBtn = pauseBtn;
    }

    public JLabel getLogoName() {
        return logoName;
    }

    public void setLogoName(JLabel logoName) {
        this.logoName = logoName;
    }

    public void setMenuPanel(JPanel menuPanel) {
        this.menuPanel = menuPanel;
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

    public void setP(MusicPlayer p) {
        this.p = p;
    }

    public int getCheck() {
        return check;
    }
    public void setCheck(int check) {
        this.check = check;
    }
}
