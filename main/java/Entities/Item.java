package Entities;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType(value="Item")
public class Item {

    private String id;
    private String task;
    private boolean checked;

    public Item(String id, String task, boolean checked) {
        this.id = id;
        this.task = task;
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
