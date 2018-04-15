package ifmo.lab6;

import ifmo.lab1.ConnectionUtil;
import ifmo.lab1.Country;
import ifmo.lab3.CountryDAO;
import ifmo.lab3.entity.ResponseCode;
import ifmo.lab3.exception.NotFoundException;
import ifmo.lab3.exception.SqlException;
import lombok.val;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Base64;

@Path("/country")
@Produces({MediaType.APPLICATION_JSON})
public class CountryResource extends ifmo.lab4.CountryResource {

    private static final String USERNAME = "hello";
    private static final String PASS = "there";

    @PUT
    @Consumes("application/json")
    public String addCountry(@HeaderParam("authorization") String authString, Country country) throws CountryServiceException {
        checkAuth(authString);
        checkCountry(country);
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        try {
            return dao.addCountry(country);
        } catch (SqlException e) {
            throw new CountryServiceException("Bad country");
        }
    }

    @POST
    @Consumes("application/json")
    public ResponseCode updateCountry(@HeaderParam("authorization") String authString, Country country) throws CountryServiceException {
        checkAuth(authString);
        checkCountry(country);
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        try {
            return dao.updateCountry(country);
        } catch (NotFoundException e) {
            throw new CountryServiceException("Country not found");
        }
    }

    @DELETE
    public ResponseCode deleteCountry(@HeaderParam("authorization") String authString, @QueryParam("code") String code) throws CountryServiceException {
        checkAuth(authString);
        if (code == null || code.equals("")) {
            throw new CountryServiceException("Empty code");
        }
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        try {
            return dao.deleteCountry(code);
        } catch (NotFoundException e) {
            throw new CountryServiceException("Country not found");
        }
    }

    private void checkAuth(String authStr) throws CountryServiceException {
        val authParts = authStr.split(" ");
        if (authParts.length > 1) {
            val decodedAuth = new String(Base64.getDecoder().decode(authParts[1]));
            val loginPass = decodedAuth.split(":");
            if (USERNAME.equals(loginPass[0]) && PASS.equals(loginPass[1])) {
                return;
            }
        }
        throw new CountryServiceException("Restricted access.");
    }

    private void checkCountry(Country country) throws CountryServiceException {
        if (country == null) {
            throw new CountryServiceException("null country");
        }
        if (country.getName() == null || country.getName().equals(""))
            throw new CountryServiceException("Empty name");
        if (country.getName() == null || country.getName().equals(""))
            throw new CountryServiceException("Empty code");
    }
}