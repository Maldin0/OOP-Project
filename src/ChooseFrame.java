import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChooseFrame extends JFrame implements ActionListener {
    private JButton easy, normal, hard;
    private int x;
    public ChooseFrame() {
        this.getContentPane().setPreferredSize(new Dimension(300, 80));

        // Insert Icon Image
        ImageIcon icon2 = new ImageIcon("image/Slimeconnector_icon.png");
        this.setIconImage(icon2.getImage().getScaledInstance(5000, 5000, java.awt.Image.SCALE_SMOOTH));

        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        easy = new JButton(new ImageIcon("image/Easy Button.png"));
        easy.setPreferredSize(new Dimension(66, 32));

        normal = new JButton(new ImageIcon("image/Normal Button.png"));
        normal.setPreferredSize(new Dimension(66, 32));

        hard = new JButton(new ImageIcon("image/Hard Button.png"));
        hard.setPreferredSize(new Dimension(66, 32));

        easy.addActionListener(this);
        normal.addActionListener(this);
        hard.addActionListener(this);

        p1.add(new JLabel("Choose Level"));

        p2.add(easy);
        p2.add(normal);
        p2.add(hard);

        p.add(p1, BorderLayout.NORTH);
        p.add(p2, BorderLayout.CENTER);

        this.add(p);
        this.setUndecorated(true);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == easy) {
            x = 1;
            this.dispose();
        } else if (e.getSource() == normal) {

            this.dispose();
        } else if (e.getSource() == hard) {

            this.dispose();
        }
    }
    public int getX() {
        return x;
    }
    public static void main(String[] args) {
        new ChooseFrame();
    }
}
