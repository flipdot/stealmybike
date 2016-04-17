package stealmybike.flipdot.org.stealmybike.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;

import com.google.inject.Inject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.UUID;

import stealmybike.flipdot.org.stealmybike.events.EventHandler;
import stealmybike.flipdot.org.stealmybike.model.Event;

/**
 * Created by daniel on 17.04.16.
 */
public class ReceiveBluetoothTask extends AsyncTask<String, Event, Boolean> {

    private EventHandler eventHandler;

    @Inject
    public ReceiveBluetoothTask(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> bondDevices = bluetoothAdapter.getBondedDevices();

        String macAdress = params[0];
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(macAdress);
        BluetoothSocket socket;
        try {
            socket = device.createInsecureRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            socket.connect();

            BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while((line = reader.readLine()) != null) {
                Event event = Event.parse(line);
                publishProgress(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    protected void onProgressUpdate(Event... values) {
        eventHandler.handle(values[0]);
    }
}
