package com.latoquemagique.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.latoquemagique.dbmodel.Authentication;
import com.latoquemagique.dbmodel.AuthenticationByKeyLocation;
import com.latoquemagique.dbrepo.AuthenticationByKeyLocationRepo;
import hubriseModel.Events;
import hubriseModel.RootCallBack;
import hubriseModel.RootOrder;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

import static com.latoquemagique.util.Constants.CALL_BACK_HUBRISE_URL;

public class HubriseClientUtil {

    private static final HubriseClientUtil instance = new HubriseClientUtil();
    public static final String X_ACCESS_TOKEN = "X-Access-Token";

//    private JacksonJsonProvider jackson_json_provider = new JacksonJaxbJsonProvider()
//            .configure(JsonParser.Feature.IGNORE_UNDEFINED, true);
//            .configure()
//            .configure(DeserializationConfig.  FAIL_ON_UNKNOWN_PROPERTIES, false)
//            .configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

//    private ObjectMapper object_mapper = jackson_json_provider.locateMapper(
//            Object.class, MediaType.APPLICATION_JSON_TYPE);


    private Client client =
            ClientBuilder
            .newClient();
//            .register(jackson_json_provider);
//
//    ClientWebTarget target = new ClientWebTarget(client, configuration);

    @Inject
    AuthenticationByKeyLocationRepo authenticationByKeyLocationRepo;

    private HubriseClientUtil() {
    }

    public static final HubriseClientUtil getInstance()
    {
        return instance;
    }

    String client_id = ConfigProvider.getConfig().getValue("hubrise.client_id", String.class);
    String country = ConfigProvider.getConfig().getValue("hubrise.country", String.class);
    String account_name = ConfigProvider.getConfig().getValue("hubrise.account_name", String.class);
    String client_secret= ConfigProvider.getConfig().getValue("hubrise.client_secret", String.class);

    public static final String BASE_URL = "https://manager.hubrise.com/";
    public static final String BASE_API_URL = "https://api.hubrise.com/";

    public Authentication connectWithCode(String code) {

        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder
                .append("oauth2/v1/token?code=")
                .append(code)
                .append("&client_id=")
                .append(client_id)
                .append("&client_secret=")
                .append(client_secret)
                .append("&account_name=")
                .append(account_name)
                .append("&country=")
                .append(country);

        Response post = client
                .target(urlBuilder.toString())
                .request(MediaType.APPLICATION_JSON)
                .post(null);
        Authentication authResponse = post.readEntity(Authentication.class);
        return authResponse;
    }

    public RootOrder updateOrderAfterProcess(RootOrder order, String keylocation) throws JsonProcessingException {
        StringBuilder urlBuilder = new StringBuilder(BASE_API_URL);
        urlBuilder
                .append("v1/location/orders/" + order.getId());

        AuthenticationByKeyLocationRepo authenticationByKeyLocationRepoInstance =
                new AuthenticationByKeyLocationRepo();
        AuthenticationByKeyLocation authenticationByKeyLocation
                = authenticationByKeyLocationRepoInstance.findByKeyLocation(keylocation);

        String authToken = authenticationByKeyLocation.getAuthentication().getAccess_token();

        RootOrder orderPatch = new RootOrder();
        orderPatch.setStatus(order.getStatus());
        orderPatch.setConfirmed_time(order.getConfirmed_time());
        orderPatch.setPrivate_ref(order.getPrivate_ref());

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonorderPatch = objectMapper.writeValueAsString(orderPatch);

        Response resp = client
                .target(urlBuilder.toString())
                .request(MediaType.APPLICATION_JSON)
                .header(X_ACCESS_TOKEN, authToken)
                .method("PATCH", javax.ws.rs.client.Entity.json(jsonorderPatch));

        System.out.println("resp = " + resp);
        RootOrder response = resp.readEntity(RootOrder.class);
        return response;
    }

    public RootCallBack registerCallBack(String authToken, String baseUrl,
                                         String keylocation, CallBackConfig callBackConfigObj) {
        StringBuilder urlBuilder = new StringBuilder(BASE_API_URL);
        urlBuilder
                .append("v1/callback");

        RootCallBack rootCallBack = new RootCallBack();
            rootCallBack.setUrl(baseUrl + CALL_BACK_HUBRISE_URL + "/" + keylocation);

        Events events = new Events();
        ArrayList<String> ordersConf =  new ArrayList<>();
        ArrayList<String> customerConf =  new ArrayList<>();
        ArrayList<String> locationConf =  new ArrayList<>();
        ArrayList<String> catalogConf =  new ArrayList<>();
        ArrayList<String> inventoryConf =  new ArrayList<>();

        if (callBackConfigObj.isOrder_create() || callBackConfigObj.isOrder_update()) {
            if (callBackConfigObj.isOrder_create()) {
                ordersConf.add("create");
            }
            if (callBackConfigObj.isOrder_update()) {
                ordersConf.add("update");
            }

        }
        events.setOrder(ordersConf);

        if (callBackConfigObj.isCustomer_create() || callBackConfigObj.isCustomer_update()) {
            if (callBackConfigObj.isCustomer_create()) {
                customerConf.add("create");
            }
            if (callBackConfigObj.isCustomer_update()) {
                customerConf.add("update");
            }

        }
        events.setCustomer(customerConf);


        if (callBackConfigObj.isLocation_update()) {
            if (callBackConfigObj.isLocation_update()) {
                locationConf.add("update");
            }

        }
        events.setLocation(locationConf);

        if (callBackConfigObj.isCatalog_create() || callBackConfigObj.isCatalog_update()) {
            if (callBackConfigObj.isCatalog_create()) {
                catalogConf.add("create");
            }
            if (callBackConfigObj.isCatalog_update()) {
                catalogConf.add("update");
            }

        }
        events.setCatalog(catalogConf);

        if (callBackConfigObj.isInventory_patch() || callBackConfigObj.isInventory_update()) {
            if (callBackConfigObj.isInventory_patch()) {
                inventoryConf.add("patch");
            }
            if (callBackConfigObj.isInventory_update()) {
                inventoryConf.add("update");
            }

        }
        events.setInventory(inventoryConf);

        rootCallBack.setEvents(events);

        Response post = client
                .target(urlBuilder.toString())
                .request(MediaType.APPLICATION_JSON)
                .header(X_ACCESS_TOKEN, authToken)
                .post(Entity.entity(rootCallBack, MediaType.APPLICATION_JSON));
        RootCallBack response = post.readEntity(RootCallBack.class);
        return response;
    }
}
