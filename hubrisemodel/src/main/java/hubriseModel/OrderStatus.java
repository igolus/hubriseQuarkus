package hubriseModel;

public enum OrderStatus {
    NEW("new"),
    RECEIVED("received"),
    ACCEPTED("accepted"),
    IN_PREPARATION("in_preparation"),
    AWAITING_SHIPMENT("awaiting_shipment"),
    AWAITING_COLLECTION("awaiting_collection"),
    IN_DELIVERY("in_delivery"),
    COMPLETED("completed"),
    REJECTED("rejected"),
    CANCELLED("cancelled"),
    DELIVERY_FAILED("delivery_failed");

    private String value;

    private OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
