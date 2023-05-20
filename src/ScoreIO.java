import java.io.*;

public class ScoreIO {
    private ScoreBoardPanel scoreBoardPanel;
    private ScoreTime scoreTime;
    private File file;

    public ScoreIO() {
        scoreTime = new ScoreTime();

        file = new File("TimeData.dat");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveData() {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(scoreTime);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadData() {
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                scoreTime = (ScoreTime) ois.readObject();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("File not found.");
        }
    }
}
