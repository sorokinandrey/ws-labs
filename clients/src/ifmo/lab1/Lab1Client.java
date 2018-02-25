package ifmo.lab1;

import ifmo.lab1.service.CountriesService;
import ifmo.lab1.service.Country;
import lombok.val;

import java.util.List;

public class Lab1Client {
    public static void main(String[] argv) {
        val service = new CountriesService().getCountriesWebServicePort();

        printAll(service.getCountries("Albania"));
        printAll(service.getCountries("rus"));
        printAll(service.getCountries("a"));
        printAll(service.getCountries("242900"));
        System.out.println(service.getCountry("RUS"));
    }

    private static void printAll(List<Country> countries) {
        if (countries == null || countries.size() == 0)
            return;

        for (val country: countries) {
            System.out.println(country);
        }
    }

}
