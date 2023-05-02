import javax.swing.*;
import java.awt.*;
public class ChoosePanel{
    public int difficulty = -1;
    private JButton easy, normal, hard;
    public ChoosePanel() {

        easy = new JButton(new ImageIcon("image/Easy Button.png"));
        normal = new JButton(new ImageIcon("image/Normal Button.png"));
        hard = new JButton(new ImageIcon("image/Hard Button.png"));

        easy.setPreferredSize(new Dimension(66, 32));
        normal.setPreferredSize(new Dimension(66, 32));
        hard.setPreferredSize(new Dimension(66, 32));

        easy.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            difficulty = 0;
        });

        normal.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            difficulty = 1;
        });

        hard.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            difficulty = 2;
        });

        JLabel label = new JLabel("Choose the difficulty level:");

        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel(new FlowLayout());

        buttonPanel.add(easy);
        buttonPanel.add(normal);
        buttonPanel.add(hard);

        mainPanel.add(label);
        mainPanel.add(buttonPanel);

        JDialog dialog = new JDialog();
        dialog.setTitle("Difficulty");
        dialog.setUndecorated(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setPreferredSize(new Dimension(260, 120));
        dialog.setContentPane(mainPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }
    public static void main(String[] args) {
        ChoosePanel c = new ChoosePanel();
        System.out.println(c.difficulty);
    }
}
