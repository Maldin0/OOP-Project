/**
 * @author Maldin0
 * @created 3/26/2023 - 5:25 PM
 * @project OOP-Project
 */
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GamePanel extends JPanel{
    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));

        List<Color> colors = Arrays.asList(
                Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.CYAN,
                Color.MAGENTA, Color.ORANGE, Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY
        );

        GameBoard gameBoard = new GameBoard(4, 5, colors);
        add(gameBoard);
    }
}
