package ifmo.lab4;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import ifmo.lab1.service.Country;
import lombok.val;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

public class Lab4Client {
    private final Client client;

    private final String url;

    public Lab4Client(final String url) {
        this.url = url;
        final ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
        client = Client.create(clientConfig);
    }

    public Country getCountryByCode(String code) {
        final WebResource resource = client.resource(url)
                .queryParam("code", code);

        final ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        final val type = new GenericType<Country>() {};

        if (ClientResponse.Status.OK.getStatusCode() != response.getStatus()) {
            throw new RuntimeException();
        }

        return response.getEntity(type);
    }

    public List<Country> searchCountry(String term) {
        final WebResource resource = client.resource(url + "/search")
                .queryParam("term", term);

        final ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        final val type = new GenericType<List<Country>>() {};

        if (ClientResponse.Status.OK.getStatusCode() != response.getStatus()) {
            throw new RuntimeException();
        }

        return response.getEntity(type);
    }

    public static void main(String[] args) {
        val client = new Lab4Client("http://localhost:8080/rest/country");
        System.out.println(client.getCountryByCode("USA"));
        System.out.println(Arrays.toString(client.searchCountry("Germ").toArray()));
    }
}
