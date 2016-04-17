package stealmybike.flipdot.org.stealmybike.events;

import com.google.inject.Inject;

import stealmybike.flipdot.org.stealmybike.model.Event;

/**
 * Created by daniel on 17.04.16.
 */
public class EventDispatcher {
    private EventRenderer eventRenderer;
    private ExplicitAlarmHandler explicitAlarmHandler;

    @Inject
    public EventDispatcher(
            EventRenderer eventRenderer,
            ExplicitAlarmHandler explicitAlarmHandler
    ) {
        this.eventRenderer = eventRenderer;
        this.explicitAlarmHandler = explicitAlarmHandler;
    }

    public void dispatch(Event event) {
        EventHandler handler;
        switch (event.getType()) {
            case "TEXT": {
                handler = eventRenderer;
                break;
            }
            case "ALARM": {
                handler = explicitAlarmHandler;
                break;
            }
            default: {
                return;
            }
        }

        handler.handle(event);
    }
}

