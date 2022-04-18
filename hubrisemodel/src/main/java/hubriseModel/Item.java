package hubriseModel;

import java.util.ArrayList;

public class Item {

    public Item(String product_name, String sku_ref, String sku_name, String price, String quantity, ArrayList<Option> options, DealLine deal_line, String points_used) {
        this.product_name = product_name;
        this.sku_ref = sku_ref;
        this.sku_name = sku_name;
        this.price = price;
        this.quantity = quantity;
        this.options = options;
        this.deal_line = deal_line;
        this.points_used = points_used;
    }

    private String product_name;
    private String sku_ref;
    private String sku_name;
    private String price;
    private String quantity;
    private ArrayList<Option> options;
    private DealLine deal_line;
    private String points_used;

    public Item() {

    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSku_ref() {
        return sku_ref;
    }

    public void setSku_ref(String sku_ref) {
        this.sku_ref = sku_ref;
    }

    public String getSku_name() {
        return sku_name;
    }

    public void setSku_name(String sku_name) {
        this.sku_name = sku_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public DealLine getDeal_line() {
        return deal_line;
    }

    public void setDeal_line(DealLine deal_line) {
        this.deal_line = deal_line;
    }

    public String getPoints_used() {
        return points_used;
    }

    public void setPoints_used(String points_used) {
        this.points_used = points_used;
    }
}
