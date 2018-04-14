package ifmo.lab7;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.juddi.api_v3.Publisher;
import org.apache.juddi.api_v3.SavePublisher;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.transport.TransportException;
import org.apache.juddi.v3_service.JUDDIApiPortType;
import org.uddi.api_v3.*;
import org.uddi.v3_service.DispositionReportFaultMessage;
import org.uddi.v3_service.UDDISecurityPortType;

import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

/**
 * This shows you to interact with a UDDI server by publishing a Business,
 * Service and Binding Template. It uses some fairly generic code that should be
 * mostly portable to any other UDDI client library and is therefore consider
 * "portable". URLs are set in uddi.xml
 *
 */
public class JuddiPublisher {

    private static UDDIClient uddiClient;

    public void publishBusiness(UDDIClerk clerk) {
        // Creating the parent business entity that will contain our service.
        BusinessEntity myBusEntity = new BusinessEntity();
        Name myBusName = new Name();
        myBusName.setValue("WSDL-Business");
        myBusEntity.getName().add(myBusName);
        myBusEntity.setBusinessKey("uddi:uddi.andrey.com:business_WSDL-Business");
        clerk.register(myBusEntity);
    }

    public void publishWSDL(UDDIClerk clerk) throws MalformedURLException {
        // Register the wsdls for this clerk, referenced in the wsdl2uddi-uddi.xml
        clerk.registerWsdls(new URL("http://localhost:18080"));
    }

    public static void publishSample () {

        System.out.println("1. Bring up the hello world endpoint at port 18080");
        Endpoint helloWorldEndPoint = Endpoint.create(new HelloWorldImpl());
        helloWorldEndPoint.publish("http://localhost:18080/services/helloworld");

        System.out.println("2. Programmatically publish the endpoint to UDDI");
        JuddiPublisher sp = new JuddiPublisher();
        try {
            uddiClient = new UDDIClient("META-INF/uddi.xml");
            UDDIClerk clerk = uddiClient.getClerk("andrey");

            System.out.println("setting up the publisher");
            sp.setupAndreyPublisher(clerk);
            System.out.println("publish the business");
            sp.publishBusiness(clerk);
            System.out.println("and the wsdl");
            sp.publishWSDL(clerk);

            System.out.println("waiting for calls into the HelloWorldImpl...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This setup needs to be done once, either using the console or using code like this
    private void setupAndreyPublisher(UDDIClerk clerk) throws DispositionReportFaultMessage, RemoteException, ConfigurationException, TransportException {

        UDDISecurityPortType security = uddiClient.getTransport("default").getUDDISecurityService();

        //login as root so we can create joe publisher
        GetAuthToken getAuthTokenRoot = new GetAuthToken();
        getAuthTokenRoot.setUserID("root");
        getAuthTokenRoot.setCred("");
        // Making API call that retrieves the authentication token for the 'root' user.
        AuthToken rootAuthToken = security.getAuthToken(getAuthTokenRoot);
        System.out.println("root AUTHTOKEN = " + rootAuthToken.getAuthInfo());
        //Creating andrey publisher THIS IS JUDDI Specific code
        JUDDIApiPortType juddiApi = uddiClient.getTransport("default").getJUDDIApiService();
        Publisher p = new Publisher();
        p.setAuthorizedName("andrey");
        p.setPublisherName("Andrey Publisher");
        // Adding the publisher to the "save" structure, using the 'root' user authentication info and saving away.
        SavePublisher sp = new SavePublisher();
        sp.getPublisher().add(p);
        sp.setAuthInfo(rootAuthToken.getAuthInfo());
        juddiApi.savePublisher(sp);
        //END jUDDI specific code

        //Every publisher should have a keyGenerator, Joe has his:
        TModel keyGenerator = new TModel();
        keyGenerator.setTModelKey("uddi:uddi.joepublisher.com:keygenerator");
        Name name = new Name();
        name.setValue("Andrey Publisher's Key Generator");
        keyGenerator.setName(name);
        Description description = new Description();
        description.setValue("This is the key generator for Andrey Publisher's UDDI entities!");
        keyGenerator.getDescription().add(description);
        OverviewDoc overviewDoc = new OverviewDoc();
        OverviewURL overviewUrl = new OverviewURL();
        overviewUrl.setUseType("text");
        overviewUrl.setValue("http://uddi.org/pubs/uddi_v3.htm#keyGen");
        overviewDoc.setOverviewURL(overviewUrl);
        keyGenerator.getOverviewDoc().add(overviewDoc);
        CategoryBag categoryBag = new CategoryBag();
        KeyedReference keyedReference = new KeyedReference();
        keyedReference.setKeyName("uddi-org:types:keyGenerator");
        keyedReference.setKeyValue("keyGenerator");
        keyedReference.setTModelKey("uddi:uddi.org:categorization:types");
        categoryBag.getKeyedReference().add(keyedReference);
        keyGenerator.setCategoryBag(categoryBag);
        clerk.register(keyGenerator);
    }
}
