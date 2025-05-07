public class Aircraft {
    public final AircraftModels aircraftModel; //TODO Boeing 777-300ER
    public final double aircraftLength; //TODO 73.9
    public final int cruisingSpeed; //TODO 905
    public final double maxHeightFlight; //TODO 13.1
    public final int maxRangeFlight; //TODO 11_200
    public final int countBusinessSpaces; //TODO 20
    public final int countEconomySpaces; //TODO 138

    public Aircraft(
            AircraftModels aircraftModel, double aircraftLength,
            int cruisingSpeed, double maxHeightFlight,
            int maxRangeFlight, int countBusinessSpaces,
            int countEconomySpaces) {
        this.aircraftModel = aircraftModel;
        this.aircraftLength = aircraftLength;
        this.cruisingSpeed = cruisingSpeed;
        this.maxHeightFlight = maxHeightFlight;
        this.maxRangeFlight = maxRangeFlight;
        this.countBusinessSpaces = countBusinessSpaces;
        this.countEconomySpaces = countEconomySpaces;
    }

    public AircraftModels getAircraftModel() {
        return aircraftModel;
    }

    public double getAircraftLength() {
        return aircraftLength;
    }

    public int getCruisingSpeed() {
        return cruisingSpeed;
    }

    public double getMaxHeightFlight() {
        return maxHeightFlight;
    }

    public int getMaxRangeFlight() {
        return maxRangeFlight;
    }

    public int getCountBusinessSpaces() {
        return countBusinessSpaces;
    }

    public int getCountEconomySpaces() {
        return countEconomySpaces;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraftModel=" + aircraftModel +
                ", aircraftLength=" + aircraftLength +
                ", cruisingSpeed=" + cruisingSpeed +
                ", maxHeightFlight=" + maxHeightFlight +
                ", maxRangeFlight=" + maxRangeFlight +
                ", countBusinessSpaces=" + countBusinessSpaces +
                ", countEconomySpaces=" + countEconomySpaces +
                '}';
    }
}
