package stealmybike.flipdot.org.stealmybike;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import com.google.inject.Inject;

/**
 * Created by daniel on 17.04.16.
 */
public class NotificationHandler {
    private Context context;

    @Inject
    public NotificationHandler(
            Context context
    ) {
        this.context = context;
    }

    public void showNotify() {
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = new Notification.Builder(context)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("ALARM! ALARM! ALARM!")
                .setContentText("Fahrrad wurde geklaut!")
                .build();

        notificationManager.notify(1, notification);
    }
}
