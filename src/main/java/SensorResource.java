import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sensors")
public class SensorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sensor> getSensors(@QueryParam("type") String type) {
        List<Sensor> all = DataStore.getAllSensors();
        if (type == null || type.trim().isEmpty()) {
            return all;
        }
        List<Sensor> out = new ArrayList<>();
        for (Sensor sensor : all) {
            if (sensor.getType() != null && sensor.getType().equalsIgnoreCase(type)) {
                out.add(sensor);
            }
        }
        return out;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSensor(Sensor sensor) {
        if (!DataStore.rooms.containsKey(sensor.getRoomId())) {
            throw new DataNotFoundException("room not found");
        }
        DataStore.sensors.put(sensor.getSensorId(), sensor);
        return Response.status(Response.Status.CREATED).entity(sensor).build();
    }
}