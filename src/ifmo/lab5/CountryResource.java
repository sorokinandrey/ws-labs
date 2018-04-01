package ifmo.lab5;

import ifmo.lab1.ConnectionUtil;
import ifmo.lab1.Country;
import ifmo.lab2.CountryDAO;
import ifmo.lab2.entity.ResponseCode;
import lombok.val;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/country")
@Produces({MediaType.APPLICATION_JSON})
public class CountryResource extends ifmo.lab4.CountryResource {
    @PUT
    @Consumes("application/json")
    public String addCountry(Country country) {
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.addCountry(country);
    }

    @POST
    @Consumes("application/json")
    public ResponseCode updateCountry(Country country) {
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.updateCountry(country);
    }

    @DELETE
    public ResponseCode deleteCountry(@QueryParam("code") String code) {
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.deleteCountry(code);
    }
}