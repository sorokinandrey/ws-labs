package ifmo.lab1;

import javax.xml.ws.Endpoint;

public class App {

    public static void main(String[] args) {
        String url = "http://0.0.0.0:8080/CountriesService";
        Endpoint.publish(url, new CountriesWebService());
    }
}
