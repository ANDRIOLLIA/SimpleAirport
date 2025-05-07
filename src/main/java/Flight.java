import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Flight {
    private Aircraft aircraft;
    private TypeFlight typeFlight;
    private LocalDateTime timeDeparture;
    private LocalDateTime timeArrival;
    private String numberFlight;
    private String placeForArrival;
    private String status;
    private Integer[] gate;

    public Flight(
            Aircraft aircraft, TypeFlight typeFlight, LocalDateTime timeDeparture,
            LocalDateTime timeArrival, String numberFlight, String placeForArrival,
            String status, Integer[] gate) {

        this.aircraft = aircraft;
        this.typeFlight = typeFlight;
        this.timeDeparture = timeDeparture;
        this.timeArrival = timeArrival;
        this.numberFlight = numberFlight;
        this.placeForArrival = placeForArrival;
        this.status = status;
        this.gate = gate;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public TypeFlight getTypeFlight() {
        return typeFlight;
    }

    public LocalDateTime getTimeDeparture() {
        return timeDeparture;
    }

    public LocalDateTime getTimeArrival() {
        return timeArrival;
    }

    public String getNumberFlight() {
        return numberFlight;
    }

    public String getPlaceForArrival() {
        return placeForArrival;
    }

    public String getStatus() {
        return status;
    }

    public Integer[] getGate() {
        return gate;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "\naircraft=" + aircraft +
                "\ntypeFlight=" + typeFlight +
                "\ntimeDeparture=" + timeDeparture +
                "\ntimeArrival=" + timeArrival +
                "\nnumberFlight='" + numberFlight + '\'' +
                "\nplaceForArrival='" + placeForArrival + '\'' +
                "\nstatus='" + status + '\'' +
                "\ngate=" + Arrays.toString(gate) +
                '}';
    }
}