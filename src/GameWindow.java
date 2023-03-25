import javax.swing.*;

/**
 * @author Maldin0
 * @created 3/25/2023 - 8:46 PM
 * @project OOP-Project
 */
public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("Slime Connector");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}
