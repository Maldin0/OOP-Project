import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MyFrameEvent implements ActionListener {
    private final MyFrame frame;

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
            SwingUtilities.invokeLater(() -> {
                CreditPanel creditPanel = CreditPanel.getInstance();
                creditPanel.show();
            });
        }
        // if Click Exit Button Exit game or Close JFrame
        if (e.getSource().equals(frame.getExitBtn())) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
        if (e.getSource().equals(frame.getSoundBtn())) {
            if (frame.isSoundOn()) {
                ImageIcon button6_2 = new ImageIcon(getClass().getResource("/image/Sound off button.png"));
                frame.getSoundBtn().setIcon(button6_2);
                frame.setSoundOn(false);
                frame.getP().mute();
            } else {
                ImageIcon button6 = new ImageIcon(getClass().getResource("/image/Sound button.png"));
                frame.getSoundBtn().setIcon(button6);
                frame.setSoundOn(true);
                frame.getP().unmute();
            }
        }
        if (e.getSource().equals(frame.getHelpBtn())) {
            SwingUtilities.invokeLater(() -> {
                HowToPlay howToPlay = HowToPlay.getInstance();
                howToPlay.show();
            });
        }
    }
}
