/**
 * @author Maldin0
 * @created 3/26/2023 - 5:25 PM
 * @project OOP-Project
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GamePanel extends JPanel {
    public GamePanel(int rows, int cols) {
        setPreferredSize(new Dimension(800, 600));
        setSize(new Dimension(800, 600));

        int windowWidth = this.getWidth();
        int windowHeight = this.getHeight();
//        System.out.println(windowWidth);
//        System.out.println(windowHeight);

        // Calculate card size based on the frame size and number of rows and columns
        int cardSize = (windowHeight/rows)-1;
//        System.out.println(cardSize);

        List<Color> uniqueColors = Arrays.asList(
                Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.CYAN,
                Color.MAGENTA, Color.ORANGE, Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY,
                // Additional colors
                new Color(255, 153, 153), new Color(255, 204, 153), new Color(255, 255, 153),
                new Color(204, 255, 153), new Color(153, 255, 153), new Color(153, 255, 204),
                new Color(153, 255, 255), new Color(153, 204, 255), new Color(153, 153, 255),
                new Color(204, 153, 255), new Color(255, 153, 255), new Color(255, 153, 204),
                new Color(255, 102, 102), new Color(255, 178, 102), new Color(255, 255, 102),
                new Color(178, 255, 102), new Color(102, 255, 102), new Color(102, 255, 178),
                new Color(102, 255, 255), new Color(102, 178, 255), new Color(102, 102, 255),
                new Color(178, 102, 255)
        );

        List<Color> colorPairs = createColorPairs(uniqueColors, rows * cols / 2);
        Collections.shuffle(colorPairs);

        GameBoard gameBoard = new GameBoard(rows, cols, cardSize, colorPairs);
//        System.out.println(colorPairs.size());

        add(gameBoard);
    }

    private List<Color> createColorPairs(List<Color> uniqueColors, int pairCount) {
        List<Color> colorPairs = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < pairCount; i++) {
            colorPairs.add(uniqueColors.get(index));
            colorPairs.add(uniqueColors.get(index));

            index++;
            if (index >= uniqueColors.size()) {
                index = 0;
            }
        }

        return colorPairs;
    }

}

