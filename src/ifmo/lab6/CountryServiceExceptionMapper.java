package ifmo.lab6;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 * @author vtaravkov
 * @since lab6
 */
@Provider
public class CountryServiceExceptionMapper implements ExceptionMapper<CountryServiceException> {
    @Override
    public Response toResponse(CountryServiceException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage())
                .build();
    }
}