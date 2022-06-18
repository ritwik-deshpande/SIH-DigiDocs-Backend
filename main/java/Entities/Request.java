package Entities;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType(value="Request")
public class Request {

    private String id;
    private String nameofSender;
    private String subject;
    private String status;
    private String date;
    private String receivedon;
    private boolean priority;

    public Request(String id, String nameofSender, String subject, String status, String date, String receivedon, boolean priority) {
        this.id = id;
        this.nameofSender = nameofSender;
        this.subject = subject;
        this.status = status;
        this.date = date;
        this.receivedon = receivedon;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNameofSender() {
        return nameofSender;
    }

    public void setNameofSender(String nameofSender) {
        this.nameofSender = nameofSender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReceivedon() {
        return receivedon;
    }

    public void setReceivedon(String receivedon) {
        this.receivedon = receivedon;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }
}
