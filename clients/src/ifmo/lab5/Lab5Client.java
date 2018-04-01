package ifmo.lab5;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import ifmo.lab1.service.Country;
import ifmo.lab4.Lab4Client;
import lombok.val;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class Lab5Client extends Lab4Client{

    public Lab5Client(final String url) {
        super(url);
    }

    public void addCountry(Country country) {
        WebResource resource = client.resource(url);

        resource
                .type(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.json(country));
    }

    public void updateCountry(Country country) {
        WebResource resource = client.resource(url);

        resource
                .type(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(country));
    }

    public void deleteCountry(String code) {
        WebResource resource = client.resource(url)
                .queryParam("code", code);

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .delete(ClientResponse.class);

        if (ClientResponse.Status.OK.getStatusCode() != response.getStatus()) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        val client = new Lab5Client("http://localhost:8080/rest/country");
        val country = client.getCountryByCode("DEU");
        country.setName("TEST");
        client.updateCountry(country);
        country.setCode("NEW");
        client.addCountry(country);
        client.deleteCountry("NEW");
    }
}
