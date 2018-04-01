package ifmo.lab5;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import ifmo.lab1.service.Country;
import ifmo.lab4.Lab4Client;
import lombok.val;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class Lab5Client extends Lab4Client{

    public Lab5Client(final String url) {
        super(url);
    }

    public void addCountry(Country country) throws IOException {
        WebResource resource = client.resource(url);

        ClientResponse response =  resource
                .type(MediaType.APPLICATION_JSON_TYPE)
                .put(ClientResponse.class, Entity.json(country));

        if (ClientResponse.Status.OK.getStatusCode() != response.getStatus()) {
            throw new IOException(response.getEntity(String.class));
        }
    }

    public void updateCountry(Country country) throws IOException {
        WebResource resource = client.resource(url);

        ClientResponse response = resource
                .type(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class, Entity.json(country));

        if (ClientResponse.Status.OK.getStatusCode() != response.getStatus()) {
            throw new IOException(response.getEntity(String.class));
        }
    }

    public void deleteCountry(String code) throws IOException {
        WebResource resource = client.resource(url)
                .queryParam("code", code);

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .delete(ClientResponse.class);

        if (ClientResponse.Status.OK.getStatusCode() != response.getStatus()) {
            throw new IOException(response.getEntity(String.class));
        }
    }

    public static void main(String[] args) throws IOException {
        val client = new Lab5Client("http://localhost:8080/rest/country");
        val country = client.getCountryByCode("DEU");
        country.setName("TEST");
        client.updateCountry(country);
        country.setCode("NEW");
        client.addCountry(country);
        client.deleteCountry("NEW");
    }
}
