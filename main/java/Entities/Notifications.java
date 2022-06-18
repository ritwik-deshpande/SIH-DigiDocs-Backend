package Entities;

import com.datastax.driver.mapping.annotations.Frozen;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table
public class Notifications {

    @PrimaryKey
    private String id;

    @Frozen
    private List<notif> notifs;

    public Notifications(String id, List<notif> notifs) {
        this.id = id;
        this.notifs = notifs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<notif> getNotifs() {
        return notifs;
    }

    public void setNotifs(List<notif> notifs) {
        this.notifs = notifs;
    }
}




