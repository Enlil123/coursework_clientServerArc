import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rooms")
public class RoomResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getRooms() {
        return DataStore.getAllRooms();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRoom(Room room) {
        DataStore.rooms.put(room.getRoomId(),room);
        return Response.status(Response.Status.CREATED).entity(room).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Room getRoom(@PathParam("id") int id) {
        if (!DataStore.rooms.containsKey(id)) {
            throw new RoomNotFoundException("room not found");
        }
        return DataStore.rooms.get(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRoom(@PathParam("id") int id) {
        if (!DataStore.rooms.containsKey(id)) {
            throw new RoomNotFoundException("room not found");
        }

        for (Sensor sensor:DataStore.sensors.values()) {
            if (sensor.getRoomId() == id) {
                throw new RoomNotEmptyException("room has sensors");
            }
        }

        DataStore.rooms.remove(id);
        return Response.ok().build();
    }
}