import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlay{
        private JFrame frame;
        private JPanel mainPanel, smallPanel, infoPanel;
        private JLabel head;
        private JButton backBtn;

        public HowToPlay() {
            frame = new JFrame();
            head = new JLabel("How To Play");
            frame.getContentPane().setPreferredSize(new Dimension(400, 350));
            Color yellow = new Color(255,236,138);
            Color orange = new Color(240,165,0);
            mainPanel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image HowToImg = new ImageIcon("image/Howtoplay.png").getImage();
                    g.drawImage(HowToImg, 0, 0, null);
                }
            };
            mainPanel.setLayout(null);
            mainPanel.setBackground(yellow);

            smallPanel = new JPanel();
            smallPanel.setBackground(orange);
            smallPanel.add(head);

            backBtn = new JButton();
            ImageIcon imgBtn = new ImageIcon("image/Back button.png");
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
    }