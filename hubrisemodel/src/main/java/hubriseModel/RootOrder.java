package hubriseModel;

import java.util.ArrayList;
import java.util.Date;

public class RootOrder {

    public RootOrder() {

    }

    private String private_ref;
    private String id;
    private String status;
    private String service_type;
    private String service_type_ref;
    private Date expected_time;
    private Date confirmed_time;
    private String customer_id;
    private ArrayList<Item> items;
    private ArrayList<LoyaltyOperation> loyalty_operations;
    private ArrayList<Charge> charges;
    private ArrayList<Payment> payments;
    private ArrayList<Discount> discounts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getConfirmed_time() {
        return confirmed_time;
    }

    public void setConfirmed_time(Date confirmed_time) {
        this.confirmed_time = confirmed_time;
    }

    public String getPrivate_ref() {
        return private_ref;
    }

    public void setPrivate_ref(String private_ref) {
        this.private_ref = private_ref;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getService_type_ref() {
        return service_type_ref;
    }

    public void setService_type_ref(String service_type_ref) {
        this.service_type_ref = service_type_ref;
    }

    public Date getExpected_time() {
        return expected_time;
    }

    public void setExpected_time(Date expected_time) {
        this.expected_time = expected_time;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<LoyaltyOperation> getLoyalty_operations() {
        return loyalty_operations;
    }

    public void setLoyalty_operations(ArrayList<LoyaltyOperation> loyalty_operations) {
        this.loyalty_operations = loyalty_operations;
    }

    public ArrayList<Charge> getCharges() {
        return charges;
    }

    public void setCharges(ArrayList<Charge> charges) {
        this.charges = charges;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }
}