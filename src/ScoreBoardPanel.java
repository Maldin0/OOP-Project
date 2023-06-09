import javax.swing.*;
import java.awt.*;

public class ScoreBoardPanel extends JPanel {
    private final JPanel mainPanel;
    private final JButton backBtn;
    private final JLabel easyScore;
    private JLabel normalScore;
    private JLabel hardScore;

    public ScoreBoardPanel(MyFrame frame) {
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Background
                Image bgImage = new ImageIcon(getClass().getResource("/image/scoreboardstuff.png")).getImage();
                g.drawImage(bgImage, 0, 0, null);
            }
        };

        mainPanel.setLayout(null);

        backBtn = new JButton();
        backBtn.setIcon(new ImageIcon(getClass().getResource("/image/Back button.png")));
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
        easyScore.setForeground(new Color(255, 236, 138, 255));
        easyScore.setBackground(new Color(63, 63, 116, 255));
        easyScore.setOpaque(true);
        easyScore.setFont(font);
        mainPanel.add(easyScore);

        normalScore = new JLabel("", JLabel.LEFT);
        normalScore.setBounds(230, 320, 350, 40);
        normalScore.setForeground(new Color(255, 236, 138, 255));
        normalScore.setBackground(new Color(63, 63, 116, 255));
        normalScore.setOpaque(true);
        normalScore.setFont(font);
        mainPanel.add(normalScore);

        hardScore = new JLabel("", JLabel.LEFT);
        hardScore.setBounds(230, 505, 350, 40);
        hardScore.setForeground(new Color(255, 236, 138, 255));
        hardScore.setBackground(new Color(63, 63, 116, 255));
        hardScore.setOpaque(true);
        hardScore.setFont(font);
        mainPanel.add(hardScore);

        getEasyScore().setText(MyFrame.scoreTime.getEasyTime());
        getNormalScore().setText(MyFrame.scoreTime.getNormalTime());
        getHardScore().setText(MyFrame.scoreTime.getHardTime());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getEasyScore() {
        return easyScore;
    }

    public JLabel getNormalScore() {
        return normalScore;
    }

    public JLabel getHardScore() {
        return hardScore;
    }

}
