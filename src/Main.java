import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public Main() {
        setTitle("Slime Connector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(800, 600));
        setResizable(true);

        GamePanel gamePanel = new GamePanel(4,4);
        add(gamePanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            new Main();
        });
    }
}
