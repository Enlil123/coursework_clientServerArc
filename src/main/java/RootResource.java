import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RootResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getApiInfo() {
        Map<String, Object> data = new HashMap<>();
        Map<String, String> resources = new HashMap<>();
        
        resources.put("rooms","/api/v1/rooms");
        resources.put("sensors","/api/v1/sensors");
        data.put("version","v1");
        data.put("contact","student");
        data.put("resources", resources);

        return data;
    }
}