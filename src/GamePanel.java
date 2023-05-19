/**
 * @author Maldin0
 * @created 3/26/2023 - 5:25 PM
 * @project OOP-Project
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamePanel extends JPanel {
    public GamePanel(int rows) {
        setSize(800, 550);
        setOpaque(false);
//        setBackground(Color.BLUE);
//        this.setLayout(new BoxLayout());
        int windowWidth = this.getWidth();
        int windowHeight = this.getHeight();
//        System.out.println(windowWidth);
//        System.out.println(windowHeight);

        // Calculate card size based on the frame size and number of rows and columns
        int cardSize = (windowHeight/rows)-1;
//        System.out.println(cardSize);

//        List<Color> uniqueColors = Arrays.asList(
//                Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.CYAN,
//                Color.MAGENTA, Color.ORANGE, Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY,
//                // Additional colors
//                new Color(255, 153, 153), new Color(255, 204, 153), new Color(255, 255, 153),
//                new Color(204, 255, 153), new Color(153, 255, 153), new Color(153, 255, 204),
//                new Color(153, 255, 255), new Color(153, 204, 255), new Color(153, 153, 255),
//                new Color(204, 153, 255), new Color(255, 153, 255), new Color(255, 153, 204),
//                new Color(255, 102, 102), new Color(255, 178, 102), new Color(255, 255, 102),
//                new Color(178, 255, 102), new Color(102, 255, 102), new Color(102, 255, 178),
//                new Color(102, 255, 255), new Color(102, 178, 255), new Color(102, 102, 255),
//                new Color(178, 102, 255)
//        );

//        List<Color> colorPairs = createColorPairs(uniqueColors, rows * rows / 2);
//        Collections.shuffle(colorPairs);

        List<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            try {
                URL imageUrl = getClass().getResource("/Slime/Slime" + i + ".png");
                BufferedImage img = ImageIO.read(imageUrl);
                BufferedImage scaledImage = new BufferedImage(cardSize, cardSize, BufferedImage.TYPE_INT_ARGB);
                Graphics2D graphics2D = scaledImage.createGraphics();
                graphics2D.drawImage(img, 0, 0, cardSize, cardSize, null);
                graphics2D.dispose();
                images.add(scaledImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<BufferedImage> imagePairs = createImagePairs(images, rows * rows / 2);
        Collections.shuffle(imagePairs);

        GameBoard gameBoard = new GameBoard(rows, rows, cardSize, imagePairs);
//        System.out.println(colorPairs.size());

        add(gameBoard);
    }

    private List<BufferedImage> createImagePairs(List<BufferedImage> uniqueImages, int pairCount) {
        List<BufferedImage> imagePairs = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < pairCount; i++) {
            imagePairs.add(uniqueImages.get(index));
            imagePairs.add(uniqueImages.get(index));

            index++;
            if (index >= uniqueImages.size()) {
                index = 0;
            }
        }

        return imagePairs;
    }

}

