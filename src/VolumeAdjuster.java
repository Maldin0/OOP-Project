/**
 * @author Maldin0
 * @created 5/2/2023 - 12:28 PM
 * @project OOP-Project
 */
import javax.sound.sampled.*;

public class VolumeAdjuster implements Runnable {
    private final FloatControl volumeControl;
    private final int direction;

    public VolumeAdjuster(FloatControl volumeControl, int direction) {
        this.volumeControl = volumeControl;
        this.direction = direction;
    }

    @Override
    public void run() {
        float targetVolume = (direction == 1) ? volumeControl.getMaximum() : volumeControl.getMinimum();
        float currentVolume = volumeControl.getValue();
        float step = 0.5f * direction;

        while ((direction == 1 && currentVolume < targetVolume) || (direction == -1 && currentVolume > targetVolume)) {
            currentVolume += step;
            volumeControl.setValue(currentVolume);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
