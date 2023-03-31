/**
 * @author Maldin0
 * @created 3/26/2023 - 4:46 PM
 * @project OOP-Project
 */
import javax.swing.*;
import java.awt.*;
public class CardPanel extends JPanel {
     ColorCard card;
     private static final Color HIDDEN_COLOR = Color.GRAY;

     public CardPanel(ColorCard card, int cardSize) {
         this.card = card;
         setPreferredSize(new Dimension(cardSize, cardSize));
         setOpaque(false);
     }

     @Override
     protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         int margin = 2;

         if (card.isRevealed() || card.isMatched()) {
             g.setColor(card.getColor());
         } else {
             g.setColor(HIDDEN_COLOR);
         }
         g.fillRect(margin, margin, getWidth() - 2 * margin, getHeight() - 2 * margin);

         if (!card.isRevealed() && !card.isMatched()) {
             g.setColor(Color.BLACK);
             g.fillRect(margin + 1, margin + 1, getWidth() - 2 * margin - 2, getHeight() - 2 * margin - 2);
         }
     }
}
