package mozal.spring.responses;

/**
 * Created by Monika on 2016-04-11.
 */
public class BasicResponse {
    private boolean result = false;
    private String text;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
