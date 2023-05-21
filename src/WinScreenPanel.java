import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinScreenPanel extends JPanel {
    private final JButton exits;
    private JLabel winSign;

    public WinScreenPanel(MyFrame frame, MyTimer timer) {
        this.setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/WinScreen.png"));
        winSign = new JLabel(imageIcon);
        winSign.setHorizontalAlignment(JLabel.CENTER);
        this.add(winSign, BorderLayout.CENTER);

        JPanel botPanel = new JPanel();
        botPanel.setLayout(new BorderLayout());

        timer.setHorizontalAlignment(JLabel.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        exits = new JButton(new ImageIcon(getClass().getResource("/image/Exit to menu button.png")));
        exits.setPreferredSize(new Dimension(192, 64));
        exits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == exits) {
                    frame.getContentPane().removeAll();
                    frame.revalidate();
                    frame.add(frame.getMenuPanel());
                    frame.repaint();
                    frame.pack();
                }
            }
        });
        buttonPanel.add(exits);
        buttonPanel.setOpaque(false);
        botPanel.add(timer, BorderLayout.CENTER);
        botPanel.add(buttonPanel, BorderLayout.SOUTH);
        botPanel.setOpaque(false);
        this.add(botPanel, BorderLayout.SOUTH);

//        this.add(buttonPanel, BorderLayout.SOUTH);


        this.setPreferredSize(new Dimension(800, 600));
        this.setVisible(true);
        // Create a separate thread and start it
//        Thread t = new Thread(new WinScreenAnimation(this, imageIcon));
//        t.start();
    }

    public JLabel getWinSign() {
        return winSign;
    }

    public void setWinSign(JLabel winSign) {
        this.winSign = winSign;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(getClass().getResource("/image/BG02.png")).getImage(), 0, 0, null);
    }
}
