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

@Path("/country")
@Produces({MediaType.APPLICATION_JSON})
public class CountryResource extends ifmo.lab4.CountryResource {
    @PUT
    @Consumes("application/json")
    public String addCountry(Country country) throws CountryServiceException {
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
    public ResponseCode updateCountry(Country country) throws CountryServiceException {
        checkCountry(country);
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        try {
            return dao.updateCountry(country);
        } catch (NotFoundException e) {
            throw new CountryServiceException("Country not found");
        }
    }

    @DELETE
    public ResponseCode deleteCountry(@QueryParam("code") String code) throws CountryServiceException {
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