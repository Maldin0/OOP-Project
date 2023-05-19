import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PausePanelEvent implements ActionListener {
    private MyFrame myFrame;
    private PausePanel pausePanel;
    private JPanel background;
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
            System.out.println(check);
            if (check == 0) {
                new GameBoard();
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.add(myFrame.getPauseBtn());
                background = new JPanel(new BorderLayout()) {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        Image bg2 = new ImageIcon("image/easybackground.png").getImage();
                        g.drawImage(bg2, 0, 0, null);
                    }
                };
                JLabel label = new JLabel("Test");
                label.setHorizontalAlignment(JLabel.CENTER);
                background.add(label, BorderLayout.CENTER);
                background.add(new GamePanel(4), BorderLayout.SOUTH);
                myFrame.add(background);
            }
            else if (check == 1) {
                new GameBoard();
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.add(myFrame.getPauseBtn());
                background = new JPanel(new BorderLayout()) {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        Image bg2 = new ImageIcon("image/mediumbackground.png").getImage();
                        g.drawImage(bg2, 0, 0, null);
                    }
                };
                JLabel label = new JLabel("Test");
                label.setHorizontalAlignment(JLabel.CENTER);
                background.add(label, BorderLayout.CENTER);
                background.add(new GamePanel(6), BorderLayout.SOUTH);
                myFrame.add(background);
            }
            else if (check == 2) {
                new GameBoard();
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.add(myFrame.getPauseBtn());
                background = new JPanel(new BorderLayout()) {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        Image bg2 = new ImageIcon("image/hardbackground.png").getImage();
                        g.drawImage(bg2, 0, 0, null);
                    }
                };
                JLabel label = new JLabel("Test");
                label.setHorizontalAlignment(JLabel.CENTER);
                background.add(label, BorderLayout.CENTER);
                background.add(new GamePanel(8), BorderLayout.SOUTH);
                myFrame.add(background);
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
