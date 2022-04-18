package hubriseModel;

import java.util.ArrayList;

public class EventsLocation {
    private ArrayList<String> location;

    public EventsLocation() {
    }

    public EventsLocation(ArrayList<String> values) {
        this.location = values;
    }

    public ArrayList<String> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }
}