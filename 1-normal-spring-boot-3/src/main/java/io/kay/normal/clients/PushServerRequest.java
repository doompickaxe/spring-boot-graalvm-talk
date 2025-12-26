package io.kay.normal.clients;

public class PushServerRequest {

    private String content;

    public PushServerRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
