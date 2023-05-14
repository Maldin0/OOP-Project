import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameEvent implements ActionListener {
    private MyFrame frame;
    public MyFrameEvent (MyFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // if Click Start Button goes to GamePanel
        if (e.getSource() == frame.getBtn1()) {
            ChoosePanel c = new ChoosePanel();
            if (e.getSource() == frame.getPauseButton()) {
                new PausePanel(frame);
            }
            if (c.difficulty != -1) {
                frame.remove(frame.getMenuPanel());
                frame.revalidate();
                frame.add(frame.getPauseButton());

                if (c.difficulty == 0) {
                    frame.setCheck(0);
                    frame.add(new GamePanel(4,4));
                } else if (c.difficulty == 1) {
                    frame.setCheck(1);
                    frame.add(new GamePanel(6,6));
                } else if (c.difficulty == 2) {
                    frame.setCheck(2);
                    frame.add(new GamePanel(8,8));
                }
                frame.repaint();
                frame.pack();

            }
        }
        if (e.getSource().equals(frame.getBtn2())) {
            new ScoreBoardPanel();
        }
        //Credit Button
        if (e.getSource().equals(frame.getBtn3())) {
            new CreditPanel();
        }
        // if Click Exit Button Exit game or Close JFrame
        if (e.getSource().equals(frame.getBtn4())) {
            System.exit(0);
        }
        if (e.getSource().equals(frame.getBtn5())) {
            new HowToPlay();
        }
        if (e.getSource().equals(frame.getBtn6())) {
            if (frame.isSoundOn()) {
                ImageIcon button6_2 = new ImageIcon("image/Sound off button.png");
                frame.getBtn6().setIcon(button6_2);
                frame.setSoundOn(false);
                frame.getP().mute();

            } else {
                ImageIcon button6 = new ImageIcon("image/Sound button.png");
                frame.getBtn6().setIcon(button6);
                frame.setSoundOn(true);
                frame.getP().unmute();
            }
        }
    }
}
