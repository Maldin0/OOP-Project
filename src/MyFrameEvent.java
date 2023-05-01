import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameEvent implements ActionListener {
    private MyFrame mf;
    @Override
    public void actionPerformed(ActionEvent e) {
        // if Click Start Button goes to GamePanel
        if (e.getSource().equals(mf.getBtn1())) {
            ChoosePanel c = new ChoosePanel();
            mf.remove(mf.getMenuPanel());
            mf.revalidate();
            mf.add(mf.getPauseButton());

            if (c.difficulty == 0) {
                mf.add(new GamePanel(4, 4));
            } else if (c.difficulty == 1) {
                mf.add(new GamePanel(6, 6));
            } else if (c.difficulty == 2) {
                mf.add(new GamePanel(8, 8));
            }

            mf.repaint();
            mf.pack();
        }
        //Credit Button
        if (e.getSource().equals((mf.getBtn3()))) {
            new CreditPanel();
        }
        // if Click Exit Button Exit game or Close JFrame
        if (e.getSource().equals(mf.getBtn4())) {
            System.exit(0);
        }
        if (e.getSource().equals(mf.getBtn6())) {
            if (mf.isSoundOn()) {
                ImageIcon button6_2 = new ImageIcon("image/Sound off button.png");
                mf.getBtn6().setIcon(button6_2);
                mf.setSoundOn(false);
                mf.getP().mute();

            } else {
                ImageIcon button6 = new ImageIcon("image/Sound button.png");
                mf.getBtn6().setIcon(button6);
                mf.setSoundOn(true);
                mf.getP().unmute();
            }
        }
    }
}
