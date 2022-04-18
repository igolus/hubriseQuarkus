package hubriseModel;

public class Discount {

    public Discount(String name, String ref, String price_off) {
        this.name = name;
        this.ref = ref;
        this.price_off = price_off;
    }

    public Discount() {
    }

    private String name;
    private String ref;
    private String price_off;

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

    public String getPrice_off() {
        return price_off;
    }

    public void setPrice_off(String price_off) {
        this.price_off = price_off;
    }
}
