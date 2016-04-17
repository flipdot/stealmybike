package stealmybike.flipdot.org.stealmybike.events;

import stealmybike.flipdot.org.stealmybike.model.Event;

public abstract class EventHandler {
    public abstract void handle(Event event);
}
