import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Airport {
    private String nameAirport;
    private List<Aircraft> listAircraft;
    private List<LaneForAircraft> listLanesForAircraft;
    private List<Flight> listFlights;
    private Map<String, Integer> mapCountParkedAircraftByTerminalName;
    private Set<Flight> setSortedFlightsDeparture;

    public Airport(String nameAirport) {
        this.nameAirport = nameAirport;
        listAircraft = new ArrayList<>();
        listLanesForAircraft = new ArrayList<>();
        mapCountParkedAircraftByTerminalName = new TreeMap<>();
        listFlights = new ArrayList<>();
        setSortedFlightsDeparture = new TreeSet<>();
        for (int i = 0; i < 360; i++) {
            createAircraft();
        }
        createFlight();
        createLanesForAircraft();
    }

    public Aircraft createAircraft() {
        AircraftModels[] arrayAircraftModels = AircraftModels.values();
        int randomNumberForAircraftModel = (int) (Math.random() * 8);
        AircraftModels randomAircraftModel = arrayAircraftModels[randomNumberForAircraftModel];
        double randomAircraftLength = 20 + (int) (Math.random() * 57);
        int randomCruisingSpeed = 200 + (int) (Math.random() * 801);
        double randomMaxHeightFlight = (double) ((int) ((10 + (double) (Math.random() * 6)) * 10)) / 10.0;
        int randomMaxRangeFlight = 1_000 + (int) (Math.random() * 14_001);
        int randomCountBusinessSpaces = 8 + (int) (Math.random() * 21);
        int randomCountEconomySpaces = 100 + (int) (Math.random() * 201);
        Aircraft aircraft = new Aircraft(
                randomAircraftModel,
                randomAircraftLength,
                randomCruisingSpeed,
                randomMaxHeightFlight,
                randomMaxRangeFlight,
                randomCountBusinessSpaces,
                randomCountEconomySpaces
        );
        listAircraft.add(aircraft);
        return aircraft;
    }

    public Flight createFlight() {
        Aircraft randomAircraft = createAircraft();
        int randomIndexTypeFlight = (int) (Math.random() * 2);
        TypeFlight typeFlight = TypeFlight.values()[randomIndexTypeFlight];
        int randomHour = (int) (Math.random() * 24);
        int randomMinute = (int) (Math.random() * 60);
        LocalDate localDateNow = LocalDate.now();
        LocalDateTime timeDeparture = LocalDateTime.of(localDateNow.getYear(), localDateNow.getMonth(),
                localDateNow.getDayOfMonth(), randomHour, randomMinute);
        LocalDateTime timeArrival = timeDeparture.plusHours(2);
        String[] arrayRandomFlights = {"U6-548", "S7-6346", "SU-1135"};
        String randomFlight = arrayRandomFlights[(int) (Math.random() * 3)];
        String[] arrayRandomPlaces = {"МОСКВА/ШРМ", "С.-ПЕТЕРБУРГ", "ИРКУТСК"};
        String randomPlace = arrayRandomPlaces[(int) (Math.random() * 3)];
        String[] arrayRandomStatus = {"Регистрация", "Задержан", "Регистрация завершена"};
        String randomStatus = arrayRandomStatus[(int) (Math.random() * 3)];
        int randomSizeExit = 1 + (int) (Math.random() * 2);
        Integer[] arrayRandomExit = new Integer[randomSizeExit];
        int randomExit = 1 + (int) (Math.random() * 30);
        arrayRandomExit[0] = randomExit;
        if(randomSizeExit == 2){
            arrayRandomExit[1] = randomExit < 30 ? randomExit + 1 : randomExit - 1;
        }
        Flight flight = new Flight(randomAircraft,
                typeFlight,
                timeDeparture,
                timeArrival,
                randomFlight,
                randomPlace,
                randomStatus,
                arrayRandomExit);
        listFlights.add(flight);
        return flight;
    }

    public List<LaneForAircraft> createLanesForAircraft() {
        String[] arrayNameLanesForAircraft = {"A", "B", "C", "D"};
        for (String currentNameLaneForAircraft : arrayNameLanesForAircraft) {
            LaneForAircraft currentLaneForAircraft = new LaneForAircraft(currentNameLaneForAircraft);
            int randomCountParkedAircraft = 10 + (int) (Math.random() * 11);
            for (int i = 0; i < randomCountParkedAircraft; i++) {
                currentLaneForAircraft.addParkedAircraft(createAircraft());
                currentLaneForAircraft.addFlight(createFlight());
            }
            listLanesForAircraft.add(currentLaneForAircraft);
        }
        return listLanesForAircraft;
    }

    /*
    TODO Метод должен найти
     количество припаркованных самолетов на каждой полосе
     и вернуть такой Map
     */
    public Map<String, Integer> findMapCountParkedAircraftByTerminalName() {
        for (LaneForAircraft currentLaneForAircraft : listLanesForAircraft) {
            mapCountParkedAircraftByTerminalName.put(
                    currentLaneForAircraft.getNameLaneForAircraft(),
                    currentLaneForAircraft.getListParkedAircraft().size());
        }
        return mapCountParkedAircraftByTerminalName;
    }

    /*
    TODO Найти кол-во самолётов с номером указанной модели
     */
    public int findCountAircraftWithNumberSpecifiedModel(int numberSpecifiedModelAircraft) {
        int countAircraft = 0;

        for (Aircraft currentAircraft : listAircraft) {
            if (currentAircraft.getAircraftModel().equals(
                    AircraftModels.values()[numberSpecifiedModelAircraft - 1])) {
                countAircraft++;
            }
        }

        return countAircraft;
    }

    /*
    TODO Найти ближайший рейс в указанную пользователем точку прибытия
     */
    public Flight findFirstFlightToSpecifiedPlaceArrival(String namePlaceForArrival) {
        LocalDateTime now = LocalDateTime.now();
        Flight earliestFlight = null;

        for (Flight currentFlight : listFlights) {
            if (currentFlight.getPlaceForArrival().equalsIgnoreCase(namePlaceForArrival)
                    && currentFlight.getTimeDeparture().isAfter(now)
                    && currentFlight.getTypeFlight() == TypeFlight.DEPARTURE) {

                if (earliestFlight == null ||
                        currentFlight.getTimeDeparture().isBefore(earliestFlight.getTimeDeparture())) {
                    earliestFlight = currentFlight;
                }
            }
        }

        return earliestFlight;
    }

    /*
    TODO Метод должен найти и вернуть список отправляющихся рейсов
     в ближайшее количество часов,
     в указанное место.
     */
    public List<Flight> findListFlightsDepartureInNextCountHours(int countHours, String namePlaceForArrival) {
        List<Flight> listFlightsDepartureInNextCountHours = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime limitTime = now.plusHours(countHours);

        for (Flight flight : listFlights) {
            if (flight.getPlaceForArrival().equalsIgnoreCase(namePlaceForArrival)
                    && flight.getTypeFlight() == TypeFlight.DEPARTURE
                    && !flight.getTimeDeparture().isBefore(now)
                    && !flight.getTimeDeparture().isAfter(limitTime)) {
                listFlightsDepartureInNextCountHours.add(flight);
            }
        }

        listFlightsDepartureInNextCountHours.sort(Comparator.comparing(Flight::getTimeDeparture));

        return listFlightsDepartureInNextCountHours;
    }

    public String getNameAirport () {
        return nameAirport;
    }

    public List<Aircraft> getListAircraft () {
        return listAircraft;
    }

    public List<LaneForAircraft> getListLanesForAircraft () {
        return listLanesForAircraft;
    }

    public List<Flight> getListFlights () {
        return listFlights;
    }

    public Map<String, Integer> getMapCountParkedAircraftByTerminalName () {
        return mapCountParkedAircraftByTerminalName;
    }

    public Set<Flight> getSetSortedFlightsDeparture () {
        return setSortedFlightsDeparture;
    }

    @Override
    public String toString () {
        return "Airport{" +
                "nameAirport='" + nameAirport + '\'' +
                ", listAircraft=" + listAircraft +
                ", listLanesForAircraft=" + listLanesForAircraft +
                ", listFlights=" + listFlights +
                ", mapCountParkedAircraftByTerminalName=" + mapCountParkedAircraftByTerminalName +
                ", setSortedFlightsDeparture=" + setSortedFlightsDeparture +
                '}';
    }
}
