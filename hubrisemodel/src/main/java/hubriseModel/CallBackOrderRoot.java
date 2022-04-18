package hubriseModel;

public class CallBackOrderRoot {

    public CallBackOrderRoot() {
    }

    private String resource_type;
    private String event_type;
    private RootOrder new_state;
    private RootOrder previous_state;

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

    public RootOrder getNew_state() {
        return new_state;
    }

    public void setNew_state(RootOrder new_state) {
        this.new_state = new_state;
    }

    public RootOrder getPrevious_state() {
        return previous_state;
    }

    public void setPrevious_state(RootOrder previous_state) {
        this.previous_state = previous_state;
    }
}
