package hubriseModel;

public class AuthResponse {
    private String access_token;
    private String account_id;
    private String location_id;
    private String catalog_id;
    private String customer_list_id;
    private String account_name;
    private String location_name;
    private String catalog_name;
    private String customer_list_name;

    public AuthResponse(String access_token, String account_id, String location_id, String catalog_id, String customer_list_id, String account_name, String location_name, String catalog_name, String customer_list_name) {
        this.access_token = access_token;
        this.account_id = account_id;
        this.location_id = location_id;
        this.catalog_id = catalog_id;
        this.customer_list_id = customer_list_id;
        this.account_name = account_name;
        this.location_name = location_name;
        this.catalog_name = catalog_name;
        this.customer_list_name = customer_list_name;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(String catalog_id) {
        this.catalog_id = catalog_id;
    }

    public String getCustomer_list_id() {
        return customer_list_id;
    }

    public void setCustomer_list_id(String customer_list_id) {
        this.customer_list_id = customer_list_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getCatalog_name() {
        return catalog_name;
    }

    public void setCatalog_name(String catalog_name) {
        this.catalog_name = catalog_name;
    }

    public String getCustomer_list_name() {
        return customer_list_name;
    }

    public void setCustomer_list_name(String customer_list_name) {
        this.customer_list_name = customer_list_name;
    }

    public AuthResponse() {


    }
}
