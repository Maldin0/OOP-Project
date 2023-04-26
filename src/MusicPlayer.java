import java.io.*;
import javax.sound.sampled.*;

public class MusicPlayer {
    private Clip clip;
    private FloatControl volumeControl;

    public void play(String filename) {
        try {
            File file = new File(filename);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Get the volume control of the clip
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error playing music file: " + ex.getMessage());
        }
    }
    public void mute() {
        if (volumeControl != null) {
            volumeControl.setValue(volumeControl.getMinimum());
        }
    }

    public void unmute() {
        if (volumeControl != null) {
            volumeControl.setValue(volumeControl.getMaximum());
        }
    }
}
