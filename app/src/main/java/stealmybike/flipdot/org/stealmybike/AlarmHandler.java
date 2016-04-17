package stealmybike.flipdot.org.stealmybike;

import android.content.Context;
import android.os.Vibrator;

import com.google.inject.Inject;

/**
 * Created by daniel on 17.04.16.
 */
public class AlarmHandler {
    private Context context;

    @Inject
    public AlarmHandler(Context context) {
        this.context = context;
    }

    public void raiseAlarm() {
        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1000 * 2);
    }
}
