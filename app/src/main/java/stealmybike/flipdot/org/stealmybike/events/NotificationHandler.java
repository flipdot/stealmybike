package stealmybike.flipdot.org.stealmybike.events;

import android.content.Context;
import android.os.Vibrator;

import com.google.inject.Inject;

import stealmybike.flipdot.org.stealmybike.model.Event;

/**
 * Created by daniel on 17.04.16.
 */
public class NotificationHandler {
    private Context context;

    @Inject
    public NotificationHandler(Context context) {
        this.context = context;
    }

    public void handle(Event event) {
        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1000 * 2);
    }
}
