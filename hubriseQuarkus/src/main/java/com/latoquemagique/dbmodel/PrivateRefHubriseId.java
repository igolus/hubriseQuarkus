package com.latoquemagique.dbmodel;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class PrivateRefHubriseId extends PanacheEntity {
    public String hubRiseId;
    public String privateRef;
    public String keylocation;
}
