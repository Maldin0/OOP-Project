import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class MusicPlayer {
    private FloatControl volumeControl;
    private boolean isMuted = false;

    public void play(String filename) {
        try {
            URL url = this.getClass().getResource(filename);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
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
        if (volumeControl != null && !isMuted) {
            isMuted = true;
            adjustVolume(-1);
        }
    }

    public void unmute() {
        if (volumeControl != null && isMuted) {
            isMuted = false;
            adjustVolume(1);
        }
    }

    private void adjustVolume(int direction) {
        // Adjust the volume gradually
        VolumeAdjuster volumeAdjuster = new VolumeAdjuster(volumeControl, direction);
        new Thread(volumeAdjuster).start();
    }
}
