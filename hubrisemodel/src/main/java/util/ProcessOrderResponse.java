package util;

import hubriseModel.OrderStatus;

import java.util.Date;

public class ProcessOrderResponse {
    private String orderStatus;
    private String private_ref;
    private Date confirmed_time;

    public ProcessOrderResponse() {
    }

    public ProcessOrderResponse(String orderStatus, String private_ref, Date confirmed_time) {
        this.orderStatus = orderStatus;
        this.private_ref = private_ref;
        this.confirmed_time = confirmed_time;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getConfirmed_time() {
        return confirmed_time;
    }

    public void setConfirmed_time(Date confirmed_time) {
        this.confirmed_time = confirmed_time;
    }

    public String getPrivate_ref() {
        return private_ref;
    }

    public void setPrivate_ref(String private_ref) {
        this.private_ref = private_ref;
    }
}
