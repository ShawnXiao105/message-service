package mymessage;

import org.springframework.data.annotation.Id;


public class Message {

    @Id
    public String id;

    public String fromAddress;
    public String toAddress;
    public String title;
    public String content;

    public Message() {}

    public Message(String fromAddress, String toAddress, String title, String content) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format(
                "Message[id=%s, fromAddress='%s', toAddress='%s', title='%s', content='%s']",
                id, fromAddress, toAddress, title, content);
    }

}