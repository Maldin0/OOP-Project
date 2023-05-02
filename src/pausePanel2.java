import javax.swing.*;
import java.awt.*;
public class pausePanel2{
    public int bb;
    private JButton con, retry, exits;
    public pausePanel2() {

        con = new JButton(new ImageIcon("image/Continue button.png"));
        retry = new JButton(new ImageIcon("image/Restart button.png"));
        exits = new JButton(new ImageIcon("image/Exit to menu button.png"));

        con.setPreferredSize(new Dimension(128, 64));
        retry.setPreferredSize(new Dimension(128, 64));
        exits.setPreferredSize(new Dimension(192, 64));

        con.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
        });

        retry.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            bb = 1;
        });

        exits.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            bb = 2;
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
        dialog.setTitle("Pausssssse");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setUndecorated(false);
        dialog.setModal(true);
        dialog.setPreferredSize(new Dimension(500, 170));
        dialog.setContentPane(mainPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }
    public static void main(String[] args) {
        new pausePanel2();
    }
}
