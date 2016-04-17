package stealmybike.flipdot.org.stealmybike;

import android.widget.TextView;

/**
 * Created by daniel on 17.04.16.
 */
public class MainActivtyUiElements {
    private TextView eventLogElm;

    public MainActivtyUiElements(TextView eventLogElm) {
        this.eventLogElm = eventLogElm;
    }

    public TextView getEventLogElm() {
        return eventLogElm;
    }
}
