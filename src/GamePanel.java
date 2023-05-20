/**
 * @author Maldin0
 * @created 3/26/2023 - 5:25 PM
 * @project OOP-Project
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamePanel extends JPanel {
    private int rows;
    private Image bg1;
    private MyFrame frame;
    private JButton pauseBtn;
    public GamePanel(int rows, MyFrame frame) {
        this.rows = rows;
        this.frame = frame;
        // Load Background images
        if (rows == 4){
            bg1 = new ImageIcon("image/easybackground.png").getImage();
        } else if (rows == 6) {
            bg1 = new ImageIcon("image/mediumbackground.png").getImage();
        } else if (rows == 8) {
            bg1 = new ImageIcon("image/hardbackground.png").getImage();
        }
        setLayout(new BorderLayout());
        setSize(800,600);
        setOpaque(true);
//        setBackground(Color.BLUE);

        int windowHeight = this.getHeight();

        // Calculate card size based on the frame size and number of rows and columns
        int cardSize = ((windowHeight-50)/rows)-1;

        List<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            try {
                URL imageUrl = getClass().getResource("/Slime/Slime" + i + ".png");
                BufferedImage img = ImageIO.read(imageUrl);
                BufferedImage scaledImage = new BufferedImage(cardSize, cardSize, BufferedImage.TYPE_INT_ARGB);
                Graphics2D graphics2D = scaledImage.createGraphics();
                graphics2D.drawImage(img, 0, 0, cardSize, cardSize, null);
                graphics2D.dispose();
                images.add(scaledImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<BufferedImage> imagePairs = createImagePairs(images, rows * rows / 2);
        Collections.shuffle(imagePairs);

        MyTimer clock = new MyTimer();
        Thread thread = new Thread(clock);
        clock.setHorizontalAlignment(JLabel.CENTER);

        GameBoard gameBoard = new GameBoard(rows, cardSize, imagePairs, clock, rows);

        JPanel wrapper = new JPanel(new FlowLayout());

        wrapper.add(gameBoard);
        wrapper.setOpaque(false);

        pauseBtn = new JButton();
        pauseBtn.setPreferredSize(new Dimension(50,50));
        pauseBtn.setIcon(new ImageIcon("image/Pause button.png"));
        pauseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.pauseTimer();
                new PausePanel(frame, clock);
            }
        });
        JPanel fillPanel = new JPanel();
        fillPanel.setPreferredSize(new Dimension(50, 50));
        fillPanel.setOpaque(false);

        add(clock, BorderLayout.CENTER);
        add(pauseBtn, BorderLayout.WEST);
        add(fillPanel, BorderLayout.EAST);
        add(wrapper, BorderLayout.SOUTH);

        Timer timer = new Timer(3000, te -> {
            thread.start();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private List<BufferedImage> createImagePairs(List<BufferedImage> uniqueImages, int pairCount) {
        List<BufferedImage> imagePairs = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < pairCount; i++) {
            imagePairs.add(uniqueImages.get(index));
            imagePairs.add(uniqueImages.get(index));

            index++;
            if (index >= uniqueImages.size()) {
                index = 0;
            }
        }

        return imagePairs;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg1, 0, 0, null);
    }
}

