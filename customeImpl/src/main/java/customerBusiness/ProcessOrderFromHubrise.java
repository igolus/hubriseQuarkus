package customerBusiness;

import hubriseModel.OrderStatus;
import hubriseModel.RootCustomer;
import hubriseModel.RootOrder;
import util.ProcessOrderResponse;

import java.util.UUID;

public class ProcessOrderFromHubrise {


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
}
