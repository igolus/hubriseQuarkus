package com.latoquemagique.hubriseConnector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.latoquemagique.util.CallBackConfig;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Base64;

import org.jboss.logging.Logger;

import static com.latoquemagique.util.Constants.CONNECT_HUBRISE_ACTION_URL;
import static com.latoquemagique.util.Constants.REGISTER_CALLBACK_HUBRISE_ACTION_URL;

@Path(CONNECT_HUBRISE_ACTION_URL)

public class ConnectHubriseAction {

    @ConfigProperty(name = "hubrise.client_id")
    String client_id;

    @ConfigProperty(name = "hubrise.country")
    String country;

    @ConfigProperty(name = "hubrise.account_name")
    String account_name;

    @Inject
    Template redirect;

    @Inject
    Logger log;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance post(
            @Context UriInfo uriInfo,
            @FormParam("ordersScope") String ordersScope,
            @FormParam("customerListScope") String customerListScope,
            @FormParam("catalogScope") String catalogScope,
            @FormParam("keylocation") String keylocation,
            @FormParam("redirecturi") String redirecturi,
            @FormParam("order.create") String order_create,
            @FormParam("order.update") String order_update,
            @FormParam("customer.create") String customer_create,
            @FormParam("customer.update") String customer_update,
            @FormParam("location.update") String location_update,
            @FormParam("catalog.create") String catalog_create,
            @FormParam("catalog.update") String catalog_update,
            @FormParam("inventory.patch") String inventory_patch,
            @FormParam("inventory.update") String inventory_update

            )
    {
        CallBackConfig callBackConfig = new CallBackConfig();

        callBackConfig.setOrder_create(order_create != null);
        callBackConfig.setOrder_update(order_update != null);

        callBackConfig.setCustomer_create(customer_create != null);
        callBackConfig.setCustomer_update(customer_update != null);

        callBackConfig.setLocation_update(location_update != null);

        callBackConfig.setCatalog_create(catalog_create != null);
        callBackConfig.setCatalog_update(catalog_update != null);

        callBackConfig.setInventory_update(inventory_update != null);
        callBackConfig.setInventory_patch(inventory_patch != null);



        var requestUri = uriInfo.getRequestUri();
        String baseUriLocal = requestUri.getAuthority();
        System.out.println(keylocation);

        StringBuilder urlBuiler = new StringBuilder("https://manager.hubrise.com/oauth2/v1/authorize?");
        try {

            ObjectMapper mapper = new ObjectMapper();
            String jsonRepCallBackConfig = mapper.writeValueAsString(callBackConfig);

            urlBuiler
                    .append("redirect_uri=")
                    .append("https" + "://" + baseUriLocal)
                    .append(REGISTER_CALLBACK_HUBRISE_ACTION_URL + "/")
                    .append(Base64.getEncoder().encodeToString(keylocation.getBytes()))
                    .append("/")
                    .append(Base64.getEncoder().encodeToString(redirecturi.getBytes()))
                    .append("/")
                    .append(Base64.getEncoder().encodeToString(jsonRepCallBackConfig.getBytes()))
                    .append("&client_id=")
                    .append(client_id)
                    .append("&account_name=")
                    .append(account_name)
                    .append("&country=")
                    .append(country)
                    .append("&scope=location[");
        } catch (Exception e) {
            log.error("Unable to build connect urk", e);
        }

        StringBuilder scopeLocations = new StringBuilder();
        if (!ordersScope.equals("0")) {
            if (ordersScope.equals("1")) {
                scopeLocations.append("orders.read ");
            }
            if (ordersScope.equals("2")) {
                scopeLocations.append("orders.write ");
            }
        }
        if (!customerListScope.equals("0")) {
            if (customerListScope.equals("1")) {
                scopeLocations.append("customer_list.read ");
            }
            if (customerListScope.equals("2")) {
                scopeLocations.append("customer_list.write ");
            }
        }
        if (!catalogScope.equals("0")) {
            if (catalogScope.equals("1")) {
                scopeLocations.append("catalog.read ");
            }
            if (catalogScope.equals("2")) {
                scopeLocations.append("catalog.write ");
            }
        }
        String scopeLocationsComma = scopeLocations.toString().trim().replace(' ', ',');
        urlBuiler.append(scopeLocationsComma);

        urlBuiler.append("]");
        return redirect.data("redirectUrl", urlBuiler.toString());
    }
}