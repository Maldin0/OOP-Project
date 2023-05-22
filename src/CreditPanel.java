import javax.swing.*;
import java.awt.*;

public class CreditPanel {
    private static CreditPanel instance;
    private final JFrame fr;
    private final JButton backBtn;

    private CreditPanel() {
        fr = new JFrame();
        fr.setUndecorated(true);
        Font thaiFont = new Font("Tahoma", Font.BOLD, 13);
        fr.getContentPane().setPreferredSize(new Dimension(400, 370));
        Color yellow = new Color(255, 236, 138);

        //Background
        JPanel creditPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image creditImg = new ImageIcon(getClass().getResource("/image/Credit Sprite.png")).getImage();
                g.drawImage(creditImg, 0, 0, null);
            }
        };
        creditPanel.setLayout(null);
        creditPanel.setBackground(yellow);

        //Names
        JLabel name1 = new JLabel("     นาย ก้องภพ สินสังข์");
        JLabel name2 = new JLabel("     นาย จิรกิตต์ มราชชาลี");
        JLabel name3 = new JLabel("     นาย จุนบอม คิม");
        JLabel name4 = new JLabel("     นางสาว กนลรัตน์ เบิกขุนทด");
        JLabel name5 = new JLabel("     นาย กิตติพล สิริอมรกิติ์");
        JLabel name6 = new JLabel("     นาย ชัยพิพัฒน์ พงษ์ประภาชื่น");
        JLabel num1 = new JLabel("                 65070007");
        JLabel num2 = new JLabel("                 65070015");
        JLabel num3 = new JLabel("                 65070019");
        JLabel num4 = new JLabel("                 65070034");
        JLabel num5 = new JLabel("                 65070040");
        JLabel num6 = new JLabel("                 65070047");

        //Set Font
        name1.setFont(thaiFont);
        name2.setFont(thaiFont);
        name3.setFont(thaiFont);
        name4.setFont(thaiFont);
        name5.setFont(thaiFont);
        name6.setFont(thaiFont);

        //Button
        backBtn = new JButton();
        ImageIcon imgBtn = new ImageIcon(getClass().getResource("/image/Back button.png"));
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
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(6, 2));
        namePanel.add(name4);//Mean
        namePanel.add(num1);
        namePanel.add(name1);//Klong
        namePanel.add(num2);
        namePanel.add(name5);//Holmes
        namePanel.add(num3);
        namePanel.add(name2);//Smol Boz
        namePanel.add(num4);
        namePanel.add(name3);//Junbom
        namePanel.add(num5);
        namePanel.add(name6);//Big Boz
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

    public static CreditPanel getInstance() {
        if (instance == null) {
            instance = new CreditPanel();
        }
        return instance;
    }

    public void show() {
        fr.setVisible(true);
    }
}
