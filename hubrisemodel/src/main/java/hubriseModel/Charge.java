package hubriseModel;

public class Charge {

    public Charge(String name, String ref, String price) {
        this.name = name;
        this.ref = ref;
        this.price = price;
    }

    public Charge() {
    }

    private String name;
    private String ref;
    private String price;

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
}
