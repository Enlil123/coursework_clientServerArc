import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable e) {
        ErrorMessage er = new ErrorMessage("internal server error", 500, "N/A");
        return Response.status(500).type(MediaType.APPLICATION_JSON).entity(er).build();
    }
}
