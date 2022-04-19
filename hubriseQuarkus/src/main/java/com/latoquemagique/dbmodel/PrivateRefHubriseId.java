package com.latoquemagique.dbmodel;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class PrivateRefHubriseId extends PanacheEntity {
    private String hubRiseId;
    private String privateRef;
    private String keylocation;

    public PrivateRefHubriseId() {
    }

    public PrivateRefHubriseId(String hubRiseId, String privateRef, String keylocation) {
        this.hubRiseId = hubRiseId;
        this.privateRef = privateRef;
        this.keylocation = keylocation;
    }

    public String getHubRiseId() {
        return hubRiseId;
    }

    public void setHubRiseId(String hubRiseId) {
        this.hubRiseId = hubRiseId;
    }

    public String getPrivateRef() {
        return privateRef;
    }

    public void setPrivateRef(String privateRef) {
        this.privateRef = privateRef;
    }

    public String getKeylocation() {
        return keylocation;
    }

    public void setKeylocation(String keylocation) {
        this.keylocation = keylocation;
    }
}
