package model;

public class GameTextQuestResult {

    private String message;
    private String[] options;
    private boolean isVictory;
    private boolean isLoss;
    private boolean isFinish;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public boolean isVictory() {
        return isVictory;
    }

    public void setVictory(boolean victory) {
        isVictory = victory;
    }

    public boolean isLoss() {
        return isLoss;
    }

    public void setLoss(boolean loss) {
        isLoss = loss;
    }

    public boolean isFinish() {
        return isFinish;
    }
}
