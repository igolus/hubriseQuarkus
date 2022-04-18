package hubriseModel;

public class RootCallBack {
    private String url;
    private Events events;

    public RootCallBack() {
    }

    public RootCallBack(String url, Events events) {
        this.url = url;
        this.events = events;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }
}
