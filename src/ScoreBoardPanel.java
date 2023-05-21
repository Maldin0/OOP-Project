import javax.swing.*;
import java.awt.*;
import java.io.*;
public class ScoreBoardPanel extends JPanel{
    private JPanel mainPanel;
    private JButton backBtn;
    private JLabel easyScore, normalScore, hardScore;
    private ScoreIO scoreIO;
    private ScoreTime scoreTime;

    public ScoreBoardPanel(MyFrame frame) {
        mainPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Background
            Image bgImage = new ImageIcon("image/scoreboardstuff.png").getImage();
            g.drawImage(bgImage, 0, 0, null);
            }
        };
        mainPanel.setLayout(null);

        backBtn = new JButton();
        backBtn.setIcon(new ImageIcon("image/Back button.png"));
        backBtn.setBounds(35, 35, 50, 50);
        backBtn.addActionListener(e -> {
            if (e.getSource().equals(backBtn)) {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.add(frame.getMenuPanel());
                frame.repaint();
                frame.pack();
            }
        });
        mainPanel.add(backBtn);

        Font font = new Font("Tahoma", Font.BOLD, 30);
        easyScore = new JLabel("", JLabel.LEFT);
        easyScore.setBounds(230, 140, 350, 40);
        easyScore.setForeground(new Color(255,236,138,255));
        easyScore.setBackground(new Color(63,63,116,255));
        easyScore.setOpaque(true);
        easyScore.setFont(font);
        mainPanel.add(easyScore);

        normalScore = new JLabel("", JLabel.LEFT);
        normalScore.setBounds(230, 320, 350, 40);
        normalScore.setForeground(new Color(255,236,138,255));
        normalScore.setBackground(new Color(63,63,116,255));
        normalScore.setOpaque(true);
        normalScore.setFont(font);
        mainPanel.add(normalScore);

        hardScore = new JLabel("", JLabel.LEFT);
        hardScore.setBounds(230, 505, 350, 40);
        hardScore.setForeground(new Color(255,236,138,255));
        hardScore.setBackground(new Color(63,63,116,255));
        hardScore.setOpaque(true);
        hardScore.setFont(font);
        mainPanel.add(hardScore);
        ImageIcon icon = new ImageIcon("image/Slimeconnector_icon.png");

        scoreIO = new ScoreIO();
        scoreTime = new ScoreTime();
        scoreIO.loadData();
        getEasyScore().setText(scoreTime.getEasyTime());
        getNormalScore().setText(scoreTime.getNormalTime());
        getHardScore().setText(scoreTime.getHardTime());

        this.add(mainPanel);

    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
    public JLabel getEasyScore() {
        return easyScore;
    }

    public void setEasyScore(String score) {
        easyScore.setText(score);
    }

    public JLabel getNormalScore() {
        return normalScore;
    }

    public void setNormalScore(JLabel normalScore) {
        this.normalScore = normalScore;
    }

    public JLabel getHardScore() {
        return hardScore;
    }

    public void setHardScore(JLabel hardScore) {
        this.hardScore = hardScore;
    }
}
