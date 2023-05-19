/**
 * @author Maldin0
 * @created 3/26/2023 - 5:01 PM
 * @project OOP-Project
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class GameBoard extends JPanel implements CardListener {
    private int rows;
    private int cols;
    private List<ImageCard> cards;
    private List<CardPanel> selectedCards = new ArrayList<>();
    private List<CardPanel> cardPanels = new ArrayList<>();
    private boolean canInteract = true;
    private BufferedImage hiddenImage;
    private static int count;

    public GameBoard(int rows, int cols, int cardSize, List<BufferedImage> images) {
        this.rows = rows;
        this.cols = cols;
        this.cards = generateCards(images);
        setOpaque(false);
//        setBackground(Color.RED);

        try {
            URL hiddenImageUrl = getClass().getResource("Slime/cardback.png");
            BufferedImage originalHiddenImage = ImageIO.read(hiddenImageUrl);
            hiddenImage = new BufferedImage(cardSize, cardSize, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = hiddenImage.createGraphics();
            g.drawImage(originalHiddenImage, 0, 0, cardSize, cardSize, null);
            g.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new GridLayout(rows, cols, 0, 0));

        for (ImageCard card : cards) {
            CardPanel cardPanel = new CardPanel(card, cardSize, hiddenImage);

            cardPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (canInteract) {
                        onCardFlip(cardPanel);
                    }
                }
            });

            add(cardPanel);
            cardPanels.add(cardPanel);
        }

        revealAllCards();
    }
    public GameBoard() {
        resetCount();
    }


    private List<ImageCard> generateCards(List<BufferedImage> images) {
        List<ImageCard> cards = new ArrayList<>();
        for (BufferedImage image : images) {
            cards.add(new ImageCard(image));
//            cards.add(new ColorCard(color));
        }
        Collections.shuffle(cards);
        return cards;
    }

    @Override
    public void onCardFlip(CardPanel cardPanel) {
        if (cardPanel.card.isRevealed() || cardPanel.card.isMatched()) {
            // Ignore the click event if the card is already revealed or matched
            return;
        }

        if (selectedCards.contains(cardPanel)) {
            // Do not process the same card if it's already in the selectedCards list
            return;
        }

        cardPanel.card.setRevealed(true);
        cardPanel.repaint();
        selectedCards.add(cardPanel);

        if (selectedCards.size() == 2) {
            SwingUtilities.invokeLater(this::checkForMatch);
        }
    }



    private void checkForMatch() {
        canInteract = false;

        CardPanel card1 = selectedCards.get(0);
        CardPanel card2 = selectedCards.get(1);

        // Add a delay before checking for a match and updating cards' state
        Timer timer = new Timer(1000, e -> {
            if (card1.card.isMatch(card2.card)) {
                onMatchFound(card1, card2);
            } else {
                card1.card.setRevealed(false);
                card2.card.setRevealed(false);
            }

            card1.repaint();
            card2.repaint();
            selectedCards.clear();
            canInteract = true;
        });

        timer.setRepeats(false);
        timer.start();
    }


    @Override
    public void onMatchFound(CardPanel card1, CardPanel card2) {
        card1.card.setMatched(true);
        card2.card.setMatched(true);
        count++;
        if ((rows == 4 && count == 8) || (rows == 6 && count == 16) || (rows == 8 && count == 32)) {
            new WinScreenPanel();
            resetCount();
        }
    }

    private void revealAllCards() {
        cardPanels.forEach(cardPanel -> {
            cardPanel.card.setRevealed(true);
            cardPanel.repaint();
        });

        Timer timer = new Timer(1000, e -> {
            cardPanels.forEach(cardPanel -> {
                cardPanel.card.setRevealed(false);
                cardPanel.repaint();
            });
        });

        timer.setRepeats(false);
        timer.start();
    }

    public void resetCount() {
        count = 0;
    }
}
