import javax.swing.*;
import java.awt.*;
public class PausePanel {
    private MyFrame myFrame;
    private JButton con, retry, exits;
    private JDialog dialog;
    private PausePanelEvent pausePanelEvent;
    public PausePanel(MyFrame mf) {
        this.myFrame = mf;

        con = new JButton(new ImageIcon("image/Continue button.png"));
        retry = new JButton(new ImageIcon("image/Restart button.png"));
        exits = new JButton(new ImageIcon("image/Exit to menu button.png"));

        con.setPreferredSize(new Dimension(128, 64));
        retry.setPreferredSize(new Dimension(128, 64));
        exits.setPreferredSize(new Dimension(192, 64));

        pausePanelEvent = new PausePanelEvent(this, myFrame);
        con.addActionListener(pausePanelEvent);
        retry.addActionListener(pausePanelEvent);
        exits.addActionListener(pausePanelEvent);

        JLabel label = new JLabel("Pause");

        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        mainPanel.add(label);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(con);
        buttonPanel.add(retry);
        buttonPanel.add(exits);

        mainPanel.add(buttonPanel);


        dialog = new JDialog();
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
}
