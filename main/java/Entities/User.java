package Entities;

import com.datastax.driver.mapping.annotations.Frozen;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.HashMap;
import java.util.List;

@Table
public class User {

    @PrimaryKey
    private String id;

    private String name;
    private String username;
    private String emailID;
    private String address;
    private String branch;
    private long contact;
    private String password;
    private String esign;
    private String pin;
    private List<String> roles;
    private int no_of_approvals;
    private long avg_response_time;
    @Frozen
    private HashMap<String, titleContent> notifications;

    private HashMap<String, String> seals;

    public User(String id, String name, String username, String emailID, String address, String branch, long contact, String password, String esign, HashMap<String, titleContent> notifications, String pin, List<String> roles, int no_of_approvals, long avg_response_time, HashMap<String, String> seals) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.emailID = emailID;
        this.address = address;
        this.branch = branch;
        this.contact = contact;
        this.password = password;
        this.esign = esign;
        this.notifications = notifications;
        this.pin = pin;
        this.roles = roles;
        this.avg_response_time = avg_response_time;
        this.no_of_approvals = no_of_approvals;
        this.seals = seals;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEsign() {
        return esign;
    }

    public void setEsign(String esign) {
        this.esign = esign;
    }

    public HashMap<String, titleContent> getNotifications() {
        return notifications;
    }

    public void setNotifications(HashMap<String, titleContent> notifications) {
        this.notifications = notifications;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public int getNo_of_approvals() {
        return no_of_approvals;
    }

    public void setNo_of_approvals(int no_of_approvals) {
        this.no_of_approvals = no_of_approvals;
    }

    public long getAvg_response_time() {
        return avg_response_time;
    }

    public void setAvg_response_time(long avg_response_time) {
        this.avg_response_time = avg_response_time;
    }

    public HashMap<String, String> getSeals() {
        return seals;
    }

    public void setSeals(HashMap<String, String> seals) {
        this.seals = seals;
    }
}
