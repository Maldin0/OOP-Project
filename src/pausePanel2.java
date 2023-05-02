import javax.swing.*;
import java.awt.*;
public class pausePanel2{
    public int bb;
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
        });

        retry.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
        });

        exits.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
        });

        JLabel label = new JLabel("Pause");

        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        mainPanel.add(label);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(con);
        buttonPanel.add(retry);
        buttonPanel.add(exits);

        mainPanel.add(buttonPanel);


        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(true);
        dialog.setPreferredSize(new Dimension(420, 120));
        dialog.setContentPane(mainPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }
    public static void main(String[] args) {
        new pausePanel2();
    }
}
