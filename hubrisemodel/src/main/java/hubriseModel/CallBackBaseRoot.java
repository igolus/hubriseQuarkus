package hubriseModel;

public class CallBackBaseRoot {

    public CallBackBaseRoot(String resource_type, String event_type, RootOrder new_state) {
        this.resource_type = resource_type;
        this.event_type = event_type;
    }

    public CallBackBaseRoot() {
    }

    protected String resource_type;
    protected String event_type;

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
}
