import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PausePanelEvent implements ActionListener {
    private MyFrame myFrame;
    private PausePanel pausePanel;

    public PausePanelEvent (PausePanel pausePanel, MyFrame myFrame) {
        this.myFrame = myFrame;
        this.pausePanel = pausePanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pausePanel.getCon())) {
            pausePanel.getDialog().dispose();
        }
        else if (e.getSource().equals(pausePanel.getRetry())) {
            int check = myFrame.getCheck();

            if (check == 0) {
                new GameBoard();
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.setLayout(new BorderLayout());
                myFrame.add(myFrame.getPauseBtn());
                JPanel fillPanel = new JPanel();
                myFrame.add(fillPanel, BorderLayout.CENTER);
                myFrame.add(new GamePanel(4), BorderLayout.SOUTH);
                System.out.println(check);

            }
            else if (check == 1) {
                new GameBoard();
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.add(myFrame.getPauseBtn());
                JPanel fillPanel = new JPanel();
                myFrame.add(fillPanel, BorderLayout.CENTER);
                myFrame.add(new GamePanel(6), BorderLayout.SOUTH);
                System.out.println(check);
            }
            else if (check == 2) {
                new GameBoard();
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.add(myFrame.getPauseBtn());
                JPanel fillPanel = new JPanel();
                myFrame.add(fillPanel, BorderLayout.CENTER);
                myFrame.add(new GamePanel(8), BorderLayout.SOUTH);
                System.out.println(check);
            }
            pausePanel.getDialog().dispose();
            myFrame.repaint();
            myFrame.pack();
        }
        else if (e.getSource().equals(pausePanel.getExits())) {
            myFrame.getContentPane().removeAll();
            myFrame.revalidate();
            myFrame.add(myFrame.getMenuPanel());
            pausePanel.getDialog().dispose();
            myFrame.repaint();
            myFrame.pack();
        }
    }
}
