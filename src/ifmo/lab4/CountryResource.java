package ifmo.lab4;

import ifmo.lab1.ConnectionUtil;
import ifmo.lab1.Country;
import ifmo.lab1.CountryDAO;
import ifmo.lab3.exception.NotFoundException;
import lombok.val;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/country")
@Produces({MediaType.APPLICATION_JSON})
public class CountryResource {
    @GET
    public Country getCountry(@QueryParam("code") String code) {
        try {
            return new CountryDAO(ConnectionUtil.getConnection()).getCountry(code);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("search")
    public List<Country> getCountries(@QueryParam("term") String term) {
        val dao = new CountryDAO(ConnectionUtil.getConnection());
        return dao.getCountries(term);
    }
}