import javax.swing.*;
import java.awt.*;

public class ChoosePanel {
    public int difficulty = -1;
    private JButton easy, normal, hard;
    private final ChoosePanelEvent event;

    public ChoosePanel() {
        easy = new JButton(new ImageIcon("image/Easy Button.png"));
        normal = new JButton(new ImageIcon("image/Normal Button.png"));
        hard = new JButton(new ImageIcon("image/Hard Button.png"));

        easy.setPreferredSize(new Dimension(66, 32));
        normal.setPreferredSize(new Dimension(66, 32));
        hard.setPreferredSize(new Dimension(66, 32));

        event = new ChoosePanelEvent(this);
        easy.addActionListener(event);
        normal.addActionListener(event);
        hard.addActionListener(event);

        JLabel label = new JLabel("Choose the difficulty level:");

        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel(new FlowLayout());

        buttonPanel.add(easy);
        buttonPanel.add(normal);
        buttonPanel.add(hard);

        mainPanel.add(label);
        mainPanel.add(buttonPanel);

        JDialog dialog = new JDialog();
        dialog.setTitle("Difficulty");

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        ImageIcon icon = new ImageIcon("image/Slimeconnector_icon.png");
        dialog.setIconImage(icon.getImage().getScaledInstance(5000, 5000, java.awt.Image.SCALE_SMOOTH));
        dialog.setPreferredSize(new Dimension(260, 120));
        dialog.setContentPane(mainPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }

    public JButton getEasy() {
        return easy;
    }

    public void setEasy(JButton easy) {
        this.easy = easy;
    }

    public JButton getNormal() {
        return normal;
    }

    public void setNormal(JButton normal) {
        this.normal = normal;
    }

    public JButton getHard() {
        return hard;
    }

    public void setHard(JButton hard) {
        this.hard = hard;
    }
}
