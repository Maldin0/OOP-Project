import javax.swing.*;
import java.awt.event.*;

public class PausePanel extends JFrame implements ActionListener {
    private JPanel pausePanel;
    private JButton continueButton, retryButton, backToMenuButton;
    private JLabel PauseWord;

    public PausePanel() {
        pausePanel = new JPanel();
        continueButton = new JButton("Continue");
        retryButton = new JButton("retry");
        backToMenuButton = new JButton("Exit to Menu");
        PauseWord = new JLabel("Pause");

        // กำหนดปุ่มได้เอง
        pausePanel.setLayout(null);

        // title pause
        PauseWord.setBounds(375, 50, 128, 64);
        pausePanel.add(PauseWord);

        // continue button
        continueButton.setBounds(330, 150, 128, 64);
        pausePanel.add(continueButton);

        // retry button
        retryButton.setBounds(330, 250, 128, 64);
        pausePanel.add(retryButton);

        // back to menu button
        backToMenuButton.setBounds(330, 350, 128, 64);
        pausePanel.add(backToMenuButton);

        this.add(pausePanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        backToMenuButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(backToMenuButton)) {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            MyFrame mf = new MyFrame();
            this.add(mf);
        }
    }

    public static void main(String[] args) {
        new PausePanel();
    }
}
