package com.latoquemagique.dbmodel;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AuthenticationByKeyLocation extends PanacheEntity {
    public String keyLocation;
    @ManyToOne
    public Authentication authentication;

    public AuthenticationByKeyLocation() {

    }

    public String getKeyLocation() {
        return keyLocation;
    }

    public void setKeyLocation(String keyLocation) {
        this.keyLocation = keyLocation;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }
}
