import java.awt.image.BufferedImage;

/**
 * @author Maldin0
 * @created 5/18/2023 - 11:53 AM
 * @project OOP-Project
 */
public class ImageCard extends BaseCard{
    private BufferedImage image;

    public ImageCard(BufferedImage image) {
        super(null);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    @Override
    public boolean isMatch(BaseCard otherCard) {
        if (otherCard instanceof ImageCard) {
            return this.image.equals(((ImageCard) otherCard).getImage());
        }
        return false;
    }
}
