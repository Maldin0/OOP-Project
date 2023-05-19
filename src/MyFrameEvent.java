import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameEvent implements ActionListener {
    public int check;
    private MyFrame frame;
    public MyFrameEvent(MyFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // if Click Start Button goes to GamePanel
        if (e.getSource() == frame.getStartBtn()) {
            ChoosePanel c = new ChoosePanel();
            if (e.getSource() == frame.getPauseBtn()) {
                new PausePanel(frame);
            }
            if (c.difficulty != -1) {
                frame.remove(frame.getMenuPanel());
                frame.revalidate();
                frame.add(frame.getPauseBtn());

                if (c.difficulty == 0) {
                    check = 0;
                    frame.add(new GamePanel(4));
                } else if (c.difficulty == 1) {
                    check = 1;
                    frame.add(new GamePanel(6));
                } else if (c.difficulty == 2) {
                    check = 2;
                    frame.add(new GamePanel(8));
                }
                frame.repaint();
                frame.pack();

            }
        }
        if (e.getSource().equals(frame.getScoreBtn())) {
            new ScoreBoardPanel();
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
    }
}
