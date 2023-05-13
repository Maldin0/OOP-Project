import javax.swing.*;
import java.awt.*;

public class ScoreBoardPanel {
    private JFrame frame;
    private JPanel mainPanel, leaderNumberPanel, nameAndScorePanel, namePanel, scorePanel;
    private JLabel nameTitle, scoreTitle, noTitle;
    public ScoreBoardPanel() {
        frame = new JFrame("ScoreBoard");
        mainPanel = new JPanel();
        leaderNumberPanel = new JPanel();
        namePanel = new JPanel();
        scorePanel = new JPanel();
        nameAndScorePanel = new JPanel();
        nameTitle = new JLabel("Name", JLabel.CENTER);
        scoreTitle = new JLabel("Score", JLabel.CENTER);
        noTitle = new JLabel("No.", JLabel.CENTER);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(leaderNumberPanel, BorderLayout.WEST);
        mainPanel.add(nameAndScorePanel, BorderLayout.CENTER);

        leaderNumberPanel.setLayout(new GridLayout(6, 1));
        leaderNumberPanel.add(noTitle);
        leaderNumberPanel.add(new JLabel("1", JLabel.CENTER));
        leaderNumberPanel.add(new JLabel("2", JLabel.CENTER));
        leaderNumberPanel.add(new JLabel("3", JLabel.CENTER));
        leaderNumberPanel.add(new JLabel("4", JLabel.CENTER));
        leaderNumberPanel.add(new JLabel("5", JLabel.CENTER));

        nameAndScorePanel.setLayout(new GridLayout(1, 2));
        nameAndScorePanel.add(namePanel);
        nameAndScorePanel.add(scorePanel);

        namePanel.setLayout(new GridLayout(6, 1));
        namePanel.add(nameTitle);

        scorePanel.setLayout(new GridLayout(6, 1));
        scorePanel.add(scoreTitle);

        frame.add(mainPanel);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new ScoreBoardPanel();
    }
}
