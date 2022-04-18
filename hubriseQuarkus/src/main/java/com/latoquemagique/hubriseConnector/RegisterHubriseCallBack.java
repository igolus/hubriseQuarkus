package com.latoquemagique.hubriseConnector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.latoquemagique.dbmodel.Authentication;
import com.latoquemagique.dbmodel.AuthenticationByKeyLocation;
import com.latoquemagique.dbrepo.AuthenticationByKeyLocationRepo;
import com.latoquemagique.util.CallBackConfig;
import com.latoquemagique.util.HubriseClientUtil;
import hubriseModel.RootCallBack;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Base64;

import static com.latoquemagique.util.Constants.REGISTER_CALLBACK_HUBRISE_ACTION_URL;

@Path(REGISTER_CALLBACK_HUBRISE_ACTION_URL)
public class RegisterHubriseCallBack {

    @Inject
    Template redirect;

    @Inject
    AuthenticationByKeyLocationRepo authenticationByKeyLocationRepo;


    @GET
    @Produces(MediaType.TEXT_HTML)
    @Transactional
    @Path("/{keylocation}/{redirectUrl}/{callBackConfig}")
    public TemplateInstance add(
            @Context UriInfo uriInfo,
            @PathParam("keylocation") String keylocation,
            @PathParam("redirectUrl") String redirectUrl,
            @PathParam("callBackConfig") String callBackConfig,
            @QueryParam("code") String code) {

        String decodedRedirect =  new String(Base64.getDecoder().decode(redirectUrl));

        try {

            String decodedCallBackConfig =  new String(Base64.getDecoder().decode(callBackConfig));
            ObjectMapper mapper = new ObjectMapper();
            CallBackConfig callBackConfigObj = mapper.readValue(decodedCallBackConfig, CallBackConfig.class);
            Authentication authResponse = HubriseClientUtil.getInstance().connectWithCode(code);

            AuthenticationByKeyLocation item = new AuthenticationByKeyLocation();
            item.setKeyLocation(keylocation);
            item.setAuthentication(authResponse);
            //item.authentication = authResponse;
            authResponse.persist();
            //saveAuthentication(item);
            item.persist();
            //ConfManager.setMappingConfig(keylocation, authResponse);

            var requestUri = uriInfo.getRequestUri();
            String baseUriLocal = "https://" + requestUri.getAuthority();

            RootCallBack rootCallBack = HubriseClientUtil.getInstance()
                    .registerCallBack(authResponse.getAccess_token(), baseUriLocal, keylocation, callBackConfigObj);



            System.out.println("rootCallBack = " + rootCallBack);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return redirect.data("redirectUrl", decodedRedirect);
        //return Response.ok().build();
    }

    @Transactional
    public void saveAuthentication(AuthenticationByKeyLocation item) {
        item.persist();
    }
}