package Entities;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType(value="notif")
public class notif {

    private String title;
    private String content;

    public notif(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
