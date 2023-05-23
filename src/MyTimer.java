import javax.swing.*;
import java.awt.*;


/**
 * @author Maldin0
 * @created 5/4/2023 - 8:18 PM
 * @project OOP-Lab
 */
public class MyTimer extends JLabel implements Runnable {
    public boolean isEnable = true;
    private int sec;
    private int min;
    private int hour;

    public MyTimer() {
        this.sec = 0;
        this.min = 0;
        this.hour = 0;
    }

    public synchronized void resumeTimer() {
        isEnable = true;
        this.notify();
    }

    public synchronized void pauseTimer() {
        isEnable = false;
    }

    private synchronized void checkPause() {
        while (!isEnable) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            checkPause();
            this.setFont(new Font("Tahoma", Font.BOLD, 30));
            this.setText(String.format("%02d : %02d : %02d", hour, min, sec));

            try {
                // Wait for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sec++;
            if (sec == 60) {
                sec = 0;
                min++;
                if (min == 60) {
                    min = 0;
                    hour++;
                }
            }
        }
    }
}
