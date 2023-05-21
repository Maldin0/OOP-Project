/**
 * @author Maldin0
 * @created 3/26/2023 - 4:35 PM
 * @project OOP-Project
 */

import java.awt.*;

public abstract class BaseCard {
    protected Color color;
    protected boolean isMatched;
    protected boolean isRevealed;

    public BaseCard(Color color) {
        this.color = color;
        this.isMatched = false;
        this.isRevealed = false;
    }

    public Color getColor() {
        return color;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public abstract boolean isMatch(BaseCard otherCard);
}

