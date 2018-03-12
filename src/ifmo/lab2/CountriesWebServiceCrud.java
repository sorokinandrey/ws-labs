package ifmo.lab2;

import ifmo.lab1.ConnectionUtil;
import ifmo.lab1.CountriesWebService;
import ifmo.lab1.Country;
import ifmo.lab2.entity.ResponseCode;
import lombok.val;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "CountriesWebServiceCrud")
public class CountriesWebServiceCrud extends CountriesWebService {

    @WebMethod(operationName = "addCountry")
    public String addCountry(Country country) {
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.addCountry(country);
    }

    @WebMethod(operationName = "updateCountry")
    public ResponseCode updateCountry(Country country) {
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.updateCountry(country);
    }

    @WebMethod(operationName = "deleteCountry")
    public ResponseCode deleteCountry(String code) {
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.deleteCountry(code);
    }
}
