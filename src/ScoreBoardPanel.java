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

        name1 = new JLabel("A");
        name1.setBounds(150, 90, 350, 50);
        name1.setForeground(Color.ORANGE);
        name1.setBackground(Color.WHITE);
        name1.setOpaque(true);
        name1.setFont(font);
        mainPanel.add(name1);

        name2 = new JLabel("B");
        name2.setBounds(150, 150, 350, 50);
        name2.setForeground(Color.ORANGE);
        name2.setBackground(Color.WHITE);
        name2.setOpaque(true);
        name2.setFont(font);
        mainPanel.add(name2);

        name3 = new JLabel("C");
        name3.setBounds(150, 210, 350, 50);
        name3.setForeground(Color.ORANGE);
        name3.setBackground(Color.WHITE);
        name3.setOpaque(true);
        name3.setFont(font);
        mainPanel.add(name3);

        name4 = new JLabel("D");
        name4.setBounds(150, 270, 350, 50);
        name4.setForeground(Color.ORANGE);
        name4.setBackground(Color.WHITE);
        name4.setOpaque(true);
        name4.setFont(font);
        mainPanel.add(name4);

        name5 = new JLabel("E");
        name5.setBounds(150, 330, 350, 50);
        name5.setForeground(Color.ORANGE);
        name5.setBackground(Color.WHITE);
        name5.setOpaque(true);
        name5.setFont(font);
        mainPanel.add(name5);

        name6 = new JLabel("F");
        name6.setBounds(150, 390, 350, 50);
        name6.setForeground(Color.ORANGE);
        name6.setBackground(Color.WHITE);
        name6.setOpaque(true);
        name6.setFont(font);
        mainPanel.add(name6);

        name7 = new JLabel("G");
        name7.setBounds(150, 450, 350, 50);
        name7.setForeground(Color.ORANGE);
        name7.setBackground(Color.WHITE);
        name7.setOpaque(true);
        name7.setFont(font);
        mainPanel.add(name7);

        name8 = new JLabel("H");
        name8.setBounds(150, 510, 350, 50);
        name8.setForeground(Color.ORANGE);
        name8.setBackground(Color.WHITE);
        name8.setOpaque(true);
        name8.setFont(font);
        mainPanel.add(name8);

        score1 = new JLabel("111111");
        score1.setBounds(590, 90, 150, 50);
        score1.setForeground(Color.ORANGE);
        score1.setBackground(Color.WHITE);
        score1.setOpaque(true);
        score1.setFont(font);
        mainPanel.add(score1);

        score2 = new JLabel("222222");
        score2.setBounds(590, 150, 150, 50);
        score2.setForeground(Color.ORANGE);
        score2.setBackground(Color.WHITE);
        score2.setOpaque(true);
        score2.setFont(font);
        mainPanel.add(score2);

        score3 = new JLabel("333333");
        score3.setBounds(590, 210, 150, 50);
        score3.setForeground(Color.ORANGE);
        score3.setBackground(Color.WHITE);
        score3.setOpaque(true);
        score3.setFont(font);
        mainPanel.add(score3);

        score4 = new JLabel("444444");
        score4.setBounds(590, 270, 150, 50);
        score4.setForeground(Color.ORANGE);
        score4.setBackground(Color.WHITE);
        score4.setOpaque(true);
        score4.setFont(font);
        mainPanel.add(score4);

        score5 = new JLabel("555555");
        score5.setBounds(590, 330, 150, 50);
        score5.setForeground(Color.ORANGE);
        score5.setBackground(Color.WHITE);
        score5.setOpaque(true);
        score5.setFont(font);
        mainPanel.add(score5);

        score6 = new JLabel("666666");
        score6.setBounds(590, 390, 150, 50);
        score6.setForeground(Color.ORANGE);
        score6.setBackground(Color.WHITE);
        score6.setOpaque(true);
        score6.setFont(font);
        mainPanel.add(score6);

        score7 = new JLabel("777777");
        score7.setBounds(590, 450, 150, 50);
        score7.setForeground(Color.ORANGE);
        score7.setBackground(Color.WHITE);
        score7.setOpaque(true);
        score7.setFont(font);
        mainPanel.add(score7);

        score8 = new JLabel("888888");
        score8.setBounds(590, 510, 150, 50);
        score8.setForeground(Color.ORANGE);
        score8.setBackground(Color.WHITE);
        score8.setOpaque(true);
        score8.setFont(font);
        mainPanel.add(score8);

        this.add(mainPanel);

        this.setIconImage(new ImageIcon("image/Slimeconnector_icon.png").getImage());
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
