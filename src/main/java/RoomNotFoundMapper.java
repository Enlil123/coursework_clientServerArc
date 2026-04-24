import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RoomNotFoundMapper implements ExceptionMapper<RoomNotFoundException> {

    @Override
    public Response toResponse(RoomNotFoundException e) {
        ErrorMessage er = new ErrorMessage(e.getMessage(), 404, "none");
        return Response.status(404).type(MediaType.APPLICATION_JSON).entity(er).build();
    }
}