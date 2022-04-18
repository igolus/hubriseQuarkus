package hubriseModel;

import java.util.ArrayList;

public class EventsInventory {
    private ArrayList<String> inventory;

    public EventsInventory() {
    }

    public EventsInventory(ArrayList<String> values) {
        this.inventory = values;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }
}