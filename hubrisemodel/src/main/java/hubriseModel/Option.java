package hubriseModel;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
org.acme.rest.json.hubriseModel.Root root = om.readValue(myJsonString, org.acme.rest.json.hubriseModel.Root.class); */
class Option {

    public Option(String option_list_name, String name, String ref, String price, int quantity) {
        this.option_list_name = option_list_name;
        this.name = name;
        this.ref = ref;
        this.price = price;
        this.quantity = quantity;
    }

    public Option() {
    }

    private String option_list_name;
    private String name;
    private String ref;
    private String price;
    private int quantity;

    public String getOption_list_name() {
        return option_list_name;
    }

    public void setOption_list_name(String option_list_name) {
        this.option_list_name = option_list_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
