package ifmo.lab6;

import ifmo.lab5.Lab5Client;
import lombok.val;

import java.io.IOException;

public class Lab6Client extends Lab5Client {

    public Lab6Client(final String url) {
        super(url);
    }

    public static void main(String[] args) {
        val client = new Lab6Client("http://localhost:8080/rest/country");
        try {
            val country = client.getCountryByCode("YYY");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            val country = client.getCountryByCode("DEU");
            country.setCode("");
            client.updateCountry(country);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            client.deleteCountry("ZZZ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
