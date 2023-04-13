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

        backBtn = new JButton("Back To Main Menu");
        panel1.setLayout(new GridLayout(3,2));
        panel2.setLayout(new FlowLayout());
        panel1.add(devName1);//Klong
        panel1.add(artName4);//Mean
        panel1.add(devName2);//Smol Boz
        panel1.add(artName5);//Holmes
        panel1.add(devName3);//Junbom
        panel1.add(artName6);//Big Boz
        panel2.add(backBtn);

        fr.setLayout(new GridLayout(2,1));
        fr.add(panel1);
        fr.add(panel2);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new CreditPanel();
    }
}
