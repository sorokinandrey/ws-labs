package ifmo.lab3;

import ifmo.lab3.service.CountriesWebService;
import ifmo.lab3.service.IllegalArgumentException;
import ifmo.lab3.service.NotFoundException;
import ifmo.lab3.service.SecurityException;
import lombok.val;

import javax.xml.ws.BindingProvider;

public class Lab3Client {
    public static void main(String[] argv) {
        val service = new CountriesWebService().getCountriesErrorHandlingServicePort();
        val prov = (BindingProvider) service;
        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "hello");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "there");

        try {
            val empty = service.getCountry("");
        } catch (IllegalArgumentException | NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            val notFound = service.deleteCountry("ZZZ");
        } catch (IllegalArgumentException | NotFoundException | SecurityException e) {
            System.out.println(e.getMessage());
        }

    }
}
