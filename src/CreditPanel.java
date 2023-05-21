import javax.swing.*;
import java.awt.*;

public class CreditPanel {
    private final JFrame fr;
    private final JPanel creditPanel;
    private final JPanel namePanel;
    private final JLabel Name1;
    private final JLabel Name2;
    private final JLabel Name3;
    private final JLabel Name4;
    private final JLabel Name5;
    private final JLabel Name6;
    private final JLabel num1;
    private final JLabel num2;
    private final JLabel num3;
    private final JLabel num4;
    private final JLabel num5;
    private final JLabel num6;
    private final JButton backBtn;

    public CreditPanel() {
        fr = new JFrame();
        fr.setUndecorated(true);
        Font thaiFont = new Font("Tahoma", Font.BOLD, 13);
        fr.getContentPane().setPreferredSize(new Dimension(400, 370));
        Color yellow = new Color(255, 236, 138);

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
        Name1 = new JLabel("     นาย ก้องภพ สินสังข์");
        Name2 = new JLabel("     นาย จิรกิตต์ มราชชาลี");
        Name3 = new JLabel("     นาย จุนบอม คิม");
        Name4 = new JLabel("     นางสาว กนลรัตน์ เบิกขุนทด");
        Name5 = new JLabel("     นาย กิตติพล สิริอมรกิติ์");
        Name6 = new JLabel("     นาย ชัยพิพัฒน์ พงษ์ประภาชื่น");
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

        //ActionPerformed for Button set visible to false
        backBtn.addActionListener(e -> {
            if (e.getSource().equals(backBtn)) {
                fr.dispose();
            }
        });
        creditPanel.add(backBtn);

        //Add names on panel
        namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(6, 2));
        namePanel.add(Name4);//Mean
        namePanel.add(num1);
        namePanel.add(Name1);//Klong
        namePanel.add(num2);
        namePanel.add(Name5);//Holmes
        namePanel.add(num3);
        namePanel.add(Name2);//Smol Boz
        namePanel.add(num4);
        namePanel.add(Name3);//Junbom
        namePanel.add(num5);
        namePanel.add(Name6);//Big Boz
        namePanel.add(num6);
        namePanel.setBackground(yellow);

        //Everything on frame
        fr.pack();
        fr.setLayout(new BorderLayout());
        fr.add(creditPanel);
        fr.add(namePanel, BorderLayout.SOUTH);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
    }
}
