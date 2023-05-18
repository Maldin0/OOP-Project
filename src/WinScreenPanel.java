import javax.swing.*;

public class WinScreenPanel extends JFrame {
    public JLabel winSign;

    public WinScreenPanel() {
        winSign = new JLabel();
        winSign.setHorizontalAlignment(JLabel.CENTER);
        this.add(winSign);

        ImageIcon image = new ImageIcon("image/WinScreen.png");

        // Create a separate thread and start it
        Thread t = new Thread(new WinScreenAnimation(this, image));
        t.start();

        this.setTitle("Image Display");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new WinScreenPanel();
    }
}
