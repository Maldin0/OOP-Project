import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreditPanel {
    private JFrame fr;
    private JPanel panel1, panel2;
    private JLabel devName1, devName2, devName3, artName4, artName5, artName6;
    private JButton backBtn;

    public CreditPanel(){
        fr = new JFrame("Credit");
        Font thaiFont = new Font("Tahoma", Font.BOLD, 14);

        panel1 = new JPanel();
        panel2 = new JPanel();
        devName1 = new JLabel("นายก้องภพ สินสังข์ 65070015");
        devName2 = new JLabel("นายจิรกิตต์ มราชชาลี 65070034");
        devName3 = new JLabel("นายจุนบอม คิม 65070040");
        artName4 = new JLabel("นางสาวกนลรัตน์ เบิกขุนทด 65070007");
        artName5 = new JLabel("นายกิตติพล สิริอมรกิติ์ 65070019");
        artName6 = new JLabel("นายชัยพิพัฒน์ พงษ์ประภาชื่น 65070047");

        devName1.setFont(thaiFont);
        devName2.setFont(thaiFont);
        devName3.setFont(thaiFont);
        artName4.setFont(thaiFont);
        artName5.setFont(thaiFont);
        artName6.setFont(thaiFont);

        backBtn = new JButton();
        ImageIcon imgBtn = new ImageIcon("image/Back button.png");
        backBtn.setIcon(imgBtn);
        backBtn.setBounds(10, 15, 50, 50);
        panel1.add(backBtn);
        /*
        panel1.add(devName1);//Klong
        panel1.add(artName4);//Mean
        panel1.add(devName2);//Smol Boz
        panel1.add(artName5);//Holmes
        panel1.add(devName3);//Junbom
        panel1.add(artName6);//Big Boz
         */
        fr.add(backBtn);
        fr.setLayout(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(700, 500);
        fr.setVisible(true);
    }
    /*public void actionPerformed(ActionEvent ac) {
        if (backB)
    }*/
    public static void main(String[] args) {
        new CreditPanel();
    }
}
//Note to myself ทำไมไม่ลองให้มันสร้างหน้าต่างขึ้นมาเลยแต่ให้ การมองเห็นเป็น False แทนล่ะ พอกดคลิกก็เปลี่ยนเป็น True