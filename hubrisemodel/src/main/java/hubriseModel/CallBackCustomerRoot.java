package hubriseModel;

public class CallBackCustomerRoot {

    public CallBackCustomerRoot() {
    }

    private String resource_type;
    private String event_type;
    private RootCustomer new_state;
    private RootCustomer previous_state;

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public RootCustomer getNew_state() {
        return new_state;
    }

    public void setNew_state(RootCustomer new_state) {
        this.new_state = new_state;
    }

    public RootCustomer getPrevious_state() {
        return previous_state;
    }

    public void setPrevious_state(RootCustomer previous_state) {
        this.previous_state = previous_state;
    }
}
