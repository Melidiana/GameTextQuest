package model;

public class GameTextQuestResult {

    private String message;
    private String[] options;
    private boolean showImage;
    private boolean showImage1;
    private boolean finished;

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

    public boolean showImage() {
        return showImage;
    }

    public void setShowImage(boolean showImage) {
        this.showImage = showImage;
    }

    public boolean showImage1() {
        return showImage1;
    }

    public void setShowImage1(boolean showImage1) {
        this.showImage1 = showImage1;
    }

    public boolean finished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
