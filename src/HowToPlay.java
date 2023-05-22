import javax.swing.*;
import java.awt.*;

public class HowToPlay {
    private static HowToPlay instance;
    private final JFrame frame;
    private final JButton backBtn;

    private HowToPlay() {
        frame = new JFrame();
        JLabel head = new JLabel("How To Play");
        frame.getContentPane().setPreferredSize(new Dimension(400, 350));
        Color yellow = new Color(255, 236, 138);
        Color orange = new Color(240, 165, 0);
        JPanel mainPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image HowToImg = new ImageIcon(getClass().getResource("/image/Howtoplay.png")).getImage();
                g.drawImage(HowToImg, 0, 0, null);
            }
        };
        mainPanel.setLayout(null);
        mainPanel.setBackground(yellow);

        JPanel smallPanel = new JPanel();
        smallPanel.setBackground(orange);
        smallPanel.add(head);

        backBtn = new JButton();
        ImageIcon imgBtn = new ImageIcon(getClass().getResource("/image/Back button.png"));
        backBtn.setIcon(imgBtn);
        backBtn.setBounds(10, 15, 50, 50);
        backBtn.addActionListener(e -> {
            if (e.getSource().equals(backBtn)) {
                frame.dispose();
            }
        });
        mainPanel.add(backBtn);

        frame.setUndecorated(true);
        frame.pack();
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel);
        frame.add(smallPanel, BorderLayout.NORTH);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
    public static HowToPlay getInstance() {
        if (instance == null) {
            instance = new HowToPlay();
        }
        return instance;
    }

    public void show() {
        frame.setVisible(true);
    }
}