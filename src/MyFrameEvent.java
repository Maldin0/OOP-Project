import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameEvent implements ActionListener {
    public int check;
    private MyFrame frame;
    private JPanel menuPanel;
    public MyFrameEvent(MyFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // if Click Start Button goes to GamePanel
        if (e.getSource() == frame.getStartBtn()) {
            ChoosePanel c = new ChoosePanel();
            if (c.difficulty != -1) {
                frame.remove(frame.getMenuPanel());
                frame.revalidate();
                frame.setLayout(new BorderLayout());
                if (c.difficulty == 0) {
                    frame.setCheck(0);
                    frame.add(new GamePanel(4, frame));
                } else if (c.difficulty == 1) {
                    frame.setCheck(1);
                    frame.add(new GamePanel(6, frame));
                } else if (c.difficulty == 2) {
                    frame.setCheck(2);
                    frame.add(new GamePanel(8, frame));
                }
                frame.repaint();
                frame.pack();
            }
        }
        if (e.getSource().equals(frame.getScoreBtn())) {
            frame.setLayout(new BorderLayout());
            frame.remove(frame.getMenuPanel());
            frame.revalidate();
            frame.setLayout(new BorderLayout());
            frame.add(new ScoreBoardPanel(frame).getMainPanel());
            frame.repaint();
            frame.pack();
        }
        //Credit Button
        if (e.getSource().equals(frame.getCreditBtn())) {
            new CreditPanel();
        }
        // if Click Exit Button Exit game or Close JFrame
        if (e.getSource().equals(frame.getExitBtn())) {
            System.exit(0);
        }
        if (e.getSource().equals(frame.getSoundBtn())) {
            if (frame.isSoundOn()) {
                ImageIcon button6_2 = new ImageIcon("image/Sound off button.png");
                frame.getSoundBtn().setIcon(button6_2);
                frame.setSoundOn(false);
                frame.getP().mute();

            } else {
                ImageIcon button6 = new ImageIcon("image/Sound button.png");
                frame.getSoundBtn().setIcon(button6);
                frame.setSoundOn(true);
                frame.getP().unmute();
            }
        }
        if (e.getSource().equals(frame.getHelpBtn())) {
            new HowToPlay();
        }
    }
}
