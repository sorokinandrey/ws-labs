package ifmo.lab1;

import ifmo.lab3.exception.NotFoundException;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(serviceName = "CountriesServiceJ2EE")
public class CountriesWebServiceJ2EE {

    @Resource(lookup = "jdbc/wstest")
    private DataSource dataSource;

    @WebMethod(operationName = "getCountry")
    public Country getCountry(String code) throws NotFoundException {
        CountryDAO dao = new CountryDAO(getConnection());
        return dao.getCountry(code);
    }

    @WebMethod(operationName = "getCountries")
    public List<Country> getCountries(String term) {
        CountryDAO dao = new CountryDAO(getConnection());
        return dao.getCountries(term);
    }


    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CountriesWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
