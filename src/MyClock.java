import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MyClock extends JLabel implements Runnable {
    private boolean running;
    private int time;
    public MyClock() {
        Font font = new Font("Monospaced", Font.BOLD, 50);
        this.setFont(font);
        this.running = true;
        this.time = 0;
    }
    @Override
    public void run() {
        while (true) {
//                Calendar d = Calendar.getInstance();
//                int sec = d.get(Calendar.SECOND);
//                int min = d.get(Calendar.MINUTE);
//                int hour = d.get(Calendar.HOUR_OF_DAY);
//                this.setText(String.format("%02d:%02d:%02d", hour, min, sec));
            try {
                if(running) {
                    time++;
                    int hour = time / 3600;
                    int min = (time / 60) % 60;
                    int sec = time % 60;
                    this.setText(String.format("%02d:%02d:%02d", hour, min, sec));
                }
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }

        }
    }
    public boolean getRunning() {
        return running;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
}