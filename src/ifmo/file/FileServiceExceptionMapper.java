package ifmo.file;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class FileServiceExceptionMapper implements ExceptionMapper<FileServiceException> {
    @Override
    public Response toResponse(FileServiceException e) {
        return Response.status(e.getStatus())
                .entity(e.getMessage())
                .build();
    }
}