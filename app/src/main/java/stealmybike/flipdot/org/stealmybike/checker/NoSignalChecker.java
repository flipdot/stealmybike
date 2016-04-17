package stealmybike.flipdot.org.stealmybike.checker;

import android.content.Context;
import android.os.Vibrator;

import com.google.inject.Inject;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import stealmybike.flipdot.org.stealmybike.AlarmHandler;
import stealmybike.flipdot.org.stealmybike.bluetooth.ReceiveBluetoothTask;

/**
 * Created by daniel on 17.04.16.
 */
public class NoSignalChecker implements Runnable {

    private AlarmHandler alarmHandler;
    private ReceiveBluetoothTask receiveBluetoothTask;

    @Inject
    public NoSignalChecker(
            AlarmHandler alarmHandler,
            ReceiveBluetoothTask receiveBluetoothTask
    ) {
        this.alarmHandler = alarmHandler;
        this.receiveBluetoothTask = receiveBluetoothTask;
    }

    @Override
    public void run() {
        DateTime lastUpdated = receiveBluetoothTask.getLastUpdated();

        DateTime now = DateTime.now();
        Duration duration = new Duration(lastUpdated, now);
        if(duration.getStandardSeconds() > 1) {
            alarmHandler.raiseAlarm();
        }
    }
}
