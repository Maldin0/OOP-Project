import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PausePanelEvent implements ActionListener {
    private MyFrame myFrame;
    private PausePanel pausePanel;
    private JPanel background;
    private MyClock clock;
    public PausePanelEvent (PausePanel pausePanel, MyFrame myFrame) {
        this.myFrame = myFrame;
        this.pausePanel = pausePanel;
    }
    public PausePanelEvent(MyClock clock) {
        this.clock = clock;
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
                background.add(myFrame.getPauseBtn());
                clock = new MyClock();
                clock.setHorizontalAlignment(JLabel.CENTER);
                Thread t = new Thread(clock);
                background.add(clock, BorderLayout.CENTER);
                t.start();
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
                background.add(myFrame.getPauseBtn());
                clock = new MyClock();
                clock.setHorizontalAlignment(JLabel.CENTER);
                Thread t = new Thread(clock);
                background.add(clock, BorderLayout.CENTER);
                t.start();
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
                background.add(myFrame.getPauseBtn());
                clock = new MyClock();
                clock.setHorizontalAlignment(JLabel.CENTER);
                Thread t = new Thread(clock);
                background.add(clock, BorderLayout.CENTER);
                t.start();
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
