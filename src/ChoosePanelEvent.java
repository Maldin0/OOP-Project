import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoosePanelEvent implements ActionListener {
    private final ChoosePanel choosePanel;

    public ChoosePanelEvent(ChoosePanel choosePanel) {
        this.choosePanel = choosePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(choosePanel.getEasy())) {
            JOptionPane.getRootFrame().dispose();
            choosePanel.difficulty = 0;
        } else if (e.getSource().equals(choosePanel.getNormal())) {
            JOptionPane.getRootFrame().dispose();
            choosePanel.difficulty = 1;
        } else if (e.getSource().equals(choosePanel.getHard())) {
            JOptionPane.getRootFrame().dispose();
            choosePanel.difficulty = 2;
        }
    }
}
