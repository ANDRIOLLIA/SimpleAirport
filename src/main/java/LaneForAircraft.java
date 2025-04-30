import java.util.ArrayList;
import java.util.List;

public class LaneForAircraft {
    private String nameLaneForAircraft;
    private List<Aircraft> listParkedAircraft;

    public LaneForAircraft(String nameLaneForAircraft) {
        this.nameLaneForAircraft = nameLaneForAircraft;
        listParkedAircraft = new ArrayList<>();
    }

    public void addParkedAircraft(Aircraft aircraft){
        listParkedAircraft.add(aircraft);
    }

    public String getNameLaneForAircraft() {
        return nameLaneForAircraft;
    }

    public List<Aircraft> getListParkedAircraft() {
        return listParkedAircraft;
    }

    @Override
    public String toString() {
        return "LaneForAircraft{" +
                "nameLaneForAircraft='" + nameLaneForAircraft + '\'' +
                ", listParkedAircraft=" + listParkedAircraft +
                '}';
    }
}
