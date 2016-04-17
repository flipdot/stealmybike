package stealmybike.flipdot.org.stealmybike.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

import stealmybike.flipdot.org.stealmybike.events.EventDispatcher;
import stealmybike.flipdot.org.stealmybike.model.Event;

/**
 * Created by daniel on 17.04.16.
 */
@Singleton
public class ReceiveBluetoothTask extends AsyncTask<String, Event, Boolean> {

    private EventDispatcher eventDispatcher;
    private DateTime lastUpdated;

    @Inject
    public ReceiveBluetoothTask(EventDispatcher eventRenderer) {
        this.eventDispatcher = eventRenderer;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        String macAdress = params[0];
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(macAdress);
        BluetoothSocket socket;

        while(true) {
            try {
                socket = device.createInsecureRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
                socket.connect();

                BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String line;
                while((line = reader.readLine()) != null) {
                    Event event = Event.parse(line);
                    if(event == null) {
                        continue;
                    }

                    lastUpdated = DateTime.now();
                    publishProgress(event);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onProgressUpdate(Event... values) {
        eventDispatcher.dispatch(values[0]);
    }

    public DateTime getLastUpdated() {
        return lastUpdated;
    }
}
