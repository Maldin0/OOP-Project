/**
 * @author Maldin0
 * @created 3/26/2023 - 4:32 PM
 * @project OOP-Project
 */
public interface CardListener {
    void onCardFlip(CardPanel cardPanel);
    void onMatchFound(CardPanel card1, CardPanel card2);
}