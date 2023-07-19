package dk.sdu.cbse.common.events;

import dk.sdu.cbse.common.Entity;
import java.io.Serializable;

public class Event implements Serializable{
    private final Entity source;

    public Event(Entity source) {
        this.source = source;
    }

    public Entity getSource() {
        return source;
    }
}
