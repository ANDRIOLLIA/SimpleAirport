import java.util.ArrayList;
import java.util.List;

public class Airport {

    public String nameAirport;
    public List<Aircraft> listAircraft;

    public Airport(String nameAirport) {
        this.nameAirport = nameAirport;
        listAircraft = new ArrayList<>();

        for (int i = 0; i < 160; i++) {
            createAircraft();
        }
    }

    public Aircraft createAircraft(){
        AircraftModel[] arrayAircraftModels = AircraftModel.values();
        AircraftModel randomAircraftModel = arrayAircraftModels[(int) (Math.random() * 8)];
        double randomAircraftLength = 20 + (int) (Math.random() * 57);
        int randomCruisingSpeed = 800 + (int) (Math.random() * 201);
        double randomMaxHeightFlight = 1 + (int) (Math.random() * 15);
        int randomMaxRangeFlight = 1000 + (int) (Math.random() * 16_501);
        int randomCountBusinessSpaces = 8 + (int) (Math.random() * 21);
        int randomCountEconomySpaces = 100 + (int) (Math.random() * 201);
        Aircraft randomAircraft = new Aircraft(
                randomAircraftModel, randomAircraftLength ,
                randomCruisingSpeed, randomMaxHeightFlight,
                randomMaxRangeFlight, randomCountBusinessSpaces,
                randomCountEconomySpaces
        );
        listAircraft.add(randomAircraft);
        return randomAircraft;
    }

    public int getCountAircraftSpecifiedModel(int numberModelAircraft){
        int countAircraft = 0;
        AircraftModel specifiedAircraftModel = AircraftModel.values()[numberModelAircraft - 1];
        for(Aircraft currentAircraft : listAircraft){
            if(currentAircraft.aircraftModel.equals(specifiedAircraftModel)){
                countAircraft++;
            }
        }
        return countAircraft;
    }

    public List<Aircraft> getListAircraft() {
        return listAircraft;
    }
}
