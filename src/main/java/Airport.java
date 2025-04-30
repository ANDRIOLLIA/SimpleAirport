import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Airport {

    public String nameAirport;
    public List<Aircraft> listAircraft;
    private List<LaneForAircraft> listLanesForAircraft;

    public Airport(String nameAirport) {
        this.nameAirport = nameAirport;
        listAircraft = new ArrayList<>();
        listLanesForAircraft = new ArrayList<>();

        for (int i = 0; i < 160; i++) {
            createAircraft();
        }
        createAllLanesForAircraft();
    }

    public Aircraft createAircraft() {
        AircraftModel[] arrayAircraftModels = AircraftModel.values();
        AircraftModel randomAircraftModel = arrayAircraftModels[(int) (Math.random() * 8)];
        double randomAircraftLength = 20 + (int) (Math.random() * 57);
        int randomCruisingSpeed = 800 + (int) (Math.random() * 201);
        double randomMaxHeightFlight = 1 + (int) (Math.random() * 15);
        int randomMaxRangeFlight = 1000 + (int) (Math.random() * 16_501);
        int randomCountBusinessSpaces = 8 + (int) (Math.random() * 21);
        int randomCountEconomySpaces = 100 + (int) (Math.random() * 201);
        Aircraft randomAircraft = new Aircraft(
                randomAircraftModel, randomAircraftLength,
                randomCruisingSpeed, randomMaxHeightFlight,
                randomMaxRangeFlight, randomCountBusinessSpaces,
                randomCountEconomySpaces
        );
        listAircraft.add(randomAircraft);
        return randomAircraft;
    }

    public void createAllLanesForAircraft() {
        String[] arrayNamesAllLinesForAircraft = {"A", "B", "C", "D"};
        for(String currentNameLaneForAircraft : arrayNamesAllLinesForAircraft){
            LaneForAircraft currentLaneForAircraft = new LaneForAircraft(currentNameLaneForAircraft);
            int countParkedAircraft = 5 + (int) (Math.random() * 6);
            for (int i = 0; i < countParkedAircraft; i++) {
                currentLaneForAircraft.addParkedAircraft(createAircraft());
            }
            listLanesForAircraft.add(currentLaneForAircraft);
        }
    }

    public int getCountAircraftSpecifiedModel(int numberModelAircraft) {
        int countAircraft = 0;
        AircraftModel specifiedAircraftModel = AircraftModel.values()[numberModelAircraft - 1];
        for (Aircraft currentAircraft : listAircraft) {
            if (currentAircraft.aircraftModel.equals(specifiedAircraftModel)) {
                countAircraft++;
            }
        }
        return countAircraft;
    }

    public Map<String, Integer> findCountParkedAircraftByEveryLane(){
        Map<String, Integer> mapCountParkedAircraftByEveryLane = new TreeMap<>();
        for (LaneForAircraft currentLaneForAircraft : listLanesForAircraft){
            mapCountParkedAircraftByEveryLane.put(
                    currentLaneForAircraft.getNameLaneForAircraft(), currentLaneForAircraft.getListParkedAircraft().size());
        }
        return mapCountParkedAircraftByEveryLane;
    }

    public List<Aircraft> getListAircraft() {
        return listAircraft;
    }

    public void printListLanesForAircraft() {
        for (LaneForAircraft currentLaneForAircraft : listLanesForAircraft){
            System.out.println("\"" + currentLaneForAircraft + "\"\n");
        }
    }
}
