import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameEvent extends MyFrame implements ActionListener{
    public MyFrameEvent(){
        getBtn1().addActionListener(this);
        getBtn2().addActionListener(this);
        getBtn3().addActionListener(this);
        getBtn4().addActionListener(this);
        getBtn5().addActionListener(this);
        getBtn6().addActionListener(this);
    }
    public static void main(String[] args) {
        new MyFrameEvent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if Click Start Button goes to GamePanel
            if (e.getSource().equals(this.getBtn1())) {
                ChoosePanel c = new ChoosePanel();
                this.remove(this.getMenuPanel());
                this.revalidate();
                this.add(this.getPauseButton());

                if (c.difficulty == 0) {
                    this.add(new GamePanel(4, 4));
                } else if (c.difficulty == 1) {
                    this.add(new GamePanel(6, 6));
                } else if (c.difficulty == 2) {
                    this.add(new GamePanel(8, 8));
                }

                this.repaint();
                this.pack();
            }
            //Credit Button
            if (e.getSource().equals((this.getBtn3()))) {
                new CreditPanel();
            }
            // if Click Exit Button Exit game or Close JFrame
            if (e.getSource().equals(this.getBtn4())) {
                System.exit(0);
            }
            if (e.getSource().equals(this.getBtn6())) {
                if (this.isSoundOn()) {
                    ImageIcon button6_2 = new ImageIcon("image/Sound off button.png");
                    this.getBtn6().setIcon(button6_2);
                    this.setSoundOn(false);
                    this.getP().mute();

                } else {
                    ImageIcon button6 = new ImageIcon("image/Sound button.png");
                    this.getBtn6().setIcon(button6);
                    this.setSoundOn(true);
                    this.getP().unmute();
                }
            }
        }
    }
