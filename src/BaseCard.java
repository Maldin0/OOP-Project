/**
 * @author Maldin0
 * @created 3/26/2023 - 4:35 PM
 * @project OOP-Project
 */

public abstract class BaseCard {
    protected boolean isMatched;
    protected boolean isRevealed;

    public BaseCard() {
        this.isMatched = false;
        this.isRevealed = false;
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

