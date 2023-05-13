import javax.swing.*;
import java.awt.*;

public class HowToPlay {
    private JFrame frame;
    private JPanel panel;
    private JLabel ins;
    private JButton backBtn;

    public HowToPlay() {
        frame = new JFrame("HowToPlay");
        frame.getContentPane().setPreferredSize(new Dimension(400, 300));
        Color yellow = new Color(255,236,138);

        panel = new JPanel();
        ins = new JLabel("How To Play");
    }
}
