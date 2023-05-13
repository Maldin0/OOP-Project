import javax.swing.*;
import java.awt.*;
public class pausePanel2 {
    private MyFrameEvent myFrameEvent;
    private MyFrame myFrame;
    private JButton con, retry, exits;
    public pausePanel2(MyFrame mf) {
        this.myFrame = mf;
        myFrameEvent = new MyFrameEvent(myFrame);
        con = new JButton(new ImageIcon("image/Continue button.png"));
        retry = new JButton(new ImageIcon("image/Restart button.png"));
        exits = new JButton(new ImageIcon("image/Exit to menu button.png"));

        con.setPreferredSize(new Dimension(128, 64));
        retry.setPreferredSize(new Dimension(128, 64));
        exits.setPreferredSize(new Dimension(192, 64));

        con.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
        });

        retry.addActionListener(e -> {
            int check = myFrame.getCheck();

            if (check == 0) {
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.add(myFrame.getPauseButton());
                myFrame.add(new GamePanel(4, 4));
                System.out.println(check);
            }
            else if (check == 1) {
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.add(myFrame.getPauseButton());
                myFrame.add(new GamePanel(6, 6));
                System.out.println(check);
            }
            else if (check == 2) {
                myFrame.getContentPane().removeAll();
                myFrame.revalidate();
                myFrame.add(myFrame.getPauseButton());
                myFrame.add(new GamePanel(8, 8));
                System.out.println(check);
            }
            JOptionPane.getRootFrame().dispose();
            myFrame.repaint();
            myFrame.pack();
        });

        exits.addActionListener(e -> {
            myFrame.getContentPane().removeAll();
            myFrame.revalidate();
            myFrame.add(myFrame.getPauseButton());
            myFrame.add(myFrame.getMenuPanel());
            JOptionPane.getRootFrame().dispose();
            myFrame.repaint();
            myFrame.pack();
        });

        JLabel label = new JLabel("Pause");

        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        mainPanel.add(label);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(con);
        buttonPanel.add(retry);
        buttonPanel.add(exits);

        mainPanel.add(buttonPanel);


        JDialog dialog = new JDialog();
        dialog.setTitle("Pausssssse");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setUndecorated(false);
        dialog.setModal(true);
        dialog.setPreferredSize(new Dimension(500, 170));
        dialog.setContentPane(mainPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }
}
