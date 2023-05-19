import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public Main() {
        setTitle("Slime Connector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(800, 600));
        setResizable(true);
        setLayout(new BorderLayout());
        JPanel fillPanel = new JPanel();
        GamePanel gamePanel = new GamePanel(8);
        add(fillPanel, BorderLayout.CENTER);
        add(gamePanel, BorderLayout.SOUTH);

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
