import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PausePanelEvent implements ActionListener {
    private final MyFrame myFrame;
    private final PausePanel pausePanel;

    public PausePanelEvent(PausePanel pausePanel, MyFrame myFrame) {
        this.myFrame = myFrame;
        this.pausePanel = pausePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pausePanel.getCon())) {
            pausePanel.getTimer().resumeTimer();
            pausePanel.getDialog().dispose();
        } else if (e.getSource().equals(pausePanel.getRetry())) {
            int check = myFrame.getCheck();
            System.out.println(check);
            if (check == 0) {
                new GameBoard();
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.setCheck(0);
                myFrame.add(new GamePanel(4, myFrame));
            } else if (check == 1) {
                new GameBoard();
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.setCheck(0);
                myFrame.add(new GamePanel(6, myFrame));
            } else if (check == 2) {
                new GameBoard();
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.setCheck(0);
                myFrame.add(new GamePanel(8, myFrame));
            }
            pausePanel.getDialog().dispose();
            myFrame.repaint();
            myFrame.pack();
        } else if (e.getSource().equals(pausePanel.getExits())) {
            myFrame.getContentPane().removeAll();
            myFrame.revalidate();
            myFrame.add(myFrame.getMenuPanel());
            pausePanel.getDialog().dispose();
            myFrame.repaint();
            myFrame.pack();
        }
    }
}
