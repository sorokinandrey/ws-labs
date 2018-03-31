package ifmo.lab1;


import ifmo.lab3.exception.CountriesServiceFault;
import ifmo.lab3.exception.IllegalArgumentException;
import ifmo.lab3.exception.NotFoundException;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "CountriesService")
public class CountriesWebService {

    @WebMethod(operationName = "getCountry")
    public Country getCountry(String code) throws IllegalArgumentException, NotFoundException {
        if (code == null || code.equals("")) {
            throw new IllegalArgumentException("Empty code",
                    new CountriesServiceFault("Country code is empty"));
        }
        CountryDAO dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.getCountry(code);
    }

    @WebMethod(operationName = "getCountries")
    public List<Country> getCountries(String term) {
        CountryDAO dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.getCountries(term);
    }

}
