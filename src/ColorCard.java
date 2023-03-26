import java.awt.*;

/**
 * @author Maldin0
 * @created 3/26/2023 - 4:43 PM
 * @project OOP-Project
 */
public class ColorCard extends BaseCard{
    public ColorCard(Color color) {
        super(color);
    }

    @Override
    public boolean isMatch(BaseCard otherCard) {
        if (otherCard instanceof ColorCard) {
            return this.color.equals(otherCard.getColor());
        }
        return false;
    }
}
