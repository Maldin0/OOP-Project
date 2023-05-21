import javax.swing.*;
import java.awt.*;

public class PausePanel {
    private final MyTimer timer;
    private MyFrame myFrame;
    private JButton con, retry, exits;
    private JDialog dialog;

    public PausePanel(MyFrame mf, MyTimer timer) {
        this.timer = timer;
        this.myFrame = mf;

        con = new JButton(new ImageIcon(getClass().getResource("/image/Continue button.png")));
        retry = new JButton(new ImageIcon(getClass().getResource("/image/Restart button.png")));
        exits = new JButton(new ImageIcon(getClass().getResource("/image/Exit to menu button.png")));

        con.setPreferredSize(new Dimension(128, 64));
        retry.setPreferredSize(new Dimension(128, 64));
        exits.setPreferredSize(new Dimension(192, 64));

        PausePanelEvent pausePanelEvent = new PausePanelEvent(this, myFrame);
        con.addActionListener(pausePanelEvent);
        retry.addActionListener(pausePanelEvent);
        exits.addActionListener(pausePanelEvent);

        Font font = new Font("Tahoma", Font.BOLD, 30);

        JLabel label = new JLabel("Pause");
        label.setBounds(0, 0, 150, 50);
        label.setForeground(new Color(52, 60, 132));
        label.setFont(font);

        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        mainPanel.add(label);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(con);
        buttonPanel.add(retry);
        buttonPanel.add(exits);

        mainPanel.add(buttonPanel);


        dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(true);
        dialog.setPreferredSize(new Dimension(500, 120));
        dialog.setContentPane(mainPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public JButton getCon() {
        return con;
    }

    public void setCon(JButton con) {
        this.con = con;
    }

    public JButton getRetry() {
        return retry;
    }

    public void setRetry(JButton retry) {
        this.retry = retry;
    }

    public JButton getExits() {
        return exits;
    }

    public void setExits(JButton exits) {
        this.exits = exits;
    }

    public JDialog getDialog() {
        return dialog;
    }

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }

    public MyTimer getTimer() {
        return timer;
    }
}
