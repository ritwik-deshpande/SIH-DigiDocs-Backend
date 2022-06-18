package Entities;

import com.datastax.shaded.jackson.annotation.JsonIgnoreProperties;
import com.datastax.shaded.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Table
public class Workflow {
    @PrimaryKey
    private String id;

    private String User;
    private String Title;

    private String Feedback;
    private String Feedback_ts;
    private List<String> send_requests;
    private List<String> cancel_requests;
    private String status;
    private String jsonString;
    private String begin_timestamp;
    private String end_timestamp;
    private Boolean priority;
    private String hash;

    public Workflow() {
    }

    public Workflow(String id, String User, String Title, String Feedback, String Feedback_ts, List<String> send_requests, List<String> cancel_requests, String status, String jsonString, String begin_timestamp, String end_timestamp, Boolean priority, String hash) {
        this.id = id;
        this.User = User;
        this.Title = Title;
        this.Feedback = Feedback;
        this.Feedback_ts = Feedback_ts;
        this.send_requests = send_requests;
        this.cancel_requests = cancel_requests;
        this.status = status;
        this.jsonString = jsonString;
        this.begin_timestamp = begin_timestamp;
        this.end_timestamp = end_timestamp;
        this.priority = priority;
        this.hash = hash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }

    public String getFeedback_ts() {
        return Feedback_ts;
    }

    public void setFeedback_ts(String feedback_ts) {
        Feedback_ts = feedback_ts;
    }

    public List<String> getSend_requests() {
        return send_requests;
    }

    public void setSend_requests(List<String> send_requests) {
        this.send_requests = send_requests;
    }

    public List<String> getCancel_requests() {
        return cancel_requests;
    }

    public void setCancel_requests(List<String> cancel_requests) {
        this.cancel_requests = cancel_requests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public String getBegin_timestamp() {
        return begin_timestamp;
    }

    public void setBegin_timestamp(String begin_timestamp) {
        this.begin_timestamp = begin_timestamp;
    }

    public String getEnd_timestamp() {
        return end_timestamp;
    }

    public void setEnd_timestamp(String end_timestamp) {
        this.end_timestamp = end_timestamp;
    }

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void mapData(String json) throws JSONException, IOException {
        JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();
        ObjectMapper objectMapper = new ObjectMapper();
        this.id = jsonObj.get("id").getAsString();
        this.User = jsonObj.get("User").getAsString();
        this.Title = jsonObj.get("Title").getAsString();
        this.Feedback = jsonObj.get("Feedback").getAsString();
        this.Feedback_ts = jsonObj.get("Feedback_ts").getAsString();
        this.send_requests = objectMapper.readValue(jsonObj.get("send_requests").toString(), List.class);
        this.cancel_requests = objectMapper.readValue(jsonObj.get("cancel_requests").toString(), List.class);
        this.status = jsonObj.get("status").getAsString();
        this.jsonString = json;
        this.begin_timestamp = jsonObj.get("begin_timestamp").getAsString();
        this.end_timestamp = jsonObj.get("end_timestamp").getAsString();
        this.priority = jsonObj.get("priority").getAsBoolean();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append( this.getClass().getName() );
        result.append( " Object \n" );
        result.append(newLine);

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        //print field names paired with their values
        for ( Field field : fields  ) {
            result.append("  ");
            try {
                result.append( field.getName() );
                result.append(": ");
                //requires access to private field:
                result.append( field.get(this) );
            } catch ( IllegalAccessException ex ) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("\n");

        return result.toString();
    }
}




