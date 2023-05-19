import javax.swing.*;
import java.awt.*;
public class ScoreBoardPanel extends JFrame{
    private JPanel mainPanel;
    private JButton backBtn;
    private JLabel name1, name2, name3, name4, name5, name6, name7, name8;
    private JLabel score1, score2, score3, score4, score5, score6, score7, score8;
    public ScoreBoardPanel() {
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
                this.setVisible(false);
            }
        });
        mainPanel.add(backBtn);

        Font font = new Font("Tahoma", Font.BOLD, 30);

        ImageIcon icon = new ImageIcon("image/Slimeconnector_icon.png");
        this.setIconImage(icon.getImage().getScaledInstance(5000, 5000, java.awt.Image.SCALE_SMOOTH));

        this.add(mainPanel);
        this.setTitle("Scoreboard");
        this.getContentPane().setPreferredSize(new Dimension(800, 600));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        new ScoreBoardPanel();
    }
}
