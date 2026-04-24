import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundRequestMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException e) {
        ErrorMessage er = new ErrorMessage(e.getMessage(), 400, "N/A");
        return Response.status(400)
                .type(MediaType.APPLICATION_JSON)
                .entity(er)
                .build();
    }
}