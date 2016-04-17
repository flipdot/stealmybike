package stealmybike.flipdot.org.stealmybike.events;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import stealmybike.flipdot.org.stealmybike.MainActivtyUiElements;
import stealmybike.flipdot.org.stealmybike.model.Event;

/**
 * Created by daniel on 17.04.16.
 */
@Singleton
public class EventRenderer {

    private MainActivtyUiElements uiElements;

    @Inject
    public EventRenderer(
            MainActivtyUiElements uiElements
    ) {
        this.uiElements = uiElements;
    }

    public void render(Event event) {
        String text = uiElements.getEventLogElm().getText().toString();
        text = event.toString() + "\n" + text;
        uiElements.getEventLogElm().setText(text);
    }
}
