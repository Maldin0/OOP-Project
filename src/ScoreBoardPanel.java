import javax.swing.*;

public class ScoreBoardPanel extends JPanel {
    private JFrame f;
    public ScoreBoardPanel() {
        f = new JFrame("ScoreBoard");
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new ScoreBoardPanel();
    }
}
