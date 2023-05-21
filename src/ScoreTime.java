import java.io.Serializable;

public class ScoreTime implements Serializable {
    private String easyTime;
    private String normalTime;
    private String hardTime;

    public ScoreTime() {
        this("-", "-", "-");
    }

    public ScoreTime(String easyTime, String normalTime, String hardTime) {
        this.easyTime = easyTime;
        this.normalTime = normalTime;
        this.hardTime = hardTime;
    }

    public String getEasyTime() {
        return easyTime;
    }

    public void setEasyTime(String easyTime) {
        this.easyTime = easyTime;
    }

    public String getNormalTime() {
        return normalTime;
    }

    public void setNormalTime(String normalTime) {
        this.normalTime = normalTime;
    }

    public String getHardTime() {
        return hardTime;
    }

    public void setHardTime(String hardTime) {
        this.hardTime = hardTime;
    }
}
