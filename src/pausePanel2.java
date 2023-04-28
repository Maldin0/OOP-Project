import javax.swing.*;
import java.awt.*;
public class pausePanel2{
    public int difficulty;
    private JButton con, retry, exits;
    public pausePanel2() {

        con = new JButton("Continue");
        retry = new JButton("Retry");
        exits = new JButton("Exit to Menu");

        con.setPreferredSize(new Dimension(128, 64));
        retry.setPreferredSize(new Dimension(128, 64));
        exits.setPreferredSize(new Dimension(128, 64));

        con.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            difficulty = 0;
        });

        retry.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            difficulty = 1;
        });

        exits.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            difficulty = 2;
        });

        JLabel label = new JLabel("Pause");

        JPanel mainPanel = new JPanel(new GridLayout(0, 4));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        mainPanel.add(label);

        buttonPanel.add(con);
        buttonPanel.add(retry);
        buttonPanel.add(exits);

        mainPanel.add(buttonPanel);



        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(true);
        dialog.setPreferredSize(new Dimension(400, 80));
        dialog.setContentPane(mainPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }
    public static void main(String[] args) {
        new pausePanel2();
    }
}
