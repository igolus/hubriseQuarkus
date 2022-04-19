package com.latoquemagique.hubriseConnector;

import com.latoquemagique.dbmodel.AuthenticationByKeyLocation;
import com.latoquemagique.dbmodel.PrivateRefHubriseId;
import com.latoquemagique.dbrepo.AuthenticationByKeyLocationRepo;
import com.latoquemagique.dbrepo.PrivateRefHuriseIdRepo;
import com.latoquemagique.util.HubriseClientUtil;
import customerBusiness.ProcessOrderFromHubrise;
import hubriseModel.RootCallBack;
import hubriseModel.RootOrder;
import org.jboss.logging.Logger;
import util.ProcessOrderResponse;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import static com.latoquemagique.util.Constants.UPDATE_CREATE_ORDER_HUBRISE_URL;


@Path(UPDATE_CREATE_ORDER_HUBRISE_URL)
public class UpdateCreateOrder {

    @Inject
    Logger log;

    @POST
    @Transactional
    @Path("{keylocation}/{privateRef}")
    public Response add(
            @PathParam("keylocation") String keyLocation,
            @PathParam("privateRef") String privateRef) {
        try {
            PrivateRefHuriseIdRepo privateRefHuriseIdRepo =
                    new PrivateRefHuriseIdRepo();

            RootOrder rootOrder = ProcessOrderFromHubrise.buildOrderFromPrivateRef(privateRef);

            PrivateRefHubriseId byPrivateRef = privateRefHuriseIdRepo.findByPrivateRef(privateRef);
            if (byPrivateRef == null) {
                AuthenticationByKeyLocationRepo authenticationByKeyLocationRepoInstance =
                        new AuthenticationByKeyLocationRepo();
                AuthenticationByKeyLocation authenticationByKeyLocation
                        = authenticationByKeyLocationRepoInstance.findByKeyLocation(keyLocation);
                if (authenticationByKeyLocation != null) {
                    String token = authenticationByKeyLocation.getAuthentication().getAccess_token();
                    RootOrder orderCreated = HubriseClientUtil.getInstance().createOrder(token, rootOrder);

                    PrivateRefHubriseId privateRefHubriseId = new PrivateRefHubriseId();
                    privateRefHubriseId.setPrivateRef(privateRef);
                    privateRefHubriseId.setHubRiseId(orderCreated.getId());
                    privateRefHubriseId.setKeylocation(keyLocation);
                    privateRefHubriseId.persist();
                }
            }
        }
        catch (Exception e) {
            log.error("Unable to import order ", e);
            return Response.serverError().build();
        }


        return Response.ok().build();
    }
}
