import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HowToPlay{
        private JFrame frame;
        private JPanel mainPanel, smallPanel, infoPanel;
        private JLabel head, info;
        private JButton backBtn;

        public HowToPlay() {
            frame = new JFrame("HowToPlay");
            mainPanel = new JPanel();
            frame.getContentPane().setPreferredSize(new Dimension(400, 300));
            Color yellow = new Color(255,236,138);
            Color orange = new Color(240,165,0);
            mainPanel.setLayout(null);
            mainPanel.setBackground(yellow);
            head = new JLabel("How To Play");
            info = new JLabel("This is how to play and I don't know?");

            backBtn = new JButton();
            ImageIcon imgBtn = new ImageIcon("image/Back button.png");
            backBtn.setIcon(imgBtn);
            backBtn.setBounds(10, 15, 50, 50);
            backBtn.addActionListener(e -> {
                if (e.getSource().equals(backBtn)) {
                    frame.setVisible(false);
                }
            });
            mainPanel.add(backBtn);

            smallPanel = new JPanel();
            smallPanel.setBackground(orange);
            smallPanel.add(head);

            ImageIcon icon2 = new ImageIcon("image/Slimeconnector_icon.png");
            frame.setIconImage(icon2.getImage().getScaledInstance(5000, 5000, java.awt.Image.SCALE_SMOOTH));

            frame.pack();
            frame.setLayout(new BorderLayout());
            frame.add(mainPanel);
            frame.add(smallPanel, BorderLayout.NORTH);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
        }
    }