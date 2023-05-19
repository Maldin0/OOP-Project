import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinScreenPanel extends JFrame {
    private JPanel mainPanel, buttonPanel;
    private JButton exits;
    private JLabel winSign;

    public WinScreenPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        winSign = new JLabel();
        winSign.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(winSign, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        exits = new JButton(new ImageIcon("image/Exit to menu button.png"));
        exits.setPreferredSize(new Dimension(192, 64));
        exits.addActionListener(e -> {
            for (java.awt.Window window : java.awt.Window.getWindows()) {
                if (window instanceof JFrame) {
                    window.dispose();
                }
            }
        });
        buttonPanel.add(exits);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        ImageIcon imageIcon = new ImageIcon("image/WinScreen.png");

        this.add(mainPanel);

        this.setTitle("Image Display");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Create a separate thread and start it
        Thread t = new Thread(new WinScreenAnimation(this, imageIcon));
        t.start();
    }

    public static void main(String[] args) {
        new WinScreenPanel();
    }

    public JLabel getWinSign() {
        return winSign;
    }

    public void setWinSign(JLabel winSign) {
        this.winSign = winSign;
    }
}
