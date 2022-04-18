package com.latoquemagique.dbrepo;

import com.latoquemagique.dbmodel.AuthenticationByKeyLocation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationByKeyLocationRepo implements PanacheRepository<AuthenticationByKeyLocation> {
    public AuthenticationByKeyLocation findByKeyLocation(String keyLocation) {
        return find("keyLocation", keyLocation).firstResult();
    }
}
