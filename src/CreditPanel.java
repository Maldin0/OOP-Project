import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreditPanel{
    private JFrame fr;
    private JPanel panel;
    private JLabel name1, name2, name3, name4, name5, name6;
    private JButton backBtn;

    public CreditPanel(){
        fr = new JFrame("Credit");
        panel = new JPanel();
        name1 = new JLabel("นางสาวกนลรัตน์ เบิกขุนทด");
        name2 = new JLabel("นายก้องภพ สินสังข์");
        name3 = new JLabel("นายกิตติพล สิริอมรกิติ์");
        name4 = new JLabel("นายจิรกิตต์ มราชชาลี");
        name5 = new JLabel("นายจุนบอม คิม");
        name6 = new JLabel("นายชัยพิพัฒน์ พงษ์ประภาชื่น");
        backBtn = new JButton("Back To Main Menu");

        panel.add(name1);
        panel.add(name2);
        panel.add(name3);
        panel.add(name4);
        panel.add(name5);
        panel.add(name6);
        panel.add(backBtn);
        panel.setLayout(new GridLayout(3,3));

        fr.add(panel);
        fr.setLayout(new FlowLayout());
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500,500);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new CreditPanel();
    }
}
