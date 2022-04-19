package com.latoquemagique.dbrepo;

import com.latoquemagique.dbmodel.AuthenticationByKeyLocation;
import com.latoquemagique.dbmodel.PrivateRefHubriseId;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PrivateRefHuriseIdRepo implements PanacheRepository<PrivateRefHubriseId> {
    public PrivateRefHubriseId findByPrivateRef(String privateRef) {
        return find("privateRef", privateRef).firstResult();
    }
}
