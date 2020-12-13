package app.sharma.kissnebola;

import com.google.gson.annotations.SerializedName;

public class CustomMessage {
    @SerializedName("text")
    private String text;
    @SerializedName("name")
    private String name;
    @SerializedName("secrete")
    private String secrete;
    @SerializedName("time")
    private String time;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecrete() {
        return secrete;
    }

    public void setSecrete(String secrete) {
        this.secrete = secrete;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CustomMessage() {
    }

    public CustomMessage(String text, String name, String secrete, String time) {
        this.text = text;
        this.name = name;
        this.secrete = secrete;
        this.time = time;
    }
}
