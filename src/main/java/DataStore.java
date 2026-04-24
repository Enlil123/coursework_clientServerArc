import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {

    public static Map<Integer,Room> rooms = new HashMap<>();
    public static Map<Integer,Sensor> sensors = new HashMap<>();

    public static List<Room> getAllRooms() {
        return new ArrayList<>(rooms.values());
    }
    public static List<Sensor> getAllSensors() {
        return new ArrayList<>(sensors.values());
    }
}
