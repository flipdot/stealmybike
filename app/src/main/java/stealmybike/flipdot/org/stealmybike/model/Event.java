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
        return "Event{" +
                "type='" + type + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public static Event parse(String line) {
        return new Event("msg", line);
    }
}
