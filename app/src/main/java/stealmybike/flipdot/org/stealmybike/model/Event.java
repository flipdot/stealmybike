package stealmybike.flipdot.org.stealmybike.model;

/**
 * Created by daniel on 17.04.16.
 */
public class Event {
    private String type;
    private String data;

    public Event(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }


    /*
    * type and data is seperated by a equal-sign. Possible types:
    *
    * - text: display text on screen
    * - alarm: trigger an alarm
    * */
    public static Event parse(String line) {
        String[] splitted = line.split("=");

        if(splitted.length != 2) {
            return null;
        }

        return new Event(splitted[0], splitted[1]);
    }
}
