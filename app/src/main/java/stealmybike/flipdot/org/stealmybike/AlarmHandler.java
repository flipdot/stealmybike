package stealmybike.flipdot.org.stealmybike;

import android.content.Context;
import android.os.Vibrator;

import com.google.inject.Inject;

/**
 * Created by daniel on 17.04.16.
 */
public class AlarmHandler {
    private Context context;
    private NotificationHandler notificationHandler;

    @Inject
    public AlarmHandler(
            Context context,
            NotificationHandler  notificationHandler
    ) {
        this.context = context;
        this.notificationHandler = notificationHandler;
    }

    public void raiseAlarm() {
        notificationHandler.showNotify();

        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1000 * 2);
    }
}
