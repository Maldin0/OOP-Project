import java.io.*;

public class ScoreIO {

    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TimeData.dat"))) {
            oos.writeObject(MyFrame.scoreTime);
            System.out.println("Saved");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TimeData.dat"))) {
            ScoreTime loadedScore = (ScoreTime) ois.readObject();
            MyFrame.scoreTime.setEasyTime(loadedScore.getEasyTime());
            MyFrame.scoreTime.setNormalTime(loadedScore.getNormalTime());
            MyFrame.scoreTime.setHardTime(loadedScore.getHardTime());
            System.out.println("Loaded");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
