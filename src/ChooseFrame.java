import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ChooseFrame extends JFrame implements ActionListener{
    public ChooseFrame() {
        this.getContentPane().setPreferredSize(new Dimension(400, 100));

        // Insert Icon Image
        ImageIcon icon2 = new ImageIcon("image/Slimeconnector_icon.png");
        this.setIconImage(icon2.getImage().getScaledInstance(5000, 5000, java.awt.Image.SCALE_SMOOTH));

        JPanel p = new JPanel(new GridLayout(0, 1));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel(new FlowLayout());

        JButton easy = new JButton();
        p1.add(new JLabel("Choose Level"));
        p2.add();
        p.add(p1);
        p.add(p2);

        this.add(p);

//        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // exit out of application
        this.setUndecorated(true);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new ChooseFrame();
    }
}
