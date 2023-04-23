/**
 * @author Maldin0
 * @created 3/26/2023 - 5:01 PM
 * @project OOP-Project
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class GameBoard extends JPanel implements CardListener {
    private int rows;
    private int cols;
    private List<ColorCard> cards;
    private List<CardPanel> selectedCards = new ArrayList<>();
    private List<CardPanel> cardPanels = new ArrayList<>();

    public GameBoard(int rows, int cols, int cardSize, List<Color> colors) {
        this.rows = rows;
        this.cols = cols;
        this.cards = generateCards(colors);
        setBackground(Color.GRAY);

        setLayout(new GridLayout(rows, cols, 0, 0));

//        List<ColorCard> cards = generateCards(colors);

        for (ColorCard card : cards) {
            CardPanel cardPanel = new CardPanel(card, cardSize);

            cardPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    onCardFlip(cardPanel);
                }
            });

            add(cardPanel);
            cardPanels.add(cardPanel);
        }

        revealAllCards();
    }


    private List<ColorCard> generateCards(List<Color> colors) {
        List<ColorCard> cards = new ArrayList<>();
        for (Color color : colors) {
            cards.add(new ColorCard(color));
//            cards.add(new ColorCard(color));
        }
        Collections.shuffle(cards);
        return cards;
    }

    @Override
    public void onCardFlip(CardPanel cardPanel) {
        // Ignore clicks if two cards are already flipped
        if (selectedCards.size() >= 2) {
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
            SwingUtilities.invokeLater(() -> checkForMatch());
        }
    }



    private void checkForMatch() {
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
        });

        timer.setRepeats(false);
        timer.start();
    }


    @Override
    public void onMatchFound(CardPanel card1, CardPanel card2) {
        card1.card.setMatched(true);
        card2.card.setMatched(true);
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
}
