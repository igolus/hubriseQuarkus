package hubriseModel;

public class LoyaltyOperation {

    public LoyaltyOperation(String ref, String delta, String reason) {
        this.ref = ref;
        this.delta = delta;
        this.reason = reason;
    }

    public LoyaltyOperation() {
    }

    private String ref;
    private String delta;
    private String reason;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDelta() {
        return delta;
    }

    public void setDelta(String delta) {
        this.delta = delta;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
