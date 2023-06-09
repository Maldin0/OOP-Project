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
    public static int count;
    private final List<CardPanel> selectedCards = new ArrayList<>();
    private final List<CardPanel> cardPanels = new ArrayList<>();
    private boolean canInteract = true;
    private BufferedImage hiddenImage;
    private final MyTimer timer;
    private final int rows;
    private final MyFrame frame;

    public GameBoard(int rows, int cardSize, List<BufferedImage> images, MyTimer timer, MyFrame frame) {
        List<ImageCard> cards = generateCards(images);
        this.timer = timer;
        this.rows = rows;
        this.frame = frame;
        setOpaque(false);

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

        setLayout(new GridLayout(rows, rows, 0, 0));

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

    public static void resetCount() {
        count = 0;
    }

    private List<ImageCard> generateCards(List<BufferedImage> images) {
        List<ImageCard> cards = new ArrayList<>();
        for (BufferedImage image : images) {
            cards.add(new ImageCard(image));
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
        CardPanel card1 = selectedCards.get(0);
        CardPanel card2 = selectedCards.get(1);

        if (card1.card.isMatch(card2.card)) {
            onMatchFound(card1, card2);
            selectedCards.clear();
            canInteract = true;
        } else {
            // When the cards don't match, add a delay before flipping them back
            canInteract = false;
            Timer timer = new Timer(1000, e -> {
                card1.card.setRevealed(false);
                card2.card.setRevealed(false);
                card1.repaint();
                card2.repaint();
                selectedCards.clear();
                canInteract = true;
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    @Override
    public void onMatchFound(CardPanel card1, CardPanel card2) {
        card1.card.setMatched(true);
        card2.card.setMatched(true);
        count++;
        if (count == 8 && rows == 4) {
            timer.pauseTimer();
            MyFrame.scoreTime.setEasyTime(isFaster(MyFrame.scoreTime.getEasyTime(), timer.getText()));
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.add(new WinScreenPanel(frame, timer));
            resetCount();
        } else if (count == 18 && rows == 6) {
            timer.pauseTimer();
            MyFrame.scoreTime.setNormalTime(isFaster(MyFrame.scoreTime.getNormalTime(), timer.getText()));
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.add(new WinScreenPanel(frame, timer));
            resetCount();
        } else if (count == 32 && rows == 8) {
            timer.pauseTimer();
            MyFrame.scoreTime.setHardTime(isFaster(MyFrame.scoreTime.getHardTime(), timer.getText()));
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.add(new WinScreenPanel(frame, timer));
            resetCount();
        }
        frame.repaint();
        frame.pack();
    }

    private void revealAllCards() {
        cardPanels.forEach(cardPanel -> {
            cardPanel.card.setRevealed(true);
            cardPanel.repaint();
        });

        Timer timer = new Timer(3000, e -> {
            cardPanels.forEach(cardPanel -> {
                cardPanel.card.setRevealed(false);
                cardPanel.repaint();
            });
        });

        timer.setRepeats(false);
        timer.start();
    }

    public int convertToSeconds(String time) {
        String[] units = time.split(" : "); // will break the string up into an array
        int hours = Integer.parseInt(units[0]); // first element
        int minutes = Integer.parseInt(units[1]); // second element
        int seconds = Integer.parseInt(units[2]); // third element
        return (hours * 3600) + (minutes * 60) + seconds;
    }

    public String isFaster(String time1, String time2) {
        if (time1.equals("-")) {
            return time2;
        }
        if (convertToSeconds(time1) < convertToSeconds(time2)) {
            return time1;
        } else {
            return time2;
        }
    }
}
