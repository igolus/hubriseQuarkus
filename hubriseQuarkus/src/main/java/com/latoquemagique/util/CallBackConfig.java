package com.latoquemagique.util;

import javax.ws.rs.FormParam;

public class CallBackConfig {
    private boolean order_create;
    private boolean order_update;
    private boolean customer_create;
    private boolean customer_update;
    private boolean location_update;
    private boolean catalog_create;
    private boolean catalog_update;
    private boolean inventory_patch;
    private boolean inventory_update;

    public CallBackConfig() {
    }

    public boolean isOrder_create() {
        return order_create;
    }

    public void setOrder_create(boolean order_create) {
        this.order_create = order_create;
    }

    public boolean isOrder_update() {
        return order_update;
    }

    public void setOrder_update(boolean order_update) {
        this.order_update = order_update;
    }

    public boolean isCustomer_create() {
        return customer_create;
    }

    public void setCustomer_create(boolean customer_create) {
        this.customer_create = customer_create;
    }

    public boolean isCustomer_update() {
        return customer_update;
    }

    public void setCustomer_update(boolean customer_update) {
        this.customer_update = customer_update;
    }

    public boolean isLocation_update() {
        return location_update;
    }

    public void setLocation_update(boolean location_update) {
        this.location_update = location_update;
    }

    public boolean isCatalog_create() {
        return catalog_create;
    }

    public void setCatalog_create(boolean catalog_create) {
        this.catalog_create = catalog_create;
    }

    public boolean isCatalog_update() {
        return catalog_update;
    }

    public void setCatalog_update(boolean catalog_update) {
        this.catalog_update = catalog_update;
    }

    public boolean isInventory_patch() {
        return inventory_patch;
    }

    public void setInventory_patch(boolean inventory_patch) {
        this.inventory_patch = inventory_patch;
    }

    public boolean isInventory_update() {
        return inventory_update;
    }

    public void setInventory_update(boolean inventory_update) {
        this.inventory_update = inventory_update;
    }
}
