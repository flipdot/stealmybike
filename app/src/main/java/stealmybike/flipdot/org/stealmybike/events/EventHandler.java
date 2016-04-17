package stealmybike.flipdot.org.stealmybike.events;

import com.google.inject.Inject;

import stealmybike.flipdot.org.stealmybike.model.Event;

/**
 * Created by daniel on 17.04.16.
 */
public class EventHandler {
    private EventRenderer eventRenderer;
    private NotificationHandler notificationHandler;

    @Inject
    public EventHandler(
            EventRenderer eventRenderer,
            NotificationHandler notificationHandler
    ) {
        this.eventRenderer = eventRenderer;
        this.notificationHandler = notificationHandler;
    }

    public void handle(Event event) {
        eventRenderer.render(event);
        notificationHandler.handle(event);
    }
}
