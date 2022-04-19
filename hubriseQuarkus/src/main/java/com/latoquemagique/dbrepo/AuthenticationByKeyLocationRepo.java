package com.latoquemagique.dbrepo;

import com.latoquemagique.dbmodel.AuthenticationByKeyLocation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Base64;

@ApplicationScoped
public class AuthenticationByKeyLocationRepo implements PanacheRepository<AuthenticationByKeyLocation> {
    public AuthenticationByKeyLocation findByKeyLocation(String keyLocation) {
        String base64Key = Base64.getEncoder().encodeToString(keyLocation.getBytes());
        return find("keyLocation", base64Key).firstResult();
    }
}
