package hubriseModel;

import java.util.ArrayList;

public class Events {

    private ArrayList<String> order;
    private ArrayList<String> customer;
    private ArrayList<String> location;
    private ArrayList<String> catalog;
    private ArrayList<String> inventory;

    public Events() {
    }

    public Events(ArrayList<String> order, ArrayList<String> customer, ArrayList<String> location, ArrayList<String> catalog, ArrayList<String> inventory) {
        this.order = order;
        this.customer = customer;
        this.location = location;
        this.catalog = catalog;
        this.inventory = inventory;
    }

    public ArrayList<String> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<String> order) {
        this.order = order;
    }

    public ArrayList<String> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<String> customer) {
        this.customer = customer;
    }

    public ArrayList<String> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }

    public ArrayList<String> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<String> catalog) {
        this.catalog = catalog;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }
}