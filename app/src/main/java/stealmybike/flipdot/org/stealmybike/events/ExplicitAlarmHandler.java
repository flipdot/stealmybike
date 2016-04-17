package stealmybike.flipdot.org.stealmybike.events;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import stealmybike.flipdot.org.stealmybike.AlarmHandler;
import stealmybike.flipdot.org.stealmybike.model.Event;

/**
 * Created by daniel on 17.04.16.
 */
@Singleton
public class ExplicitAlarmHandler extends EventHandler {
    private AlarmHandler alarmHandler;

    @Inject
    public ExplicitAlarmHandler(AlarmHandler alarmHandler) {
        this.alarmHandler = alarmHandler;
    }

    @Override
    public void handle(Event event) {
        alarmHandler.raiseAlarm();
    }
}
