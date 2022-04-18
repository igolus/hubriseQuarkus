package hubriseModel;

public class Payment {

    public Payment(String name, String ref, String amount, Info info) {
        this.name = name;
        this.ref = ref;
        this.amount = amount;
        this.info = info;
    }

    public Payment() {
    }

    private String name;
    private String ref;
    private String amount;
    private Info info;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
