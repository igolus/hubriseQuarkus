package hubriseModel;

class DealLine {

    public DealLine(String deal_key, String label) {
        this.deal_key = deal_key;
        this.label = label;
    }

    public DealLine() {
    }

    private String deal_key;
    private String label;

    public String getDeal_key() {
        return deal_key;
    }

    public void setDeal_key(String deal_key) {
        this.deal_key = deal_key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
