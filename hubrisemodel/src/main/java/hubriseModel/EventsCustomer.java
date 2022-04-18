package hubriseModel;

import java.util.ArrayList;

public class EventsCustomer {
    private ArrayList<String> customer;

    public EventsCustomer() {
    }

    public EventsCustomer(ArrayList<String> values) {
        this.customer = values;
    }

    public ArrayList<String> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<String> customer) {
        this.customer = customer;
    }
}