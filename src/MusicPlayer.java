import java.io.*;
import javax.sound.sampled.*;

public class MusicPlayer {
    private Clip clip;
    private boolean isPaused = false;

    public void play(String filename) {
        try {
            File file = new File(filename);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error playing music file: " + ex.getMessage());
        }
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            isPaused = true;
        }
    }

    public void resume() {
        if (clip != null && isPaused) {
            clip.start();
            isPaused = false;
        }
    }
}

