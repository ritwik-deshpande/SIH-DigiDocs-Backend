package Entities;

import com.datastax.shaded.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.IOException;

@Table
public class Forms {

    @PrimaryKey
    private String id;

    private String title;
    private String schema;
    private String uischema;
    private String json;

    public Forms(){
    }

    public Forms(String id, String title, String schema, String uischema, String json) throws IOException {
        this.id = id;
        this.title = title;
        this.schema = schema;
        this.uischema = uischema;
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

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getUischema() {
        return uischema;
    }

    public void setUischema(String uischema) {
        this.uischema = uischema;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public void mapData(String formString) {
        JsonObject jsonObj = new JsonParser().parse(formString).getAsJsonObject();
        ObjectMapper objectMapper = new ObjectMapper();
        this.id = jsonObj.get("id").getAsString();
        this.json = formString;
        //this.schema = jsonObj.get("schema").getAsString();
        this.schema = "Schema";
        this.title = jsonObj.get("title").getAsString();
        //this.uischema = jsonObj.get("uischema").getAsString();
        this.uischema = "uischema";
    }
}




