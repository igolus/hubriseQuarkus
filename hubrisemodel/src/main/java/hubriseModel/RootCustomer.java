package hubriseModel;

import java.util.ArrayList;
import java.util.Date;

public class RootCustomer {
    private String id;
    private String customer_list_id;
    private boolean anonymised;
    private Object private_ref;
    private String email;
    private String first_name;
    private String last_name;
    private String gender;
    private Object birth_date;
    private Object company_name;
    private String phone;
    private String address_1;
    private Object address_2;
    private String postal_code;
    private String city;
    private Object state;
    private String country;
    private String latitude;
    private String longitude;
    private Object delivery_notes;
    private boolean sms_marketing;
    private boolean email_marketing;
    private int nb_orders;
    private String order_total;
    private Date first_order_date;
    private Date last_order_date;
    private ArrayList<LoyaltyCard> loyalty_cards;

    public RootCustomer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer_list_id() {
        return customer_list_id;
    }

    public void setCustomer_list_id(String customer_list_id) {
        this.customer_list_id = customer_list_id;
    }

    public boolean isAnonymised() {
        return anonymised;
    }

    public void setAnonymised(boolean anonymised) {
        this.anonymised = anonymised;
    }

    public Object getPrivate_ref() {
        return private_ref;
    }

    public void setPrivate_ref(Object private_ref) {
        this.private_ref = private_ref;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Object getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Object birth_date) {
        this.birth_date = birth_date;
    }

    public Object getCompany_name() {
        return company_name;
    }

    public void setCompany_name(Object company_name) {
        this.company_name = company_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public Object getAddress_2() {
        return address_2;
    }

    public void setAddress_2(Object address_2) {
        this.address_2 = address_2;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Object getDelivery_notes() {
        return delivery_notes;
    }

    public void setDelivery_notes(Object delivery_notes) {
        this.delivery_notes = delivery_notes;
    }

    public boolean isSms_marketing() {
        return sms_marketing;
    }

    public void setSms_marketing(boolean sms_marketing) {
        this.sms_marketing = sms_marketing;
    }

    public boolean isEmail_marketing() {
        return email_marketing;
    }

    public void setEmail_marketing(boolean email_marketing) {
        this.email_marketing = email_marketing;
    }

    public int getNb_orders() {
        return nb_orders;
    }

    public void setNb_orders(int nb_orders) {
        this.nb_orders = nb_orders;
    }

    public String getOrder_total() {
        return order_total;
    }

    public void setOrder_total(String order_total) {
        this.order_total = order_total;
    }

    public Date getFirst_order_date() {
        return first_order_date;
    }

    public void setFirst_order_date(Date first_order_date) {
        this.first_order_date = first_order_date;
    }

    public Date getLast_order_date() {
        return last_order_date;
    }

    public void setLast_order_date(Date last_order_date) {
        this.last_order_date = last_order_date;
    }

    public ArrayList<LoyaltyCard> getLoyalty_cards() {
        return loyalty_cards;
    }

    public void setLoyalty_cards(ArrayList<LoyaltyCard> loyalty_cards) {
        this.loyalty_cards = loyalty_cards;
    }
}
