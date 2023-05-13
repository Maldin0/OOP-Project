import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreditPanel implements ActionListener {
    private JFrame fr;
    private JPanel creditPanel, namePanel;
    private JLabel Name1, Name2, Name3, Name4, Name5, Name6, num1, num2, num3, num4, num5, num6;
    private JButton backBtn;

    public CreditPanel(){
        fr = new JFrame("Credit");
        Font thaiFont = new Font("Tahoma", Font.BOLD, 13);
        fr.getContentPane().setPreferredSize(new Dimension(400, 370));
        Color yellow = new Color(255,236,138);
        Color orange = new Color(240,165,0);

        //Background
        creditPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image creditImg = new ImageIcon("image/Credit Sprite.png").getImage();
                g.drawImage(creditImg, 0, 0, null);
            }
        };
        creditPanel.setLayout(null);
        creditPanel.setBackground(yellow);

        //Names
        Name1 = new JLabel("    นายก้องภพ สินสังข์");
        Name2 = new JLabel("    นายจิรกิตต์ มราชชาลี");
        Name3 = new JLabel("    นายจุนบอม คิม");
        Name4 = new JLabel("    นางสาวกนลรัตน์ เบิกขุนทด");
        Name5 = new JLabel("    นายกิตติพล สิริอมรกิติ์");
        Name6 = new JLabel("    นายชัยพิพัฒน์ พงษ์ประภาชื่น");
        num1 = new JLabel("                 65070007");
        num2 = new JLabel("                 65070015");
        num3 = new JLabel("                 65070019");
        num4 = new JLabel("                 65070034");
        num5 = new JLabel("                 65070040");
        num6 = new JLabel("                 65070047");

        //Set Font
        Name1.setFont(thaiFont);
        Name2.setFont(thaiFont);
        Name3.setFont(thaiFont);
        Name4.setFont(thaiFont);
        Name5.setFont(thaiFont);
        Name6.setFont(thaiFont);

        //Button
        backBtn = new JButton();
        ImageIcon imgBtn = new ImageIcon("image/Back button.png");
        backBtn.setIcon(imgBtn);
        backBtn.setBounds(10, 15, 50, 50);
        backBtn.addActionListener(this);
        creditPanel.add(backBtn);

        //Add names on panel
        namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(6, 2));
        namePanel.add(Name4);//Mean
        namePanel.add(num1);
        namePanel.add(Name1);//Kong
        namePanel.add(num2);
        namePanel.add(Name5);//Holmes
        namePanel.add(num3);
        namePanel.add(Name2);//Smol Boz
        namePanel.add(num4);
        namePanel.add(Name3);//Junbom
        namePanel.add(num5);
        namePanel.add(Name6);//Big Boz
        namePanel.add(num6);
        namePanel.setBackground(orange);

        //Everything on frame
        fr.pack();
        fr.setLayout(new BorderLayout());
        fr.add(creditPanel);
        fr.add(namePanel, BorderLayout.SOUTH);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
    }
    //ActionPerformed for Button set visible to false
    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource().equals(backBtn)) {
            fr.setVisible(false);
        }
    }
}
