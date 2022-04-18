package hubriseModel;

import java.util.ArrayList;

public class EventsCatalog {
    private ArrayList<String> catalog;

    public EventsCatalog() {
    }

    public EventsCatalog(ArrayList<String> values) {
        this.catalog = values;
    }

    public ArrayList<String> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<String> catalog) {
        this.catalog = catalog;
    }
}