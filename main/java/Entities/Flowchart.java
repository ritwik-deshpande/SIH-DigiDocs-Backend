package Entities;

import com.datastax.shaded.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Flowchart {

    @PrimaryKey
    private String id;

    private String title;
    private String json;

    public Flowchart() {
    }

    public Flowchart(String id, String title, String json) {
        this.id = id;
        this.title = title;
        this.json = json;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public void mapData(String flowchartString) {
        JsonObject jsonObj = new JsonParser().parse(flowchartString).getAsJsonObject();
        ObjectMapper objectMapper = new ObjectMapper();
        this.id = jsonObj.get("id").getAsString();
        this.json = flowchartString;
        this.title = jsonObj.get("title").getAsString();
    }
}




