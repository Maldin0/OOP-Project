import javax.swing.*;
import java.awt.*;

public class WinScreenAnimation implements Runnable {
    private WinScreenPanel winScreenPanel;
    private ImageIcon imageIcon;

    public WinScreenAnimation(WinScreenPanel winScreenPanel, ImageIcon imageIcon) {
        this.winScreenPanel = winScreenPanel;
        this.imageIcon = imageIcon;
    }

    @Override
    public void run() {
        int height = imageIcon.getIconHeight();
        int width = imageIcon.getIconWidth();

        int initialY = -height; // Start the image off the top of the panel
        int finalY = (winScreenPanel.getHeight() - height) / 2; // Calculate the final y-coordinate

        for (int y = initialY; y <= finalY; y++) {
            Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

            // Create a new position for the image within the label
            int x = (winScreenPanel.getWidth() - width) / 2;
            int currentY = y;
            Rectangle position = new Rectangle(x, currentY, width, height);

            // Set the position of the image within the label
            SwingUtilities.invokeLater(() -> {
                winScreenPanel.winSign.setIcon(scaledImageIcon);
                winScreenPanel.winSign.setBounds(position);
                winScreenPanel.repaint(); // Update the panel to show the changes
            });

            try {
                Thread.sleep(5); // Adjust the delay between each partial image display
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
