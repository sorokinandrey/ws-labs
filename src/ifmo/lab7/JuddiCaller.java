package ifmo.lab7;

import ifmo.lab7.samples.HelloWorld;
import ifmo.lab7.samples.HelloWorld_Service;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.mapping.ServiceLocator;

import javax.xml.ws.BindingProvider;
import java.util.Map;

public class JuddiCaller {


    public static void callSample() {
        try {
            UDDIClient uddiClient = new UDDIClient("META-INF/uddi.xml");
            UDDIClerk clerk = uddiClient.getClerk("andrey");

            //find the service in the UDDI registry
            System.out.println("The clientside of a runtime lookup usually knows the serviceKey.");
            System.out.println("To get updated binding information you should use the ServiceLocator with a live cache.");
            String helloWorldServiceKey = "uddi:uddi.joepublisher.com:service_helloworld";

            ServiceLocator serviceLocator = new ServiceLocator(clerk);
            String endpoint = serviceLocator.lookupEndpoint(helloWorldServiceKey);
            HelloWorld_Service helloWorldService = new HelloWorld_Service();
            HelloWorld helloWorld = helloWorldService.getHelloWorldImplPort();
            Map<String, Object> requestContext = ((BindingProvider) helloWorld).getRequestContext();
            requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
            String reply = helloWorld.sayHi("Judy");
            System.out.println("*************** Service reply: " + reply);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
