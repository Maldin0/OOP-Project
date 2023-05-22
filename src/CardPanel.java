/**
 * @author Maldin0
 * @created 3/26/2023 - 4:46 PM
 * @project OOP-Project
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CardPanel extends JPanel {
    private final BufferedImage hiddenImage;
    ImageCard card;

    public CardPanel(ImageCard card, int cardSize, BufferedImage hiddenImage) {
        this.card = card;
        this.hiddenImage = hiddenImage;
        setPreferredSize(new Dimension(cardSize, cardSize));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage displayImage;
        if (card.isRevealed() || card.isMatched()) {
            displayImage = card.getImage();
        } else {
            displayImage = hiddenImage;
        }
        int margin = 2;
        g.drawImage(displayImage, margin, margin, getWidth() - 2 * margin, getHeight() - 2 * margin, this);
    }
}
