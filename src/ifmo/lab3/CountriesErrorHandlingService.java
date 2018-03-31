package ifmo.lab3;

import ifmo.lab1.ConnectionUtil;
import ifmo.lab1.CountriesWebService;
import ifmo.lab1.Country;
import ifmo.lab3.entity.ResponseCode;
import ifmo.lab3.exception.*;
import ifmo.lab3.exception.IllegalArgumentException;
import ifmo.lab3.exception.SecurityException;
import lombok.val;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "CountriesWebService")
public class CountriesErrorHandlingService extends CountriesWebService {

    private static final String USERNAME = "hello";
    private static final String PASS = "there";

    @Resource
    WebServiceContext wsctx;

    @WebMethod(operationName = "addCountry")
    public String addCountry(Country country) throws SecurityException, IllegalArgumentException, SqlException {
        checkAuth();
        checkCountry(country);
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.addCountry(country);
    }

    @WebMethod(operationName = "updateCountry")
    public ResponseCode updateCountry(Country country) throws SecurityException, IllegalArgumentException, NotFoundException {
        checkAuth();
        checkCountry(country);
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.updateCountry(country);
    }

    @WebMethod(operationName = "deleteCountry")
    public ResponseCode deleteCountry(String code) throws SecurityException, IllegalArgumentException, NotFoundException {
        checkAuth();
        if (code == null || code.equals("")) {
            throw new IllegalArgumentException("Empty code",
                    new CountriesServiceFault("Country code is empty"));
        }
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.deleteCountry(code);
    }

    private void checkAuth() throws SecurityException {
        val mctx = wsctx.getMessageContext();

        val httpHeaders = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        val auth = (List) httpHeaders.get("Authorization");
        if (auth != null && !auth.isEmpty()) {
            val authParts = ((String) auth.get(0)).split(" ");
            if (authParts.length > 1) {
                val decodedAuth = new String(Base64.getDecoder().decode(authParts[1]));
                val loginPass = decodedAuth.split(":");
                if (USERNAME.equals(loginPass[0]) && PASS.equals(loginPass[1])) {
                    return;
                }
            }

        }
        val fault = new CountriesServiceFault("Login or password is incorrect");
        throw new SecurityException("Restricted access.", fault);
    }

    private void checkCountry(Country country) throws IllegalArgumentException {
        if (country == null) {
            throw new IllegalArgumentException("Empty country",
                    new CountriesServiceFault("Country is null"));
        }
        if (country.getName() == null || country.getName().equals(""))
            throw new IllegalArgumentException("Empty name",
                    new CountriesServiceFault("Country name is empty"));
        if (country.getName() == null || country.getName().equals(""))
            throw new IllegalArgumentException("Empty code",
                    new CountriesServiceFault("Country code is empty"));
    }
}
