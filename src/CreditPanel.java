import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreditPanel implements ActionListener {
    private JFrame fr;
    private JPanel creditPanel;
    private JLabel Name1, Name2, Name3, Name4, Name5, Name6;
    private JButton backBtn;

    public CreditPanel(){
        fr = new JFrame("Credit");
        Font thaiFont = new Font("Tahoma", Font.BOLD, 14);
        fr.getContentPane().setPreferredSize(new Dimension(400, 300));
        Color yellow = new Color(255,236,138);

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
        Name1 = new JLabel("นายก้องภพ สินสังข์ 65070015");
        Name2 = new JLabel("นายจิรกิตต์ มราชชาลี 65070034");
        Name3 = new JLabel("นายจุนบอม คิม 65070040");
        Name4 = new JLabel("นางสาวกนลรัตน์ เบิกขุนทด 65070007");
        Name5 = new JLabel("นายกิตติพล สิริอมรกิติ์ 65070019");
        Name6 = new JLabel("นายชัยพิพัฒน์ พงษ์ประภาชื่น 65070047");

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
        creditPanel.add(Name1);//Klong
        creditPanel.add(Name4);//Mean
        creditPanel.add(Name2);//Smol Boz
        creditPanel.add(Name5);//Holmes
        creditPanel.add(Name3);//Junbom
        creditPanel.add(Name6);//Big Boz

        //Everything on frame
        fr.add(creditPanel);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
        fr.setLayout(null);
        fr.setLocationRelativeTo(null);
        fr.setResizable(false);
    }
    //ActionPerformed for Button set visible to false
    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource().equals(backBtn)) {
            fr.setVisible(false);
        }
    }
}
//Note to myself ทำไมไม่ลองให้มันสร้างหน้าต่างขึ้นมาเลยแต่ให้ การมองเห็นเป็น False แทนล่ะ พอกดคลิกก็เปลี่ยนเป็น True