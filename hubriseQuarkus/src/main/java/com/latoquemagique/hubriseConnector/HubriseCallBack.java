package com.latoquemagique.hubriseConnector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.latoquemagique.util.ConfManager;
import com.latoquemagique.util.HubriseClientUtil;
import customerBusiness.ProcessOrderFromHubrise;
import hubriseModel.CallBackBaseRoot;
import hubriseModel.CallBackCustomerRoot;
import hubriseModel.CallBackOrderRoot;
import hubriseModel.RootOrder;
import org.jboss.logging.Logger;
import util.ProcessOrderResponse;

import java.util.Base64;

import static com.latoquemagique.util.Constants.CALL_BACK_HUBRISE_URL;

@Path(CALL_BACK_HUBRISE_URL)
public class HubriseCallBack {

    @Inject
    Logger log;

    public static final String ORDER_RESOURCE = "order";
    public static final String CUSTOMER_RESOURCE = "customer";

    @POST
    @Path("{keylocation}")
    public Response add(@PathParam("keylocation") String keylocation, String callBackString) {
        System.out.println(callBackString);
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            String decodedKeylocation =  new String(Base64.getDecoder().decode(keylocation));
            CallBackBaseRoot callBackBaseRoot = objectMapper.readValue(callBackString, CallBackBaseRoot.class);
            if (callBackBaseRoot.getResource_type().equals(ORDER_RESOURCE)) {
                CallBackOrderRoot callBackOrderRoot = objectMapper.readValue(callBackString, CallBackOrderRoot.class);
                ProcessOrderResponse processOrderResponse = null;
                if (callBackOrderRoot.getPrevious_state() != null) {
                    processOrderResponse =
                            ProcessOrderFromHubrise.processSystemOrder(
                                    decodedKeylocation, callBackOrderRoot.getNew_state(), callBackOrderRoot.getPrevious_state());
                }
                else {
                    processOrderResponse =
                            ProcessOrderFromHubrise.processSystemNewOrder(
                                    decodedKeylocation, callBackOrderRoot.getNew_state());
                }

                System.out.println(callBackOrderRoot);
                if (processOrderResponse != null) {
                    ackOrder(processOrderResponse, callBackOrderRoot.getNew_state(), keylocation);
                    return Response.ok().build();
                }
                else {
                    return Response.ok().build();
                }
            }
            else if (callBackBaseRoot.getResource_type().equals(CUSTOMER_RESOURCE)) {
                CallBackCustomerRoot callBackOrderRoot = objectMapper.readValue(callBackString, CallBackCustomerRoot.class);
                boolean result;
                if (callBackOrderRoot.getPrevious_state() != null) {
                    result = ProcessOrderFromHubrise.processSystemCustomer(
                            decodedKeylocation, callBackOrderRoot.getNew_state(), callBackOrderRoot.getPrevious_state());
                }
                else {
                    result = ProcessOrderFromHubrise.processSystemNewCustomer(
                            decodedKeylocation, callBackOrderRoot.getNew_state());
                }
                System.out.println(callBackOrderRoot);
                if (result) {
                    return Response.ok().build();
                }
                else {
                    return Response.serverError().build();
                }
            }

        } catch (Exception e) {
            log.error("Unable to process input ", e);
            return Response.serverError().build();
        }

        return Response.ok().build();
    }


    private void ackOrder(ProcessOrderResponse processOrderResponse, RootOrder newOrder, String keyLocation) throws JsonProcessingException {
        RootOrder orderPatch = new RootOrder();
        orderPatch.setStatus(processOrderResponse.getOrderStatus());
        orderPatch.setConfirmed_time(newOrder.getConfirmed_time());
        orderPatch.setId(newOrder.getId());
        orderPatch.setPrivate_ref(processOrderResponse.getPrivate_ref());

        HubriseClientUtil.getInstance().updateOrderAfterProcess(orderPatch, keyLocation);
    }
}