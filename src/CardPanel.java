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

     public CardPanel(ColorCard card) {
         this.card = card;
         setPreferredSize(new Dimension(23, 23));
     }

     @Override
     protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         if (card.isRevealed() || card.isMatched()) {
             g.setColor(card.getColor());
         } else {
             g.setColor(HIDDEN_COLOR);
         }
         g.fillRect(0, 0, getWidth(), getHeight());

         if (!card.isRevealed() && !card.isMatched()) {
             g.setColor(Color.BLACK);
             g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
         }
     }
}
