package ifmo.lab2;

import ifmo.lab1.ConnectionUtil;
import ifmo.lab1.CountriesWebService;
import ifmo.lab1.Country;
import ifmo.lab2.entity.ResponseCode;
import lombok.val;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "CountriesWebServiceCrud")
public class CountriesWebServiceCrud extends CountriesWebService {

    private static final String USERNAME = "hello";
    private static final String PASS = "there";

    @Resource
    WebServiceContext wsctx;

    @WebMethod(operationName = "addCountry")
    public String addCountry(Country country) {
        try {
            checkAuth();
        } catch (SecurityException e) {
            return e.getMessage();
        }
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.addCountry(country);
    }

    @WebMethod(operationName = "updateCountry")
    public ResponseCode updateCountry(Country country) {
        try {
            checkAuth();
        } catch (SecurityException e) {
            return new ResponseCode(200, e.getMessage());
        }
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.updateCountry(country);
    }

    @WebMethod(operationName = "deleteCountry")
    public ResponseCode deleteCountry(String code) {
        try {
            checkAuth();
        } catch (SecurityException e) {
            return new ResponseCode(200, e.getMessage());
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
        throw new SecurityException("Restricted access.");
    }
}
