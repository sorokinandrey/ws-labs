package ifmo.lab1;


import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "CountriesService")
public class CountriesWebService {

    @WebMethod(operationName = "getCountry")
    public Country getCountry(String code) {
        CountryDAO dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.getCountry(code);
    }

    @WebMethod(operationName = "getCountries")
    public List<Country> getCountries(String term) {
        CountryDAO dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.getCountries(term);
    }

}
