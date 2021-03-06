package stealmybike.flipdot.org.stealmybike;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import stealmybike.flipdot.org.stealmybike.bluetooth.ReceiveBluetoothTask;
import stealmybike.flipdot.org.stealmybike.checker.NoSignalChecker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivtyUiElements mainActivtyUiElements = new MainActivtyUiElements(
                (TextView)findViewById(R.id.eventLog)
        );

        AppInject.init(
                this.getApplicationContext(),
                mainActivtyUiElements
        );

        NoSignalChecker checker = AppInject.get(NoSignalChecker.class);

        ReceiveBluetoothTask receiveBluetoothTask = AppInject.get(ReceiveBluetoothTask.class);
        receiveBluetoothTask.execute("00:80:25:08:54:D4");

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(checker, 10, 1, TimeUnit.SECONDS);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
