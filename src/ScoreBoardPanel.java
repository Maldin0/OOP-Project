import javax.swing.*;
import java.awt.*;
public class ScoreBoardPanel extends JFrame{
    private JPanel mainPanel;
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

        this.setIconImage(new ImageIcon("image/Slimeconnector_icon.png").getImage());
        this.setTitle("Scoreboard");
        this.getContentPane().setPreferredSize(new Dimension(800, 600));
        this.add(mainPanel);
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
