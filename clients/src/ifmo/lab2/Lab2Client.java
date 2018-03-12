package ifmo.lab2;

import ifmo.lab2.service.CountriesWebServiceCrud_Service;
import lombok.val;

public class Lab2Client {
    public static void main(String[] argv) {
        val service = new CountriesWebServiceCrud_Service().getCountriesWebServiceCrudPort();
        val russia = service.getCountry("RUS");
        russia.setLocalName("Россия");
        val resUpdate = service.updateCountry(russia);
        System.out.println(resUpdate.getMessage());

        val resDelete = service.deleteCountry("RUS");
        System.out.println(resDelete.getMessage());

        val resDeleteFail = service.deleteCountry("AAA");
        System.out.println(resDeleteFail.getMessage());

        russia.setCode("wrong");
        val resUpdateFail = service.updateCountry(russia);
        System.out.println(resUpdateFail.getMessage());

        russia.setCode("RUS");
        val code = service.addCountry(russia);
        System.out.println(code);

    }
}
