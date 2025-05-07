import java.util.ArrayList;
import java.util.List;

public class LaneForAircraft {
    private String nameLaneForAircraft;
    private List<Aircraft> listParkedAircraft;
    private List<Flight> listFlights;

    public LaneForAircraft(String nameLaneForAircraft) {
        this.nameLaneForAircraft = nameLaneForAircraft;
        listParkedAircraft = new ArrayList<>();
        listFlights = new ArrayList<>();
    }

    public void addParkedAircraft(Aircraft aircraft) {
        listParkedAircraft.add(aircraft);
    }
    public void addFlight(Flight flight) {
        listFlights.add(flight);
    }

    public String getNameLaneForAircraft() {
        return nameLaneForAircraft;
    }

    public List<Aircraft> getListParkedAircraft() {
        return listParkedAircraft;
    }

    public List<Flight> getListFlights() {
        return listFlights;
    }

    @Override
    public String toString() {
        return "LaneForAircraft{" +
                "nameLaneForAircraft='" + nameLaneForAircraft + '\'' +
                ", listParkedAircraft=" + listParkedAircraft +
                ", listFlights=" + listFlights +
                '}';
    }
}
