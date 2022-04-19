package customerBusiness;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import hubriseModel.OrderStatus;
import hubriseModel.RootCustomer;
import hubriseModel.RootOrder;
import util.ProcessOrderResponse;

import java.util.UUID;

public class ProcessOrderFromHubrise {

    private static String orderSourceSample = "{\n" +
            "  \"status\": \"new\",\n" +
            "  \"service_type\": \"collection\",\n" +
            "  \"total\": \"11.90 EUR\",\n" +
            "  \"customer\": {\n" +
            "    \"first_name\": \"John\",\n" +
            "    \"last_name\": \"Doe\",\n" +
            "    \"address_1\": \"13 Yellow Street\",\n" +
            "    \"postal_code\": \"NE1 1ZC\",\n" +
            "    \"city\": \"London\",\n" +
            "    \"country\": \"GB\",\n" +
            "    \"phone\": \"+44123456789\"\n" +
            "  },\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"price\": \"12.90 EUR\",\n" +
            "      \"quantity\": \"1\",\n" +
            "      \"product_name\": \"Carbonara\",\n" +
            "      \"sku_ref\": \"81502\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static ProcessOrderResponse processSystemNewOrder(String keyLocation, RootOrder newOrder) {
        System.out.println("keyLocation = " + keyLocation);
        System.out.println("comingOrder = " + newOrder);
        return new ProcessOrderResponse(
                OrderStatus.RECEIVED.getValue(),
                UUID.randomUUID().toString(),
                newOrder.getExpected_time()
        );
    }

    public static ProcessOrderResponse processSystemOrder(String keyLocation, RootOrder newOrder, RootOrder oldOrder) {
        System.out.println("keyLocation = " + keyLocation);
        System.out.println("comingOrder = " + newOrder);
        return null;
    }

    public static boolean processSystemNewCustomer(String keyLocation, RootCustomer newCustomer) {
        //Code your business logic here
        //insert the order in your system
        System.out.println("keyLocation = " + keyLocation);
        System.out.println("comingOrder = " + newCustomer);
        return true;
    }

    public static boolean processSystemCustomer(String keyLocation, RootCustomer newCustomer, RootCustomer oldCustomer) {
        //Code your business logic here
        //insert the order in your system
        System.out.println("keyLocation = " + keyLocation);
        System.out.println("comingOrder = " + newCustomer);
        return true;
    }

    public static RootOrder buildOrderFromPrivateRef(String privateRef) throws JsonProcessingException {
        System.out.println("privateRef = " + privateRef);
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        RootOrder rootOrder = objectMapper.readValue(orderSourceSample, RootOrder.class);
        rootOrder.setPrivate_ref(privateRef);
        return rootOrder;
    }
}
