import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport("Сочинский");
        System.out.print("Введите цифру соответствующей модели самолета: \n" +
                "1. Boeing_777_300ER\n" +
                "2. Boeing_737_800\n" +
                "3. Airbus_A350_900\n" +
                "4. Airbus_А330_300\n" +
                "5. Airbus_А321\n" +
                "6. Airbus_A321NEO\n" +
                "7. Airbus_A320\n" +
                "8. Airbus_А320NEO\n>_");
        int numberModelAircraft = new Scanner(System.in).nextInt();
        System.out.println(airport.getCountAircraftSpecifiedModel(numberModelAircraft));
    }
}
